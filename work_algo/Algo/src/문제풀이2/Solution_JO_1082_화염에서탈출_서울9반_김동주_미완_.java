package 문제풀이2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_JO_1082_화염에서탈출_서울9반_김동주_미완_ { 
	public static int R,C,sr,sc,cnt;
	public static boolean poss, alive;
	public static char[][] map;
	public static boolean[][] v;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	public static Queue<int[]> q;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_JO_1082.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer rc = new StringTokenizer(br.readLine());
    	R = Integer.parseInt(rc.nextToken());
    	C = Integer.parseInt(rc.nextToken());
    	map = new char[R][C];
    	cnt = '0'; //분
    	q = new LinkedList<>();
    	v = new boolean[R][C];
    	for(int r=0; r<R; r++) {
        	String line = br.readLine();
        	for(int c=0; c<C; c++) {
	        	map[r][c] = line.charAt(c);
	        	// 비어있는 칸은 '.'로 표시되고, 불은 '*'로, 바위는 'X'
	        	// S - > D
	        	//지섭이는 불*과 바위X를 지나지 못한다. 불*은 바위X와 요새D에 옮겨지지 않는다.
	        	if(map[r][c] == 'S') { //시작 위치
	        		sr = r;
	        		sc = c;
	        		map[r][c] = '.';
	        	}else if(map[r][c] == '*') {
	        		map[r][c] = (char) cnt; //0
	        		q.offer(new int[] {r,c});
	        	}
        	}
        	//System.out.println(Arrays.toString(map[r]));
        	//System.out.println((int)map[0][4]);
        }
        //
       do { //불이 먼저인지 이동이 먼저인지 ? //일단 매 단계의 불의 좌표를 만든다. -> dfs
        	alive = true;
        	poss = false;
        	
        	move(sr,sc);////
        	firebfs();
        }while(!poss && alive);
        //
        if(poss) System.out.print(cnt);
        else System.out.print("impossible");
	}
	private static void firebfs() { //불번지기
		while(!q.isEmpty()) {
			int size = q.size();
			for(int c=0; c<size; c++) {
				int[] curr = q.poll();
				int i=curr[0];
				int j=curr[1];
				//int c=curr[2];
				for(int d=0; d<4; d++) {
					int ni = i+ di[d];
					int nj = j+ dj[d];
					if(ni>=0 && nj>=0 && ni<R && nj<C && map[ni][nj] == '.') {//&& map[ni][nj] != 'X' && map[ni][nj] != 'D') {
//						if(map[ni][nj] == 'S') {
//							alive = false; //죽음
//							return;
//						}else { //'.'
//							map[ni][nj] = '1';
//							q.offer(new int[] {ni, nj});
//						}
//						if(map[ni][nj] == '.') { //길
						map[ni][nj] = (char) cnt;
						q.offer(new int[] {ni, nj});
//						}else if(map[ni][nj] == cnt) { //불
//							q.offer(new int[] {ni, nj});
//						}
					}
				}
				//System.out.println(cnt);
				//move(sr,sc);
			}
			cnt++;
			System.out.println(cnt);
			for(char[] ar : map) System.out.println(Arrays.toString(ar));
		}
	}
	
	private static void move(int i, int j) { //'S'의 위치를 옮긴다.
		v[i][j] = true;
		for(int d=0; d<4; d++) {
			int ni = i+ di[d];
			int nj = j+ dj[d];
			if(ni>=0 && nj>=0 && ni<R && nj<C && map[ni][nj] != 'X' && map[ni][nj] != '*' && !v[ni][nj]) {
				if(map[ni][nj] == 'D') {
					poss = true;
					return;
				}else { //'.'
					map[ni][nj] = 'S';
				}
			}
		}
	}
	
}
