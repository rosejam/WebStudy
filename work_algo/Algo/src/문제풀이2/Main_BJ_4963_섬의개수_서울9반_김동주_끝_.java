package 문제풀이2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_4963_섬의개수_서울9반_김동주_끝_ {
	public static int W, H, cnt;
	public static int[][] map;
	public static boolean land, flag;
	public static boolean[][] v;
	public static final int[] di = {-1,-1,-1,0,0,1,1,1};
	public static final int[] dj = {-1,0,1,-1,1,-1,0,1}; //8방향
	public static Queue<int[]> q = new LinkedList<>();
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_BJ_4963.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
        	StringTokenizer wh = new StringTokenizer(br.readLine());
	    	W = Integer.parseInt(wh.nextToken());
	    	H = Integer.parseInt(wh.nextToken());
	    	if(W==0 || H==0) break;
	    	map = new int[H][W];
	    	for(int h=0; h<H; h++) {
	    		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    		for(int w=0; w<W; w++) {
	    			map[h][w] = Integer.parseInt(st.nextToken()); //1은 땅, 0은 바다
	    			//if(map[h][w] ==1) {land = true;} //si = h; sj = w; 
	    		}
	    		//System.out.println(Arrays.toString(map[h]));
	    	}//맵 받음
	    	//if(!land) {sb.append("0\n"); continue;}
	    	v = new boolean[H][W];
	    	cnt = 0;
//here:	    while(true){
//			flag = false;
    		for(int h=0; h<H; h++) {
	    		for(int w=0; w<W; w++) {
	    			if( map[h][w]==1 && !v[h][w]) {
	    				//dfs(h,w);
	    				bfs(h,w);
	    				cnt++;
//	    				flag = true;
	    				//continue here;
	    			}
	    		}
	    	}
//	    		break; //다돌아도 안돌아감
//	    	}
	    	sb.append(cnt+"\n"); //섬의 개수
        }
        System.out.print(sb);
	}
	public static void bfs(int i, int j) {
		v[i][j] = true;
		q.offer(new int[] {i,j});
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			int ii = ij[0];
			int jj = ij[1];
//			if(v[ii][jj]==false) {
			//v[ii][jj] = true;
			for(int d=0; d<8; d++) { //8방향
				int ni = ii + di[d];
				int nj = jj + dj[d];
				if(ni>=0 && nj>=0 && ni<H && nj<W && map[ni][nj] ==1 && !v[ni][nj]) {
					v[ni][nj] = true;
					q.offer(new int[] {ni,nj});
				}
			}
//			}
		}
	}
/*	public static void dfs(int i, int j) { //섬범위 탐색 visit처리
		v[i][j] = true;
		for(int d=0; d<8; d++) { //8방향
			int ni = i + di[d];
			int nj = j + dj[d];
			if(ni>=0 && nj>=0 && ni<H && nj<W && !v[ni][nj] && map[ni][nj] ==1) { //방문하지 않은 부분
				dfs(ni,nj);
			}
		}
	}*/

}
