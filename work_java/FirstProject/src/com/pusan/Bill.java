package com.pusan;
import java.awt.Button;
//import java.awt.*; //이 패키지안의 모든 클래스를 CA에 올려서 메모리가 낭비될 수 있음
import java.util.Date;

import com.object.Circle;
import com.seoul.Tommy; //작업단위는 패키지 이므로, 다른 패키지의 클래스를 사용하려면 import 패키지.클래스를 해주어야함
//Organize imports(컨+쉬+o)로 빠르게 import를 해줄 수 있다.

public class Bill {
	public static void main(String[] args) {
		Button b = new Button();
		Date d = new Date();
		System.out.println(d); //d.toString()과 동일
		Tommy t = new Tommy();
		t.hello();
		System.out.println(t.age); //필드age, 메서드 hello등 앞에 퍼블릭 수식어가 붙어야 다른패키지에서 접근할 수 있음!!!
		
		Circle c = new Circle(8); 
	}
}
