package com.duelgenji.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.RemoteAccessException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duelgenji.service.AsnycService;

@RestController
public class AsyncController {
	
	@Autowired
	private AsnycService asyncService;

	@RequestMapping(value="/async")
	public  Map<String, Object> async() throws ExecutionException, InterruptedException{

		 long start = System.currentTimeMillis();
		 
	        Map<String, Object> map = new HashMap<>();
	        List<Future<String>> futures = new ArrayList<>();
	        for (int i = 0; i < 10000; i++) {
	            Future<String> future = asyncService.async(i);
	            futures.add(future);
	        }
	        List<String> response = new ArrayList<>();
	        for (Future<String> future : futures) {
	            String string = future.get();
	            response.add(string);
	        }
	        map.put("data", response);
	        long seconds = (System.currentTimeMillis() - start)/1000;
	        map.put("消耗时间", String.format("任务执行成功,耗时{%s}秒", seconds));
	        return map;

	}
	

}
