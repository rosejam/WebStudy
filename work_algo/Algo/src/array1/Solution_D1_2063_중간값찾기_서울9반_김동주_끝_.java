package array1;

import java.util.Arrays;
import java.io.FileInputStream;
import java.util.Scanner;

class Solution_D1_2063_중간값찾기_서울9반_김동주_끝_{ 
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("res/input_D1_2063.txt"));
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt(); //(N-1)/2
		int[] X = new int[N];
		for(int i=0; i<N; i++) { 
			X[i]=sc.nextInt();
		} //X에 다넣기
		Arrays.sort(X); //스스로 소팅 적을 수 있어야함
		System.out.println(X[(N-1)/2]); //그냥 2로 나누어도 홀수이므로 소수점 아래 버림
		sc.close(); //부수적인 것 
	}

}
