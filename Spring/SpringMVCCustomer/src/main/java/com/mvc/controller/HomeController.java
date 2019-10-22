package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	//클라이언트로부터 get방식으로 /home.do 요청이 들어왔을 때 응답을 만들어 내는 메소드
	//리턴 타입 : String 인 경우 -> 논리적인 view 이름을 의미함.
	@RequestMapping(value = "/home.do", method = RequestMethod.GET) 
	public String home(Model model) { //Model : ui패키지에 들어있음. 화면에서 이용
									  //	map구조로 데이터를 저장하고 view에서 꺼내서 쓸 수 있음
									  //	req.setAttribute()대신 model.addAttribute()로 model에 저장
		
		model.addAttribute("city", "seoul"); //키, 밸류
		model.addAttribute("code", "12345"); //키, 밸류
		
		return "home"; //논리적인 view 이름
	}
	
	@RequestMapping(value = "/test.do", method = RequestMethod.GET) 
	public String test(Model model) {
		
		model.addAttribute("city", "seoul");
		
		return "test";
	}
	
}
