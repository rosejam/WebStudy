package stack2;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class MazeDfs { 
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
	//public static boolean[][] visit;
	public static Stack<Integer> stack;
	
	public static void main(String[] args) throws Exception {
		stack = new Stack<Integer>();
		
		maze[0][0]=-1; //원본을 손대도 되는경우
		//dfsr(0,0);
		dfs(0,0);
		
		System.out.println();
		for(int[] a:maze) System.out.println(Arrays.toString(a));
	}

	public static void dfsr(int i, int j) { //재귀호출 사용하는 방법
		//if(!(0<=ni && ni<N && 0<=nj && nj<N)) return; 처음 범위체크
		if(i==N-1 && j==N-1) {
			System.out.println(maze[i][j]*-1);
			return; //멈추는게 아니고 계속 올라감
		}
		for (int d=0; d<di.length; d++) { 
			int ni = i+di[d];
			int nj = j+dj[d];
			if(0<=ni && ni<N && 0<=nj && nj<N && maze[ni][nj]==0) { //범위체크 중요!! 범위체크 먼저, maze체크 다음
				maze[ni][nj] = maze[i][j]-1; //현재자리를 -1로 세팅해서 방문처리
				dfsr(ni,nj); 
			}
		}
	}

	public static void dfs(int i, int j) { //Stack대신에 Queue로 바꾸면 Bfs와 같은 코드로 작성!!
		//visit = new boolean[V];
		stack.push(i*N+j); //행렬
		while(!stack.empty()) {
			int curr = stack.pop();
			j = curr/N;
			i = curr%N;
			if( maze[i][j]<=0 ) {
				if(i==N-1 && j==N-1) {
					System.out.println(maze[i][j]*-1);
					return; //멈추는게 아니고 계속 올라감
				}
				for (int d=0; d<di.length; d++) { 
					int ni = i+di[d];
					int nj = j+dj[d];
					if(0<=ni && ni<N && 0<=nj && nj<N && maze[ni][nj]==0) { //범위 안에 있고 인접한지.
						maze[ni][nj] = maze[i][j]-1; //왔던길로 돌아갈수 없도록
						stack.push(ni*N+nj);
					}
				}
			}
		}
	}
}
