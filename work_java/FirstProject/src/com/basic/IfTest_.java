package com.basic;

public class IfTest_ {

	public static void main(String[] args) {
		int score = 85; 
		
		if(score >= 90)
			System.out.println("level-1");		
		else if(score >= 80)
			System.out.println("level-2");
		else if(score >= 70)
			System.out.println("level-3");
		else
			System.out.println("no level");

	}

}
