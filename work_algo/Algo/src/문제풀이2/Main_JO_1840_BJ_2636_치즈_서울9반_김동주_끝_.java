package 문제풀이2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_JO_1840_BJ_2636_치즈_서울9반_김동주_끝_ {
	public static int R,C,time,left;
	public static int[][] cheese;
	public static boolean[][] v;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_JO_1840.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer rc = new StringTokenizer(br.readLine());
    	R = Integer.parseInt(rc.nextToken());
    	C = Integer.parseInt(rc.nextToken());
    	cheese = new int[R][C];
        for(int r=0; r<R; r++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int c=0; c<C; c++) {
        		cheese[r][c] = Integer.parseInt(st.nextToken());
        	}
        	//System.out.println(Arrays.toString(cheese[r]));
        }
        //
        time = 0; boolean flag = true;
        do {
        	time--;
        	//bfs(0,0); //없어질 부분 체크
        	left = 0;
        	v = new boolean[R][C];dfs(0,0);
        	flag = true;
here:      	for(int r=0; r<R; r++) {
        		for(int c=0; c<C; c++) {
        			if(cheese[r][c] > 0) { //없어지는 부분 말고 치즈가 남은 경우
        				flag = false;
        				break here;
        			}//else if(cheese[r][c] == time) left++;
        		}
        	}
        	//for(boolean[] vv:v)System.out.println(Arrays.toString(vv));
        	//for(int[] vv:cheese)System.out.println(Arrays.toString(vv));
        }while(!flag);
        
//        for(int r=0; r<R; r++) {
//    		for(int c=0; c<C; c++) {
//    			if(cheese[r][c] == time) left++;
//    		}
//    	}
        System.out.println(-1*time); //완전히 없어진 시간
        System.out.print(left); //없어지기 직전 칸 개수
	}
	
	public static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		v = new boolean[R][C];
		v[i][j] = true;
		q.offer(new int[] {i,j});
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int c0 = curr[0];
			int c1 = curr[1];
			//v[c0][c1] = true;
			for(int d=0; d<4; d++) {
				int ni = c0 + di[d];
				int nj = c1 + dj[d];
				if(ni>=0 && nj>=0 && ni<R && nj<C && !v[ni][nj]) {
					if(cheese[ni][nj] == 1) {
						cheese[ni][nj] = time;
						v[ni][nj] = true;
						left++; //여기서 세준다.
					}
					else if(cheese[ni][nj] > time) {
						v[ni][nj] = true;
						q.offer(new int[] {ni,nj});
					}
				}
			}
		}
	}
	
	public static void dfs(int i, int j) {
		v[i][j] = true;
		for(int d=0; d<4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if(ni>=0 && nj>=0 && ni<R && nj<C && !v[ni][nj]) {
				if(cheese[ni][nj] == 1) {
					cheese[ni][nj] = time;
					v[ni][nj] = true;
					left++; //여기서 세준다.
				}else if(cheese[ni][nj] > time) {
					//v[ni][nj] = true;
					dfs(ni,nj);
				}
			}
		}
	}
	
}
