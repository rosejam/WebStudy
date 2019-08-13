package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D1_2043_서랍의비밀번호_서울9반_김동주 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_D1_2043.txt")); //제출할때는 입력 삭제!!!
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] X = br.readLine().split(" ");
		int P = Integer.parseInt(X[0]);
		int K = Integer.parseInt(X[1]);
		if(P>K) System.out.println(P-K+1); //차이만큼만 맞춰보면 됨.
		else System.out.println(1000-K+P);
	}
}