package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D1_2058_자릿수더하기_서울9반_김동주 {

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_D1_2058.txt")); 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		byte thousand = (byte)(T/1000);
		byte hundred = (byte) ((T - thousand*1000)/100);
		byte ten = (byte) ((T- thousand*1000-hundred*100)/10);
		byte one = (byte) ((T- thousand*1000-hundred*100)%10);
		System.out.println(thousand + hundred + ten + one);
	}
}