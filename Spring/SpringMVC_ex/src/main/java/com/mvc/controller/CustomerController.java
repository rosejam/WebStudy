package com.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mybatis.service.CustomerService;
import com.mybatis.vo.Customer;


@Controller
public class CustomerController {	
	@Autowired
	CustomerService service;
	
	
	 @ExceptionHandler
	 public ModelAndView handler(Exception e) { 
		 ModelAndView mav  = new ModelAndView("ErrorHandler"); 
		 mav.addObject("msg", e.getMessage());
		 return mav;
	}
	 
	/*
	@ExceptionHandler
	 public String handler2(Model model, Exception e) {		
		 model.addAttribute("msg", e.getMessage()+"ggggg");
		 return "ErrorHandler";
	 }
	*/
	 
	//http://localhost:7777/mvc/list.mvc(properties file check)
	//@RequestMapping(value = "/all.cus", method = RequestMethod.GET)
	@GetMapping(value= "/list.mvc")
	public String list(Model model) {
		
		List<Customer> list = service.selectAll();
		model.addAttribute("list", list);
		
		return "list";
	}
	
	//parameter num

	@GetMapping(value = "/detail.mvc")
	//public String detail(@RequestParam(value="num") String number, Model model) {
	public String detail(String num, Model model) {
		
		Customer c = service.selectOne(num);
		model.addAttribute("c", c);
		
		return "detail";//handler method
	}
	
	
	@GetMapping(value = "/delete.mvc")
	//public String detail(@RequestParam(value="num") String number, Model model) {
	public String delete(String num) {		
		//int c = service.delete(num);		
		
		return "redirect:/list.mvc";
	}
	
	@GetMapping(value = "/insert.mvc")
	public String insert(Customer c) {
		return "insert";
	}
	
	@PostMapping(value = "/insert.mvc")
	//public String insertProcess(String num, String name, String address, Model model) {	
	public String insertProcess(Customer c, Model model) {	//
		//Customer c = new Customer(num, name, address);
		service.insert(c);
		
		model.addAttribute("c", c);		
		return "insertSuccess";
	}
	
	
	
}










