package com.di.animal.collection;

import java.util.List;

//@Component //Component에 id가 지정되어 있지 않으면  디폴트로 클래스이름으로 객체가 생성. id="parisZoo"(첫번째 글자는 소문자로 바뀜) //=> context.getBean("parisZoo", Zoo.class)
public class ParisZoo implements Zoo {
	List<Lion> lions;	//2마리 주입	
	List<Tiger> tigers;//2마리 주입				
	
	//setter injection
	public void setLions(List<Lion> lions) {
		this.lions = lions;
	}
	
	public void setTigers(List<Tiger> tigers) {
		this.tigers = tigers;
	}

	@Override
	public void info() {	
		System.out.println("-----------------------------------");
		for(Lion lion : lions)
			lion.info();
		System.out.println("-----------------------------------");
		for(Tiger tiger : tigers)
			tiger.info();
		System.out.println("-----------------------------------");
		System.out.println();
		
	}
}
