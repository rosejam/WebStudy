package dp;

import java.util.Arrays;

public class DpEx2 {
	public static void main(String[] args) {
		int N=6;
		int[] Y=new int[N+1];
		Y[0]=1;
		Y[1]=2;
		for(int i=2; i<=N; i++) {
			Y[i]=2*Y[i-1]+Y[i-2];
		}
		System.out.println(Y[N]);
		System.out.println("Y"+Arrays.toString(Y));
	}
}