package array1;

import java.util.Scanner;
import java.io.FileInputStream;
//팁)오른쪽으로 나보다 작은 칸의 수를 센다!!!!
class Gravity{
	public static void main(String args[]) throws Exception 
	{
		System.setIn(new FileInputStream("res/input_gravity.txt"));
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt(); //build_data(data[T]);
		int[] X = new int[T]; //길이 T의 배열 X //최대값을 가진 인덱스
		for(int t = 0; t < T; t++)
		{
			X[t] = sc.nextInt();
		} //상자 완성
		
		int max=0;
		for(int t = 0; t < T; t++) {
			int cnt = 0;
			for(int t2 = t+1 ; t2 < T; t2++) {
				if( X[t] > X[t2]) {
					cnt++;
				}
				if (max<cnt) max=cnt;
			}//t의 오른쪽 다셈
		}
		System.out.println(max);
		sc.close();
	}
}
