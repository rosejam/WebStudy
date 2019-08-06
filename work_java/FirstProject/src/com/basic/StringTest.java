package com.basic;

public class StringTest {

	public static void main(String[] args) {
		String a = new String("mylimeorange"); //new로 생성했기 때문에 Heap에 생김
		String b = "mylimeorange"; // C.A안의 Constant Pool에 생김!!
		String c = "mylimeorange"; //스트링은 객체타입중 유일하게 기본형처럼 선언후 바로 값대입이 가능
		
		if(a==b) //두 변수의 주소값 비교, Heap과 C.A에 있으므로 다름
			System.out.println("a==b"); //X 
		if(a.equals(b)) //내용 비교
			System.out.println("a.equals(b)"); //O
		if(b==c) //Constant pool안의 같은 데이터를 가르키는 변수. 값은 하나인데 가르키는 변수는 2개이므로 한쪽을 바꾸면 다른쪽도 바뀜(->그래서 스트링클래스의 "원본은 항상 수정이 안됨")
			System.out.println("b==c"); //O
		
		String aa = b.toUpperCase(); //원본은 그대로 두고 대문자로된 문자열이 따로 새로 만들어짐
		System.out.println(aa);
		System.out.println(b); //b는 그대로
		
		a.concat("gogo"); //원본은 그대로 두고
		System.out.println(a); //c는 그대로 
		
		b=b+"hello"; //변경한 내용은 b에 넣었으므로 b는 새로운 내용 가리킴
		System.out.println(b);
		System.out.println(b.substring(0,5));//0~4인덱스
		System.out.println(b.substring(5)); //서브스트링은 오버로딩되어있음. 5~끝인덱스 
		System.out.println(b.charAt(2));
		System.out.println(b.replace('m','x'));
		
		//SB는 원본 데이터에 바로 수정함  -> 스트링보다 메모리 절약
		StringBuffer buffer = new StringBuffer("mylimeorange");
		buffer.append("hello"); //String에선 .concat()이 SB에서는 .append()
		System.out.println(buffer); 
	}

}
