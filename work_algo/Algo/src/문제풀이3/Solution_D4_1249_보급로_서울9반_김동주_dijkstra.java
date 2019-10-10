package 문제풀이3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_D4_1249_보급로_서울9반_김동주_dijkstra { //다익스트라 개념 사용 //priority q사용 가능
	public static int[][] map;
	public static boolean[][] v;
	public static int[][] memo; //다익스트라용!(distance)
	public static int TC, N;
	public static final int[] di = {-1,1,0,0};
	public static final int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws Exception { //dfs
		System.setIn(new FileInputStream("res/input_D4_1249.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        TC = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=TC; tc++) {
        	N = Integer.parseInt(br.readLine());
        	map = new int[N][N];
        	for(int n=0; n<N; n++) {
        		String line = br.readLine();
        		for(int m=0; m<N; m++) {
        			map[n][m] = line.charAt(m)-'0';
        		}
        		//System.out.println(Arrays.toString(map[n]));
        	}
        	//입력 다넣음
/*        	min = Integer.MAX_VALUE;
        	v=new boolean[N][N];
        	dijkstra(0,0);*/
        	v=new boolean[N][N];
        	memo = new int[N][N];
        	
/*        	for(int n=0; n<N; n++) {
        		for(int m=0; m<N; m++) {
        			memo[n][m] = Integer.MAX_VALUE/2;
        		}
        	}
        	memo[0][0] = 0;*/
        	//dfs(0,0); //1. 좀느린듯?(내가만든 방법)
        	//bfs2(); //2.
        	//dijkstra(); //3.
        	
        	
        	bfs(); //4.초기화필요없음
        	sb.append("#"+tc+" "+memo[N-1][N-1]+"\n");
        	//System.out.print("#"+tc+" "+memo[N-1][N-1]+"\n");
        }
        System.out.print(sb);
	}

	public static void dfs(int i, int j) {
/*		if(i==N-1 && j==N-1) {
			//memo[N-1][N-1] = Math.min(memo[N-2][N-1],memo[N-1][N-2]);
			return;
		}*/
		v[i][j] = true;
		for(int d=0; d<4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if(ni>=0 && nj>=0 && ni<N && nj<N) {// && !v[ni][nj]) {
				if(memo[ni][nj] > memo[i][j] + map[ni][nj]) {
					memo[ni][nj] = memo[i][j] + map[ni][nj];
					dfs(ni,nj);
				}
			}
		}
		//v[i][j] = false;
	}
	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		v[0][0] = true;
		q.offer(new int[] {0,0});
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int i = curr[0];
			int j = curr[1];
			for(int d=0; d<4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if(ni>=0 && nj>=0 && ni<N && nj<N) {// && !v[ni][nj]) {
					if(!v[ni][nj] || memo[ni][nj] > memo[i][j] + map[ni][nj]) {
						memo[ni][nj] = memo[i][j] + map[ni][nj];
						v[ni][nj] = true;
						q.offer(new int[] {ni,nj});
					}
				}
			}
		}
	}
	public static void bfs2() {
		Queue<int[]> q = new LinkedList<>();
		//v[0][0] = true;
		q.offer(new int[] {0,0});
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int i = curr[0];
			int j = curr[1];
			for(int d=0; d<4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if(ni>=0 && nj>=0 && ni<N && nj<N) {// && !v[ni][nj]) {
					if(memo[ni][nj] > memo[i][j] + map[ni][nj]) {
						memo[ni][nj] = memo[i][j] + map[ni][nj];
						//v[ni][nj] = true;
						q.offer(new int[] {ni,nj});
					}
				}
			}
		}
	}
	public static void dijkstra() {
		for(int k=0; k<N*N; k++) {
			int min = Integer.MAX_VALUE/2;
			int mi=0;
			int mj=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!v[i][j] && min > memo[i][j]) {
						min = memo[i][j];
						mi = i;
						mj = j;
					}
				}
			}
			v[mi][mj] = true;
			for(int d=0; d<4; d++) {
				int ni = mi+di[d];
				int nj = mj+dj[d];
				if(ni<0 || nj<0 || ni>=N || nj >=N) continue;
				if(memo[ni][nj] > memo[mi][mj]+map[ni][nj]) {
					memo[ni][nj] = memo[mi][mj]+map[ni][nj];
				}
			}
		}
	}
	
}
