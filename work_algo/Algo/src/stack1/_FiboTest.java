package stack1;

public class _FiboTest {
	public static int fibo(int n) {
		if(n<2) return n;
		return fibo(n-1) + fibo(n-2);
	}
	public static int[] memo; //메모이제이션(중복호출 방지용)
	
	public static int fibo1(int n) { //메모이제이션
		if(n>=2 && memo[n] ==0) {
			memo[n]= fibo1(n-1) + fibo1(n-2);
		}
		return memo[n];
	}
	
	public static int fibo2(int n) { //DP(작은 부분 집합부터 해 구해나가기)
		for(int i=2; i<=n; i++) {
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
