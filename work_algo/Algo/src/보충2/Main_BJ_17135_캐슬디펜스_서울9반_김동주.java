package 보충2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_17135_캐슬디펜스_서울9반_김동주 {// 궁수가 공격하는 적은 거리가 D이하인 적 중에서 가장 가까운 적이고, 왼쪽에 있는 적을 공격한다. 
												//같은 적이 여러 궁수에게 공격당할 수 있다. 
	public static int N,M,D,turn,ni,nj,Sum,Max;
	public static int[][] X;
	public static boolean[][] visit;
	public static boolean[] v;
	public static int[] indx,rr,cc,dd;
	public static int[] di = {0,-1,0};
	public static int[] dj = {-1,0,1}; //좌상우
	
	public static Queue<int[]> q;
	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input_BJ_17135.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken()); //공격거리제한
		
		X = new int[N+1][M]; //궁수3명이 아래 N에 배치된다.
		q = new LinkedList<>();
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			//int mm=0;
			//while(st.hasMoreTokens()) {
			for(int m=0; m<M; m++) {
				X[n][m] = Integer.parseInt(st.nextToken());
				//if(X[n][m] ==1) q.offer(new int[] {n,m});
			}
		}//
		
		//0.M_C_3궁수배치(모두 이 안에서 해결)
		v = new boolean[M];
		indx = new int[3];
		Max = 0;
		rr = new int[3]; //각각의 궁수가 매턴 죽일 놈 좌표
		cc = new int[3];
		dd = new int[3];
		comb(0,0);
		//1.공격
		//2.적제거
		//3.적이동
		System.out.println(Max);
	}
	public static void comb(int start, int count) {
		if(count == 3) {
			//궁수가배치될 인덱스가 indx에 들어있다.
			Sum=0;
			turn = 0; //N이 될때 까지
			archery();
			if(Max < Sum) Max = Sum;
			return;
		}
		for(int i=start; i<M; i++) {
			if(!v[i]) {
				v[i]=true;
				indx[count] = i;
				comb(i,count+1);
				v[i]=false;
			}
		}
	}
	
	public static void archery() {
		while(turn<N) { //매 턴 반복시켜야함 
			for(int a=0; a<3; a++) { //각 궁수
				visit = new boolean[N+1][M];
				rr[a] = N - turn; //처음엔 궁수a좌표
				cc[a] = indx[a];
				findenemy(rr[a],cc[a],0,a);//궁수a의 위치 indx[a]열//1.
			}
			for(int a=0; a<3; a++) {
				killenemy(a);//2.
			}
			//3.
			turn++;
		}
	}
	
	public static void findenemy(int r, int c, int dist,int a) { //dfs가 아닌 bfs로 해야함!!!
/*		if(dist == D) return;
		if(r < N-turn && X[r][c] == 1 && dd[a] > dist) {
			rr[a]=r;
			cc[a]=c;
			dd[a]=dist;
		}
		visit[r][c] = true;
		for(int d=0; d<3; d++) {
			ni = r+di[d];
			nj = c+dj[d];
			if(ni>=0 && nj>=0 && ni<N+1 && nj<M && !visit[ni][nj]) {
				findenemy(ni,nj,dist+1,a);
			}
		}
		//visit[r][c]=false;
*/	
		visit[r][c] = true;
		q.offer(new int[] {r,c});
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int rs = curr[0];
			int cs = curr[1];
			//if(ds == D) return;
			
			for(int d=0; d<3; d++) {
				ni = rs + di[d];
				ni = cs + dj[d];
				if(ni>=0 && nj>=0 && ni<N && nj<M && !visit[ni][nj]) {
					if(ni < r && X[ni][nj] ==1) {
						rr[a]=ni;
						cc[a]=nj;
						return;
					}
					visit[ni][nj]=true;
					q.offer(new int[] {ni,nj});
				}
			}
		}
	}
	public static void killenemy(int a) {
		if(X[rr[a]][cc[a]] == 1) {
			Sum++;
			X[rr[a]][cc[a]] = 0;
		}
	}
}
