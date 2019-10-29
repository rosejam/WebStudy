package com.ssafy.pms.repo;

import java.util.List;

import com.ssafy.pms.dto.Phone;
import com.ssafy.pms.dto.UserInfo;

public interface IPhoneDAO {
	int insert(Phone phone);

	int delete(List<String> list);

	Phone select(Phone phone);

	List<Phone> select();

	UserInfo select(UserInfo user);
	
	// rest service 추가
	int update(Phone phone);
	
}
