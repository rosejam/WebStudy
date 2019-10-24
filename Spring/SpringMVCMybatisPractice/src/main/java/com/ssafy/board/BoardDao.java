package com.ssafy.board;

import java.util.List;

public interface BoardDao {
	List<Board> selectAll();
	Board selectOne(String num);
	void insert(Board b);
	void delete(String num);
	void update(Board b);
	
}
