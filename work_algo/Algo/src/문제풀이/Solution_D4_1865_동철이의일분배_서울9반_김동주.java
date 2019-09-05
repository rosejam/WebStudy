package 문제풀이;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1865_동철이의일분배_서울9반_김동주 {
	public static int T,N;
	public static double Max;
	public static int[][] P;
	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input_D4_1861.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			P = new int[N][N];
			for(int n=0; n<N; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int nn=0;
				while(st.hasMoreTokens()) {
					P[n][nn++] = Integer.parseInt(st.nextToken()); //n번사람이 m번 일을 성공할 확률 퍼센트 %
				}
			}
			//nPn의 곱을 구해야 할 것 같다. (0.01곱한다음)
			perm(0,0);
			sb.append("#"+tc+" "+String.format("%.6f", Max)+"\n"); //모든 일을 성공할 확률(곱)이 최대화될 때의 확률 %
		}
		System.out.println(sb);
	}
	public static void perm(int i, int j) {
		// TODO Auto-generated method stub
		
	}
}
