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

import com.ssafy.board.service.BoardService;
import com.ssafy.board.vo.Board;

@Controller
public class BoardController {
	@Autowired
	BoardService service;
	
	@ExceptionHandler
	public ModelAndView handler(Exception e) {
		ModelAndView mav = new ModelAndView("ErrorHandler");
		mav.addObject("msg", e.getMessage());
		return mav;
	}

	@GetMapping("/listBoard.do")
	public String boardList(Model model) {
		List<Board> list = service.selectAll();
		model.addAttribute("list", list);
		//return "board/listBoard";
		return "list";
	}
	
	@GetMapping("/readBoard.do")
	public String boardRead(Model model, String num) {
		Board b = null;
		try {
			b = service.selectOne(num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("b", b);
		//return "board/listBoard";
		return "read";
	}

	@PostMapping("/searchBoard.do")
	public String searchBoard(String search, String searchtext, Model model) {
		List<Board> list = service.search(search, searchtext);
		//return "board/searchBoard";
		if(list.size() == 0) {
			return "noresult";
		}else {
			model.addAttribute("list", list);
			return "list";
		}
	}

	@GetMapping("/insertBoardForm.do")
	public String insertBoardForm(Board b) {
		//return "board/boardInsert";
		return "insert";
	}

	@PostMapping("/boardInsert.do")
	public String insertBoard(@ModelAttribute("b") Board b, Model model) {
		service.insert(b);
		//model.addAttribute("b", b);
		return "redirect:listBoard.do";
	}
	
	@GetMapping(value="/deleteBoard.do")
	public String delete(String num) {
		service.delete(num);
		return "redirect:/listBoard.do"; //그냥 "list"가 아니다! view로 가는 것이 아니고 list.cus요청이 새로 들어오게 함
	}
}
