package stack1;

public class FiboTest {
	public static int fibo(int n) {
		if(n<2) return n;
		return fibo(n-1) + fibo(n-2);
	}
	public static int[] memo; //메모이제이션
	
	public static int fibo1(int n) { //메모이제이션
		if(n>=2 && memo[n] ==0) {
			memo[n]= fibo1(n-1) + fibo1(n-2);
		}
		return memo[n];
	}
	
	public static int fibo2(int n) { //DP
		for(int i=2; i<=n; i++) { //memo ==0인지 확인하고 해도 좋음 
			memo[i] = memo[i-1] + memo[i-2];
		}
		return memo[n];
	}
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(fibo(40));
		long end = System.currentTimeMillis();
		System.out.println((end-start)+"ms"); //시작~끝의 시간을 세서 출력
		
		start = System.nanoTime();
		memo = new int[100]; //생성
		memo[0] = 0;
		memo[1] = 1;
		System.out.println(fibo1(40));
		end = System.nanoTime();
		System.out.println((end-start)+"ns"); 
		
		start = System.nanoTime();
		memo = new int[100]; //생성
		memo[0] = 0;
		memo[1] = 1;
		System.out.println(fibo2(40));
		end = System.nanoTime();
		System.out.println((end-start)+"ns");

	}

}
