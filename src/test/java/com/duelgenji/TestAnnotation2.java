package com.duelgenji;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestAnnotation2 {
	
	@Before
	public void before(){
		System.out.println("test before 2");
	}
	
	@BeforeClass
	public static void beforeClass(){
		System.out.println("test beforeClass 2");
	}

	
	@After
	public void after(){
		System.out.println("test after 2");
	}

	
	@AfterClass
	public static void afterClass(){
		System.out.println("test afterClass 2");
	}

	
	@Test
	public void test(){
		System.out.println("test 2");
	}

	
	

}
