package com.inner;
//static class 예제 : static class 사용 시에는 반드시 바깥쪽 클래스를 생성하지 않아도 됨!
//바깥쪽 클래스의 이름으로 생성 가능
class Outer{ //top-level class
	static int count = 99;
	
	static class Inner{ //static inner class 
		public void go() {
			System.out.println(count); //바깥 클래스의 스태틱 필드를 사용
		}
	}
}

public class StaticClassTest {

	public static void main(String[] args) {
		System.out.println(Outer.count); //스태틱 변수이므로 클래스이름.변수이름으로 접근가능
		
		//inner class 생성(그냥 Inner라고 하면 못알아들음.)
		//위의 count와 똑같이, 스태틱이 붙은 class이므로 (외부)클래스이름.클래스이름으로 접근해서 생성할 수 있다.
		Outer.Inner i = new Outer.Inner(); //Outer클래스를 생성하지는 않았음!!
		i.go();
		System.out.println(i.getClass().getName()); //com.inner.Outer$Inner, 즉 Outer$Inner클래스이다.

	}

}
