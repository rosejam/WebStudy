package 보충3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//꺾는 코너 최소화
public class Main_JO_1113_119구급대_서울9반_김동주 { //카운트 뿐만아니라 각각의 점에서 꺾은횟수가 최소인지도 봐야함
	public static int M,N,m,n,map[][],ni,nj,min;
	public static final int[] di = {-1,1,0,0};
	public static final int[] dj = {0,0,-1,1};//상하좌우
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_JO_1113.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken()); //행, 열(문제 오타)
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken()); //행, 열
		map = new int[M][N];
		for(int nn=0; nn<M; nn++) {
			st = new StringTokenizer(br.readLine());
			for(int mm=0; mm<N; mm++) {
				map[nn][mm] = Integer.parseInt(st.nextToken());
				//System.out.print(map[nn][mm]+" ");
			}
			//System.out.println();
		}
		//입력다받음. 1로만 지날 수 있음
		min = Integer.MAX_VALUE;
		dfs(0,0,4,-1);
		//bfs(0,0,4,-1);
		//dfs(1,0,1,0);
		//dfs(0,1,3,0);
		System.out.print(min);
	}
/*	private static void bfs(int i, int j, int k, int l) {
		Queue<Point> q = new LinkedList<>();
		dMap[0][0] = l;
		while(!q)
		
	}*/
	private static void dfs(int i, int j, int dir, int cnt) {
		map[i][j] = 0; //비짓처리
		
		if(cnt>=min) { //같은것도 포함해야함!
			map[i][j] = 1; //제발 ;;;;
			return; //
		}
		if(i==m && j==n) {
			min = (min < cnt)? min : cnt; //꺾는 횟수 입력
			map[i][j] = 1; //제발 ;;;;;
			return;
		}
		
		for(int d=0; d<4; d++) { //dir은 현재 방향, d는 다음방향
			ni = i + di[d];
			nj = j + dj[d];
			if(ni>=0 && nj>=0 && ni<N && nj<M && map[ni][nj] == 1) {
				if(dir != d) dfs(ni,nj,d,cnt+1);
				else dfs(ni,nj,d,cnt);
			}
		}
		
		map[i][j] = 1;////
	}

}