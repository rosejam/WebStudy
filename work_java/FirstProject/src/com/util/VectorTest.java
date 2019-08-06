package com.util;

import java.util.Vector;
//Vector(List종류) : 데이터의 순서 O, 중복 O
public class VectorTest {

	public static void main(String[] args) {

		
		Vector v1 = new Vector(2); //생성자(초기capacity, 증가 capacity); 몇칸씩 늘릴지 말안하면 모자랄때 계속 "2배" 늘린다.
		System.out.println(v1.capacity()); //capacity():벡터 자체 크기 = 벡터가 배열로 몇칸인지 (디폴트 10칸이므로 4칸이 남아있음)
											//내용이 넘어가면 새로운 배열을 만들어서 복사 붙여넣기 한다.
		v1.add("hello");
		v1.add(123);
		v1.add(3.67);
		System.out.println(v1.capacity());
		v1.add('x');
		v1.add(true);
		System.out.println(v1.capacity());
		v1.add("hello");
		
		for(int i=0; i < v1.size() ; i++) { //size():벡터의 내용물(데이터)개수 
			System.out.println(v1.get(i)); //벡터에서 원소꺼내기
		}
		v1.remove(1); //index 1의 데이터를 지움
		System.out.println("---------------------------");
		for(int i=0; i < v1.size() ; i++) { 
			System.out.println(v1.get(i)); 
		}
		v1.clear(); //모든 데이터 날림
		System.out.println(v1.isEmpty()); //true
		System.out.println(v1.size()); //0 
		/////////////////
		Vector<String> v2 = new Vector<>(); //<꺽쇠>는 generic프로그래밍 방식 적용한 것 : 저장될 타입을 말해줌 <뒤>에는 생략 가능 
		v2.add("red");
		v2.add("blue");
		v2.add("white");
		v2.add("pink");
		v2.add("red");
		//v2.add(123);
		
		for(String color : v2) { //타입이 일치되므로 for each문을 사용할수 있다. 
			System.out.println(color);
		}
		////////////////
		int a = 3, b = 5;
		Vector<Integer> v3 = new Vector<>(); //"콜렉션 관련 클래스" 안에는 int 등 기본형안되고 참조형인 "객체만 저장가능"!!!! - Wrapper 클래스를 활용해야함
		v3.add(new Integer(3)); 
		v3.add(new Integer(a));
		v3.add(new Integer(b));
		v3.add(3); //원래 안되는데 auto-boxing 발생. 자동으로 형 변환이 되어서 add 시킨다.
		v3.remove(0);
		System.out.println(v3.size()); //remove하면 알아서 인덱스가 땡겨지고 size가 맞게 줄어드는 것을 확인할 수있다.
	}

}
