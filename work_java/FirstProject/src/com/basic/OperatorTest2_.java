package com.basic;

public class OperatorTest2_ { //�ҽ��ڵ忡 ����+�ٿ��ֱ��ϸ� �ҽ��ڵ�2 ����

	public static void main(String[] args) {
		//����������(������ ������ ���)  --> �������� ��Ʈ������ ��������
		int e = 3, f= 5;
		System.out.println(e & f);
		System.out.println(e | f);
		System.out.println(e ^ f); 
		
		
		
		//����������(������ ������ ���)
		boolean a = true, b = false, c= false;
		System.out.println(a && b); //&& and(2��¥���� short-cut logic���� �� ����)
		System.out.println(b==false & c==false);
		System.out.println(a || b); //|| or(short-cut logic)
		System.out.println(a ^ b); //xor(�ٸ��� ��)
		
		
		int A = 3, B = 5;
		if(A++>4 && ++B>2) {
		}
		//A = 4, B = 5 ���� false���� �ڴ� ����X(���� &&�ƴϰ� &�̸� �ںκ��� �ڵ尡 ����Ǿ B = 6�̵ȴ�~)
		System.out.println(A);
		System.out.println(B);
		
		boolean g = true;
		System.out.println(!g); //not

	}

}