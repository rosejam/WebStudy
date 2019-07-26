package com.computer;

public class SingletonObject {
	//1. field의 조건 : <static, private> 딱한번만 만들고 외부에서 접근X
	private static SingletonObject instance; //SingletonObject(객체, 본인)타입의 instance변수는 스태틱이므로 C.A.에서 여러 객체에서 공유됨!!!!
	//객체에 스태틱을 붙일경우, 객체를 여러개 만들지 않고 하나로 전부 참조해서 사용
	
	//2. 생성자 : private (클래스외부에서 생성못하게 막아놓음)
	private SingletonObject() {}//생성자메서드가 private로 막혀있음 >클래스내부인 아래쪽에서만 사용
	
	//3. 객체를 생성해서 리턴해 주는 static 메소드가 있어야함
	public static SingletonObject getInstance() { //C.A에 한번생성되고 다시안만들어짐
		if (instance == null) {//최초
			instance = new SingletonObject(); 
		}
		return instance;
	}//메서드를 반복해서 호출해도 "instance 객체가 만들어지는 것은 맨 처음뿐 단 한개뿐", 그 후에는 계속 그 객체를 리턴
	
	public void test() {
		System.out.println("hello");
	}
}
