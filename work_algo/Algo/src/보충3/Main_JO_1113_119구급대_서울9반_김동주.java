package 보충3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//꺾는 코너 최소화
public class Main_JO_1113_119구급대_서울9반_김동주 {
	public static int M,N,m,n,map[][],ni,nj; //열, 행
	public static final int[] di = {-1,1,0,0};
	public static final int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int nn=0; nn<N; nn++) {
			st = new StringTokenizer(br.readLine());
			for(int mm=0; mm<M; mm++) {
				map[nn][mm] = Integer.parseInt(st.nextToken());
			}
		}
		//입력다받음. 1로만 지날 수 있음
		dfs(0,0,1,0);
		dfs(0,0,3,0);
		System.out.println();
	}
	private static void dfs(int i, int j, int dir, int cnt) {
		map[i][j] = 0; //비짓처리
		for(int d=0; d<4; d++) {
			ni = i + di[d];
			nj = j + dj[d];
			if(ni>=0 && nj>=0 && ni<N && nj<M && map[ni][nj] == 1) {
				if(dir != d) dfs(ni,nj,d,cnt+1);
				else dfs(ni,nj,d,cnt);
			}
		}
	}

}