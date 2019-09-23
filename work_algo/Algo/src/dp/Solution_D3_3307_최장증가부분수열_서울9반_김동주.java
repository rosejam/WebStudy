package dp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_3307_최장증가부분수열_서울9반_김동주 { //LIS1사
	static long[] A;
	static int N;
	static int cnt;
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_D3_3307.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++){
			N = Integer.parseInt(br.readLine()); //수열안의 개수N 
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			A = new long[N];
			for(int i=0; i<N; i++) {
				A[i]=Long.parseLong(st.nextToken());
			} //수열A에 다 넣기
			int n = A.length;
			
			int[] l = new int[n];
			int max = Integer.MIN_VALUE;
			for(int i=0; i<n; i++) {
				l[i]=1;
				for(int j=0; j<i; j++) {
					if(A[j]<A[i] && l[i]<1+l[j]) {
						 			l[i]=1+l[j];
					}
				}
				max = Math.max(max, l[i]);
			}
			sb.append("#"+tc+" "+max+"\n");
			//System.out.println(Arrays.stream(l).max().getAsInt()); //이 한줄로 어레이의 최대값을 구할 수 있다.
			//System.out.println(Arrays.toString(l));
		}
		System.out.println(sb);
	}
}