package 보충;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//시뮬레이션
public class Solution_D3_7675_통역사성경이_서울9반_김동주_미완_ { //대화에서 나오는 모든 이름
	public static int N;
	public static String str;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_D3_7675.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++){
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), ".?!");  //‘.’, ‘?’, ‘!’로 문장 구분
			while(st.hasMoreTokens()) {
				String[] strs = st.nextToken();
			}
			sb.append("#"+tc+" "+Ans+"\n");
		}
		System.out.println(sb);
	}
}
