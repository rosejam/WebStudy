package solution.D1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Solution_D1_2070_큰놈작은놈같은놈_서울9반_김동주 {
	public static int a;
	public static int b;
	public static StringTokenizer st; //한 쌍이라도 토크나이저 쓰자!!!
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_D1_1936.txt")); //제출할때는 입력 삭제!!!
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			if(a>b) System.out.println("#"+tc+" >");
			else if(a<b) System.out.println("#"+tc+" <");
			else System.out.println("#"+tc+" =");
		}
	}
}

