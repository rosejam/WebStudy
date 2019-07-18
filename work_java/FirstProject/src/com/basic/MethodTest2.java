package com.basic;

public class MethodTest2 {
	//
	static double average(int a, int b, int c) {
		double average = (a + b + c) / 3; //3이 아닌 3.0으로 나누어야함!!!!!
		return average;
	}
	static String concat(String a, String b) {
		String concat = a + b;
		return concat;
	}
	//reverse() : boolean형 매개변수 한 개를 입력 받아 그 반대의 값을 리턴
	//(true => false, false =>true)
	static boolean reverse(boolean X) {
		boolean X_toggle = !X;
		return X_toggle;
	}
	static String result(boolean a, boolean b) {
		//if문 사용할 때 if와 else안쪽에 return을 해주어야한다!!!!!!!!!!!!!!!!!!!!!!!
/*		if (a && b) {
			String result = "ok";
			return result;
		}
		else {
			String result = "cancel";
			return result;
		}*/
		//3항연산자 사용하면 더 간단
		String result = (a && b) ? "ok" : "cancel";
		return result;
	}
	static void loopString(int count, String msg) {
		for(int i=0; i<count; i++) {
			System.out.println(msg);
		}
	}
	static double getArea(int r) {
		return 3.14 * r * r;
	}
	static void printCircum(int r) {
		System.out.println(2*3.14*r);
	}
	static int[] makeArray(int len) {
		int[] array;
		array = new int[len];
		//int[] array = new int[len]; //한줄표현
		return array;
	}
	static int total(int[] data) {
		int total = 0;
		for(int x: data) {
			total = total + x;
		}
//		for(int i=0; i<a.length ; i++)
//			total = total + a[i];
		return total;
	}

	
	public static void main(String[] args) { //public static는 메서드의 수식어
		// main메서드 내부에서 사용자 정의 메소드들을 사용하는 부분
		System.out.println(average(1514,147,8473));
		System.out.println(concat("ㄹㄹㄹ","루후루"));
		System.out.println(result(true, true));
		System.out.println(reverse(false));
		loopString(4,"message");
		System.out.println(getArea(7));
		printCircum(3);
		System.out.println(makeArray(8));
		int[] data = {10, 28, 30, 50, 90, 123, 450, 66, 67};
		total(data);
	}
	//main바깥
	
}