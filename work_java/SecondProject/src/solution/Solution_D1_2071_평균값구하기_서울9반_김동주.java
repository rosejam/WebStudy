package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Solution_D1_2071_평균값구하기_서울9반_김동주 {
	public static int input;
	public static int avg;
	public static StringTokenizer st; 
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_D1_2072.txt")); //제출할때는 입력 삭제!!!
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int sum=0;
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				input = Integer.parseInt(st.nextToken());
				sum += input;
			}
			avg = (sum%10 >=5)? sum/10+1 : sum/10; //3항 연산자로 바꾸어 표현
			//if(avg%10 >=5) sb.append("#"+tc+" "+(avg/10+1)+"\n");
			//else sb.append("#"+tc+" "+avg/10+"\n");
			sb.append("#"+tc+" "+avg+"\n");
		}
		System.out.println(sb);
	}
}

