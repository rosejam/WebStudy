package tree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
//예시답안
public class Solution_D4_1232_사칙연산_서울9반_김동주 {
	public static class Node{ //필드클래스
		boolean isNum;
		double num;
		char op; //double또는 char의 값이 트리에 들어감
		int lidx; //
		int ridx; //n까지 꽉 찬 complete트리가 아니므로 자식과 연결해주어야 함
	}
	public static Node[] nodes; //노드의 배열(arraylist 사용해도 됨)
	
	public static double getNum(int idx) { //재귀호출로 아래로 내려가면서 계산 //여기서 익셉션 발생하면 유효성 체크=0;
		if(nodes[idx].isNum) return nodes[idx].num; //숫자면 그대로 숫자를 리턴(시드)
		//숫자가 아니면
		double num=-1.0;
		switch(nodes[idx].op) {
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
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= 10; tc++){
			int N = Integer.parseInt(br.readLine());
			nodes = new Node[N+1]; //각 노드에 인덱스가 있다.
			//a = new char[N+1];
			for(int i=1; i<=N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				Node node = new Node();
				nodes[i]=node;
				
				st.nextToken(); //버림 N과 같음.
				String s = st.nextToken();
				char c = s.charAt(0);
				if ('0'<=c && c<='9') { //char가 숫자면 '0'이상 '9'이하이다. 이범위를 벗어나면 숫자가 아님!
					node.isNum =true;
					node.num=Double.parseDouble(s); //그 토큰을 숫자로 바꿈
				}else {
					node.isNum=false;
					node.op=c;
					node.lidx=Integer.parseInt(st.nextToken());
					node.ridx=Integer.parseInt(st.nextToken());
				}
			}
			sb.append("#" + tc + " "+(int)getNum(1)+"\n"); //재귀함수 호출, 1Node부터 시작 결과가 리턴
		}
		System.out.println(sb);
		br.close();
	}
}

