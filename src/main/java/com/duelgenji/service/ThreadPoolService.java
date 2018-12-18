package com.duelgenji.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolService {
	
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(2);
	}

}
