package stack1;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Dfs__ { 
	public static int V; //점 
	public static int E; //선
	public static int[][] graph; //연결상황 //나중엔 linked list사용
	public static boolean[] visit; //체크여부
	public static Stack<Integer> stack;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_dfs.txt")); //dfs,dfs1
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		graph = new int[V][V];
		stack = new Stack<Integer>();
		
		for(int i=0; i<E; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			graph[v1][v2] = graph[v2][v1] = 1; //왼쪽으로 한단계씩 대입(양방향이므로)
		}
		  //for(int[] a: graph) System.out.println(Arrays.toString(a));
		  dfs(0);
		
/*		visit = new boolean[V];
		dfsr(0);*/
	}

	public static void dfsr(int node) { //재귀호출 사용하는 방법
		visit[node]=true;
		System.out.print(node + " ");
		//if(node == 99) return 1; D4_1219길찾기에서 사용
		for (int next=0; next<V; next++) { //0 1 3 5 4 2 6
			if(visit[next]==false && graph[node][next]==1) {
				dfsr(next); //재귀호출 //if(dfsr(next) ==1) return 1; 여기서도 리턴을 해주어야 계속 리턴이됨.
			}
		}
		//return 0; for문을 모두 돌아도 1이안될경우
	}
	
	//이 메서드만 기억하면 dfs,dfsr,bfs모두 기억됨
	public static void dfs(int node) { //Stack대신에 Queue로 바꾸면 Bfs와 같은 코드로 작성!!!!
		visit = new boolean[V];
		stack.push(node);
		while(!stack.empty()) {
			int curr = stack.pop();
			if(visit[curr]==false) {
				visit[curr]=true;
				System.out.print(curr + " ");
				
				for (int next=0; next<V; next++) { //0 2 4 5 6 3 1 
				//for (int next=V-1; next>=0; next--) { //0 1 3 5 4 2 6 
					if(visit[next]==false && graph[curr][next]==1) { //방문하지 않았고 인접
						stack.push(next);
					}
				}
			}//이 if문 내부는 재귀호출부분과 동일하다!!!!
		}
	}
}
