package com.util;

import java.util.ArrayList;

import com.object.Circle;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList<String> name = new ArrayList<>(); //꺽쇠는 제네릭 프로그래밍을 위해 씀. 한리스트의  타입을 일치시킴
		name.add("tommy");
		name.add("jane");
		name.add("billy");
		name.add("tommy");
		name.add("harry");
		
		System.out.println(name.get(2));
		name.remove("tommy"); //첫번째 토미가 사라짐
		
		System.out.println(name); //레퍼런스만 찍으면 .toString()호출 오버라이딩 되어있다
		for(String n:name)
			System.out.println(n);
		
		ArrayList<Circle> list = new ArrayList<>(); //내가만든 클래스를 가져온다
		list.add(new Circle(6));
		list.add(new Circle(7));
		list.add(new Circle(8));
		list.add(new Circle(9));//반지름으로 넣었으니 생성은 되었다는 것을 안다.(생성자에는 public이 붙어잇음)
		
		for (Circle circle : list) {
			System.out.println("---------------");
			System.out.println(circle.getArea());
			System.out.println(circle.getCircum());
		}
	}

}
