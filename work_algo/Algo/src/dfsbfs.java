import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class dfsbfs {
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
		
		
		dfs(0);
		System.out.println();
		bfs(0);
	}
	public static void dfs(int node) {
		stack = new Stack<Integer>();
		visit = new boolean[V];
		stack.push(node);
		while(!stack.empty()) {
			int temp = stack.pop();
			if(!visit[temp]) {
				visit[temp] = true;
				System.out.print(temp + " ");
				
				for(int next=0; next<V; next++) {
					if(!visit[next] && graph[temp][next]==1) {
						stack.push(next);
					}
				}
			}
		}
	}
	public static void dfsr(int node) {
		visit[node] = true;
		System.out.print(node+" ");
		
		for(int next=0; next<V; next++) {
			if(!visit[next] && graph[node][next]==1) {
				dfsr(next);
			}
		}
	}
/*	private static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        //v[i][j] = true;
        //sum += m[i][j];
        q.offer(new int[] {i,j});
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            i = curr[0];
            j = curr[1];
            if(!v[i][j]) {
            	v[i][j] = true;
            	if(Math.abs(c-i)+Math.abs(c-j) >c) break;
            	sum += m[i][j];
            	for(int d = 0; d < 4; d++) {
            		int ni = i+di[d];
            		int nj = j+dj[d];
            		if(0<=ni && ni<N && 0<=nj && nj<N && v[ni][nj] == false) {// && Math.abs(c-ni)+Math.abs(c-nj)<=c) {
            			//v[ni][nj] = true;
            			//sum += m[ni][nj];
            			q.offer(new int[] {ni,nj});
            		}
            	}
            }
        }
	}*/
	public static void bfs(int node) {
		queue = new LinkedList<>();
		visit = new boolean[V];
		queue.offer(node);
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			if(!visit[temp]) {
				visit[temp] = true;
				System.out.print(temp+" ");
				
				for(int next=0; next<V; next++) {
					if(!visit[next] && graph[temp][next]==1) {
						queue.offer(next);
					}
				}
			}
		}
	}
}
