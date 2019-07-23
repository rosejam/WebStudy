package com.inter;

class Tom{
	int age = 55;
}
class Bill{}
interface Hillary{
	//인터페이스 안의 필드는 기본으로 static이자 final이다!!!!
	int age = 50; //옆으로 누워있으면 static인 것을 알 수 있다.
}

public class LittleTom extends Tom implements Hillary {
	int age = 25; //리틀톰은 3개의 age변수를 가짐
	
	void test() {
		System.out.println(age);
		System.out.println(this.age);
		System.out.println(super.age); //상위 클래스의 필드값
		//Hillary.age = 52;
		System.out.println(Hillary.age); //상위 인터페이스의 필드값 (인터페이스를 생성하지 않고 이름으로 필드값에 접근할 수 있다!!!!!)
	}
	
	public void main(String[] args) {
		LittleTom little = new LittleTom();
		
		if(little instanceof Tom) {
			System.out.println("instanceof Tom");
		}
		if(little instanceof Hillary) {
			System.out.println("instanceof Hillary");
		}
		if(little instanceof LittleTom) {
			System.out.println("instanceof LittleTom");
		}
		if(little instanceof Object) {
			System.out.println("instanceof Object");
		}
//		if(little instanceof Bill) {
//			System.out.println("instanceof Bill");
//		} //상속관계가 아니기 때문에 비교불가
		
	}
}
