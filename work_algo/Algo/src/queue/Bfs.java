package queue;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bfs { 
	public static int V; //점 
	public static int E; //선
	public static int[][] graph; //연결상황 //나중엔 linked list사용
	public static boolean[] visit; //체크여부
	public static Queue<Integer> queue;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_bfs.txt")); //bfs,bfs1
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		graph = new int[V][V];
		queue = new LinkedList<Integer>(); //큐는 링크드리스트
		
		for(int i=0; i<E; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			graph[v1][v2] = graph[v2][v1] = 1; //왼쪽으로 한단계씩 대입(양방향이므로)
		}
		  //for(int[] a: graph) System.out.println(Arrays.toString(a));
		  bfs(0);
		  System.out.println();
	}

	//재귀는사용X

	public static void bfs2(int node) { //!!
		int cnt=0; //
		visit = new boolean[V];
		visit[node]=true; //미리 방문처리를 하고 넣는다!(큐중복방지)
		queue.offer(node); //(new int[]{node,1})
		while(!queue.isEmpty()) { 
			//int size = queue.size(); //cnt+1;
			//for(int i=0; i<size; i++) { //cnt용
				int curr = queue.poll(); 
				System.out.print(curr + " ");
				//종료조건 
				for (int next=0; next<V; next++) { //0 1 2 3 4 5 6 
					if(visit[next]==false && graph[curr][next]==1) { //큐에 중복되게 들어가는 것을 없앨 수 있다!!
						visit[next]=true; //여기서도 방문처리하고 넣는다.
						queue.offer(next);
					}
				}
			//}
			//System.out.println("level="+ cnt++); //시작거리에서 얼마만큼의 거리를 가지는지 확인
		}
	}
	
	public static void bfs(int node) { //Dfs와 겹치는 코드!
		visit = new boolean[V];
		queue.offer(node);
		while(!queue.isEmpty()) { //스택은 그냥 엠티
			int curr = queue.poll();
			if(visit[curr]==false) { //이게 없으면 큐가 터짐
				visit[curr]=true;
				System.out.print(curr + " ");
				
				for (int next=0; next<V; next++) { //0 1 2 3 4 5 6 
					if(visit[next]==false && graph[curr][next]==1) { //방문하지 않았고 인접
						queue.offer(next);
					}
				}
			}
		}
	}
}
