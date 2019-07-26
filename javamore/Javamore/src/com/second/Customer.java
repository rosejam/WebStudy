package com.second;

public class Customer {
	//data(field, member field, property)= 전역변수 (초기화 안해도 default값을 가지고 있음 )
	int num;
	String name;
	String address;
	
	//생성자 : 객체생성시에 자동 호출되는 메소드. 초기화(값 셋팅)작업 등이 들어감
	//조건 : 메소드 이름이 클래스 이름과 동일해야 하고 리턴 타입은 적지 않음
	Customer(){
		System.out.println("Customer 생성자 ");
	}
	Customer(int num){
		this.num = num; //this란? "이 생성자가 호출될 때 만들어진 바로 그 객체"를 의미 
		//c2.num 안됨. c2는 만들어지지도 않은 지역변수
	}
	Customer(int num, String name){
		this.num = num;
		this.name = name;
	}
	Customer(int num, String name, String address){
		this.num = num;
		this.name = name;
		this.address = address;
	}
	
	//method
	void info() {
		String code = "tom"; //지역변수는 반드시 초기화 시킨 후에 사용가능함
		System.out.println(code);
		
		System.out.println("num:" + num);
		System.out.println("name:" + name);
		System.out.println("address:" + address);
	}
	
	void test() {
		//System.out.println(code);
	}
	
	public static void main(String[] args) {
		Customer c1 = new Customer();
		Customer c2 = new Customer(123);
		c2.num = 987;
		c2.info();
		Customer c3 = new Customer(457, "tommy");
		Customer c4 = new Customer(890, "jane", "seoul");
	}
}
