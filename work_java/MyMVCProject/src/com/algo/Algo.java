package com.algo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Algo {
	int num1, num2;
	
	public Algo(File f) throws FileNotFoundException {
		//this.num1 = Integer.parseInt(num1);
		//this.num2 = Integer.parseInt(num2);
		Scanner sc = new Scanner(f);
		this.num1 = sc.nextInt();
		this.num2 = sc.nextInt();
	}

	public int[] doJob() {
		return new int[] {num1+num2};
	}

	public int[] doJob2() {
		return new int[] {num1*num1 + num2*num2};
	}

}
