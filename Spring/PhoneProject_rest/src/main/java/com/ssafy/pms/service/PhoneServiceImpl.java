package com.ssafy.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.pms.dto.Phone;
import com.ssafy.pms.dto.UserInfo;
import com.ssafy.pms.repo.IPhoneDAO;

@Service
public class PhoneServiceImpl implements IPhoneService {
	@Autowired
	IPhoneDAO repo;

	@Override
	@Transactional
	public int insert(Phone phone) {
		return repo.insert(phone);
	}

	@Override
	@Transactional
	public int delete(List<String> list) {
		return repo.delete(list);
	}

	@Override
	public Phone select(Phone phone) {
		return repo.select(phone);
	}

	@Override
	public List<Phone> select() {
		return repo.select();
	}

	@Override
	public UserInfo select(UserInfo user) {
		return repo.select(user);
	}

	@Override
	public int update(Phone phone) {
		return repo.update(phone);
	}
}
