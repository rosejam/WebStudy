package 문제풀이_PS;

import java.util.Scanner;

public class Main_JO_1658_최대공약수와최소공배수_서울9반_김동주_끝_ { //GCD, LCM
	public static int A,B,GCD,LCM;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		
		GCD = gcd_get(A,B);
		LCM = A*B / GCD;
		
		System.out.println(GCD);
		//System.out.println(gcd_get2(A,B));
		//System.out.println(gcd_get3(A,B));
		System.out.print(LCM);
	}
	
	//유클리드 호제법 사용 //재귀
	private static int gcd_get(int x, int y) {
		if(y==0) return x;
		return gcd_get(y, x%y);
	}
	
/*	private static int gcd_get2(int x, int y) { //재귀X
		int r;
		while(y!=0) {
			r = x%y;
			x = y;
			y = r;
		}
		return x;
	}
	
	private static int gcd_get3(int x, int y) {
		int ans = 1;
		for(int i=2; i<=x; i++) { //작은 쪽의 모든 약수만 체크해도 된다.(제곱근만에 모두 구할 수 있음)
			if(x%i ==0 && y%i ==0) { //공약수 i
				ans = i;
			}
		}
		return ans;
	}*/
	
	
}
