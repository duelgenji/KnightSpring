package com.duelgenji.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@Controller
public class TemplatesController {
	
	@RequestMapping(value="/h1")
	public String home1() {
		//thymeleaf 覆盖，同时使用的话 访问不到h1
		return "h1";
	}
	
	@RequestMapping(value="/h2")
	public String home2() {
		return "h2";
	}
}
