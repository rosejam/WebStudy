package com.seoul;

public class Tommy {
	public int age = 30;
	
	public void hello() {
		Member m = new Member();
		//m.num = 999;는 안됨ㅜㅜ 필드가 private이라.. 
		m.setNum(999); //메소드를 통해서 간접적으로 데이터에 접근은 가능
 		System.out.println("hello, tommy...");
	}
}
