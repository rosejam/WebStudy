package 기타;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D3_8888_시험_서울9반_김동주 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			len = line.length(); //입력길이
			S = new int[len];
			for(int l=0; l<len; l++) {
				S[l] = line.charAt(l)-'0';
			}
			//키입력받음
			N = Integer.parseInt(st.nextToken()); //사전 단어수
			//dic = new String[N];
			//dic = new char[N][];
			cnt = 0;
			st = new StringTokenizer(br.readLine());
			for(int n=0; n<N; n++) {
				line = st.nextToken().toLowerCase();
				//dic[n] = st.nextToken().toCharArray(); //길이 다르면 다름!
				if(line.length() == len) {
					//int[] arr = new int[len];
					boolean flag = true;
					for(int l=0; l<len; l++) {
						if(key[line.charAt(l) - 'a'] != S[l]) flag = false;
						break; //이거 아니므로 넘어감(최적화)
					}
					if(flag) cnt++;
				}
			}
			//사전입력받음
/*			cnt = 0;
			ss = new char[len];
			dfs(ss,0);*/
			
			//출력
			sb.append('#').append(tc).append(' ').append(cnt).append('\n');
			//System.out.println("#"+tc+" "+cnt);
		}
		System.out.print(sb);
	}
/*	private static void dfs(char[] find, int depth) {
		if(depth == len) {
			//if cnt++
			for(int n=0; n<N; n++) { //이 단어로 사전 검색
				boolean flag = true;
				if(dic[n].length != len) {
					flag = false;
				}else {
					for(int l=0; l<len; l++) {
						if(find[l] != dic[n][l]) flag = false;
					}
					if(flag) { //사전에 있음
						cnt++;
						break;
					}
				}
			}
			
			return;
		}
		
		for(int i=0; i<key[S[depth]].length; i++) { //3또는 4
			find[depth] = key[S[depth]][i];
			dfs(find, depth+1);
		}
	}*/

}
