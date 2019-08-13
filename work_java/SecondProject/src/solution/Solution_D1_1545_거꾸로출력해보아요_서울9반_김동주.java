package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Solution_D1_1545_거꾸로출력해보아요_서울9반_김동주 {
	public static int a;
	public static int b;
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_D1_2019.txt")); //제출할때는 입력 삭제!!!
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=T; tc>=0; tc--) {
			System.out.print(tc+" ");
			//sb.append(tc+" ");
		}
		//System.out.println(sb);
	}
}

