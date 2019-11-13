package 보충3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//말의 움직임 최대 K번까지 가능
//기본 움직임은 상하좌우
public class Main_BJ_1600_말이되고픈원숭이_서울9반_김동주_미완_ {
	public static int K,W,H,map[][],min,ni,nj;
	//public static boolean v[][];
	public static int v[][];
	public static final int[] mi = {-1,1,0,0};
	public static final int[] mj = {0,0,-1,1}; //상하좌우
	public static final int[] hi = {-2,-2,-1,-1,1,1,2,2};
	public static final int[] hj = {-1,1,-2,2,-2,2,-1,1}; //말의 8방향
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		//v = new int[H][W]; //dfs백트래킹용
		for(int h=0;h<H;h++) {
			for(int w=0;w<W;w++) {
				v[h][w] = Integer.MAX_VALUE; //1은 장애물
			}
		}
		for(int h=0;h<H;h++) {
			st = new StringTokenizer(br.readLine());
			for(int w=0;w<W;w++) {
				map[h][w] = Integer.parseInt(st.nextToken()); //1은 장애물
			}
		}
		//
		min = Integer.MAX_VALUE;
		//dfs(0,0,K,0); //크기상 불가능함..!! + 최단거리 문제임!
		bfs(0,0,K,0);
		//
		if(min != Integer.MAX_VALUE)System.out.print(min);
		else System.out.print(-1);
	}
	/*private static void dfs(int i, int j, int horse, int cnt) {
		if(i==H-1 && j==W-1) { //도착한 경우
			min = (min<cnt)? min:cnt;
			return;
		}
		if(horse>0) { //말움직임 할 수 있음
			for(int d=0;d<8;d++) { //말움직임
				ni = i + hi[d];
				nj = j + hj[d];
				if(ni<H && nj<W && ni>=0 && nj>=0 && map[ni][nj] == 0 && cnt<v[ni][nj]) {
					v[ni][nj] = cnt+1;
					dfs(ni,nj,horse-1,cnt+1);
				}
			}
		}
		for(int d=0;d<4;d++) { //원숭이움직임 
			ni = i + mi[d];
			nj = j + mj[d];
			if(ni<H && nj<W && ni>=0 && nj>=0 && map[ni][nj] == 0 && cnt<v[ni][nj]) {
				v[ni][nj] = cnt+1;
				dfs(ni,nj,horse,cnt+1);
			}
		}
	}*/
	private static void bfs(int i, int j, int horse, int cnt) {
		
	}

}
