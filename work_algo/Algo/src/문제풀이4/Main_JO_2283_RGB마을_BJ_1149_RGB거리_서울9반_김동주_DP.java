package 문제풀이4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//N개의 집 일렬로
//DP
public class Main_JO_2283_RGB마을_BJ_1149_RGB거리_서울9반_김동주_DP { //홍길동
	public static int N, R,G,B; //rgb[][], ans;
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_D3_5601.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N= Integer.parseInt(br.readLine().trim());
		//rgb = new int[N][3];
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine().trim());
			/*for(int m=0; m<3; m++) {
				rgb[n][m] = Integer.parseInt(st.nextToken());
			}*/
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int tR = r + Math.min(G, B);
			int tG = g + Math.min(R, B);
			int tB = b + Math.min(R, G);
			
			R = tR;
			G = tG;
			B = tB;
		}
		
		System.out.print(Math.min(R, Math.min(G, B)));
	}
}
