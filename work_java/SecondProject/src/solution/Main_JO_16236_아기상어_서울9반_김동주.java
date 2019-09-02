package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JO_16236_아기상어_서울9반_김동주 {
	public static int N,Ans;
	public static int[][] space;
	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());//공간의 크기
		space = new int[N][N];
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m=0; m<N; m++) {
				space[n][m] = Integer.parseInt(st.nextToken()); //공간의 상태는 0, 1, 2, 3, 4, 5, 6, 9
				/* 0: 빈 칸
				1, 2, 3, 4, 5, 6: 칸에 있는 물고기의 크기
				9: 아기 상어의 위치  한마리*/
			}
		}
		
		
		System.out.println(Ans);//아기 상어가 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는 시간
	}
}
