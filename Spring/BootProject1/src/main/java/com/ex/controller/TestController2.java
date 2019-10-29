package com.ex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //View가 응답으로 나간다
public class TestController2 {
	
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("city", "paris");
		return "home";
	}
	
}
