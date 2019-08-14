package solution.D1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Solution_D1_2019_더블더블_서울9반_김동주 {
	public static int a;
	public static int b;
	public static StringTokenizer st; //한 쌍이라도 토크나이저 쓰자!!!
	public static StringBuilder sb;
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_D1_2019.txt")); //제출할때는 입력 삭제!!!
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<=T; tc++) {
			sb.append((int)Math.pow(2, tc)+" ");
		}
		System.out.println(sb);
	}
}

