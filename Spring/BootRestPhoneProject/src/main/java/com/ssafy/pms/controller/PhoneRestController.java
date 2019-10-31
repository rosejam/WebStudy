package com.ssafy.pms.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.pms.dto.Phone;
import com.ssafy.pms.dto.UserInfo;
import com.ssafy.pms.service.IPhoneService;

import io.swagger.annotations.ApiOperation;

//@RestController = @Controller + @ResponseBody 가 합쳐진 어노테이션
//								  @ResponseBody : 응답결과(자바 객체)를 json 형식으로 바꿔 보내줌
@RestController
public class PhoneRestController {
	@Autowired
	IPhoneService service;
	
	//GET - http://localhost:8080/rest/phones
	@RequestMapping(value="/phones", method=RequestMethod.GET)
	@ApiOperation("모든 폰 정보") //
	public List<Phone> selectAll(){
		return service.selectAll();
	}
	
	//GET - http://localhost:8080/rest/phones/111
	@RequestMapping(value="/phones/{num}", method=RequestMethod.GET)
	@ApiOperation("해당 번호의 폰 정보") //
	public Phone selectOne(@PathVariable String num){ //url 경로상의 {num}을 가져오기 위한 어노테이션
		return service.selectOne(num);
	}
	
	//POST - http://localhost:8080/rest/phones
	@RequestMapping(value="/phones", method=RequestMethod.POST) //메소드를 오퍼레이션으로 변경
	@ApiOperation("새 폰 등록") //
	public Map insert(@RequestBody Phone c){
					//@RequestBody(json -> java객체) : RequestBody에 담겨져 온 "json객체가 vo인 Phone에 매핑됨!!!"
		service.insert(c);
		HashMap<String, String> map = new HashMap();
		map.put("result", "추가성공");
		return map;
	}
	
	//PUT - http://localhost:8080/rest/phones
	@RequestMapping(value="/phones", method=RequestMethod.PUT)
	@ApiOperation("폰 정보 수정") //
	public Map update(@RequestBody Phone c){
					//@RequestBody(json -> java객체) : RequestBody에 담겨져 온 "json객체가 vo인 Phone에 매핑됨!!!"
		service.update(c);
		HashMap<String, String> map = new HashMap();
		map.put("result", "수정성공");
		return map;
	}
	
	@RequestMapping(value = "/phones/{id}/{pw}", method = RequestMethod.GET)
	@ApiOperation("로그인")
	public Map login(@PathVariable String id, @PathVariable String pw) {
		UserInfo user = new UserInfo(id, pw);
		service.selectUser(user);
		HashMap<String, String> map = new HashMap();
		map.put("result", "로그인 성공");
		return map;
	}
	
	//DELETE - http://localhost:8080/rest/phones/111
	@RequestMapping(value="/phones/{nums}", method=RequestMethod.DELETE) //메소드를 오퍼레이션으로 변경
	@ApiOperation("해당 번호의 폰 정보 삭제") //
	//public Map delete(@PathVariable List<String> list){ 
	public Map delete(@PathVariable String nums){ //url 경로상의 {num}을 가져오기 위한 어노테이션
		//service.delete(num); ////리스트를 어떻게 하나씩 지우는지??
		
		List<String> list = new ArrayList<>();
		for(String tt : nums.split("&")) {
			list.add(tt);
		}
		service.delete(list);
		
		HashMap<String, String> map = new HashMap();
		map.put("result", "삭제성공");
		return map;
	}
	
}
