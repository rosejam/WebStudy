package 문제풀이;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_1861_정사각형방_서울9반_김동주 {
	public static int T, N, cnt,Room,Max,x,y,nx,ny,cc;
	public static int[][] A;
	public static Queue<int[]> q;
	public static boolean[][] visit;
	public static final int[] dx= {1,-1,0,0};
	public static final int[] dy= {0,0,1,-1};
	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input_D4_1861.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			A = new int[N][N];
			for(int n=0; n<N; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int nn=0;
				while(st.hasMoreTokens()) {
					A[n][nn++] = Integer.parseInt(st.nextToken()); //1이상 N^2 이하의 수. 모두 다름
				}
			}
			
			Room=0;
			Max=0;
			q = new LinkedList<>();
			for(int i=0;i<N;i++) { 
				for(int j=0;j<N;j++) {
					//cnt=0; //cnt를 셋는데 Max보다 "크면" 방의 숫자를 ans에 대입
					bfs(i,j); //매칸부터 시작해서 정확히 1더 큰 방으로 이동
				}
			}
			
			sb.append("#"+tc+" "+Room+" "+Max+"\n");
		}
		System.out.println(sb);
	}
	
	public static void bfs(int i, int j) {
		//visit = new boolean[N][N];
		//visit[i][j] = true;
		q.offer(new int[] {i,j,1});
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			x = curr[0];
			y = curr[1];
			cc = curr[2];
			
			if(cc > Max) {
				Max = cc;
				Room = A[x][y];
			}else if(cc == Max && Room > A[x][y]){
				Room = A[x][y];
			}
			
			for(int d=0; d<4; d++) {
				nx = x+dx[d];
				ny = y+dy[d];
				
				if(nx>=0 && ny>=0 && nx<N && ny<N && A[nx][ny] == A[x][y]+1) {
					//visit[nx][ny] = true;
					q.offer(new int[] {nx, ny,cc+1});
					break;
				}
			}
		}
		//bfs 종료
	}
}
