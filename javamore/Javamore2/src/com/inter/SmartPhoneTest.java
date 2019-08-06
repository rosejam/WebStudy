package com.inter;

import java.util.ArrayList;

public class SmartPhoneTest {

	public static void main(String[] args) {
/*		SmartPhone[] p = new SmartPhone[2];
		p[0] = new IPhone();
		p[1] = new Galaxy();
		
		for(SmartPhone x: p) {
			System.out.println(x.getClass().getName());
			x.call();
			x.sendMessage();
			if(x instanceof IPhone) {
				((IPhone)x).FaceTime();
			}else if(x instanceof Galaxy) {
				((Galaxy)x).saveFile();
			}
		}*/
		ArrayList<SmartPhone> list = new ArrayList<>(); //배열 안에 들어가는 타입을 말해줌
		list.add(new IPhone());
		list.add(new IPhone());
		list.add(new Galaxy());
		list.add(new Galaxy());
		list.add(new Galaxy());
		
		System.out.println(list);
		
		list.remove(1);
		System.out.println(list);
		System.out.println(list.size());
		list.clear();
		System.out.println(list.isEmpty());//true비었다.
	}
}
