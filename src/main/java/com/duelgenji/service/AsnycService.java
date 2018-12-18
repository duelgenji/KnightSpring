package com.duelgenji.service;

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
		
		
		System.out.println("start #" + i);

		try {

//			cpu block
//			double count=0;
//			for(double j=0;j<5000000;j++) {
//				count=Math.sin(j*2);
//			}

//			io block 
//			Thread.sleep(3000);
		
			double d = Math.random();
			if(d<0) {
				System.out.println("retry #" + i + ":" + d + "<0.3 retry");
				throw new RemoteAccessException("#"+i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 

		System.out.println("end #" + i);
		return new AsyncResult<>(String.format("这个是第{%s}个成功异步调用的证书，成功", i));
	}
	
	@Recover
	public Future<String> recover(RemoteAccessException ex,int i) {
		
		System.out.println(ex.getMessage() + " recover" + "#"+i);
		return new AsyncResult<>(String.format("这个是第{%s}个异步调用的证书，失败", i));
	}

}
