package N과M;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
//조합 M_C_N의 수열이 아닌 개수만 본다!!
public class Main_BJ_1010_다리놓기_시간초과 {
	public static int N,M,idx[],cnt;
	public static boolean[] v;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			v = new boolean[M];
			idx = new int[N];
			cnt = 0;
			comb(0,0);
			sb.append(cnt).append('\n');
		}
		System.out.print(sb);
	}
	
	private static void comb(int start, int depth) {
		if(depth == N) {
			cnt++;
			return;
		}
		for(int i=start; i<M; i++) {
			if(!v[i]) {
				v[i] = true;
				idx[depth] = i;
				comb(i, depth+1);
				v[i] = false;
			}
		}
	}
}