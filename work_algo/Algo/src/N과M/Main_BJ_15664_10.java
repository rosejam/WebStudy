package N과M;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//n[0]부터 n[N-1]까지 자연수 중에서 중복 없이 M개를 고른 수열
//조합 N_C_M를 오름차순으로 출력
//n이 중복되어 들어올 수 있음
public class Main_BJ_15664_10 {
	public static int N,M,n[],idx[];
	public static boolean[] v;
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
		
		v = new boolean[N];
		idx = new int[M];
		comb(0,0);
		
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
		for(int i=start; i<N; i++) {
			if(!v[i] && idx[depth] != n[i]) { ////idx의 어떤 자리에 같은 수가 왔던 적이 있는지 체크
				v[i] = true;
				idx[depth] = n[i]; //
				comb(i, depth+1);
				v[i] = false;
			}
		}
		idx[depth] = 0; ////자연수가 아닌 수로 초기화
	}
}