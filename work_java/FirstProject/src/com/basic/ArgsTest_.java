package com.basic;

public class ArgsTest_ {

	public static void main(String[] args) { //여기에 배열이 하나 들어가있음! 그러나 선언만 되어있고 생성이 안되어있기 때문에 배열에 접근 불가
		//Run configuration으로 입력변수를 넣어줌
		System.out.println(args[0]); 
		for(String x : args) 
			System.out.println(x); 
		
	}

}
