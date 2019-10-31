package com.ssafy.pms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.pms.dto.Phone;
import com.ssafy.pms.dto.UserInfo;
import com.ssafy.pms.service.IPhoneService;

@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	IPhoneService service;
	
	@GetMapping("regPhone.do")
	public String getRegPhone(Model model) {
		model.addAttribute("title", "핸드폰 관리-핸드폰 등록");
		return "PhoneReg";
	}

	@PostMapping("regPhone.do")
	public String doRegPhone(Phone phone, Model model) {
		try {
			service.insert(phone);
			model.addAttribute("title", "핸드폰 관리-등록성공");
			return "Result";
		}catch(RuntimeException e) {
			logger.error("폰등록실패", e);
			model.addAttribute("title", "핸드폰 관리-에러");
			model.addAttribute("message", "문제 내용 - 저장 중 오류가 발생했습니다.");
			return "Error";
		}
	}
	
	@GetMapping("searchPhone.do")
	public String doList(Model model) {
		try {
			List<Phone> list = service.selectAll();
			model.addAttribute("title", "핸드폰 관리-리스트");
			model.addAttribute("phones", list);
			return "PhoneList";
		}catch(RuntimeException e) {
			logger.error("폰 목록 조회 실패", e);
			model.addAttribute("title", "핸드폰 관리-에러");
			model.addAttribute("message", "문제 내용 - 목록조회 중 오류가 발생했습니다.");
			return "Error";
		}
	}
	
	@GetMapping("detail.do")
	public String doDetail(String num, Model model) {
		try {
			Phone selected = service.selectOne(num);
			model.addAttribute("title", "핸드폰 관리-핸드폰 조회");
			model.addAttribute("phone", selected);
			return "PhoneView";
		}catch(RuntimeException e) {
			logger.error("폰조회실패", e);
			model.addAttribute("title", "핸드폰 관리-에러");
			model.addAttribute("message", "문제 내용 - 조회 중 오류가 발생했습니다.");
			return "Error";
		}
	}
	
	@GetMapping("login.do")
	public String getLoginForm() {
		return "Login";
	}
	
	@PostMapping("login.do")
	public String doLogin(UserInfo user, Model model, HttpSession session) {
		try {
			UserInfo selected = service.selectUser(user); //유저
			logger.info("user: {}", selected);
			if(selected!=null) {
				session.setAttribute("loginUser", selected);
				return "redirect:searchPhone.do";
			}else {
				return "Login";
			}
		}catch(RuntimeException e) {
			logger.error("로그인 실패", e);
			model.addAttribute("title", "핸드폰 관리-로그인 실패");
			model.addAttribute("message", "문제 내용 - 로그인 중 오류가 발생했습니다.");
			return "Error";
		}
	}
	
	@GetMapping("logout.do")
	public String doLogout(HttpSession session) {
		session.setAttribute("loginUser", null);
		return "redirect:rest.do";
	}
	
	@GetMapping("rest.do")
	public String getRestClient() {
		return "rest";
	}
	
	@PostMapping("update.do")
	public String doUpdate(Phone phone, Model model) {
		try {
			service.update(phone);
			model.addAttribute("title", "핸드폰 관리-수정성공");
			return "Result";
		}catch(RuntimeException e) {
			logger.error("폰수정실패", e);
			model.addAttribute("title", "핸드폰 관리-에러");
			model.addAttribute("message", "문제 내용 - 저장 중 오류가 발생했습니다.");
			return "Error";
		}
	}
	
	@GetMapping("delete.do")
	public String doDelete(@RequestParam List<String> list, Model model) {
		try {
			service.delete(list);  ////리스트를 어떻게 하나씩 지우는지??
			return "redirect:searchPhone.do";
		}catch(RuntimeException e) {
			logger.error("폰삭제실패", e);
			model.addAttribute("title", "핸드폰 관리-에러");
			model.addAttribute("message", "문제 내용 - 삭제 중 오류가 발생했습니다.");
			return "Error";
		}
	}
	
}
