package com.app;

import java.util.List;

import com.dao.CustomerDAO;
import com.dao.ICustomer;
import com.domain.Customer;

//client program
public class CustomerTest {

	public static void main(String[] args) {
		//CustomerDAO dao = new CustomerDAO();
		ICustomer dao = new CustomerDAO(); //���� ������ : �������̽� ���� �޼ҵ常 ȣ�� ����(DAO���� �߰��� �޼ҵ�� ��� �Ұ�, ���������θ� ���)
		List<Customer> list = dao.selectAll();
		for (Customer rec : list) {
			System.out.println(rec.getNum() + "--" + rec.getName() + "--" + rec.getAddress());
		}
		System.out.println("----------------------------");
		List<Customer> list2 = dao.searchAll(null, null); // name / address / null(����)
		for (Customer rec : list2) {
			System.out.println(rec.getNum() + "--" + rec.getName() + "--" + rec.getAddress());
		}
		System.out.println("----------------------------");
		Customer rec = dao.selectOne("730");
		System.out.println(rec.getNum() + "--" + rec.getName() + "--" + rec.getAddress());
	}

}