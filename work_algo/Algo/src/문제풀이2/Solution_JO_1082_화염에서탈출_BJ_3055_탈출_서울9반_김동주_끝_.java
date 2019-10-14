package 문제풀이2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_JO_1082_화염에서탈출_BJ_3055_탈출_서울9반_김동주_끝_ { //왜 어떤 firebfs뒤에 move를 끝까지 못하는지?? //char과 int가 겹쳐서
	public static int R,C,sr,sc,walk,cnt;
	//public static char cnt;
	public static boolean poss;
	public static int[][] map;
	public static boolean[][] v;
	public static final int[] di = {-1,1,0,0};
	public static final int[] dj = {0,0,-1,1};
	public static Queue<int[]> q;
	public static void main(String[] args) throws Exception { //불을 먼저 숫자로 표현하고 S를 dfs로 이동
		//System.setIn(new FileInputStream("res/input_JO_1082.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer rc = new StringTokenizer(br.readLine());
    	R = Integer.parseInt(rc.nextToken());
    	C = Integer.parseInt(rc.nextToken());
    	map = new int[R][C];
    	cnt = 0; walk =0;
    	q = new LinkedList<>();
    	v = new boolean[R][C];
    	for(int r=0; r<R; r++) {
        	String line = br.readLine();
        	for(int c=0; c<C; c++) {
	        	//map[r][c] = line.charAt(c);
	        	// 비어있는 칸은 '.'로 표시되고, 불은 '*'로, 바위는 'X'
	        	// S - > D
	        	//지섭이는 불*과 바위X를 지나지 못한다. 불*은 바위X와 요새D에 옮겨지지 않는다.
	        	switch(line.charAt(c)) {
	        	case '.':
	        		map[r][c] = -1;
	        		break;
	        	case 'X':
	        		map[r][c] = -2;
	        		break;
	        	case '*':
	        		map[r][c] = cnt; //0부터
	        		q.offer(new int[] {r,c});
	        		break;
	        	case 'S':
	        		sr = r;
	        		sc = c;
	        		map[r][c] = -1; //'.'
	        		break;
	        	case 'D':
	        		map[r][c] = -3;
	        		break;
	        	}
/*	        	if(map[r][c] == 'S') { //시작 위치 저장
	        		sr = r;
	        		sc = c;
	        		map[r][c] = 0; //'.'
	        	}else if(map[r][c] == '*') {
	        		map[r][c] = cnt; //0
	        		q.offer(new int[] {r,c}); //큐에 전부 넣기
	        	}*/
        	}
        	//System.out.println(Arrays.toString(map[r]));
        	//System.out.println((int)map[0][4]);
        }
    	//for(char[] ar : map) System.out.println(Arrays.toString(ar));
        //
//       do { //불이 먼저인지 이동이 먼저인지 ? //일단 매 단계의 불의 좌표를 만든다. -> dfs
//        	alive = true;
//        	poss = false;
//        	move(sr,sc);////
    	//cnt = (char) (cnt+1);
        firebfs(); //단계별로 불 표시
//        }while(!poss && alive);
        //System.out.println(stages);
        //walk=-1;
        move(sr,sc);
        if(poss) System.out.print(walk);
        else System.out.print("KAKTUS"); //impossible //KAKTUS
	}
	
	private static void firebfs() { //불번지기
		while(!q.isEmpty()) {
			cnt = cnt+1;
			//System.out.println((int)cnt);
			int size = q.size();
			for(int c=0; c<size; c++) {
				int[] curr = q.poll();
				int i=curr[0];
				int j=curr[1];
				//int c=curr[2];
				for(int d=0; d<4; d++) {
					int ni = i+ di[d];
					int nj = j+ dj[d];
					if(ni>=0 && nj>=0 && ni<R && nj<C && map[ni][nj] == -1) {//&& map[ni][nj] != 'X' && map[ni][nj] != 'D') {
						map[ni][nj] = cnt; //방문처리 대신
						q.offer(new int[] {ni, nj});
					}
				}
			}
/*			System.out.println((int)cnt);
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(map[i][j] >=0 && map[i][j] < 10) System.out.print((int)map[i][j]+"  ");
					else if(map[i][j] >= 10 && map[i][j] < 50) System.out.print((int)map[i][j]+" ");
					else System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}*/
		}
	}
	
	//최단거리는 dfs가 아니고 bfs로 구하는게 맞다!!
	private static void move(int i, int j) { //'S'의 위치를 옮긴다. walk보다 큰 곳은 지날 수 있음!
		//q = new LinkedList<>();
		v[i][j] = true;
		q.offer(new int[] {i,j});
		while(!q.isEmpty()) {
			int size = q.size();
			walk++;
	 		//System.out.println(walk);
			for(int s=0; s<size; s++) {
				int[] curr = q.poll();
				int ii = curr[0];
				int jj = curr[1];
				//v[ii][jj] = true;
				for(int d=0; d<4; d++) {
					int ni = ii + di[d];
					int nj = jj + dj[d];
					if(ni>=0 && nj>=0 && ni<R && nj<C && !v[ni][nj] && map[ni][nj] != -2) {
						if(map[ni][nj] == -1 || (map[ni][nj] < cnt && map[ni][nj] > walk)) { //(불이 걷기보다 한번 먼저 번진다.)
							v[ni][nj] = true;
							q.offer(new int[] {ni,nj});
/*							System.out.println(ni);
							System.out.println(nj);
							System.out.println();*/
						}else if(map[ni][nj]== -3) {
							poss = true;
							//q.clear();
							return;
						}
					}
				}
			}
			//walk++;
			//for(boolean[] c: v) System.out.println(Arrays.toString(c));
		}
	}
}
