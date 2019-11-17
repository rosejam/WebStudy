package N과M;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//n[0]부터 n[N-1]까지 자연수 중에서 M개를 고른 수열
//중복순열 N_Pi_M를 오름차순으로 출력
//n이 중복되어 들어올 수 있음
public class Main_BJ_15665_11 {
	public static int N,M,n[],idx[];
	//public static boolean[] v;
	public static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		n = new int[N];
		st = new StringTokenizer(br.readLine());
		int x = 0;
		while(st.hasMoreTokens()) {
			n[x++] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(n);
		
		//v = new boolean[N];
		idx = new int[M];
		perm(0);
		
		System.out.print(sb);
	}
	private static void perm(int depth) {
		if(depth == M) {
			for(int m=0; m<M; m++) {
				sb.append(idx[m]).append(' ');
			}
			sb.append('\n');
			return;
		}
		for(int i=0; i<N; i++) {
			if(idx[depth] != n[i]) { ////idx의 어떤 자리에 같은 수가 왔던 적이 있는지 체크
				idx[depth] = n[i]; //
				perm(depth+1);
			}
		}
		idx[depth] = 0; ////자연수가 아닌 수로 초기화
	}
}