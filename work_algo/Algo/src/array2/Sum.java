package array2;

public class Sum {
	private static int sum(int n) {
		if(n==1) return 1;
		return n+sum(n-1);
	} //재귀호출 - 멈추지않으면 Stackoverflow 따라서 if문을 꼭넣어주어서 멈춰준다! "재귀호출은 기본적으로 if-else문"

	private static int fac(int n) {
		if(n==1) return 1;
		return n*fac(n-1);
	} 
	
	private static int fibo(int n) {
//		if(n==0) return 0;
//		if(n==1) return 1;
		if(n<2) return n;
		return fibo(n-1)+fibo(n-2);
	} 
	
	public static void main(String[] args) {
		System.out.println(fibo(7));

	}


}
