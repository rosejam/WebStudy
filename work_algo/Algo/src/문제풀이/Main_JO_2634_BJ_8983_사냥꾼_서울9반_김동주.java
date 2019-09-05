package 문제풀이;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JO_2634_BJ_8983_사냥꾼_서울9반_김동주 {

	public static void main(String[] args) throws Exception {
		//System.setIn(new java.io.FileInputStream("res/input_JO_2634.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int M = Integer.parseInt(st.nextToken()); //사대수
		int N = Integer.parseInt(st.nextToken()); //동물수
		int L = Integer.parseInt(st.nextToken()); //총의 사정 거리
		
		int[] X = new int[M]; //사대 x좌표
		st = new StringTokenizer(br.readLine()," ");
		//for(int m=0; m<M; m++) {
		int mm=0;
		while(st.hasMoreTokens()) {
			X[mm++] = Integer.parseInt(st.nextToken());
		}//사대 위치 x좌표다받음
		
		//int[][] Ani = new int[N][2]; //동물n의  x,y좌표, 죽인 여부
		//boolean[] kill = new boolean[N];
		//ArrayList<int[]> Ani = new ArrayList<>(); //시간초과 났으므로 모든 동물을 kill체크 하지 않고 죽으면 없애기 위해
													//ArrayList터져서 RTE
		int x=0;
		int y=0;
		int Ans=0;
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine()," ");
/*			Ani[n][0] = Integer.parseInt(xys.nextToken());
			Ani[n][1] = Integer.parseInt(xys.nextToken());*/
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			/*x = Integer.parseInt(xys.nextToken());
			y = Integer.parseInt(xys.nextToken());
			if(y<=L) { //가능성 있는 동물만 넣기
				Ani.add(new int[]{x,y});
			}*/
			//if(Ani[n][1] > L) Ani[n][2] = 1; //죽어있음
			if(y > L) continue;
			for(int m=0; m<M; m++) {
				//if(Math.abs(x-X[m]) > L) continue;
				if(Math.abs(x-X[m])+y <= L) {
					Ans++;
					//Ani[n][2]=1;
					break; //죽었으니 더 볼 필요 없이 다음 동물!!
				}
			} //사대에 걸려서 죽는지
		}//동물 위치 다받음 
		
		System.out.println(Ans); //잡을 수 있는 동물의 수!!
	}
}
