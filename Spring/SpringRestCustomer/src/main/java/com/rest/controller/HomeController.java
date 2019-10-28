package com.rest.controller;

import java.util.Locale;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.vo.Customer;

//@RestController = @Controller + @ResponseBody 가 합쳐진 어노테이션
//								  @ResponseBody : 응답결과(자바 객체)를 json 형식으로 바꿔 보내줌
@RestController
public class HomeController {
	
	//get : 서버의 자원을 read(=select)
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "this is my first rest service"; //자바 스트링 객체
	}
	
	@RequestMapping(value = "/home2", method = RequestMethod.GET)
	public Customer home2() {
		return new Customer("23", "billy jean", "london"); //커스토머 객체
	}
	
}
