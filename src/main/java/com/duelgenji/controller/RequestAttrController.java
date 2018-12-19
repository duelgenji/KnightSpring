package com.duelgenji.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

@RestController
public class RequestAttrController {
	
	@RequestMapping(value="/ra/{name}")
	public String set(@PathVariable("name") String name) {

		RequestAttributes currentRequestAttributes = RequestContextHolder.currentRequestAttributes();
		currentRequestAttributes.setAttribute("item", name, RequestAttributes.SCOPE_SESSION);

		return name;
	}
	
	@RequestMapping(value="/ra")
	public String get() {
		

		RequestAttributes currentRequestAttributes = RequestContextHolder.currentRequestAttributes();

		return currentRequestAttributes.getAttribute("item",RequestAttributes.SCOPE_SESSION).toString();
	}
	

}
