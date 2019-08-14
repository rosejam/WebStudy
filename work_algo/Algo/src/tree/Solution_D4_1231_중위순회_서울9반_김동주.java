package tree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

import tree.Tree.Node;

public class Solution_D4_1231_중위순회_서울9반_김동주 {
	public static byte N;
	public static char[] a;
	public static StringBuilder sb;
	public static void inorder(int i) {
		if(i<=N && a[i]!=0) { //유니코드의 null='\u0000'=0 //배열의 인덱스가 범위내여야 한다 //노드가 널이 아니면
			inorder(2*i);
			//System.out.print(a[i]+" ");
			sb.append(a[i]);//Character.toString(a[i])
			inorder(2*i+1);
		}
	}
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("res/input_D4_1231.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		for(int tc = 1; tc <= 10; tc++){
			N = Byte.parseByte(br.readLine());
			sb = new StringBuilder();
			a = new char[N+1];
			for(int n=1; n<=N; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
/*				ch=st.nextToken().charAt(0); //알파벳
				L=Byte.parseByte(st.nextToken()); //
				R=Byte.parseByte(st.nextToken()); // */
				a[n] = st.nextToken().charAt(0);
			}
			inorder(1);
			System.out.println("#" + tc + " "+sb);
		}
		br.close();
	}
}


