package array1;

import java.util.Scanner;
import java.io.FileInputStream;

class Gravity_서울9반_김동주{
	public static void main(String args[]) throws Exception //// 팁)오른쪽으로 나보다 작은 칸의 수를 센다!!!!
	{
		System.setIn(new FileInputStream("res/input_gravity.txt"));
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt(); //build_data(data[T]);
		//String line = sc.nextLine();
		int[] X = new int[T]; //길이 T의 배열 X
		//int[] index = new int[T]; //최대값을 가진 인덱스
		int index = 0;
		
		for(int tc = 0; tc < T; tc++)
		{
			X[tc] = sc.nextInt();
			int cnt = 0;
			for(int tc2 = tc+1 ; tc2 < T; tc2++) {
				if( X[tc] > X[tc2]) {
					cnt++;
					//index = tc;
				}
			}
		}
		int count =0;
		for(int tc = 0; tc < T; tc++) {
			if(X[index] == X[tc])
				count ++;
		}
		System.out.println(count);
	}
}
