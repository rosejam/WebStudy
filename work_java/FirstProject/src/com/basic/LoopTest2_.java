package com.basic;

public class LoopTest2_ {

	public static void main(String[] args) {
		// 여러겹의 for -- logic이 생각이 잘안날 때 
here:	for(int i = 0; i < 5; ++i) { //0,1,2,3,4 //here라는 label을 붙임
			for(int j = 0; j < 3; j++) { //0,1,2
				for(int k = 0; k < 3; k++) { //0,1,2
					if(j == 2)
						//break here; //k가 2가되면 here라벨이 붙은곳까지 가서 반복문을 탈출
						continue here;
					System.out.println(i + "," + j + "," + k);
				}
			}
			
		}
		System.out.println("-----------------------------");
	}
	
}
