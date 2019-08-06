package com.object;
//<꺽쇠>의 의미를 알아보자 (generic)
//클래스 안의 필드 타입을 컴파일 타임이 아닌 런타임에 결정하는 방식
public class MyTest<X> { //X라는 타입이 사용이 될것이다.(컴파일시켜도 어떤 타입인지는 모름 고정되지않음) but 미완성 클래스는 아니다!
	//field 선언
	int a; 
	String b;
	X what;
	
	public X getWhat() {
		return what;
	}

	public void setWhat(X what) {
		this.what = what;
	}

	public static void main(String[] args) { //다른클래스로 가도됨
		MyTest<String> t = new MyTest<>(); //"객체 생성시=실행시"!!! 이 때 X의 타입이 결정된다! 
		MyTest<Integer> t2 = new MyTest<>(); //따라서 Heap에 같은 클래스타입 객체로 있지만 안의 X타입이 다르다!!!!
		
		t.setWhat("hello, generic...");
		t2.setWhat(123);
		
		System.out.println(t.getWhat());
		System.out.println(t2.getWhat());
		
	}

}
