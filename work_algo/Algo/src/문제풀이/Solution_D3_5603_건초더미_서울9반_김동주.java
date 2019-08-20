package 문제풀이;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D3_5603_건초더미_서울9반_김동주 { //높이를 모두 같게
	public static int N;
	public static int move;
	public static int sum;
	public static int[] guncho;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_D3_5603.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			N = Integer.parseInt(br.readLine());
			guncho = new int[N];
			move=0;
			sum =0;
			for(int n=0; n<N; n++) {
				guncho[n] = Integer.parseInt(br.readLine());
				sum += guncho[n];
			} //다 받음
			sum /= N; //average;
			for(int n=0; n<N; n++) {
				move += Math.abs(sum-guncho[n]);
			}
			sb.append("#"+tc+" "+move/2+"\n");
		}
		System.out.println(sb);
	}
}
