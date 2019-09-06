package 보충2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_17135_캐슬디펜스_서울9반_김동주_끝_ {// 궁수가 공격하는 적은 거리가 D이하인 적 중에서 가장 가까운 적이고, 왼쪽에 있는 적을 공격한다. 
												//같은 적이 여러 궁수에게 공격당할 수 있다. 
	public static int N,M,D,turn,ni,nj,Sum,Max;
	public static int[][] X,Y; //clone용 배열 Y! 매 순열조합마다 새로 시작해야하기 때문!!
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
		Y = new int[N+1][M];
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			//int mm=0;
			//while(st.hasMoreTokens()) {
			for(int m=0; m<M; m++) {
				X[n][m] = Integer.parseInt(st.nextToken());
				//if(X[n][m] ==1) q.offer(new int[] {n,m});
			}
			//System.out.println(Arrays.toString(X[n]));
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
			////제발제발 매 permcomb시 배열 초기화!!!!!
			for(int n=0; n<N; n++) { //행을 N+1개 만들었다는 것을 잊지말기!
				Y[n] = X[n].clone();
			}
			//System.out.println(Arrays.toString(indx));
			archery();
			//System.out.println("*********************"+Sum);
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
		while(turn<=N) { //매 턴 반복시켜야함 
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
			//확인
			//System.out.println(turn);
/*			for(int n=0;n<N;n++) {
				System.out.println(Arrays.toString(X[n]));
			}*/
			//System.out.println(Sum);
		}
	}
	
	public static void findenemy(int r, int c, int dist,int a) { //dfs가 아닌 bfs로 해야함!!!ㅜㅜ
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
*/		q = new LinkedList<>(); //제발 큐를 bfs안에서 새로만들기!!!! for문안에서 큐를 다쓰기 전에 리턴했기 때문!
		visit[r][c] = true;
		q.offer(new int[] {r,c,0});
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int rs = curr[0];
			int cs = curr[1];
			int ds = curr[2];
			if(ds == D) return; //ds는 궁수로부터 거리

			for(int d=0; d<3; d++) {
				ni = rs + di[d];
				nj = cs + dj[d];
				if(ni>=0 && nj>=0 && ni<N+1 && nj<M && !visit[ni][nj]) { //궁수행까지 bfs!!!!!
					//System.out.println(rr[a]);
					//System.out.println(a+":"+ni+" "+nj+" "+ds);
					if(ni < N-turn && Y[ni][nj]==1) { //적발견
						rr[a]=ni;
						cc[a]=nj;
						//System.out.println(a+" 죽일것 "+rr[a] + " "+cc[a]+" "+(ds+1));
						return;
					}
					//적없음
					visit[ni][nj]=true;
					q.offer(new int[] {ni,nj,ds+1});
				}
			}
		}
	}
	public static void killenemy(int a) {
		if(rr[a] < N-turn && Y[rr[a]][cc[a]] == 1) { //적발견한경우
			Sum++;
			Y[rr[a]][cc[a]] = 0;
		}
	}
}
