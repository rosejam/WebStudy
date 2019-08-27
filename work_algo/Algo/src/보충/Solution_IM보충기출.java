package 보충;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution_IM보충기출 
{	
	static int Ans,T,N;
	static boolean[] light,room;
	public static void main(String args[]) throws Exception
	{
		System.setIn(new java.io.FileInputStream("res/input_IM_gichul.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++)
		{
			N = Integer.parseInt(br.readLine()); 
			light = new boolean[N+1];
			room = new boolean[N+1];
			int x=1;
			StringTokenizer st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				if(st.nextToken().equals("1"))
					light[x++]=true;
				else
					x++;
			}
			Ans=0;
			for(int i=1; i<=N; i++) {
				if(light[i]!=room[i]) {
					Ans++;
					for(int j=i; j<=N; j+=i) { //j는i부터 i의 배수 전부
						light[j]=!light[j];
					}
				}
			}
			sb.append("#" + test_case+" "+Ans+"\n"); 
		}
		System.out.println(sb);
		br.close(); 
	}
}
