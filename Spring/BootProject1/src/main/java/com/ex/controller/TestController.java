package com.ex.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //데이터가 응답으로 나간다
public class TestController {
	
	@GetMapping("/start")
	public String start() {
		return "hello, boot!!!";
	}
	
}
