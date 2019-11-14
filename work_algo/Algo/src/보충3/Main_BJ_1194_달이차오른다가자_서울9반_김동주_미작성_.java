package 보충3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//말이 되고싶은 원숭이와 같은 느낌
//문제가 참 문학적이네... 달이 차오른다 가자...
//이동 횟수의 최솟값 -> bfs
public class Main_BJ_1194_달이차오른다가자_서울9반_김동주_미작성_ {
	public static int N,M,min,ni,nj,mi,mj,ei,ej;
	public static char[][] map;
	public static boolean v[][],key[];
	public static final int[] di = {-1,1,0,0};
	public static final int[] dj = {0,0,-1,1}; //
	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input_BJ_1194.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		map = new char[N][M];

		String line = null;
		for(int n=0;n<N;n++) {
			line = br.readLine();
			for(int m=0;m<M;m++) {
				map[n][m] = line.charAt(m);
				//. 이동가능 # 이동불가 
				//a-f 처음갔을때 열쇠를 집고 .이됨
				//A-F 대응하는 열쇠가 있을 때만 이동가능
				//0 현재 위치 1 출구
				if(map[n][m] == '0') {
					mi = n;
					mj = m;
				}
				if(map[n][m] == '1') {
					ei = n;
					ej = m;
				}
			}
		}//입력끝
		//
		min = Integer.MAX_VALUE;
		bfs(mi,mj,0);
		//
		if(min != Integer.MAX_VALUE) System.out.print(min);
		else System.out.print(-1);
	}
	
	private static void bfs(int i, int j, int cnt) { //cnt(이동횟수)가 최소가 되도록 도착해야 함
		Queue<int[]> q = new LinkedList<>();
		v = new boolean[N][M];
		key = new boolean[6];
		v[i][j] = true;
		q.offer(new int[] {i,j,cnt});
		int[] curr = null;int ci=i,cj=j,ccnt = 0;
		while(!q.isEmpty()) {
			curr = q.poll();
			ci = curr[0];
			cj = curr[1];
			ccnt = curr[2];
			if(ccnt >= min) continue; //백트랙킹
			if(ci == ei && cj == ej) {//도착
				min = (min<ccnt)? min:ccnt; //지금까지 이동횟수
				return;
			}
			
			for(int d=0;d<4;d++) { //말움직임
				ni = ci + di[d];
				nj = cj + dj[d];
				if(ni<N && nj<M && ni>=0 && nj>=0 && map[ni][nj] != '#' && !v[ni][nj]) {
					v[ni][nj] = true;
					q.offer(new int[] {ni,nj,chorse-1,ccnt+1});
				}
			}
		}
	}
	
}
