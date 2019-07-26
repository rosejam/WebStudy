package com.ssafy.java;

public class AlpaTest2 {

	public static void main(String[] args) {
		char x = 'A';
		for(int i=0 ; i<5 ; i++) {
			for(int k=0; k<(8-2*i); k++)
				System.out.print(" ");
			for(int j=0 ; j<=i ; j++) {
				System.out.print(" ");
				System.out.print(x++);
			}
			System.out.println("\n");
		}
		
	}

}
