package com.cc.kr.api.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping(value = "/test")
	public String test(String str) {
		return "test Success"; 
	}
	
	
}
