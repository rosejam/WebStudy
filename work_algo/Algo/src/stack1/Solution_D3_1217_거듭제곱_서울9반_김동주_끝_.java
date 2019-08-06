package stack1;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D3_1217_거듭제곱_서울9반_김동주_끝_ {
	public static int N, M, answer;
	public static int power(int n, int m) {
		if (m==0) return 1;
		return power(n, m-1)*n ;
	}
	public static int power2(int n, int m) { //분할정복
		if (m==0) return 1;
		if ((m&1) == 0) { //비트연산활용
			int y = power2(n, m/2);
			return y*y;
		}else {
			int y = power2(n, (m-1)/2);
			return y*y*n;
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("res/input_D3_1217.txt")); //제출할때는 입력 삭제!!!
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++)
		{
			sc.nextInt();
			N = sc.nextInt();
			M = sc.nextInt();

			System.out.println("#" + tc + " " + power(N, M)); //Math.pow와 동일하다
			System.out.println("#" + tc + " " + power2(N, M)); //Math.pow와 동일하다

		}
		sc.close();
	}
}