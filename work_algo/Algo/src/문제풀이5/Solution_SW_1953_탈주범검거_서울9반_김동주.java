package 문제풀이5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SW_1953_탈주범검거_서울9반_김동주 {
	public static int T,nums,N,M,a[],b[],cnt1,cnt2,stud[][];
	public static boolean v[][];
	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input_SW_1953.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		T = Integer.parseInt(br.readLine().trim());
		
		for(int tc=1;tc<=T;tc++) {
			
			sb.append('#').append(tc).append(' ').append(1).append('\n');
		}
	}
	
}
