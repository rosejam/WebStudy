package queue;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_3499_퍼펙트셔플_서울9반_김동주 {
	static String[] string1;
//	static String[] string2;
	static String[] string3;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_D3_3499.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int tc=1; tc <=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			string3 = new String[N];
			string1 = new String[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			if(N%2==0) {
//				string1 = new String[N/2];
//				string2 = new String[N/2];
				for(int n=0; n<N; n++) {
					string1[n] = st.nextToken();
				}
				for(int m=0; m<N; m++) {
					if(m%2==0) string3[m] = string1[m/2];
					else string3[m] = string1[(N/2)+(m/2)];
				}
			}else {
//				string1 = new String[N/2+1];
//				string2 = new String[N/2];
				for(int n=0; n<N; n++) {
					string1[n] = st.nextToken();
				}
				for(int m=0; m<N; m++) {
					if(m%2==0) string3[m] = string1[m/2];
					else string3[m] = string1[(N/2)+(m/2)+1];
				}
			}
			
			System.out.print("#"+tc);
			for(int j=0; j<N; j++) {
				System.out.print(" " + string3[j]);
			}
			System.out.println();		
		}
	}
}
