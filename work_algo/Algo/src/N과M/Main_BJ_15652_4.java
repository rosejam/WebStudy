package N과M;

import java.util.Scanner;

//1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
//중복조합 N_H_M를 오름차순으로 출력
public class Main_BJ_15652_4 {
	public static int N,M,idx[];
	public static boolean[] v;
	public static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		
		N = sc.nextInt();
		M= sc.nextInt();
		
		v = new boolean[N+1]; //1부터 N까지 사용할 것임
		idx = new int[M]; //
		comb(1,0);
		
		System.out.print(sb);
	}
	private static void comb(int start, int depth) {
		if(depth == M) {
			for(int m=0; m<M; m++) {
				sb.append(idx[m]).append(' ');
			}
			sb.append('\n');
			return;
		}
		for(int i=start; i<=N; i++) {
			idx[depth] = i;
			comb(i, depth+1);
		}
	}
}
