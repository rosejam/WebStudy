package stack1;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

public class Solution_D4_1219_길찾기_서울9반_김동주 { //Dfs 활용하여 완전탐색
	public static final int V = 100; //점은 최대 100개로 고정
	public static int E, a, b; //선
	public static int[] graph1;
	public static int[] graph2; //최대 2개의 갈림길 연결
	public static boolean[] visit;
	public static int road;
	public static Stack<Integer> stack;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_D4_1219.txt"));
		Scanner sc = new Scanner(System.in);
		for(int tc=1; tc<=10; tc++) {
			sc.nextInt();
			E = sc.nextInt(); //선의 개수
			graph1 = new int[V];
			graph2 = new int[V];
			stack = new Stack<Integer>();
			road = 0;
			//visit = new boolean[V];
			for(int e=0; e<E; e++) { 
				a = sc.nextInt();
				b = sc.nextInt();
				if(graph1[a]==0) { //0으로 돌아가는 길은 없다고 가정한다.
					graph1[a]= b;
				}else {
					graph2[a]= b;
				}
			}//선 모두 연결
			visit = new boolean[V];//경로 새로 찾을 때마다 초기화 시켜야함
			dfs(0);
			System.out.println("#"+ tc + " " + road); //road를 따로 만들지 않고 dfs(0)을 int 리턴으로 만들어  넣는게 좋다.
		}
	}
	
	public static void dfs(int node) { 
		stack.push(node);
		while(!stack.empty()) {
			int curr = stack.pop();
			//System.out.println(curr);
				//System.out.println(curr + " ");
				//for (int next=0; next<V; next++) { //0 2 4 5 6 3 1 
			if(visit[curr]==false) {
				if ((graph1[curr] == 99)||(graph2[curr] == 99)) {
					road= 1;
					break;
				}
				visit[curr]=true;
				if (graph1[curr]!=0 && visit[graph1[curr]]==false) {
					stack.push(graph1[curr]);
					//visit[graph1[curr]]=true;
					//continue;
				}
				if (graph2[curr]!=0 && visit[graph2[curr]]==false) {
					stack.push(graph2[curr]);
					//visit[graph2[curr]]=true;
					//continue;
				}
			}
		}
	}
}
