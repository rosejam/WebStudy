package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {	
	//클라이언트로부터 get 방식으로 /home.do요청이 들어왔을 때 응답을 만들어 내는 메소드
	//서비스 메소드의 리턴타입:String(논리적인 view 이름)
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Model model) {		
		//Model: map구조로 데이터를 저장하고 view에서 꺼내서 쓸수 있음
		model.addAttribute("city", "seoul" );
		model.addAttribute("code", "12345" );
		
		return "home";//논리적 view 이름
	}
	//클라이언트로부터 get 방식으로 /test.do요청이 들어왔을 때 응답을 만들어 내는 메소드
	@RequestMapping(value = "/test.do", method = RequestMethod.GET)
	public String test( Model model) {		
		
		model.addAttribute("name", "tommy lee" );
		
		return "test";
	}
	
}










