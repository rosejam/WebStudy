package 기타;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_JO_2690_휴대전화로문자보내기_서울9반_김동주_끝_ {
	public static Map<Character, String> key;
	public static int TC, N, cnt, len;
	public static String[] S;
	public static String befnum, curnum;
	//public static char[][] key = {null, null, {'a','b','c'}, {'d','e','f'}, {'g','h','i'}, {'j','k','l'}, {'m','n','o'}, {'p','q','r','s'}, {'t','u','v'}, {'w','x','y','z'} };
	//public static int[] key = {2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,8,8,8,9,9,9,9};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		key = new HashMap<>();
		key.put('a', "2");key.put('b', "22");key.put('c', "222");
		key.put('d', "3");key.put('e', "33");key.put('f', "333");
		key.put('g', "4");key.put('h', "44");key.put('i', "444");
		key.put('j', "5");key.put('k', "55");key.put('l', "555");
		key.put('m', "6");key.put('n', "66");key.put('o', "666");
		key.put('p', "7");key.put('q', "77");key.put('r', "777");key.put('s', "7777");
		key.put('t', "8");key.put('u', "88");key.put('v', "888");
		key.put('w', "9");key.put('x', "99");key.put('y', "999");key.put('z', "9999");
		key.put(' ', "0");
		
		TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			
			String line = br.readLine();
			
			befnum = key.get(line.charAt(0));
			sb.append(befnum);
			for(int l=1; l<line.length(); l++) {
				curnum = key.get(line.charAt(l));
				if(line.charAt(l) == line.charAt(l-1) || befnum.endsWith(curnum.substring(0,1))) {
					sb.append(' ').append(key.get(line.charAt(l)));
					befnum = curnum;
				}else {
					sb.append(key.get(line.charAt(l)));
					befnum = curnum;
				}
			}
			//출력
			sb.append('\n');
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
