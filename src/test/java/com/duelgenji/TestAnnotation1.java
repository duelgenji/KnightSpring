package com.duelgenji;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
public class TestAnnotation1 {
	
	@Before
	public void before(){
		System.out.println("test before 1");
	}
	
	@BeforeClass
	public static void beforeClass(){
		System.out.println("test beforeClass 1");
	}

	
	@After
	public void after(){
		System.out.println("test after 1");
	}

	
	@AfterClass
	public static void afterClass(){
		System.out.println("test afterClass 1");
	}

	
	@Test
	public void test(){
		System.out.println("test 1");
	}

}
