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

public class Solution_D9_5644_무선충전_서울9반_김동주 { //구현
	static class Battery{
		public Battery(int x, int y, int c, int p) {
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
	public static boolean[] a, b;
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
		
		TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
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
			}
			//배터리들 정보 받음
			//입력
			
			maxsum = 0;
			for(int t=0; t<=T; t++) { //시간이 흐름
				ab[0].x += di[A[t]];
				ab[0].y += dj[A[t]];
				ab[1].x += di[B[t]];
				ab[1].y += dj[B[t]];
				//일단 ab이동해서
				map[ab[0].x][ab[0].y] = 'A';
				map[ab[1].x][ab[1].y] = 'B';
				//map에 표시
				
				//AP = new int[N]; //a에게 p의 영향
				//BP = new int[N];
				a = new boolean[N];
				b = new boolean[N];
				for(int n=0; n<N; n++) { //각각의 충전기에 대해 bfs해서 A,B를 찾음
					bfs(bcs[n].x, bcs[n].y, bcs[n].C, n);
				}
				
				alist = new ArrayList<>();
				blist = new ArrayList<>();
				//이제 A,B는 어떤 게 최대값인지 찾아 접속
				for(int n=0; n<N; n++) { //이거 위에 포문에 들어갈 수 있음!!!!
					if(a[n]) alist.add(new int[] {bcs[n].P, n});
					if(b[n]) blist.add(new int[] {bcs[n].P, n});
				}
				Collections.sort(alist, new Comparator<int[]>() {
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
				
				if(alist.size()!=0 && blist.size()!=0) {
					//합에 더하기
					if(alist.get(0)[1] == blist.get(0)[1]) { //max가 같은 곳에서 받을 경우
						if(alist.get(1)[0] > blist.get(1)[0]) { //두번째거 비교해서 크거나 같은 쪽 넣기
							maxsum += alist.get(1)[0];
							maxsum += blist.get(0)[0];
						}else {
							maxsum += alist.get(0)[0];
							maxsum += blist.get(1)[0];
						}
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
	private static void bfs(int x, int y, int c, int n) {
		v = new boolean[10][10];
		v[x][y] = true;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x,y,0});
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int ci = curr[0];
			int cj = curr[1];
			int depth = curr[2];
			if(map[ci][cj] == 'A') a[n] = true;
			if(map[ci][cj] == 'B') b[n] = true;
			if(depth == c) return;
			
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
