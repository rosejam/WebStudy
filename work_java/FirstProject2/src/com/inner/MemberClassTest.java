package com.inner;
//member class 예제 : member class 사용 시에는 반드시 바깥쪽 클래스가 먼저 생성되어 있어야 됨!
class Car{ //top-level class
	int speed = 200; //member field
	//member method
	class Engine{ //member inner class (범위 수식어는 붙여도됨) - "타입이 클래스인 Car의 멤버"
					//위의 멤버필드speed처럼 Engine클래스도 Car클래스의 멤버이다.
		public void run() {
			System.out.println("speed:" + speed);
		}
	}
}

public class MemberClassTest {

	public static void main(String[] args) {
		Car c = new Car(); //바깥쪽 클래스의 객체를 생성
		System.out.println(c.speed);
		
		Car.Engine e = c.new Engine(); //new후에, 생성된객체의 레퍼런스.new 이너클래스
		e.run();
		System.out.println(e.getClass().getName()); //com.inner.Car$Engine //내부클래스도 클래스파일이 따로만들어짐
	}
}
