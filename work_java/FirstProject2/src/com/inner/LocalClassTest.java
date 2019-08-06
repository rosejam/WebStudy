package com.inner;
//local class 예제 : 메소드 안에서 선언되고 메소드 안에서만 사용되는 클래스
class Mountain{ //top-level class
	int height = 1950;
	public void dig() {
		class Gold{ //local inner class : 메소드 안에 클래스가 들어가있음
					//이 메소드 안에서만 사용가능한 클래스(재활용성이 낮다.)
			void glitter() {
				System.out.println("height:" + height);
			}
		}
		//Gold클래스 밖, dig()메소드 안
		Gold g = new Gold();
		g.glitter();
		System.out.println(g.getClass().getName()); //com.inner.Mountain$1Gold 숫자가 껴있음
	}
}

public class LocalClassTest {

	public static void main(String[] args) {
		new Mountain().dig();

	}

}
