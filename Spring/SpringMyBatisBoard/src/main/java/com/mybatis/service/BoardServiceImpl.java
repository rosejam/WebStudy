package com.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mybatis.dao.BoardDao;
import com.mybatis.vo.Board;

@Component("bod")
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDao dao;
	
	@Override
	public List<Board> selectAll() {
		return dao.selectAll();
	}
	
	@Transactional
	@Override
	public Board selectOne(String num) throws Exception {
		dao.update(dao.selectOne(num));
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
	public List<Board> findByTitle(String title) {
		return dao.findByTitle(title);
	}

	@Override
	public List<Board> findByName(String name) {
		return dao.findByName(name);
	}

}
