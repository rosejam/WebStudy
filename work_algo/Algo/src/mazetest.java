import java.util.Arrays;
import java.util.Stack;

public class mazetest {
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
	public static int[] di = {0,0,1,-1};
	public static int[] dj = {-1,1,0,0}; //좌우하상
	
	public static int[][] visit;
	public static int N = maze.length;
	public static Stack<int[]> stack;

	public static void main(String[] args) throws Exception {
		visit = new int[N][N];
		
		//maze[0][0]=-1;
		dfs(0,0,0);
		System.out.println();
		//maze print
		for(int [] a: maze) System.out.println(Arrays.toString(a));
	}
	
	public static void dfs(int i, int j, int cnt) {
		//visit생성
		stack = new Stack<int[]>();
		stack.push(new int[] {i,j,cnt});
		while(!stack.empty()) {
			int[] curr = stack.pop();
			i = curr[0];
			j = curr[1];
			cnt = curr[2];
			if(visit[i][j] !=1) { //no visit
				visit[i][j] = 1;
				//종료조건있으면 적기!!
				if(i==N-1 && j==N-1) {
					System.out.print(i+" "+j+" "+cnt);
					return;
				}
				//다음 서치(4방향)
				for(int d=0;d<4; d++) {
					int ni = i+di[d];
					int nj = j+dj[d];
					if(ni>=0 && nj>=0 && ni<N && nj <N && maze[ni][nj]==0 && visit[ni][nj]==0) {//방문하지 않은 다음 길
						stack.push(new int[] {ni,nj,++cnt});
					}
				}
			}
		}
	}
	public static void dfsr(int i, int j, int cnt) {
		visit[i][j]= 1;
		//종료조건 여기서
		if(i==N-1 && j==N-1) {
			System.out.print(i+" "+j+" "+cnt);
			return;
		}
		//다음 서치 4방향 
		for(int d=0; d<4; d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			if(0<=ni && ni<N && 0<=nj && nj<N && maze[ni][nj]==0 && visit[ni][nj]==0) { //갈수 있는데 방문하지 않은 길
				dfsr(ni,nj,cnt+1);
			}
		}
	}
}
