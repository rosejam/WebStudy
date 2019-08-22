package graph;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

public class DfsLinked { 
	public static class Node{
		int data;
		Node link;
	}
	public static int V; //점 
	public static int E; //선
	public static Node[] graph; //노드의 1차원배열~
	public static boolean[] visit; //체크여부
	public static Stack<Node> stack;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_dfs.txt")); //dfs,dfs1
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		graph = new Node[V];
		stack = new Stack<Node>();
		
		for(int i=0; i<E; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			////////////////
			Node n1 = new Node();
			n1.data = v2;
			if(graph[v1]==null) {////
				n1.link=graph[v1];
				graph[v1]=n1;
			}else {////
				Node t = graph[v1];////
				while(t.link!=null) t=t.link;////
				//n1.link = t.link; //이미 null이 들어가 있으므로 null을 넣는것은 생략
				t.link = n1;////
			}////
	//무향이므로 양방향 모두 연결
			Node n2 = new Node();
			n2.data = v1;
			if(graph[v2]==null) {////
				n2.link=graph[v2];
				graph[v2]=n2;
			}else {////
				Node t = graph[v2];////
				while(t.link!=null) t=t.link;////
				//n1.link = t.link; //이미 null이 들어가 있으므로 null을 넣는것은 생략
				t.link = n2;////
			}////
	//위의 if else문을 주석처리 하면 append가 아니고 앞에 insert가 된다.
			////////////////	
/*		
0:->1->2
1:->0->3->4
2:->0->4
3:->1->5
4:->1->2->5
5:->3->4->6
6:->5 
0 1 3 5 4 2 6

0:->2->1
1:->4->3->0
2:->4->0
3:->5->1
4:->5->2->1
5:->6->4->3
6:->5
0 2 4 5 6 3 1 */
		}
		//구조를 출력
		for(int i=0; i<V; i++) {
			System.out.print(i+":->");
			if(graph[i]!=null) {
				Node t = graph[i];
				while(t.link!=null) {
					System.out.print(t.data+"->");
					t=t.link;
				}
				System.out.println(t.data);
			}
		}
		dfs(0);
/*		
		visit = new boolean[V];
		dfsr(0);*/
	}

	public static void dfsr(int node) { //재귀호출 사용하는 방법
		visit[node]=true;
		System.out.print(node + " ");
		
		Node t = graph[node];
		while(t.link!=null) {
			if(!visit[t.data]) {
				dfsr(t.data);
			}
			t = t.link;
		}
		if(!visit[t.data]) {
			dfsr(t.data);
		}
	}
	
	
	//이 메서드만 기억하면 dfs,dfsr,bfs모두 기억됨
	public static void dfs(int node) { //Stack대신에 Queue로 바꾸면 Bfs와 같은 코드로 작성!!!!
		visit = new boolean[V];
		Node n = new Node();
		n.data = node;
		stack.push(n);
		while(!stack.empty()) {
			Node curr = stack.pop();
			if(visit[curr.data]==false) {
				visit[curr.data]=true;
				System.out.print(curr.data + " ");
				
				Node t = graph[curr.data];
				while(t.link!=null) {
					if(!visit[t.data]) {
						stack.push(t);
					}
					t = t.link;
				}
				if(!visit[t.data]) {
					stack.push(t);
				}
			}
		}
	}
}
