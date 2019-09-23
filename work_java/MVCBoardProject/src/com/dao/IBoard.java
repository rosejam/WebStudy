package com.dao;

import java.util.ArrayList;

import com.vo.Board;

public interface IBoard {
	public ArrayList<Board> selectAll();
	public Board selectOne(String num);
	public void insert(Board b);
	public void delete(String num);
	public ArrayList<Board> search(String condition, String word);
	public void countUp(String num);
}
