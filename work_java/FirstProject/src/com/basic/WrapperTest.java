package com.basic;

public class WrapperTest {
	
	public void test(Integer x) {
		System.out.println(x+1); //Integer - > int 언박싱이 포함된 번역 
	}
	
	public static void main(String[] args) {
		new WrapperTest().test(55); //boxing int -> Integer //Integer형을 줘야 하는데 int형을 줘버림. but 컴파일러 내부에서 자동으로 boxing해줌.
		
		int a = 89;
		double d = 3.66;
		boolean flag = true;
		char c = 'x';
		String num ="345";
		
		//기본형 데이터를 객체형으로 변환시켜 주는 클래스 -> wrapper class(boxing) (메소드를 호출 할 수 있게됨)
		Integer i = new Integer(a);
		int num2 = Integer.parseInt(num);
		double d33 = Double.parseDouble("5.66");
		
		Double d2 = new Double(d);
		Boolean b2 = new Boolean(flag);
		Character c2 = new Character(c);
		
		int val = i.intValue(); //unboxing
		double d3 =d2.doubleValue();
	}

}
