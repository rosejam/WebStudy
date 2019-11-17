import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class dfsbfstesting {
	public static int V,E,graph[][];
	public static boolean visit[];
	public static Stack<Integer> stack;
	public static Queue<Integer> queue;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_dfs.txt")); //dfs,dfs1
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		E = sc.nextInt();
		graph = new int[V][V];
		for(int i=0; i<E; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			graph[v1][v2] = graph[v2][v1] = 1; //왼쪽으로 한단계씩 대입(양방향이므로)
		}
		visit = new boolean[V];
		dfs(0);
		visit = new boolean[V];
		System.out.println();
		bfs(0);
	}
	private static void dfs(int node) {
		visit[node] = true;
		System.out.print(node+" ");
		for(int next=0; next<V; next++) {
			if(!visit[next] && graph[node][next]==1) {
				dfs(next);
			}
		}
	}
	private static void bfs(int node) {
		queue = new LinkedList<>();
		//visit = new boolean[V];
		visit[node] = true;
		queue.offer(node);
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			System.out.print(temp+" ");
			for(int next=0; next<V; next++) {
				if(!visit[next] && graph[temp][next] ==1) {
					visit[next] = true;
					queue.offer(next);
				}
			}
		}
		
	}
}
