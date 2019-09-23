package com.algo;

public class Algo {
	int num1, num2;
	
	public Algo(String num1, String num2) {
		this.num1 = Integer.parseInt(num1);
		this.num2 = Integer.parseInt(num2);
	}

	public int doJob() {
		return num1+num2;
	}

	public int doJob2() {
		return num1*num1 + num2*num2;
	}

}
