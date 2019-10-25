package 문제풀이_PS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

//nCr을 1234567891 로 나눈 나머지
//mod 연산
public class Solution_D3_5607_조합_서울9반_김동주 {
	public static int T,N,R;
	public static long ans, fac[];
	public static final int P = 1234567891; //mod값
	public static void main(String[] args) throws Exception { //범위를 long으로!!!
		System.setIn(new FileInputStream("res/input_D3_5607.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
/*		//mod_factorial을 메모이제이션 N범위 10^6만큼!
		int n = 1000000;
		fac = new long[n+1];
		fac[0] = 1;
		for(int i=1; i<=n; i++) fac[i] = fac[i-1]*i%P;*/
		
		T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			
			//페르마의 소정리
			ans = mod_factorial(N);
			
			ans *= mod_P_1(mod_factorial(R), P-2);
			//ans *= mod_P_2(fac[R]%P, P-2);
			ans %= P; //중간에도 해줘야 답이 제대로 나온다! //중간에 오버플로우나나? 아니면 mod연산 문제?
			
			ans *= mod_P_1(mod_factorial(N-R), P-2);
			//ans *= mod_P_2(fac[N-R]%P, P-2);
			ans %= P;
			
			sb.append('#').append(tc).append(' ').append(ans).append('\n');
		}
		System.out.print(sb);
	}
	
	//m^n mod P를 구해서 리턴. //반반으로 분할정복!
	public static long mod_P_1(long m, int n) { //fermat
		if(n==0) return 1L;
		//if(n==1) return m;
		long x = mod_P_1(m, n/2); //long으로 !!
		if(n%2==0) {
			return (x*x)%P;
		}else {
			return (((x*x)%P)*m)%P; //이 때 m%P = m 이므로 m으로 적음
		}
		
	}
	
	//m^n mod P를 구해서 리턴.
	public static long mod_P_2(long m, int n) { //이건 mod_P_1의 변형인데 잘 모르겠다~
		long r = 1L;
		//거듭제곱 모듈라의 연산횟수 줄이는 방법
		//	지수를 덧셈 여러개로 바꾼다.
		while(n>0) {
			if(n%2==1) r=(r*m)%P; //홀수인 경우
			n = n>>1; //n=n/2
			m = (m*m)%P;
		}
		return r;
	}
	
	private static long mod_factorial(int n) { //이것 대신 메모이제이션을 해도 된다.
		if(n == 0) return 1L; //long계산을 위해 1을 long으로 준다!!!!
		return (n*mod_factorial(n-1))%P;
	}
	
	//그냥 BigInteger 클래스를 활용해서 modInverse를 활용해서 풀 수 있다!!
/*	public static BigInteger nCr(int n, int r, int p) {
		if(r==0) return 1L;
		//여기서 팩토리얼 메모이제이션을 해도 됨
		
		BigInteger PP = BigInteger.valueOf(P); //BigInteger로 변환
		BigInteger A = BigInteger.valueOf(fac[n]);
		BigInteger B = BigInteger.valueOf(fac[r]).mod_P_2(PP).remainder(PP);
		BigInteger C = BigInteger.valueOf(fac[n-r]).mod_P_2(PP).remainder(PP);
		return A.multiply(B).multiply(C).remainder(PP);
	}*/
	
}
