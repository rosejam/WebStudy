package com.ssafy.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDaoImpl implements BoardDao {
	@Autowired
	SqlSession session;
	
	public List<Board> selectAll() {
		return session.selectList("selectAll"); //리스트!!!!
	}

	public Board selectOne(String num) {
		return session.selectOne("selectOne", num);
	}

	public void insert(Board b) {
		session.insert("insert", b);
	}

	public void delete(String num) {
		session.delete("delete", num);
	}

	public void update(Board b) {
		session.update("update", b);
	}

}
