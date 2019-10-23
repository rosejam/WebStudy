package 문제풀이3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_16236_아기상어_서울9반_김동주 { //구현및bfs
	public static int N, pool[][],cnt,size,eat,si,sj,ii,jj,ni,nj,far;//,fishnum;
	public static int[] di = {-1,0,0,1}; 
	public static int[] dj = {0,-1,1,0};
	public static boolean isFish, v[][];
	public static Queue<int[]> q;
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_BJ_16236.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		pool = new int[N][N];
		//String line;
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			//line = br.readLine();
			for(int m=0; m<N; m++) {
				//pool[n][m] = line.charAt(2*m) -'0';
				pool[n][m] = Integer.parseInt(st.nextToken());
				/*	0: 빈 칸
					1, 2, 3, 4, 5, 6: 칸에 있는 물고기의 크기
					9: 아기 상어의 위치 - 한마리, 처음 크기 "2"
				*/
				if(pool[n][m] > 0) {
					if(pool[n][m] == 9) {si =n; sj= m; pool[n][m] = 0;} //아기상어
					if(pool[n][m] < 2) isFish = true; //먹을 수 있는 물고기 유무
				}
			}
			//System.out.println(Arrays.toString(pool[n]));
		}
		//입력다받음
		//물고기 M마리 //크기가 작은 물고기 먹을 수 있음  //같으면 지나갈 수 있음 //크면 못지나감 V
/* 이동 기준 : 먹을 수 있는 물고기가 없으면 종료 V
 * 여러마리 -> 가장가까운것 부터 상/좌/우/하 순으로 우선순위 (상좌/상우/하좌/하우) V
 * 자기 크기만큼 잡아먹으면 크기++ V
 */		
		q = new LinkedList<>();
		size = 2;
		while(isFish) {
			bfs(si,sj);
			for(int[] x: pool) System.out.println(Arrays.toString(x));
			System.out.println(cnt);
			System.out.println(size+"size");
			System.out.println("----");
		}
		System.out.print(cnt);
	}
	
	private static void bfs(int i, int j) {
		v = new boolean[N][N];
		v[i][j] = true;
		q.offer(new int[] {i,j,0});
		//int ii=i,ni=i,jj=j,nj=j,far=0;
		while(!q.isEmpty()) {
			ii = q.peek()[0];
			jj = q.peek()[1];
			far = q.poll()[2];
			for(int d=0; d<4; d++) {
				ni = ii+di[d];
				nj = jj+dj[d];
				if(ni<0 || nj<0 || ni>=N || nj>=N ) continue;//|| pool[ni][nj] > size
				if(v[ni][nj] || pool[ni][nj] > size) continue;
				else if(pool[ni][nj] > 0 && pool[ni][nj] < size) { //잡아먹음
					cnt += (far+1);
					eat++;
					if(eat == size) {size++; eat=0;}
					pool[ni][nj] = 0;
					//pool[ii][jj] = 9;
					//pool[i][j] = 0;
					si = ni; sj = nj;
					q.clear();
					return;
				}
				v[ni][nj] = true;
				q.offer(new int[] {ni,nj,far+1});
			}
		}
		isFish = false;
	}
}
