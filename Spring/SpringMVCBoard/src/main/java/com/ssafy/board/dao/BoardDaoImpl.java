package com.ssafy.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.board.vo.Board;

//@Component("bdao")
@Repository("bdao")
public class BoardDaoImpl implements BoardDao {
	@Autowired
	SqlSession session;
	
	public List<Board> selectAll() {
		return session.selectList("board.selectAll");
	}

	public Board selectOne(String num) {
		return session.selectOne("board.selectOne", num);
	}

	public int insert(Board b) {
		int x = session.insert("board.insert", b);
		return x;
	}

	public int delete(String num) {
		int x = session.delete("board.delete", num);
		return x;
	}

	public List<Board> findByTitle(String title) {
		return session.selectList("board.findTitle", title);
	}

	public List<Board> findByName(String name) {
		return session.selectList("board.findName", name);
	}

	public void countUp(String num) { //countUp
		session.update("board.countUp", num);
	}
	
}
