package com.duelgenji;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import sun.misc.IOUtils;

//@TestPropertySource(value= {"classpath:application.properties"})
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestExample {

//	@Autowired
//	private Environment env;
//
//	@Value("${name}")
//	private String name;

	
	@Value("${spring.mvc.view.suffix}")
	private String suffix;

	@Test
	public void testFind() {
		Resource data = new ClassPathResource("test.json");
		
		System.out.println("test begin");
//		System.out.println(name);
		System.out.println(suffix);

		try {
			String json = new String(IOUtils.readFully(data.getInputStream(), -1, true));
			
//			new ObjectMapper().readValue(src, valueType);
			System.out.println(new JacksonJsonParser().parseMap(json));
		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
