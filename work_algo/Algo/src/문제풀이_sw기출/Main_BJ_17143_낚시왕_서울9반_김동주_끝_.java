package 문제풀이_sw기출;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_17143_낚시왕_서울9반_김동주_끝_ {
	//상하우좌 0123
	public static final int[] di = {-1,1,0,0};
	public static final int[] dj = {0,0,1,-1};
	public static class Fish{
		public Fish(int i, int j, int speed, int dir, int size) { //좌표,속도,방향,크기
			this.i = i; 
			this.j = j;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}
		int i; 
		int j;
		int speed;
		int dir;
		int size; //크기는 모두 다름
	}//상어 클래스
	
	public static int R,C,M,sum;
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
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken())-1; //0~3
			int z = Integer.parseInt(st.nextToken());
			pool[r][c] = new Fish(r,c,s,d,z);
		}
		//상어 다 넣음. 없는 칸은 null일걸
		
		sum =0;
		Queue<Fish> q = new LinkedList<>();
		for(int jj=0; jj<C; jj++) { //1.낚시꾼 위치는 -1,jj //1초간 일어나는 일
			
			for(int ii=0; ii<R; ii++) { //2.상어 0~1마리 잡기
				if(pool[ii][jj] != null) { //물고기 발견
					//System.out.println(pool[ii][jj].size);////
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
			}//상어들을 일단 모두 큐에 넣는다?
			//int num = q.size();
			
			pool = new Fish[R][C]; //풀비우기

			//speed, dir
			while(!q.isEmpty()) {
				Fish F = q.poll(); //하나씩 꺼내서 이동
/*				int speed = F.speed;
				int dir = F.dir; //상하우좌 0123
//				//이동거리
//				int fdi = (speed * di[d]) % (R-1);
//				int fdj = (speed * dj[d]) % (C-1);
				//int fi = ((speed * di[dir]) / (R-1)) %2; //몫이 홀수인지 짝수 인지
				//int fj = ((speed * dj[dir]) / (C-1)) %2; //홀수이면 toggle
				
				switch(F.dir) {
				case 0: //상 //R-2기준
					if(speed < R-2) {
						
					}else if((((speed-F.i-1) / (R-1)) & 1) ==0) { //짝수
						F.i 
					}else {
						F.dir = 1;
					}
					break;
				case 1: //하 /1기준
					if(F.i ==0) {
						
					}
					break;
				case 2: //우 //1기준
					if(((speed / (C-1)) & 1) ==0) { //짝수
						
					}else {
						F.dir = 3;
					}
					break;
				case 3: //좌 //C-2기준
					if(((speed / (C-1)) & 1) ==0) { //짝수
						
					}else {
						F.dir = 2;
					}
					break;
				}*/
//				if(fi ==0) {
//					
//				}else {
//					
//				}
				//pool[F.i][F.j] = null;
				
 				switch(F.dir) { //index를 0베이스로 바꾸면 다 바꿔주어야함. + 업데이트된 경우 클래스에 넣어야
				case 0:
				case 1:
					for(int s=0; s<F.speed; s++) {
						if(F.i ==0) { F.i = 1; F.dir = 1; }
						else if(F.i ==R-1) {F.i = R-2; F.dir = 0; }
						else F.i += di[F.dir];
					}
					break;
				case 2:
				case 3:
					for(int s=0; s<F.speed; s++) {
						if(F.j ==0) { F.j = 1; F.dir = 2; }
						else if(F.j ==C-1) {F.j = C-2; F.dir = 3; }
						else F.j += dj[F.dir];
					}
					break;
				}//상어 좌표 이동
				
				//int fi = speed * dj[d];
				//int fj = speed * dj[d];
				if(pool[F.i][F.j] == null) pool[F.i][F.j]=F;
				else if(pool[F.i][F.j].size < F.size) {
						pool[F.i][F.j] = F; //원래 있던애보다 큰애면넣기
						//같은 칸에오면 가장 큰애만 유지
				}//상어 실제 이동
				
			} //q끝(모든 상어 이동)
/*			//출력체크
  			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(pool[i][j]!=null)
						System.out.print(pool[i][j].size+" ");
					else System.out.print("0 ");
				}
				System.out.println();
			}
			System.out.println("*********************");*/
		}
		System.out.print(sum);
	}
}
