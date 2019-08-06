package com.exception;
//사용자 정의 Exception 클래스 : Exception 클래스를 상속받아야 함!
class MyException extends Exception {
	@Override
	public String toString() { //(레퍼런스만 찍을경우 자동호출되는) toString을 오버라이딩
		return "MyException 발생 : 0이나 양수값을 넣어주세요";
	} //MyException객체를 생성한다 == 예외가 발생한다!!
	
}


public class MyExceptionTest {
	public void go() {
		System.out.println("gogo~~~~");
	}
	//throw new MyException : 해당 메소드 실행 도중에 특정한 조건이 되면 예외가 발생할 수 있음을 표시하는 선언(저 익셉션을 발생시킬 수 있다.)
	//예외가 발생되어도 처리를 하지 않고 호출자로 예외를 전달하는 것을 표시 - 여기서는 main
		
	public void check2(int num) throws MyException { //throw's' 익셉션
		if(num >= 0) {
			System.out.println(--num);
		}else {
			throw new MyException();
		}
	}
	
	public void check(int num) { 
		if(num >= 0 ) {
			System.out.println(++num);
		}else{//num이 음수인 경우를 예외 상황으로 처리 -> 예외를 발생시킴
			
			try {
				throw new MyException(); // -> 예외 발생시킬때 사용(throw 익셉션객체 )
			} catch (MyException e) {
				System.out.println(e);
			}
			
		}
	}

	public static void main(String[] args) { //만약 main에서 throws로 던지면 아무도 예외처리를 하지 않아 VM으로 간다. - 빨간글씨 발생
		MyExceptionTest test = new MyExceptionTest();
		//test.check(-66);
		try {
			test.check2(-66);
		} catch (MyException e) {
			e.printStackTrace();
		}
		
	}

}
