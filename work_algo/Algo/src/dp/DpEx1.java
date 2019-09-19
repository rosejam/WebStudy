package dp;

import java.util.Arrays;

public class DpEx1 {
	public static void main(String[] args) {
		int N=8;
		int[] Y=new int[N+1];
		int[] B=new int[N+1];
		Y[1]=1;
		B[1]=1;
		for(int i=2; i<=N; i++) {
			Y[i]=Y[i-1]+B[i-1]; //맨위인 i층에 놓일 색이 Y인 경우의 수
			B[i]=Y[i-1];
		}
		System.out.println(Y[N]+B[N]);
		System.out.println("Y"+Arrays.toString(Y));
		System.out.println("B"+Arrays.toString(B));
	}
}
