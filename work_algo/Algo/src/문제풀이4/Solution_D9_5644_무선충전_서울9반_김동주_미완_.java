package 문제풀이4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D9_5644_무선충전_서울9반_김동주_미완_ { //50개중 49개 맞음;
	static class Battery{
		public Battery(int y, int x, int c, int p) { //아 배터리 행렬 반대...(개빡;)
			this.x = x;
			this.y = y;
			C = c;
			P = p;
		}
		int x,y;
		int C;//충전범위C(bfs)
		int P;//성능P(짝수)
	}
	static class Person {
		int x,y;
		public Person(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static char[][] map;
	public static int[] A, B;
	public static boolean[][] v;
	public static boolean a, b;
	//public static boolean[] a, b;
	public static Battery[] bcs;
	public static Person[] ab;
	public static int TC, T, N, maxsum;
	public static ArrayList<int[]> alist, blist;
	public static final int[] di = {0,-1,0,1,0};
	public static final int[] dj = {0,0,1,0,-1}; //방향순서대로 해놈
	public static void main(String[] args) throws Exception {
		//충전기 : 좌표, 충전범위C(bfs), 성능P(짝수)
		//사용자A,B 각각의 이동좌표
		//한사용자에 2개의 충전기 -> 더P가 큰것 선택(사용자가 겹칠떄 반 또는 다른사용자가 안쓰는것 중에 큰것)
		//한충전기에 2명의 사용자 -> 반으로 나눔
		//충전 합의 최댓값
		System.setIn(new FileInputStream("res/input_SW_5644.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Comparator<int[]> comp = new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return -Integer.compare(o1[0], o2[0]); //앞에꺼로비교하는 컴패래터 작성 내림차순
			}
		};
		
		TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) { //테케1만 돌려보자*************
			map = new char[10][10];/////
			ab = new Person[2];
			ab[0] = new Person(0,0); //A
			ab[1] = new Person(9,9); //B
			
			st = new StringTokenizer(br.readLine());
			T = Integer.parseInt(st.nextToken()); //이동 시간
			N = Integer.parseInt(st.nextToken()); //충전기 개수
			bcs = new Battery[N];
			
			A = new int[T+1];
			st = new StringTokenizer(br.readLine());
			for(int t=1; t<=T; t++) {
				A[t] = Integer.parseInt(st.nextToken()); //0,0부터시작
			}
			B = new int[T+1];
			st = new StringTokenizer(br.readLine());
			for(int t=1; t<=T; t++) {
				B[t] = Integer.parseInt(st.nextToken()); //9,9부터 시작
			}
			//이동방향받음
			
			for(int n=0; n<N; n++) {
				st = new StringTokenizer(br.readLine());
				bcs[n] = new Battery(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				//System.out.println(bcs[n].x+" "+bcs[n].y);
			}
			//배터리들 정보 받음
			//입력
			
			maxsum = 0;
			for(int t=0; t<=T; t++) { //시간이 흐름
				map[ab[0].x][ab[0].y] = '\u0000';
				map[ab[1].x][ab[1].y] = '\u0000'; //원래있던자리는 널처리!!!
				ab[0].x += di[A[t]];
				ab[0].y += dj[A[t]];
				ab[1].x += di[B[t]];
				ab[1].y += dj[B[t]];
				map[ab[0].x][ab[0].y] = 'A';
				map[ab[1].x][ab[1].y] = 'B';
				//일단 ab이동해서 //map에 표시
/*				if(t==3) {
					System.out.println(t+"******");
					for(char[] x:map)System.out.println(Arrays.toString(x));
				}*/
				
				//a = new boolean[N];
				//b = new boolean[N];
				alist = new ArrayList<>();
				blist = new ArrayList<>();
				for(int n=0; n<N; n++) { //각각의 충전기에 대해 bfs해서 A,B를 찾음
					a = false; b = false;
					bfs(bcs[n].x, bcs[n].y, bcs[n].C);
					if(a) alist.add(new int[] {bcs[n].P, n});
					if(b) blist.add(new int[] {bcs[n].P, n});
				}
				
				//이제 A,B는 어떤 게 최대값인지 찾아 접속
/*				Collections.sort(alist, new Comparator<int[]>() {
					@Override
					public int compare(int[] o1, int[] o2) {
						return -Integer.compare(o1[0], o2[0]);
					}
				});
				Collections.sort(blist, new Comparator<int[]>() {
					@Override
					public int compare(int[] o1, int[] o2) {
						return -Integer.compare(o1[0], o2[0]);
					}
				}); //P기준 내림차순으로 각각 정렬!
*/				
				Collections.sort(alist, comp);
				Collections.sort(blist, comp);
				/*System.out.println(t+"******");
				Collections.sort(alist, comp);
				for(int[] x:alist) System.out.print(x[0]+" ");
				System.out.println();
				Collections.sort(blist, comp);
				for(int[] x:blist) System.out.print(x[0]+" ");
				System.out.println();*/
				//합에 더하기
				if(alist.size()!=0 && blist.size()!=0) { //두사람 다 접속가능한 경우
					
					if(alist.get(0)[1] == blist.get(0)[1]) { //max가 같은 곳에서 받을 경우!!!!
/*						if(alist.size()>1 && blist.size()>1) { //둘다 2개 이상
							if(alist.get(1)[0] > blist.get(1)[0]) { //두번째거 비교해서 크거나 같은 쪽 넣기
								maxsum += alist.get(1)[0];
								maxsum += blist.get(0)[0];
							}else {
								maxsum += alist.get(0)[0];
								maxsum += blist.get(1)[0];
							}
						}else {//둘다 2개이상이 아님
							if(alist.size()>1) {
								
							}
						}
					}else {
						maxsum += alist.get(0)[0];
						maxsum += blist.get(0)[0];
					}*/
						if(alist.size()==1 && blist.size()==1) {
							maxsum += alist.get(0)[0];
							//maxsum += blist.get(0)[0]/2;
						}else if(alist.size()>1 && blist.size() ==1) {
							maxsum += alist.get(1)[0] + blist.get(0)[0]; //따로 갖는 것
						}else if(blist.size()>1 && alist.size() ==1) {
							maxsum += blist.get(1)[0] + alist.get(0)[0]; //따로 갖는 것						
						}else { //둘다 2개 이상인 경우 !!
							//if()
							maxsum += Math.max(alist.get(1)[0] + blist.get(0)[0], blist.get(1)[0] + alist.get(0)[0]);
						}
/*						int xx = 1;
						while(alist.size()>xx && blist.size()>xx && alist.get(xx)[1] == blist.get(xx)[1]) { //맥스가 같은 n인경우
							int n = alist.get(0)[1];
							alist.remove(0);
							alist.add(new int[] {bcs[n].P/2, n});
							Collections.sort(alist, comp);
							blist.remove(0);
							alist.add(new int[] {bcs[n].P/2, n});
							Collections.sort(blist, comp);
							xx++;
						}*/
						
/*						if(alist.get(0)[1] == blist.get(0)[1] && alist.get(0)[1] == n) { //반으로 나눠도 최대
							maxsum += alist.get(0)[0];
							maxsum += blist.get(0)[0];
						}*/
						
					}else {
						maxsum += alist.get(0)[0];
						maxsum += blist.get(0)[0];
					}
					
				}else if(alist.size()!=0 && blist.size()==0) {
					maxsum += alist.get(0)[0];
				}else if(blist.size()!=0 && alist.size()==0) {
					maxsum += blist.get(0)[0];
				}
				
			}//시간 다흐름
			
			//출력
			sb.append('#').append(tc).append(' ').append(maxsum).append('\n');
		}
		System.out.print(sb);
	}
	private static void bfs(int x, int y, int c) { //이거 시간흐르기 전에 세팅해놓기
		v = new boolean[10][10];
		v[x][y] = true;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x,y,0});
		while(!q.isEmpty()) {
			int ci = q.peek()[0];
			int cj = q.peek()[1];
			int depth = q.poll()[2];
			if(map[ci][cj] == 'A') a = true;// a[n] = true;
			if(map[ci][cj] == 'B') b = true;// b[n] = true;
			
			if(depth == c) {
				//System.out.println("n:"+n+", x:"+ci+", y:"+cj);
				continue;
			}
			
			for(int d=1; d<5; d++) {
				int ni = ci + di[d];
				int nj = cj + dj[d];
				if(ni>=0 && nj>=0 && ni<10 && nj<10 && !v[ni][nj]) {
					v[ni][nj] = true;
					q.offer(new int[] {ni,nj,depth+1});
				}
			}
		}
	}

}
