package com.duelgenji.service;

import java.io.IOException;
import java.rmi.AccessException;
import java.util.concurrent.Future;

import org.springframework.remoting.RemoteAccessException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

@Component
public class AsnycService {

	@Async
	@Retryable(value=RemoteAccessException.class,backoff = @Backoff(delay = 500,multiplier = 1))
	public Future<String> async(int i)  {
		
		
		try {
			Thread.sleep(500);
			double d = Math.random();
			if(d<0.7) {
				System.out.println("#" + i + ":" + d + "<0.3 retry");
				throw new RemoteAccessException("#"+i);
			}
			System.out.println(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 

		return new AsyncResult<>(String.format("这个是第{%s}个异步调用的证书", i));
	}
	
	@Recover
	public Future<String> recover(RemoteAccessException ex,int i) {
		
		System.out.println(ex.getMessage() + " recover" + "#"+i);
		return new AsyncResult<>(String.format("这个是第{%s}个异步调用的证书", i));
	}

}
