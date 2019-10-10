package sw기출;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_16234_인구이동_서울9반_김동주_끝_ {
	public static int N,L,R,move,cnt,sum,nat,nn;//befcnt;
	public static int[][] A,union;
	//public static boolean[][] v;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	public static ArrayList<Integer> evenn;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_BJ_16234.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		A = new int[N][N];
		nn = N*N;
		for(int n=0; n<N; n++) {
			StringTokenizer nns = new StringTokenizer(br.readLine());
			for(int m=0; m<N; m++) {
				A[n][m] = Integer.parseInt(nns.nextToken());
			}
		}
		//
		if(N==1) System.out.print(0);
		else {
			while(true) {
				//v = new boolean[N][N];
				//새연합
				evenn = new ArrayList<>();
				union = new int[N][N];
				cnt = 0;
				evenn.add(0);
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(union[i][j] == 0) { //!visited
							sum=0;nat=0;
							cnt++;
							findunion(i,j); //dfs/bfs
							//sum /= nat;
							evenn.add((int)sum/nat);
						}
					}
				}
				for(int[] u : union) System.out.println(Arrays.toString(u));
				if(cnt == nn) { //연합을 더이상 만들 수 없을 때
					//(cnt == befcnt) { //연합을 다시 나눠도 개수가 동일할 때(원래는 계속 줄어야 함)
					break;
				}
				evenpeople();
				move++;
				//System.out.println(move);
				//befcnt = cnt;
/*				//평평체크
				boolean even = true;
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(A[i][j] != A[0][0]) {
							even = false;
						}
					}
				}
				if(even) break;*/
			}
			//
			System.out.print(move);//(move-1);
		}
	}
	public static void evenpeople() {
/*			int sum = 0;
			int nat = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(union[i][j]==c) {
						sum += A[i][j];
						nat++;
					}
				}
			}
			sum /= nat;*/
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				A[i][j] = evenn.get(union[i][j]);
			}
		}
	}
	
	public static void findunion(int i, int j) {
		union[i][j] = cnt;
		sum += cnt;
		nat++;
		for(int d=0; d<4; d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			if(ni>=0 && nj>=0 && ni<N && nj<N && union[ni][nj]==0 && Math.abs(A[ni][nj]-A[i][j]) >=L && Math.abs(A[ni][nj]-A[i][j]) <=R ){
				findunion(ni,nj);
			}
		}
	}
}
