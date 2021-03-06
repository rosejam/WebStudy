package com.basic;

public class DataTypeTest_ {

	public static void main(String[] args) {
		//논리형 : 참, 거짓 
		boolean flag = true; //우변은 논리 리터럴(숫자는 안됨 ~~)
		
		//정수형 -->int.
		byte b = 1; //1 : -128 ~ 127
		
		//b = b + 1; 
		//정수 리터럴이 "연산에 사용될 때만"(위에 대입에선 상관없었음!), JVM에서 정수 리터럴은 4Byte"에 저장이 되있다.
		//byte변수인 b에 정수리터럴 1을 더함 --> 연산결과는 더 큰 4Byte로 나온다. 
		//연산결과인 int를 byte에 대입하면 타입이 안맞아서 오류(데이터 손실 가능성)
		//			-->1) 명시적 타입변환 또는 2) b의 타입을 바꿔서 맞춰주기
		b = (byte)(b + 1); //1) 강제로 형변환=explicit type casting - 큰 타입의 데이터를 작은 타입의 데이터에 넣을 때
		//			-->그냥 정수형 변수에 "int"를 사용하면 형변환 필요X
		
		short s = 300; //2
		s = b; //작은 데이터를 큰데 들어가는건 문제없음 = implicit type casting
		
		int i = 12345; //4
		s = (short)i;
		
		long l = 67890; //8
		char c = 'q'; //2 : 글자 1개를 저장하기 위한 타입 -- '글자1개' 또는 숫자
		char c2 = '\t'; //tab키, \n:newline(줄바꿈)
		
		//실수형 -->double
		//float f =2.1; 실수형 리터럴은 무조건(대입만 할때도)"8Byte"에 저장되어 있음. 그래서 데이터 타입이 안맞아서 대입 불가~
		float f = 2.1f;
		double d =3.14;
		
		System.out.println("hello" + c2 + "bye");
		System.out.println(flag);
		System.out.println(b);
		System.out.println(s);
		System.out.println(i);
		System.out.println(l);
		System.out.println(c);
		System.out.println(f);
		System.out.println(d);//컨트롤+알트+아래방향키로 자동복사

	}

}
