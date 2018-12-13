package com.duelgenji.service;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

@Component
public class AsnycService {
	

	@Async
	public Future<String> async(int i){
		 try {
	         
	            Thread.sleep(500);	
	            System.out.println(i);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	      
	        return new AsyncResult<>(String.format("这个是第{%s}个异步调用的证书", i));
	}

}
