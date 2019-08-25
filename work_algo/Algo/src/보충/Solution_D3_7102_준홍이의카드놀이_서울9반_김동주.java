package 보충;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_7102_준홍이의카드놀이_서울9반_김동주 {
	public static byte N, M;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_D3_7102.txt"));
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Byte.parseByte(st.nextToken());
			M = Byte.parseByte(st.nextToken()); //int가 더 빠르대. 
			int[] cnt = new int[M+N+1];
			int max = 0;
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=M; j++) {
					cnt[i+j]++;
					if(max < cnt[i+j]) max = cnt[i+j];
					//if(cnt[maxi] <cnt[i+j]) maxi = i+j;
				}
			}
			sb.append("#"+tc);
			for(int n=2; n<N+M+1; n++) {
				if(cnt[n]==max) sb.append(" "+n); //if(cnt[n] == cnt[maxi])
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
