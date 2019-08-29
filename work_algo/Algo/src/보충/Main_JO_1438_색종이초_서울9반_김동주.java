package 보충;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JO_1438_색종이초_서울9반_김동주 {
	public static int T,x,y;
	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input_JO_1438.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder sb = new StringBuilder();
		boolean[][] black = new boolean[100][100];
		T = Integer.parseInt(br.readLine());
		//int index;
		for (int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			for(int i=0; i<10; i++) {
				for(int j=0; j<10; j++) { //또는 y부터 y+10까지 돌기
					black[x+i][y+j] = true;
				}
			}
		}//모든 색종이 붙임
		
		int Ans=0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(black[i][j]==true) Ans++;
			}
		}
		System.out.println(Ans);
	}
}