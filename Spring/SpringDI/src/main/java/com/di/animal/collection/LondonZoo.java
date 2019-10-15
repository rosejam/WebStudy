package com.di.animal.collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("london")
public class LondonZoo implements Zoo{
	@Autowired
	@Qualifier("tiger1")
	Tiger tiger;
	
	@Autowired
	Lion lion1;

	@Override
	public void info() {
		tiger.info();
		System.out.println("-----------------------------------");
		lion1.info();
		System.out.println("-----------------------------------");
	}

}
