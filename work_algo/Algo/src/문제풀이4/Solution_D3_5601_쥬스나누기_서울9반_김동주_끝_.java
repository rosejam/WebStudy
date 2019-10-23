package 문제풀이4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D3_5601_쥬스나누기_서울9반_김동주_끝_ { //1L를 N명이 나누어 마신다.
	public static int T,N,bunja,bunmo;
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_D3_5601.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T= Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N= Integer.parseInt(br.readLine());
			bunja = 1;
			bunmo = N;
			sb.append('#').append(tc);
			for(int n=0; n<N; n++) {
				sb.append(' ').append(bunja).append('/').append(bunmo);
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
}
