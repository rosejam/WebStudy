package 보충_IM;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_6958_6913_동철이의프로그래밍대회_서울9반_김동주_끝_ {
	public static int N,M,max,maxp;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_D3_6958.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++){
			StringTokenizer nm = new StringTokenizer(br.readLine());
			N = Integer.parseInt(nm.nextToken());
			M = Integer.parseInt(nm.nextToken());
			int[] a = new int[N];
			max=0;
			maxp=0;
			for(int n = 0; n < N; n++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				while(st.hasMoreTokens()) {
					a[n]+=Integer.parseInt(st.nextToken());
				}
				if(a[n]>max) max=a[n];
			}
			for(int n = 0; n < N; n++){
				if(max==a[n]) maxp++;
			}
			
			sb.append("#"+tc+" "+maxp+" "+max+"\n");
		}
		System.out.println(sb);
	}
}
