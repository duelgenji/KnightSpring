package com.duelgenji;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.duelgenji.service.MainService;

@SpringBootTest
public class TestSub {
	
	
	@Autowired
	private MainService mainservice;
	
	@Test
	public void testSub() {

		System.out.println("test sub");

//		System.out.println(mainservice.doSomething());
		
	}

}
