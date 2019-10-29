package com.ssafy.pms.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.pms.dto.Phone;
import com.ssafy.pms.dto.UserInfo;
import com.ssafy.pms.repo.IPhoneDAO;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:/spring/application-config.xml")
@Transactional
public class RepoTest {

	@Autowired
	IPhoneDAO repo;

	@Test
	public void testBean() {
		assertThat(repo, is(notNullValue()));
	}

	@Test
	public void insertPhoneTest() {
		Phone phone = new Phone("num", "model", 100, "10");
		int result = repo.insert(phone);
		assertThat(result, is(1));
	}

	@Test
	public void selectPhoneTest() {
		Phone phone = new Phone();
		phone.setNum("S105G");
		Phone selected = repo.select(phone);
		assertThat(selected.getModel(), is("겔럭시 S10 5G"));
		assertThat(selected.getCompany().getVendor(), is("삼성"));
	}

	@Test
	public void deletePhoneTest() {
		List<String> list = Arrays.asList("S105G", "V50SQ");
		int result = repo.delete(list);
		assertThat(result, is(2));

		Phone phone = new Phone();
		phone.setNum("S105G");
		Phone selected = repo.select(phone);
		assertThat(selected, is(nullValue()));
	}

	@Test
	public void loginTest() {
		UserInfo user = new UserInfo("ssafy", "ssafy");

		UserInfo selected = repo.select(user);
		assertThat(selected, is(notNullValue()));

		user = new UserInfo("ssafy", "some");

		selected = repo.select(user);
		assertThat(selected, is(nullValue()));
	}
}
