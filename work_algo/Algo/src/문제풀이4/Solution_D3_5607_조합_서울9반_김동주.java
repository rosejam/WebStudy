package 문제풀이4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//nCr을 1234567891 로 나눈 나머지
public class Solution_D3_5607_조합_서울9반_김동주 {
	public static int T,N,R,ans;
	public static final int X = 1234567891; //mod값
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_D3_5607.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			
			ans = mod_factorial(N);
			System.out.println(ans);
			System.out.println();
			ans *= mod_X(mod_factorial(R), X-2);
			System.out.println(mod_factorial(R));
			System.out.println(mod_X(mod_factorial(R), X-2));
			System.out.println();
			ans *= mod_X(mod_factorial(N-R), X-2);
			System.out.println(mod_factorial(N-R));
			System.out.println(mod_X(mod_factorial(N-R), X-2));
			System.out.println();
			ans = ans%X;
			
			sb.append('#').append(tc).append(' ').append(ans).append('\n');
		}
		System.out.print(sb);
	}
	
	//m^n mod X를 구해서 리턴.
	private static int mod_X(int m, int n) {
		if(n==0) return 1;
		//if(n==1) return m;
		int x = mod_X(m, n/2);
		if(n%2==0) {
			return (x*x)%X;
		}else {
			return (((x*x)%X)*(m%X))%X;
		}
		
	}
	
	private static int mod_factorial(int n) {
		if(n == 0) return 1;
		return (n*mod_factorial(n-1))%X;
	}
	
}
