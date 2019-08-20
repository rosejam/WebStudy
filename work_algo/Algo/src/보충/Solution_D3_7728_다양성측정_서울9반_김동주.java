package 보충;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_7728_다양성측정_서울9반_김동주 { //K행 N열 
	public static String line;
	public static boolean[] V;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_D3_8104.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine()); //int는 21억 까지
		for (int tc = 1; tc <= TC; tc++) {
			line = br.readLine();
			V = new boolean[10]; //각 자리수의 사용 여부를 체크
			byte cnt = 0;
			for (int i = 0; i < line.length(); i++) {
				//자리 숫자를 취하는 방법 : 1. 숫자로 %,/작업
				int x =line.charAt(i)-'0'; //2.문자열로 charAt()-'0' (-'0는 char숫자를 정수형 숫자로)
				if(V[x]==false) {
					V[x] = true;
					cnt++;
				}
			}
			sb.append("#"+tc+" "+cnt+"\n");
		}
		System.out.println(sb);
	}
}
