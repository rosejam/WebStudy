package 보충2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_17144_미세먼지안녕_서울9반_김동주 { //배열 돌리는부분 숏코딩 확인
	public static int R,C,T,Ans,gongi,ni,nj; //gongi는 공기청정기 아래단 행
	public static int[][] A;
	public static int[] di= {-1,1,0,0};
	public static int[] dj= {0,0,-1,1}; //상하좌우
	public static Queue<munji> mq;
	public static class munji{
		int x;
		int y;
		int m;
		public munji(int x, int y, int m) {
			this.x = x;
			this.y = y;
			this.m = m;
		}
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_BJ_17144.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		A = new int[R][C];
		for(int r=0; r<R; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<C; c++) {
				A[r][c] = Integer.parseInt(st.nextToken());
				if(A[r][c] == -1) gongi = r;
			}
		}//입력 다받음 -1세로로 2개는 공기청정기 //나머지는 미세먼지 양
		
		mq = new LinkedList<>();
		for(int t=0; t<T; t++) {
			for(int r=0; r<R; r++) {
				for(int c=0; c<C; c++) {
					if(A[r][c]>0) {
						mq.offer(new munji(r,c,A[r][c])); //일단 다 넣기
					}
				}
			}
			//1.먼저 확산(판에 있는 모든 먼지)
			while(!mq.isEmpty()) {
				munji mm = mq.poll();
				for(int d=0; d<4; d++) {
					ni = mm.x + di[d];
					nj = mm.y + dj[d];
					if(0<=ni && 0<=nj && ni<R && nj<C && A[ni][nj]!=-1) {
/*						if (mm.m/5 >0) {
							mq.offer(new munji(ni,nj,mm.m/5));
							A[mm.x][mm.y] -= mm.m/5;
						}*/
						//퍼짐
						A[ni][nj] += mm.m/5;
						A[mm.x][mm.y] -= mm.m/5; 
					}
				}
			} //여기까지 잘됨
			//2.공기청정기순환
			//A[gongi][0] = A[gongi+1][0]; //하우상좌
			for(int i=gongi+2; i<R; i++) { //하
				A[i-1][0] = A[i][0];
			}
			for(int i=1; i<C; i++) { //우
				A[R-1][i-1] = A[R-1][i];
			}
			for(int i=R-2; i>=gongi; i--) { //상
				A[i+1][C-1] = A[i][C-1];
			}
			for(int i=C-1; i>=2; i--) { //좌
				A[gongi][i] = A[gongi][i-1];
			}
			A[gongi][1] = 0;
			//위에꺼 //상우하좌
			for(int i=gongi-3; i>=0; i--) { //상
				A[i+1][0] = A[i][0];
			}
			for(int i=1; i<C; i++) { //우
				A[0][i-1] = A[0][i];
			}
			for(int i=1; i<=gongi-1; i++) { //하
				A[i-1][C-1] = A[i][C-1];
			}
			for(int i=C-1; i>=2; i--) {  //좌
				A[gongi-1][i] = A[gongi-1][i-1];
			}
			//System.out.println(gongi);
			A[gongi-1][1] = 0;
/*			for(int i=0;i<R;i++) {
				System.out.println(Arrays.toString(A[i]));
			} */
		}
		
		//남은거 세기
		Ans=2;//공기청정기
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				//if(A[r][c]>0) Ans+=A[r][c];
				Ans += A[r][c];
			}
		}
		System.out.println(Ans);//T초후 남아있는 미세먼지의 양
	}
}
