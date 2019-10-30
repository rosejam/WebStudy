package com.ssafy.pms.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.pms.dto.Phone;
import com.ssafy.pms.dto.UserInfo;
import com.ssafy.pms.service.IPhoneService;

import io.swagger.annotations.ApiOperation;

@RestController
public class PhoneRestController {

	@Autowired
	IPhoneService service;

	// all phones
	// one phone
	// insert phone
	// delete
	// update

	// http://localhost:8080/rest/customers
	@RequestMapping(value = "/phone", method = RequestMethod.GET)
	@ApiOperation("모든 고객 정보")
	public List<Phone> selectAll() {
		return service.selectAll();
	}

	// http://localhost:8080/rest/customers/111
	@RequestMapping(value = "/phone/{num}", method = RequestMethod.GET)
	@ApiOperation("모든 폰 정보 조회")
	public Phone selectOne(@PathVariable String num) {
		return service.selectOne(num);
	}
	
	@RequestMapping(value = "/phone/{id}/{pw}", method = RequestMethod.GET)
	@ApiOperation("로그인")
	public Map login(@PathVariable String id, @PathVariable String pw) {
		UserInfo us = new UserInfo(id, pw);
		service.select(us);
		HashMap<String, String> map = new HashMap();
		map.put("result", "로그인 성공");
		return map;
	}

	@RequestMapping(value = "/phone/{num}", method = RequestMethod.DELETE)
	@ApiOperation("해당 번호 폰 정보 삭제")
	public Map delete(@PathVariable List<String> num) {
		service.delete(num);
		HashMap<String, String> map = new HashMap();
		map.put("result", "삭제 성공");
		return map;
	}

	@RequestMapping(value = "/phone", method = RequestMethod.POST)
	@ApiOperation("새 폰 등록")
	public Map insert(@RequestBody Phone p) {
		// @RequestBody(json->java) : RequestBody에 담겨져 온 json 객체가 vo인 Customer에 맵핑됨
		service.insert(p);
		HashMap<String, String> map = new HashMap();
		map.put("result", "추가 성공");
		return map;
	}

	@RequestMapping(value = "/phone", method = RequestMethod.PUT)
	@ApiOperation("폰 정보 수정")
	public Map update(@RequestBody Phone p) {
		// @RequestBody(json->java) : RequestBody에 담겨져 온 json 객체가 vo인 Customer에 맵핑됨
		service.update(p);
		HashMap<String, String> map = new HashMap();
		map.put("result", "수정 성공");
		return map;
	}

}
