package com.computer;

public class SingletonTest { //객체1개만 만들어놓고 쓰는 방법

	public static void main(String[] args) {
		//SingletonObject s = new SingletonObject(); 생성자가 private으로 막혀있다. 대신 써놓은 스태틱 메서드를 사용
		
		//<스태틱 메서드>는 "객체생성 안하고" "클래스이름으로 호출"!!!!
		SingletonObject s1 = SingletonObject.getInstance();
		SingletonObject s2 = SingletonObject.getInstance();
		SingletonObject s3 = SingletonObject.getInstance();
		SingletonObject s4 = SingletonObject.getInstance();
		s1.test();
		
		System.out.println(s1 == s2);
		System.out.println(s2 == s3);
		System.out.println(s3 == s4); //전부 동일한 하나의 객체( "주소값 비교했는데 동일"했으므로 )
	}

}
