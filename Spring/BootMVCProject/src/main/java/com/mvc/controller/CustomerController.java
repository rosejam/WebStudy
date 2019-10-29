package com.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mvc.service.CustomerService;
import com.mvc.vo.Customer;

//front Controller인 DispatcherServlet으로부터 넘어온 요청 처리
@Controller //필수 어노테이션!!!!
public class CustomerController {
	//db작업을 할 dao주입
	@Autowired
	CustomerService service;
	
	//@RequestMapping(value = "/list.cus", method = RequestMethod.GET)
	@GetMapping(value="/list.cus") //Get/Post방식의 RequestMapping을 의미
	public String list(Model model) {
		//db작업 후 결과 받기
		List<Customer> list = service.selectAll();
		
		//Model : map구조로 데이터(db작업해서 가져온 결과)를 저장하고 view에서 꺼내 쓸 수 있음
		model.addAttribute("list", list);
		
		return "list"; //논리적인 view 이름
	}
	
	@GetMapping(value = "/detail.cus") 
	public String detail(Model model, String num) { //그냥 여기로 파라메터를 받아온다!!!! //1. url과 parameter이름을 동일하게 맞춰서 받거나
	//public String detail(Model model, @RequestParam("num") String number) { //2. @RequestParam("url의 파라메터 이름")를 앞에 붙여서 아무 이름의 파라메터에 받는다.
		//request.getParameter(num);대신에 위에 두줄을 사용
		
		Customer c = service.selectOne(num);
		model.addAttribute("c", c);
		return "detail";
	}
	
	@GetMapping(value="/insert.cus") //요청이 오면 여기로 처음 들어옴
	public String insert(Customer c) { //화면이 나가기 전 빈 vo를 만든 후 딸려 보내서 그 안에 입력하게 함!!! ////
		return "insert"; //form태그 안의 name과 vo의 필드명이 일치해야 그 안에 필드 값이 입력될 수 있다!!!
	}
	@PostMapping(value="/insert.cus") //post방식
//	public String insertProcess(String num, String name, String address, Model model) {
//		Customer c = new Customer(num, name, address);
	public String insertProcess(@ModelAttribute("c") Customer c, Model model) { //내용이 다 입력되어 있는 vo를 받아서 출력!!! ////
		service.insert(c);
		//model.addAttribute("c", c); //Customer c 앞에 @ModelAttribute("c")가 붙을 경우 이 줄은 필요없어짐!!//@ModelAttribute 어노테이션이 붙은 객체는(Customer 객체) 자동으로 Model에 추가되고  jsp 까지 전달 됨.
		return "insertSuccess";
	}
	
	@GetMapping(value="/delete.cus")
	public String delete(String num) {
		service.delete(num);
		return "redirect:/list.cus"; //그냥 "list"가 아니다! view로 가는 것이 아니고 list.cus요청이 새로 들어오게 함
	}
	
	//Exception 처리
/*	@ExceptionHandler
	public ModelAndView exceptionHandle(Exception e) {
		ModelAndView mv = new ModelAndView("errorPage"); //생성할 때 view이름을 주어서 생성
		mv.addObject("emsg", e.getMessage()); //.addObject()로 model 정보를 추가한다.
		return mv;
	}	*/
	
	//이 방법으로 mv가 아닌 model에 저장해도 된다.
	@ExceptionHandler
	public String exceptionHandle2(Model model, Exception e) {
		model.addAttribute("emsg", e.getMessage()); //익셉션.getMessage한 것을 emsg로 전달해서 에러페이지에서 출력
		return "errorPage";
	}
	
	@GetMapping(value="/login.cus")
	public String login() { //로그인 화면
		return "login";
	}
	@PostMapping(value="/login.cus")
	public String loginProcess(String id, HttpSession session) { //로그인 처리 //post방식으로 전달된 id를 파라메터로 받아온다.
		session.setAttribute("id", id);
		return "redirect:/list.cus";
	}
	
	@GetMapping(value="/logout.cus")
	public String logout(HttpSession session) { //로그아웃 처리
		session.setAttribute("id", null);
		return "redirect:/list.cus";
	}
	
}
