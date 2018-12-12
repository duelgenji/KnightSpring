package com.duelgenji.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrossController {

	@RequestMapping(value="/c1")
	public String c1() {
		return "c1";
	}
	

	@CrossOrigin
	@RequestMapping(value="/c2")
	public String c2() {
		return "c2";
	}
	
}
