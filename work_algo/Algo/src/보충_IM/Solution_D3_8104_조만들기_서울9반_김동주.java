package 보충_IM;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_8104_조만들기_서울9반_김동주 { //K행 N열 
	//public static int[][] team;
	public static int[] sum;
	public static byte K;
	public static byte N;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_D3_8104.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine()); //int는 21억 까지
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Byte.parseByte(st.nextToken()); 
			K = Byte.parseByte(st.nextToken());
			//team = new int[K][N]; //이 2차 배열 필요X 
			sum = new int[K];
			int num = 1;
			for (int j = 0; j < N; j++) {
					for (int i = 0; i < K; i++) {
					if(j%2==0) {//아래로 //비트연산자가 더 빠름
						//team[i][j] = num++;
						sum[i] += num++;
					}
					else { //위로
						//team[K-i-1][j] = num++; 
						sum[K-i-1] += num++;
					}
				}
			}
			sb.append("#"+tc);
			for (int i = 0; i < K; i++) {
				sb.append(" "+sum[i]);
			}
			sb.append("\n");
/*			sb.append("#"+tc);
			for (int i = 0; i < K; i++) {
				int sum = 0; //	K행의 합을 구하기 위함 
				for (int j = 0; j < N; j++) {
					sum += team[i][j];
				}
				sb.append(" "+sum);
			}
			sb.append("\n");*/
		}
		System.out.println(sb);
	}
}
