package 문제풀이4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_D4_4050_재관이의대량할인_서울9반_김동주_끝_ {
	public static int T,N,price[],sum;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			price = new int[N];
			st = new StringTokenizer(br.readLine()); //
			sum = 0;
			for(int n=0; n<N; n++) {
				price[n] = -1*Integer.parseInt(st.nextToken());
				//sum -= price[n];
			}
			Arrays.sort(price); //내림차순
			for(int n=0; n<N; n++) {
				//if(n%3 ==2) sum += price[n];
				if(n%3 !=2) sum -= price[n];
			}
			sb.append('#').append(tc).append(' ').append(sum).append('\n');
		}
		System.out.print(sb);
	}

}
