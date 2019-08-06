package com.thread;

class Matrix extends Thread {
	int num; //thread가 맡은 구구단의 단

	public Matrix(int num) {
		this.num = num;
	}
	
	public void run() { //thread 작업 내용 -> 자기가 맡은 단 출력
		for(int i=1; i<=9; i++)
			System.out.print(num + "*"+ i + "=" + (num*i)+"\t");
		System.out.println();
	}
}


public class MatrixTest {

	public static void main(String[] args) {
		for(int i=2; i<=9; i++) {
			Matrix m = new Matrix(i);
			m.start();
			try {
				m.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
