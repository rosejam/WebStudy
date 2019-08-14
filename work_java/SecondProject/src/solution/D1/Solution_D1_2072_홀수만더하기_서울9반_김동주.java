package solution.D1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Solution_D1_2072_홀수만더하기_서울9반_김동주 {
	public static int input;
	public static int sum;
	public static StringTokenizer st; //한 쌍이라도 토크나이저 쓰자!!!
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_D1_2072.txt")); //제출할때는 입력 삭제!!!
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			sum=0;
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				input = Integer.parseInt(st.nextToken());
				if(input%2==1) sum += input;
			}
			sb.append("#"+tc+" "+ sum+"\n");
		}
		System.out.println(sb);
	}
}

