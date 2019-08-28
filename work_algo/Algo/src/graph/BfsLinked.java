package graph;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import graph.DfsLinked.Node;

public class BfsLinked { 
	public static class Node{
		int data;
		Node link;
	}
	public static int V; //점 
	public static int E; //선
	public static Node[] graph; //연결상황 //노드의 1차원배열~
	public static boolean[] visit; //체크여부
	public static Queue<Node> queue;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bfs.txt")); //bfs,bfs1
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		graph = new Node[V];
		queue = new LinkedList<Node>(); //큐는 링크드리스트
		
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
0 1 2 3 4 5 6

0:->2->1
1:->4->3->0
2:->4->0
3:->5->1
4:->5->2->1
5:->6->4->3
6:->5
0 2 1 4 3 5 6
*/
		}
		//구조를 출력
		for(int i=0; i<V; i++) {
			System.out.print(i+":->");
			if(graph[i]!=null) {
/*				Node t = graph[i];
				while(t.link!=null) {
					System.out.print(t.data+"->");
					t=t.link;
				}
				System.out.println(t.data);*/
				
				for(Node t=graph[i]; t!=null; t=t.link) {
					System.out.print(t.data+"->");
				}
				System.out.println();
			}
		}
		//bfs(0);
		bfs(0);
		//System.out.println();
	}

	//재귀는사용X

	public static void bfs2(int node) { //Dfs와 겹치는 코드!!
		int cnt=0; //
		visit = new boolean[V];
		visit[node]=true; //미리 방문처리를 하고 넣는다!(큐중복방지)
		Node n = new Node();
		n.data = node;
		queue.offer(n);
		while(!queue.isEmpty()) { 
			int size = queue.size();
			for(int i=0; i<size; i++) { //cnt용
				Node curr = queue.poll(); 
				System.out.print(curr.data + " ");
				
/*				Node t = graph[curr.data];
				while(t.link!=null) {
					if(!visit[t.data]) {
						visit[t.data]=true;
						queue.offer(t);
					}
					t = t.link;
				}
				if(!visit[t.data]) {
					visit[t.data]=true;
					queue.offer(t);
				}*/
				
				for(Node t=graph[curr.data]; t!=null; t=t.link) {
					if(!visit[t.data]) {
						visit[t.data]=true;
						queue.offer(t);
					}
				}//코드가 더 짧아짐
			}
			System.out.println("level="+ cnt++); //시작거리에서 얼마만큼의 거리를 가지는지 확인
		}
	}
	
	public static void bfs(int node) { //Dfs와 겹치는 코드!
		visit = new boolean[V];
		Node n = new Node();
		n.data = node;
		queue.offer(n);
		while(!queue.isEmpty()) { //스택은 그냥 엠티
			Node curr = queue.poll();
			if(!visit[curr.data]) { //이게 없으면 큐가 터짐
				visit[curr.data]=true;
				System.out.print(curr.data + " ");
				
/*				Node t = graph[curr.data];
				while(t.link!=null) {
					if(!visit[t.data]) {
						queue.offer(t);
					}
					t = t.link;
				}
				if(!visit[t.data]) {
					queue.offer(t);
				}*/
				
				for(Node t=graph[curr.data]; t!=null; t=t.link) {
					if(!visit[t.data]) {
						queue.offer(t);
					}
				}
			}
		}
	}
}
