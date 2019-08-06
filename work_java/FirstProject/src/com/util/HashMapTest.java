package com.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
//Map : key-value 쌍(=entry!!)로 이루어진 자료구조. 중복X, 순서X
public class HashMapTest {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		map.put("num", "123");
		map.put("name", "tommy");
		map.put("address", "seoul");
		map.put("address", "london"); //put
		
		System.out.println(map);//{엔트리들}
		
		String num = map.get("num"); //get (key) 
		String address = map.get("address");
		System.out.println(num + ":"+ address);
		
		Set<String> keys = map.keySet(); //keySet은 map안에 들어 있는 키만 추출해서 Set에 담아준다!! 그 다음에 for문
		for(String key: keys) {
			String val = map.get(key);
			System.out.println(key + ":" + val);
		}
		System.out.println("---------");
		
		//TreeMap
		TreeMap<String, String> tmap = new TreeMap<>();
		tmap.put("111", "tommy");
		tmap.put("abc", "billy");
		tmap.put("ABC", "julie");
		tmap.put("참가자", "kim");
		
		System.out.println(tmap);
		System.out.println(tmap.firstKey());
		
		Set<Map.Entry<String, String>> entries = tmap.entrySet(); //Set에 <맵에서 사용하는 엔트리 타입의 데이터(키밸류쌍)>들이 들어있다.
		for(Map.Entry<String, String> entry : entries) {
			System.out.println(entry.getKey() + "::" + entry.getValue());
		}
		System.out.println("뜝뜝이 안녕");
	}

}
