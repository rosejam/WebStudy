package 문제풀이2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_17143_낚시왕_서울9반_김동주 {
	//상하우좌 1234
	public static final int[] di = {-1,1,0,0};
	public static final int[] dj = {0,0,1,-1};
	public static class Fish{
		public Fish(int i, int j, int speed, int dir, int size) {
			this.i = i; 
			this.j = j;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}
		int speed;
		int dir;
		int size; //크기는 모두 다름
		public int i; public int j;
	}
	public static int R,C,M,sum; //그냥 인덱스 늘력서 만들기
	public static Fish[][] pool;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_BJ_17143.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer rcm = new StringTokenizer(br.readLine());
		R = Integer.parseInt(rcm.nextToken());
		C = Integer.parseInt(rcm.nextToken());
		M = Integer.parseInt(rcm.nextToken());
		pool = new Fish[R][C];
		
		for(int m=0; m<M; m++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			pool[r-1][c-1] = new Fish(r-1,c-1,s,d-1,z);
		}
		//상어 다 넣음 없는 칸은 null일걸
		Queue<Fish> q = new LinkedList<>();
		for(int jj=0; jj<C; jj++) { //1.낚시꾼 위치는 i //1초간 일어나는 일
			
			for(int ii=0; ii<R; ii++) { //2.상어잡기
				if(pool[ii][jj] != null) { //물고기 발견
					sum += pool[ii][jj].size;
					pool[ii][jj] = null;
					break;
				}
			}
			//여기까지 완성
			
			//3.상어 이동 
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(pool[i][j] != null) q.offer(pool[i][j]); 
				}
			}//상어들을 일단 큐에 넣는다?
			//int num = q.size();
			
			pool = new Fish[R][C]; //풀비우기

			//speed, dir
			while(!q.isEmpty()) {
				Fish F = q.poll(); //하나씩 꺼내서 이동
				int speed = F.speed;
				int d = F.dir; //상하우좌 1234
//				//이동거리
//				int fdi = (speed * di[d]) % (R-1);
//				int fdj = (speed * dj[d]) % (C-1);
//				int fi = ((speed * di[d]) / (R-1)) %2; //몫이 홀수인지 짝수 인지
//				int fj = ((speed * dj[d]) / (C-1)) %2; //홀수이면 toggle
//				
//				if(fi ==0) {
//					
//				}else {
//					
//				}
				//pool[F.i][F.j] = null;
				
				switch(d) {
				case 1:
				case 2:
					for(int s=0; s<speed; s++) {
						if(F.i ==0) { F.i = 1; d = 2; }
						else if(F.i ==R-1) {F.i = R-2; d=1; }
						else F.i += di[d];
					}
					break;
				case 3:
				case 4:
					for(int s=0; s<speed; s++) {
						if(F.j ==0) { F.j = 1; d = 3; }
						else if(F.j ==C-1) {F.j = C-2; d= 4; }
						else F.j += dj[d];
					}
					break;
				}
				//int fi = speed * dj[d];
				//int fj = speed * dj[d];
				if(pool[F.i][F.j] == null) pool[F.i][F.j]=F;
				else if(pool[F.i][F.j].size < F.size) {
						pool[F.i][F.j] = F; //원래 있던애보다 큰애면넣기
						//같은 칸에오면 가장 큰애만 유지
				}
			} //q끝
		}
		System.out.print(sum);
	}
}
