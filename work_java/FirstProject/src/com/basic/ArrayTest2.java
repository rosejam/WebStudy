package com.basic;

public class ArrayTest2 {

	public static void main(String[] args) {
		int[] a = new int[3]; //선언+생성
		boolean[] b = new boolean[100];
		double[] d = new double[200];
		String[] name = new String[10];
		
		//참조형은 new로 생성할 때 기본으로 default값이 들어간다.
		//따라서 참조형인 배열은 생성만 해도 타입별로 default값이 들어가 있다.
		System.out.println(a[1]); //0
		System.out.println(b[56]); //false
		System.out.println(d[195]); //0.0
		System.out.println(name[7]); //null
	}

}
