package com.ssafy.java;

public class AlpaTest1 {

	public static void main(String[] args) {
		char x = 'A';
		for(int i=0 ; i<5 ; i++) {
			for(int j=0 ; j<=i ; j++) {
				System.out.print(x++ + " ");
			}
			System.out.println("\n");
		}
		
	}

}
