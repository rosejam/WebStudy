package com.di.animal.collection;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("london")
public class LondonZoo implements Zoo{
	@Autowired
	@Qualifier("tiger1")
	Tiger tiger;
	
	//@Autowired
	
	//@Resource : id기준으로 주입(이름이 없으면 타입기준, 타입이 여러개면 이름기준)
	@Resource(name="lion2")
	Lion lion1;

	@Override
	public void info() {
		System.out.println("-----------------------------------");
		tiger.info();
		System.out.println("-----------------------------------");
		lion1.info();
		System.out.println("-----------------------------------");
		System.out.println();
	}

}
