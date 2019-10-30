package com.mvc.dao;

import java.util.List;

import com.mvc.vo.Board;

public interface BoardDao {
	public List<Board> selectAll();
	public Board selectOne(String num);
	public int insert(Board b);
	public int delete(String num);
	public List<Board> findByTitle(String title);
	public List<Board> findByName(String name);
	public void countUp(String num);
	public void update(Board b);
	
}