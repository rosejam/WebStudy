package graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main_정올_1695_단지번호붙이기_Bfs_서울9반_김동주 {
	public static int[][] map;
	public static int N;
	public static int cnt;
	public static int[] di= {-1,1,0,0};
	public static int[] dj= {0,0,-1,1}; //상하좌우
	//public static boolean[][] visit; //체크여부
	public static ArrayList<Integer> counts;
	public static int danji;
	public static void bfs(int i, int j, int cn) { //재귀호출 사용하는 방법
		//visit[i][j]=true;
		//int cnt=1;
		Queue<int[]> q = new LinkedList<>();
		map[i][j]=cn; //넣기전 방문처리!!
		cnt++;
		q.offer(new int[] {i,j});
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			//여기서 초기및return조건 체크!!!!
			for(int d=0; d<4; d++) { 
				int ni = curr[0]+di[d];
				int nj = curr[1]+dj[d];
				if(0<=ni && ni<N && 0<=nj && nj<N && map[ni][nj]==1) {// && visit[ni][nj]==false) { //범위체크 중요!! 범위체크 먼저, maze체크 다음
					cnt++;
					//(return조건 체크!!)
					map[ni][nj]=cn; //여기서도 방문처리
					q.offer(new int[] {ni,nj});
				}
			}
		}
		//return 0;
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_JO_1695.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Byte.parseByte(br.readLine());
		
		map = new int[N][N];
		for(byte n=0; n<N; n++) {
			String line = br.readLine();
			for(byte m=0; m<N; m++) {
				map[n][m] = line.charAt(m)-'0';
			}
		}
		//단지 구하기
		//visit = new boolean[N][N];
		danji=0;
		counts = new ArrayList<>(); //또는 단지 수만큼 배열을 만든다!
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==1) {//(visit[i][j]==false && map[i][j]==1) {
					cnt=0;
					danji--;
					bfs(i,j,danji);
					counts.add(cnt);
				}
			}
		}
/*		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}*/
		danji=-danji;//
		Collections.sort(counts);
		sb.append(danji);
		for(int n=0; n<danji; n++) {
			sb.append("\n"+counts.get(n));
		}
		System.out.println(sb);
		br.close();
	}
}
