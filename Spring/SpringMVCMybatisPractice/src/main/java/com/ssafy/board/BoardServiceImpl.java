package com.ssafy.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bod")
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDao dao;
	
	public List<Board> selectAll() {
		return dao.selectAll();
	}

	public Board selectOne(String num) {
		return dao.selectOne(num);
	}

	public void insert(Board b) {
		dao.insert(b);
	}

	public void delete(String num) {
		dao.delete(num);
	}

	public void update(Board b) {
		dao.update(b);
	}
	
}
