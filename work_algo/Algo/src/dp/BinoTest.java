package dp;

public class BinoTest { //nCk와 동일
	public static int bino(int n, int k) {  //파스칼의 삼각형과 재귀호출 이용
		if(k==0 || n==k) return 1;//if(n<k) return 0; 대신 n==k인 경우 체크
		else return bino(n-1,k-1) + bino(n-1,k);
	}
	public static int[][] b;
	public static int bino1(int n, int k) { //메모이제이션 추가
		if(k==0 || n==k) return 1;
		if(b[n][k]!=0) return b[n][k];
		b[n][k] = bino1(n-1,k-1) + bino1(n-1,k);
		return b[n][k];
	}
	public static int bino2(int n, int k) { //DP
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=Math.min(i, k); j++) {
				if(j==0 || j==i) b[i][j]=1;
				else b[i][j] = b[i-1][j-1] + b[i-1][j];
			}
		}
		return b[n][k];
	}
	public static void main(String[] args) {
		int n=4;
		int k=2;
		System.out.println(bino(n,k));
		b=new int[n+1][n+1];
		System.out.println(bino1(n,k));
		b=new int[n+1][n+1];
		System.out.println(bino2(n,k));
	}
}
