package tree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_D4_1233_사칙연산유효성검사_서울9반_김동주 {
	public static byte N;
//	public static char[] a;
	public static StringBuilder sb;
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("res/input_D4_1233.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
loop:	for(int tc = 1; tc <= 10; tc++){
			N = Byte.parseByte(br.readLine());
			sb = new StringBuilder();
			//a = new char[N+1];
			for(int i=1; i<=N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				st.nextToken();
				if((n%2==0 && (i<n/2)) || (n%2==1 && (i<=(n-1)/2)){
					
				}else if(n%2==0 && i==n/2) {
				
				}
				node[i]=op;
				//a[n] = st.nextToken().charAt(0);
			}
			//반 이하는 연산자아니면 0,break;, 반 초과는 숫자아니면 0,break; 그 다음 1;
			System.out.println("#" + tc + " "+sb);
		}
		br.close();
	}
}

