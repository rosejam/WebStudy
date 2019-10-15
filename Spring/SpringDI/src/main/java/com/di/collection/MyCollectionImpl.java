package com.di.collection;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyCollectionImpl implements MyCollection{
	//주입받을 데이터들
	int[] array;
	List<String> list;
	Set<String> set;
	Map<String, String> map;
	
	//setter injection
	public void setArray(int[] array) {
		this.array = array;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public void setSet(Set<String> set) {
		this.set = set;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	
	@Override
	public void arrayInfo() {
		for(int num: array)
			System.out.println(num);
		System.out.println("-----------------------------------");
	}
	
	@Override
	public void listInfo() {
		for(String name: list)
			System.out.println(name);
		System.out.println("-----------------------------------");
	}

	@Override
	public void setInfo() {
		for(String color: set)
			System.out.println(color);	
		System.out.println("-----------------------------------");
	}

	@Override
	public void mapInfo() {
		Set<String> keys = map.keySet();//map안의key만 추출
		for(String key: keys)
			System.out.println(key + ":" + map.get(key));
		System.out.println("-----------------------------------");
	}

}











