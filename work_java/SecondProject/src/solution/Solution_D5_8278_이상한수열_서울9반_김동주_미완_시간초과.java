package solution;

import java.io.FileInputStream;
import java.util.Scanner;
public class Solution_D5_8278_이상한수열_서울9반_김동주_미완_시간초과 {
	static long N;
	static int M;
	static final int max = Integer.MAX_VALUE/1000;
	static int[] memo = new int[max];
    //static String[] nm = new String[2];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_D5_8278.txt"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc= new Scanner(System.in);
		int T = sc.nextInt();
		//int T = Integer.parseInt(br.readLine());
		memo[0] = 0;
		memo[1] = 1;
		for(int tc=1; tc<=T; tc++) {
			//nm = br.readLine().split(" ");
			N = sc.nextLong();
			M = sc.nextInt();
			//N = Long.parseLong(nm[0]);
			//M = Integer.parseInt(nm[1]);
			System.out.println("#" + tc + " " + get_sn(N)%M);
		}
       //br.close();
	}
	public static int get_sn(long n) { 
		if(n<2) {
			return (int) n;
/*		}else if(n<max) {
			if(memo[(int) n] == 0) {
				for(int i=2; i<=n; i++) {
					memo[i] = (int) ((Math.pow((memo[i-1])%M, 3) + Math.pow((memo[i-2])%M, 3)));
				}
			}
			return memo[(int) n];*/
		}else{
			return (int)((Math.pow((get_sn(n-1))%M, 3) + Math.pow((get_sn(n-2))%M, 3)));
		}
	}
}
