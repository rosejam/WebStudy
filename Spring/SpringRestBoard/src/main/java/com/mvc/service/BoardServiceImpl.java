package com.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.dao.BoardDao;
import com.mvc.vo.Board;

//@Component("bod")
@Service("bod")
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDao dao;
	
	public List<Board> selectAll() {
		return dao.selectAll();
	}
	
	//@Transactional
	//public Board selectOne(String num) throws Exception {
	public Board selectOne(String num) {
		dao.countUp(num);
		return dao.selectOne(num);
	}
	
	public void insert(Board c) {
		dao.insert(c);
	}

	public void delete(String num) {
		dao.delete(num);
	}

	public List<Board> search(String condition, String word){
		if(condition.equals("title")) {
			return dao.findByTitle(word);
		}else if(condition.equals("name")) {
			return dao.findByName(word);
		}
		return null;
	}

	public void update(Board b) {
		dao.update(b);
	}

}
