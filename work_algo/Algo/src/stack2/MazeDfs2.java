package stack2;

import java.util.Arrays;
import java.util.Stack;

public class MazeDfs2 { //visit 사용, 원본을 건드리지 않음
	public static int[][] maze = {
			{0,0,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,1},
			{1,1,1,0,1,1,1,1},
			{1,1,1,0,1,1,1,1},
			{1,0,0,0,0,0,0,1},
			{1,0,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,0},
			{1,1,1,1,1,1,1,0} //1이벽, 0이 길, 경로 길이 19
	};
	public static int[] di = { 0,0,-1,1};
	public static int[] dj = {-1,1, 0,0};//좌우상하
	
	public static int N = maze.length;; //8
	public static int[][] visit;
	public static Stack<int[]> stack;
	
	public static void main(String[] args) throws Exception {
		stack = new Stack<int[]>();
		visit = new int[N][N];
		//visit[0][0]=-1;
		
		//MazeDfs2 m =new MazeDfs2(); //메서드에 스태틱을 뺐을 경우 생성해주어야 함!! //객체지향에서는 static은 목적을 가지고 사용
		dfsr(0,0,0);//m.dfsr(0,0,0);
		//m.dfs(0,0,0);
		
		System.out.println();
		for(int[] a:maze) System.out.println(Arrays.toString(a));
		System.out.println();
		for(int[] a:visit) System.out.println(Arrays.toString(a));
	}

	public static void dfsr(int i, int j, int cnt) { //재귀호출 사용하는 방법
		visit[i][j]=1; //true
		if(i==N-1 && j==N-1) {
			System.out.println("i=" +i+ ", j="+j+ ", cnt="+cnt);
			return; //멈추는게 아니고 계속 올라감
		}
		for (int d=0; d<di.length; d++) { 
			int ni = i+di[d];
			int nj = j+dj[d];
			if(0<=ni && ni<N && 0<=nj && nj<N && maze[ni][nj]==0 && visit[ni][nj]==0) {
				//visit[ni][nj] = visit[i][j]-1; MD1과같다.
				dfsr(ni,nj,cnt+1); //재귀호출의 횟수를 세는 용도의 cnt(시작점까지 카운트해서 1부터 시작하면 19)
			}
		}
		//visit[i][j]=0; //방문 표시를 없애면서 지나감, 길이 여러개일때 최소경로를 찾을수 있게 해줌
	}

	public static void dfs(int i, int j, int cnt) { //Stack대신에 Queue로 바꾸면 Bfs와 같은 코드로 작성!!
		//visit = new boolean[V];
		stack.push(new int[]{i,j,cnt}); //반복문에는 int[]이 Integer보다 낫다
		while(!stack.empty()) {
			int[] curr = stack.pop();
			i = curr[0];
			j = curr[1];
			cnt = curr[2];
			if(visit[i][j]!=1) {
				visit[i][j]=1;
				if(i==N-1 && j==N-1) {
					System.out.println("i=" +i+ ", j="+j+ ", cnt="+cnt);
					return; //멈추는게 아니고 계속 올라감
				}
				for (int d=0; d<di.length; d++) { //0 1 3 5 4 2 6
					int ni = i+di[d];
					int nj = j+dj[d];
					if(0<=ni && ni<N && 0<=nj && nj<N && maze[ni][nj]==0 && visit[ni][nj]==0) {
						visit[ni][nj] = visit[i][j]-1; //돌아갈때 지우면서 감?
						stack.push(new int[] {ni,nj,cnt+1});
					}
				}
			}
		}
	}
}
