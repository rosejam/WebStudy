package tree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_D4_1232_사칙연산_서울9반_김동주 {
	public static class Node{ //중첩클래스 Node는 static method에서 
		boolean isNum;
		double num;
		char op; //double또는 char의 값이 트리에 들어감
		int lidx; //
		int ridx; //이미 인덱스는 주어짐
	}
	public static Node[] nodes;
	
	public static double getNum(int idx) {
		if(nodes[idx].isNum) return nodes[idx].num;
		
		double num=-1.0;
		switch(nodes[idx].op) { //여기서 익셉션 발생하면 유효성 체크=0;
			case '+': num=getNum(nodes[idx].lidx) + getNum(nodes[idx].ridx); break;
			case '-': num=getNum(nodes[idx].lidx) - getNum(nodes[idx].ridx); break;
			case '*': num=getNum(nodes[idx].lidx) * getNum(nodes[idx].ridx); break;
			case '/': num=getNum(nodes[idx].lidx) / getNum(nodes[idx].ridx); break;
		}
		return num;
	}
	
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("res/input_D4_1232.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		for(int tc = 1; tc <= 10; tc++){
			int N = Integer.parseInt(br.readLine());
			//StringBuilder sb = new StringBuilder();
			nodes = new Node[N+1];
			//a = new char[N+1];
			for(int i=1; i<=N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				Node node = new Node();
				nodes[i]=node;
				
				st.nextToken(); //버림
				String s = st.nextToken();
				char c = s.charAt(0);
				if ('0'<=c && c<='9') { //캐릭터가 숫자면 '0'이상 '9'이하이다. 이범위를 벗어나면 숫자가 아님!
					node.isNum =true;
					node.num=Double.parseDouble(s); //숫자로 바꿈
				}else {
					node.isNum=false;
					node.op=c;
					node.lidx=Integer.parseInt(st.nextToken());//
					node.ridx=Integer.parseInt(st.nextToken());//
				}
			}
			System.out.println("#" + tc + " "+(int)getNum(1));
		}
		br.close();
	}
}

