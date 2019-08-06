package com.util;
//Set:데이터간 순서X, 중복X

import java.util.HashSet;

public class HashSetTest {

	public static void main(String[] args) {
		HashSet<String> set = new HashSet<>();
		set.add("spring");
		set.add("summer");
		set.add("spring");
		set.add("winter");
		set.add("fall");
		set.add("spring");
		
		set.remove("spring"); //순서가 없기 때문에 리스트와 다르게 인덱스로 지울수 없다 -> 객체 지정해서 삭제
		
		for(String season : set) {
			System.out.println(season); //순서가 바뀌어있는것을 확인할 수 있다.
		}
		
		set.clear(); //모든 내용물 삭제
		System.out.println(set.size()); //0 내용물 개수
	}

}
