package 문제풀이5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SW_5656_벽돌깨기_서울9반_김동주 { //계속 맵복사하는게 약간 비효율적인가?
	//N, W, H, 그리고 벽돌들의 정보가 주어질 때,
	//남은 벽돌의 개수를 구하라!(min)
	public static int T,N,W,H,min,map[][];//,temp[][];
	public static boolean[][] v;
	public static Queue<int[]> q;
	public static final int[] di = {-1,1,0,0};
	public static final int[] dj = {0,0,-1,1}; //상하좌우
	public static void main(String[] args) throws Exception {
        //System.setIn(new java.io.FileInputStream("res/input_SW_5656.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //구슬쏘는 횟수
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W]; //[N+1][H][W]; (메모리는 많이쓰지만)
			for(int h=0; h<H; h++) {
				st = new StringTokenizer(br.readLine());
				for(int w=0; w<W; w++) {
					map[h][w] = Integer.parseInt(st.nextToken()); //[0][H][W]
				}
			}
			//for(int[] x:map) System.out.println(Arrays.toString(x));
			//입력
			
			min = Integer.MAX_VALUE;
			
			//temp = new int[H][W];
/*			for(int h=0; h<H; h++) {
				temp[h] = map[h].clone();
			}
			dfs(0, temp);*/
			dfs(0,map);
			
			//출력
			sb.append('#').append(tc).append(' ').append(min).append('\n');//출력
		}
		System.out.print(sb);
	}
	
	/*public static int perm(int depth) {//예시
		if(depth>N) return 0;
		int max=0;
		for(int i=0;i<W;i++) {
			copy(depth); //depth-1의 배열을 카피해온다. 
			for(int j=0;j<H;j++) {
				if(map[depth][j][i] > 0) {
					int cnt = bomb(j,i,depth);
					max = Math.max(max, perm(depth+1)+cnt);
					break;
				}
			}
		}
		//여기서 리턴?
	}
	
	public static int bomb(x,y,depth) {//예시
		int siz = map[depth][x][y];
		int cnt = 1;
		map[depth][x][y] = 0;
		for(int i=0; i<siz; i++) {
			for(int d=0;d<4;d++) {
				int nx = x + i*dx[d];
				int ny = y + i*dy[d];
				if(nx>=0 && ny>=0 && nx<H && ny<W && map[depth][nx][ny] !=0)
					cnt+=dfs(nx,ny,depth);
			}
		}
		return cnt;
	}*/
	
	private static void dfs(int n, int[][] tmap) { //되돌리기가 잘 안되고 있음..
		//if(n==1) {
//			System.out.println("**");
//			for(int[] x : tmap) System.out.println(Arrays.toString(x));
		//}
		if(n == N) { //다 떨궈본 경우 min값 계산(또는 중간에 벽돌들을 계산하고 벽돌이 안남은 경우로 백트래킹!!)
			int cnt = countTheBrick(tmap);
			if(min > cnt) {
				min = cnt;
			}
			return;
		}
		
		int[][] temp = new int[H][W];
		for(int h=0; h<H; h++) {
			temp[h] = tmap[h].clone(); //되돌리기위해 카피!
		}
		//
		for(int w=0; w<W; w++) { //공 떨구기
			dfs(n+1, dropTheBall(w, tmap)); //tmap이 바뀌면
			
			for(int h=0; h<H; h++) {
				tmap[h] = temp[h].clone();
			}//dfs전으로 되돌리기!!!! 드디어 성공. tmap = temp;는 안됨...
			
		}
	}
	
	//남은 벽돌개수를 리턴
	private static int countTheBrick(int[][] ttmap) {
		int cnt = 0;
		for(int h=0; h<H; h++) {
			for(int w=0; w<W; w++) {
				if(ttmap[h][w] != 0) cnt++;
			}
		}
		return cnt;
	}

	//tmap에서 공을 w에 떨궜을 때 결과를 리턴
	private static int[][] dropTheBall(int w, int[][] ttmap) {
		for(int h=0; h<H; h++) { //맨위의 공을 큐에 넣기
			if(ttmap[h][w] != 0) {
				q = new LinkedList<>();
				//v = new boolean[H][W];
				q.offer(new int[] {h,w,ttmap[h][w]}); //좌표와 범위, 들어가면서 빼면서 들어감
				//v[h][w] = true;
				ttmap[h][w] = 0; //v처리
				break;
			}
		}
		//int[] curr=null; int ni = 0, nj= 0;//, i=0, j=0;
		int[] curr = null; int ci =0; int cj =0; int cd = 0;
		while(!q.isEmpty()) {
			/*curr = q.poll();
			if(curr[2] == 1) continue;
			for(int d=0; d<4; d++) {
				ni = curr[0] + di[d];
				nj = curr[1] + dj[d];
				if(ni>=0 && nj>=0 && ni<H && nj<W && tmap[ni][nj] !=0) {
					if(tmap[ni][nj] ==1) {
						q.offer(new int[] {ni,nj,curr[2]-1});
						tmap[ni][nj] = 0;
					}else {
						q.offer(new int[] {ni,nj,curr[2]-1});
						q.offer(new int[] {ni,nj,tmap[ni][nj]});
						tmap[ni][nj] = 0;
					}
				}
			}*/
			curr= q.poll();
			ci = curr[0];
			cj = curr[1];
			cd = curr[2];
			//이 십자 탐색은 bfs로 할 수 있음!!(d 0~4, i 1~길이-1)
			for(int i=1; i<cd; i++) { //십자 탐색
				if(ci+i<H && ttmap[ci+i][cj] >0) {
					if(ttmap[ci+i][cj] >1) {
						q.offer(new int[] {ci+i, cj, ttmap[ci+i][cj]});
					}
					ttmap[ci+i][cj] = 0;
				}
				if(ci-i>=0 && ttmap[ci-i][cj] >0) {
					if(ttmap[ci-i][cj] >1) {
						q.offer(new int[] {ci-i, cj, ttmap[ci-i][cj]});
					}
					ttmap[ci-i][cj] = 0;
				}
			}
			for(int j=1; j<cd; j++) {
				if(cj+j<W && ttmap[ci][cj+j] >0) {
					if(ttmap[ci][cj+j] >1) {
						q.offer(new int[] {ci, cj+j, ttmap[ci][cj+j]});
					}
					ttmap[ci][cj+j] = 0;
				}
				if(cj-j >=0 && ttmap[ci][cj-j] >0) {
					if(ttmap[ci][cj-j] >1) {
						q.offer(new int[] {ci, cj-j, ttmap[ci][cj-j]});
					}
					ttmap[ci][cj-j] = 0;
				}
			}
		}
		int fh;
		//0인 벽돌 빈부분없애고 아래로 땡기기
		for(int ww=0; ww<W; ww++) {
			for(int hh=H-1; hh>0; hh--) {
				if(ttmap[hh][ww] == 0) {
					fh = hh;
					while(fh>=0 && ttmap[fh][ww] == 0) {
						fh--;
					}
					if(fh>=0) {
						ttmap[hh][ww] = ttmap[fh][ww];
						ttmap[fh][ww] = 0;
					}
				}
			}
		}
		return ttmap; //
	}
	
}
