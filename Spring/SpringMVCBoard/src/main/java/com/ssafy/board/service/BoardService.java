package com.ssafy.board.service;

import java.util.List;

import com.ssafy.board.vo.Board;

//client(BoardApp.java)를 위한 인터페이스
public interface BoardService {
	public List<Board> selectAll();
	public Board selectOne(String num) throws Exception;
	public void insert(Board c);
	public void delete(String num);
	public List<Board> search(String condition, String word);
	
}
