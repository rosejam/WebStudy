package 문제풀이3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D3_4406_모음이보이지않는사람_서울9반_김동주_끝_ { //aeiou
	public static int T;
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_BJ_14890.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			sb.append('#').append(tc).append(' ');
			String line = br.readLine();
			for(int i=0; i<line.length(); i++) {
				if(line.charAt(i)!='a'&&line.charAt(i)!='e'&&line.charAt(i)!='i'&&line.charAt(i)!='o'&&line.charAt(i)!='u') {
					sb.append(line.charAt(i));
				}
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
}
