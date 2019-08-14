package solution.D1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D1_2025_N줄덧셈_서울9반_김동주 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_D1_2025.txt")); //제출할때는 입력 삭제!!!
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		//System.out.print(T*(T+1)/2);
		int sum =0;
		for(int i=1; i<=T; i++) {
			sum += i;
		}
		System.out.print(sum);
	}
}