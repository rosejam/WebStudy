package 문제풀이4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1733_오목_서울9반_김동주_미완_ { //안됨.... 6개넘는 오목알일때 구분
	public static int[][] pan = new int[19][19]; //가로세로 / 행렬
	public static boolean[][] v ;
	//검은색1, 흰색 2
	public static int ni,nj,wi,wj,wd,wii,wjj, win;
	public static boolean flag;
	public static final int[] di = {-1,-1,-1,0,0,1,1,1};  //07, 16, 25, 34 가 쌍이다. 합7
	public static final int[] dj = {-1,0,1,-1,1,-1,0,1};  //0,1,3,5가 대표방향임
	public static void main(String[] args) throws Exception {
		//8방향(4방향)중 한방향으로 "5알연속"이면 이김
		//6알은 아님!
		//한군데에서, 한쪽이 이기거나 승부결정이 안남
		System.setIn(new FileInputStream("res/input_JO_1733.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i=0; i<19; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<19; j++) {
				pan[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//바둑판입력받음

here:	for(int i=0; i<19; i++) {
			for(int j=0; j<19; j++) {
				if(pan[i][j]!=0) { //여기에 v체크를 안하는게 맞을듯?
					//System.out.println(pan[i][j]);
					v = new boolean[19][19];
					flag = false;
					if(dfs(i,j,0,0,0)) win = 0;
					if(win !=0) break here;
					flag = false;
					if(dfs(i,j,0,0,1)) win = 0;
					if(win !=0) break here;
					flag = false;
					if(dfs(i,j,0,0,5)) win = 0;
					if(win !=0) break here;
					flag = false;
					if(dfs(i,j,0,0,3)) win = 0;
					if(win !=0) break here;
				}
			}
		}
		
		//출력은 이긴 번호
		System.out.println(win);
		//가장 왼쪽. 세로면 가장 위 의 좌표+1
		findLeft(wi,wj,wd);
		if(win!=0) System.out.print((wii+1)+" "+(wjj+1));
	}
	
	private static void findLeft(int i, int j, int dir) {
		wii = i;
		wjj = j;
		
		ni = i+di[dir];
		nj = j+dj[dir];
		if(ni>=0 && nj>=0 && ni<19 && nj<19 && pan[ni][nj] == pan[i][j] ) {
			findLeft(ni,nj,dir);
		}
	}

	private static boolean dfs(int i, int j, int cnt1, int cnt2, int dir) { //다돌았는데 cnt가 5인 경우 이김
		v[i][j] = true; //돌려놓지 않는다.가 아닌듯
		//boolean flag = false;
		if(cnt1+cnt2 >4) { //6개처리 true 잘해줘야함
			win = 0;
			flag = true;
			return true;
		}
		if(!flag && cnt1+cnt2 ==4) {
			win = pan[i][j];
			wi = i;
			wj = j;
			if(dir ==2) wd = 5;
			else wd = dir;
		}
		
		//양방향 탐색
		ni = i+di[dir];
		nj = j+dj[dir];
		if(ni>=0 && nj>=0 && ni<19 && nj<19 && !v[ni][nj] && pan[ni][nj] == pan[i][j] ) {
			//flag = true;
			if(dfs(ni,nj,cnt1+1,cnt2,dir)) return true;
			//else return false;
		}
		ni = i+di[7-dir];
		nj = j+dj[7-dir];
		if(ni>=0 && nj>=0 && ni<19 && nj<19 && !v[ni][nj] && pan[ni][nj] == pan[i][j] ) {
			//flag = true;
			if(dfs(ni,nj,cnt1,cnt2+1,dir)) return true;
			//else return false;
		}
		//v[i][j] = false;
		return false;
	}

}
