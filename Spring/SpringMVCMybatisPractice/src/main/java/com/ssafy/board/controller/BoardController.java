package com.ssafy.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.board.Board;
import com.ssafy.board.BoardService;

@Controller
public class BoardController {
	@Autowired
	BoardService service;
	
	

	@GetMapping("/boardList.do")
	public String boardList(Model model) {
		List<Board> list = service.selectAll();
		model.addAttribute("list", list);
		return "index";
	}
	
	@GetMapping("/boardDetail.do")
	public String boardDetail(Model model, String num) {
		Board b = service.selectOne(num);
		model.addAttribute("b", b);
		return "detail";
	}
	
	@GetMapping("/boardInput.do")
	public String boardInput(Board b) {
		return "insert";
	}
	
	@PostMapping("/boardInput.do")
	public String boardInput(@ModelAttribute("b") Board b, Model model) {
		service.insert(b);
		model.addAttribute("b",b);
		return "insertSuccess";
	}
	
	@GetMapping("/boardUpdate.do")
	public String boardUpdate(Board b) {
		service.update(b);
		return "update";
	}
	
	@PostMapping("/boardUpdate.do")
	public String boardUpdate(Board b, Model model) {
		service.update(b);
		model.addAttribute("b",b);
		return "updateSuccess";
	}
	
	@GetMapping("/boardDelete.do")
	public String boardDelete(String num) {
		service.delete(num);
		return "redirect:/boardList.do"; //삭제 후 리다이렉트!!!!
	}
}
