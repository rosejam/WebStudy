package com.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mybatis.dao.BoardDao;
import com.mybatis.vo.Board;

//@Component("bod")
@Service("bod")
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDao dao;
	
	@Override
	public List<Board> selectAll() {
		return dao.selectAll();
	}
	
	@Override
	@Transactional
	public Board selectOne(String num) throws Exception {
		dao.countUp(num);
		return dao.selectOne(num);
	}
	
	@Override
	public void insert(Board c) {
		dao.insert(c);
	}

	@Override
	public void delete(String num) {
		dao.delete(num);
	}

	@Override
	public List<Board> search(String condition, String word){
		if(condition.equals("title")) {
			return dao.findByTitle(word);
		}else if(condition.equals("name")) {
			return dao.findByName(word);
		}
		return null;
	}

}
