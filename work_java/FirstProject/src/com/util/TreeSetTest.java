package com.util;

import java.util.TreeSet;
//데이터가 오름차순으로 정렬되어 저장됨
//중복X, 입력순서와는 상관 없음
public class TreeSetTest {

	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<>();
		set.add(90); 
		set.add(35);
		set.add(75);
		set.add(100);
		set.add(90);
		set.add(88); //원래 정확하게 하려면 boxing해서 넣어야 하지만 자동으로 해줌
		
		System.out.println(set); //중복이 사라진 오름차순 정렬
		System.out.println(set.first()); 
		System.out.println(set.last());
		System.out.println(set.lower(90)); //해당 객체 바로 아래에 있는 값 찾기 
		System.out.println(set.higher(80)); //해당 객체 바로 위에 있는 값 찾기 
		
		set.pollFirst(); //첫번째 객체를 1.꺼내고(리턴하고) 2.컬렉션에서 제거
		System.out.println(set); 
		
		set.pollLast(); //마지막 객체를 꺼내고 컬렉션에서 제거
		System.out.println(set);
		///////
		TreeSet<String> set2 = new TreeSet<>();
		
		set2.add("123");
		set2.add("홍길동");
		set2.add("ABC");
		set2.add("alien");
		set2.add("banana");
		set2.add("airplane");
		set2.add("apple");
		set2.add("camera");
		set2.add("c");
		set2.add("b");
		set2.add("dance");
		set2.add("apple");
		set2.add("disc");
		
		System.out.println(set2); //스트링도 오름차순 //숫자 -> 영대문자 -> 영소문자 -> 한글 순서
		System.out.println(set2.headSet("banana", true)); //객체 앞-미만, true붙이면 이하의 세트
		System.out.println(set2.subSet("a", "al")); //a, al로 시작되는 값 사이의 세트
		System.out.println(set2.tailSet("c")); //객체 뒤-이후의 세트
	}

}
