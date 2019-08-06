package com.computer;

public class SingletonObject {
	//1. field의 조건 : <static, private> 딱한번만 만들고 외부에서 접근X
	private static SingletonObject instance;// = new SingletonObject(); //SingletonObject(객체, 본인)타입의 instance변수는 스태틱이므로 C.A.에서 여러 객체에서 공유됨!!!!
	//객체에 스태틱을 붙일경우, 객체를 여러개 만들지 않고 하나로 전부 참조해서 사용
	//instance는 싱글톤오브젝트클래스 타입의 변수
	
	//2. 생성자 : private (클래스외부에서 생성못하게 막아놓음!)
	private SingletonObject() {}//생성자메서드가 private로 막혀있음 >클래스내부인 아래쪽에서만 사용
	
	//3. 객체를 생성해서 리턴해 주는 static 메소드가 있어야함(return type = 클래스 이름)
	public static SingletonObject getInstance() { //C.A에 한번생성되고 다시안만들어짐
		if (instance == null) { //null 체크 시 여러 스레드가 동시에 접근해서 여러 객체를 생성하게 될 수도 있으므로 위의 synchronized를 붙여준다.
			instance = new SingletonObject(); //여기서만 생성자 메서드 사용하도록 해놓음 
		}
		return instance;
	}//메서드를 반복해서 호출해도 "instance 객체가 만들어지는 것은 맨 처음뿐 단 한개뿐", 그 후에는 계속 그 객체를 리턴
	
	public void test() {
		System.out.println("hello");
	}
}
