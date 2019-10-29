package com.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.service.BoardService;
import com.mvc.vo.Board;

//@RestController = @Controller + @ResponseBody 가 합쳐진 어노테이션
//								  @ResponseBody : 응답결과(자바 객체)를 json 형식으로 바꿔 보내줌
@RestController
public class BoardRestController {
	@Autowired
	BoardService service;
	
	//GET - http://localhost:8080/restb/boards
	@RequestMapping(value="/boards", method=RequestMethod.GET)
	public List<Board> selectAll(){
		return service.selectAll();
	}
	
	//GET - http://localhost:8080/rest/boards/title/la
	//GET - http://localhost:8080/rest/boards/name/kim
	@RequestMapping(value="/boards/{condition}/{value}", method=RequestMethod.GET)
	public List<Board> find(@PathVariable String condition, @PathVariable String value){ //url 경로상의 {num}을 가져오기 위한 어노테이션
		return service.search(condition,value);
	}
	
	//GET - http://localhost:8080/restb/boards/111
	@RequestMapping(value="/boards/{num}", method=RequestMethod.GET)
	public Board selectOne(@PathVariable String num){ //url 경로상의 {num}을 가져오기 위한 어노테이션
		return service.selectOne(num);
	}
	
	//DELETE - http://localhost:8080/restb/boards/111
	@RequestMapping(value="/boards/{num}", method=RequestMethod.DELETE) //메소드를 오퍼레이션으로 변경
	public Map delete(@PathVariable String num){ //url 경로상의 {num}을 가져오기 위한 어노테이션
		service.delete(num);
		HashMap<String, String> map = new HashMap();
		map.put("result", "삭제성공");
		return map;
	}
	
	//POST - http://localhost:8080/restb/boards
	@RequestMapping(value="/boards", method=RequestMethod.POST) //메소드를 오퍼레이션으로 변경
	public Map insert(@RequestBody Board b){
		//@RequestBody(json -> java객체) : RequestBody에 담겨져 온 "json객체가 vo인 Board에 매핑됨"
		service.insert(b);
		HashMap<String, String> map = new HashMap();
		map.put("result", "추가성공");
		return map;
	}
	
	//PUT - http://localhost:8080/restb/boards
	@RequestMapping(value="/boards", method=RequestMethod.PUT)
	public Map update(@RequestBody Board b){
		//@RequestBody(json -> java객체) : RequestBody에 담겨져 온 "json객체가 vo인 Board에 매핑됨"
		service.update(b);
		HashMap<String, String> map = new HashMap();
		map.put("result", "수정성공");
		return map;
	}
	
}
