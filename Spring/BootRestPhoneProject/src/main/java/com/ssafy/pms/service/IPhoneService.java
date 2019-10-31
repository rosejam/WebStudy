package com.ssafy.pms.service;

import java.util.List;

import com.ssafy.pms.dto.Phone;
import com.ssafy.pms.dto.UserInfo;

public interface IPhoneService {
	int insert(Phone phone);

	int delete(List<String> list);

	int update(Phone phone);

	Phone selectOne(String num);

	List<Phone> selectAll();

	UserInfo selectUser(UserInfo user);

}