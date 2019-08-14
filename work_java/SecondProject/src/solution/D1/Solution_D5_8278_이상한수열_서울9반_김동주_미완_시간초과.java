package solution.D1;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution_D5_8278_이상한수열_서울9반_김동주_미완_시간초과 {
	static long N;
	static int M;
	//static long[] memo;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_D5_8278.txt"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		//int T = Integer.parseInt(br.readLine());
		int T=sc.nextInt();
/*		memo = new long[Integer.MAX_VALUE];
		memo[0] = 0;
		memo[1] = 1;*/
		for(int tc=1; tc<=T; tc++) {
/*			String[] nm = br.readLine().split(" ");
			N = Integer.parseInt(nm[0]);
			M = Integer.parseInt(nm[1]);*/
			N =sc.nextLong();
			M =sc.nextInt();
			
			System.out.println("#" + tc + " " + get_sn(N)%M);
		}
		sc.close();
	}
	public static long get_sn(long n) {
		if(n<2) return n;
		return get_sn(n-1)*get_sn(n-1)*get_sn(n-1) + get_sn(n-2)*get_sn(n-2)*get_sn(n-2);
	}
}
