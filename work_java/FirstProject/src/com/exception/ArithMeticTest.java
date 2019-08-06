package com.exception;
//Arithmetic Exception : Runtime Exception
//NullPointerException : 객체 생성을 하지 않고 사용하려 할 때 발생 - 자주 나옴
class Car{
	void go() {
		System.out.println("gogo~~~~~");
	}
}

public class ArithMeticTest {
	
	public static void main(String[] args) {
		int a = 90, b = 0, c = 0; //try-catch각각에서 써야하므로 여기서 선언
		
		try { //트라이를 여러번 쓰지 않고 전부 안에 넣음, 익셉션 종류가 여러개면 catch가 많아짐...
			Car cc =null;
			cc.go();
			
			/////
			c = a / b;
/*		}catch(ArithmeticException e) { 
			c=-999;
		}catch(NullPointerException n) {
			System.out.println("객체를 생성해주세요");
		}*/			
		}catch(Exception q) { //q가 아리스메틱, 널포인터등 모두 잡음(상위 객체) catch수를 줄일 수 있음
			q.printStackTrace(); //예외처리는 되지만 빨간색으로 내용이 출력되므로
		}
		
		System.out.println(c);
		
		

		
	}
}
