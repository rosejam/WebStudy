package solution.D1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D1_2047_신문헤드라인_서울9반_김동주 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_D1_2047.txt")); //제출할때는 입력 삭제!!!
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(br.readLine().toUpperCase());
	}
}