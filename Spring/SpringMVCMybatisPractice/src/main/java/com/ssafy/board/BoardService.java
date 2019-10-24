package com.ssafy.board;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public interface BoardService {
	public List<Board> selectAll();
	@Transactional
	public Board selectOne(String num);
	public void insert(Board b);
	public void delete(String num);
	public void update(Board b);
}
