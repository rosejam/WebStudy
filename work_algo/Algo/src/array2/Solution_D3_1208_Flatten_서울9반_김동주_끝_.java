package array2;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D3_1208_Flatten_서울9반_김동주_끝_ {
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("res/input_D3_1208.txt")); 
		Scanner sc = new Scanner(System.in);
		int[] X = new int [100]; // 상자 높이
		for(int tc = 0; tc < 10; tc++)
		{
			int T = sc.nextInt();// 덤프횟수
			for(int i=0; i<100; i++) {
				X[i] = sc.nextInt();
			}//X에 정보를 다 입력하였다.
			//평탄화를 하자.
			for(int p=0; p<T; p++) { //T회 평탄화
				int max_i = 0;
				int min_i = 0; //인덱스는 항상 0부터시작해야함!!!평탄화밖에다두면 안 돼지 당연
				for(int i=1; i<100; i++) { //주어지는 소팅을 활용하면 더 빠르긴 하다.
					if(X[max_i]<X[i]) max_i=i;
					if(X[min_i]>X[i]) min_i=i; 
				}//매 덤프마다 일단 전체에서 최대 최소인덱스를 찾음
				X[max_i]--;
				X[min_i]++;
				if ((X[max_i]-X[min_i])<=1)
					break;
			}
			//마지막에도 변동이 있을수있으니 순서를바꿔야함!
			int max_ii = 0;
			int min_ii = 0;
			for(int i=1; i<100; i++) {
				if(X[max_ii]<X[i]) max_ii=i;
				if(X[min_ii]>X[i]) min_ii=i; 
			}
			
			System.out.println("#"+(tc+1)+" "+(X[max_ii]-X[min_ii]));
		}
		sc.close();
	}
}