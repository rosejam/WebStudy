package com.ssafy.pms.repo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.pms.dto.Phone;
import com.ssafy.pms.dto.UserInfo;

@Repository
public class PhoneDaoImpl implements IPhoneDAO {
	@Autowired
	SqlSession session;

	private final String ns = "sql.pms.";

	@Override
	public int insert(Phone phone) {
		return session.insert(ns + "insert", phone);
	}

	@Override
	public int delete(List<String> list) {
		return session.delete(ns + "delete", list);
	}

	@Override
	public int update(Phone phone) {
		return session.update(ns + "update", phone);
	}

	@Override
	public Phone select(Phone phone) {
		return session.selectOne(ns + "select", phone);
	}

	@Override
	public List<Phone> select() {
		return session.selectList(ns + "select", null);
	}

	@Override
	public UserInfo select(UserInfo user) {
		return session.selectOne(ns + "selectUser", user);
	}
}
