package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D1_2050_알파벳을숫자로변환_서울9반_김동주 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_D1_2050.txt")); //제출할때는 입력 삭제!!!
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] T = br.readLine().toCharArray();
		for(int i=0; i<T.length-1; i++) {
			System.out.print((int)T[i]-64+ " ");
		}
		System.out.println((int)T[T.length-1]-64);
	}
}