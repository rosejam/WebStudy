package com.di.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//(태그는 import하고 xml에서도 따로 표시해 주어야 함!!!)
@Component("london")
public class LondonZoo implements Zoo {
	//@Autowired : 자동 주입(xml문서에서 생성된 객체 중 "타입" 기준으로 자동 주입 됨!!!!)
	//1. 만들어진 Tiger/Lion타입이 있을 경우 타입이 같은 객체를 여기에 자동으로 주입
	//	2. 타입이 같은것이 여러개 있는 경우 id가 필드 이름과 같은 것을 주입!
	
	@Autowired
	@Qualifier("molly") //3. 여기서 지정한 id의 객체를 주입한다!
	Tiger tiger2;
	
	@Autowired
	Lion lion;
	
	@Override
	public void info() {
		tiger2.info();
		lion.info();
		
	}

}
