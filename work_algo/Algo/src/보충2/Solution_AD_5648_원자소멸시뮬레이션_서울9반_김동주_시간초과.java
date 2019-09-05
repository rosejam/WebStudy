package 보충2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
*/
class Solution_AD_5648_원자소멸시뮬레이션_서울9반_김동주_시간초과
{	
	public static class Particle{
		int x,y,dir,K;
		//int dir,K;
		int nx, ny;
		public Particle(int x, int y, int dir, int k) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			K = k;
		}
	}
	public static int Ans, T, N, x, y;
	//public static int[][] Q, plane;
	public static ArrayList<Particle> Ps;
	public static Particle[][] Plane;

	public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 sample_input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 sample_input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		*/
		System.setIn(new java.io.FileInputStream("res/input_AD_2.txt"));
		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		*/
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++)
		{
			N = Integer.parseInt(br.readLine()); //원자총개수N
			//Q = new int[N][4]; //한원자n의 모든 정보 4가지
			//Ps = new Particle[N];
			Ps = new ArrayList<>();
			//Plane = new Particle[2001][2001]; //원자가 움직이는 판
			for(int n=0; n<N; n++) {
				st = new StringTokenizer(br.readLine());
				Ps.add(new Particle(1000+Integer.parseInt(st.nextToken()), 1000-Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
/*				Ps[n].x=;//최초x위치 0~2000
				Ps[n].y=;//최초y위치 0~2000으로 2001가지
				Ps[n].dir=;//이동방향(상0하1좌2우3)로 4가지
				Ps[n].K=;//보유에너지K 1~100으로 100가지
*/				
				//Plane[Ps[n].x][Ps[n].y] = Ps[n]; //초기위치에 파티클을 위치시켰다. 방향과 에너지를 보유하고 있음
													//필요한 과정인지는..?
			}
			//두 개 이상의 원자!가 충돌 할 경우 충돌한 원자들은 모두 보유한 에너지를 방출하고 소멸!
			//2차원 평면 위에서 움직임, 최초위치는 중복X
			//주어진 좌표범위 밖에서 충돌못하게 됨. 따라서 2000회(=2000초)까지만 이동해보고 결론내기
			Ans=0;
			for(int i=1; i<=2000; i++) { 
				for(int n=0; n<Ps.size(); n++) {
					switch (Ps.get(n).dir) {
						case 0:
							Ps.get(n).ny = Ps.get(n).y-1;
							Ps.get(n).nx = Ps.get(n).x;
						break;
						case 1:
							Ps.get(n).ny = Ps.get(n).y+1;
							Ps.get(n).nx = Ps.get(n).x;
						break;
						case 2:
							Ps.get(n).nx = Ps.get(n).x-1;
							Ps.get(n).ny = Ps.get(n).y;
						break;
						case 3:
							Ps.get(n).nx = Ps.get(n).x+1;
							Ps.get(n).ny = Ps.get(n).y;
						break;
						default:
						break;
						}
					//}
				}//모든 파티클의 다음 이동 파악
				//충돌 확인(충돌은 서로 자리 바꾸거나 같은 곳에 도착했을때 발생)
				//N C 2에서
				for(int n=0; n<Ps.size(); n++) {
					for(int m=n+1; m<Ps.size(); m++) { //N중에서 n과 m뽑음
						if(Ps.get(n).ny == Ps.get(m).y && Ps.get(n).nx == Ps.get(m).x && Ps.get(n).y == Ps.get(m).ny &&Ps.get(n).x == Ps.get(m).nx ) {
							Ans += Ps.get(n).K;
							Ps.get(n).K=0;
							Ans += Ps.get(m).K;
							Ps.get(m).K=0;
/*							Ps[n].x = Integer.MIN_VALUE;
							Ps[n].y = Integer.MIN_VALUE;
							Ps[m].x = Integer.MIN_VALUE;
							Ps[m].y = Integer.MIN_VALUE; //우선 치워버리기
*/							//Ps.remove(m);
							//Ps.remove(n);
						}
					}
				}
				for(int n=0; n<Ps.size();) {
					if(Ps.get(n).K==0)  //충돌한 파티클들 다 치워버리기
						Ps.remove(n);
					else n++;
				}
				for(int n=0; n<Ps.size(); n++) {
					for(int m=n+1; m<Ps.size(); m++) { //N중에서 n과 m뽑음 같은곳에 도달했을 때
						if(Ps.get(n).ny == Ps.get(m).ny && Ps.get(n).nx == Ps.get(m).nx) {
							Ans += Ps.get(n).K;
							Ans += Ps.get(m).K;
							Ps.get(n).K=0;
							Ps.get(m).K=0;
//							Ps[n].x = Integer.MIN_VALUE;
//							Ps[n].y = Integer.MIN_VALUE;
//							Ps[m].x = Integer.MIN_VALUE;
//							Ps[m].y = Integer.MIN_VALUE; //우선 치워버리기
						}
					}
				}
				for(int n=0; n<Ps.size();) {
					if(Ps.get(n).K==0)  //충돌한 파티클들 다 치워버리기
						Ps.remove(n);
					else n++;
				}
				for(int n=0; n<Ps.size(); n++) {
					Ps.get(n).y = Ps.get(n).ny;
					Ps.get(n).x = Ps.get(n).nx;
				}
			}//1초간 벌어지는 일 반복
			
			// 표준출력(화면)으로 답안을 출력합니다.
			sb.append("#"+test_case+" "+Ans+"\n"); //소멸되면서 방출되는 에너지의 총합을 출력한다
		}
		System.out.println(sb);
		br.close(); // 사용이 끝난 스캐너 객체를 닫습니다.
	}
}
