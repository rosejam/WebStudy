package com.object;

import com.abst.Shape; //.*쓰면 패키지안의 모든 클래스 임포트
import com.abst.Circle; 
import com.abst.Rect; 


public class MyShape<X extends Shape> { //데이터 타입에 제약조건을 걸어서 범위를 조금 줄이는 방법
	X data;
	
	public static void main(String[] args) {
		MyShape<Circle> m = new MyShape<>();
		MyShape<Rect> m2 = new MyShape<>();
		//MyShape<String> m3 = new MyShape<>();
		
	}

}
