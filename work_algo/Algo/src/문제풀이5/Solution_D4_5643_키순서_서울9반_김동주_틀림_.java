package 문제풀이5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//N명 학생 키 소팅
//자신보다 확실히 크거나 작은 학생수 == 나머지 학생수면 자신의 번호 암.
//자신의 번호 아는 학생 수 출력
//저번에 시험친 구슬 비교 문제랑 유사한듯?
//circular없는 유향그래프!!!
//플로이드 워셜도 되지만 dfs로 해봄
public class Solution_D4_5643_키순서_서울9반_김동주_틀림_ { //맞는거같은데 왜틀리지?
	public static int T,nums,N,M,a[],b[],cnt1,cnt2,stud[][];
	public static boolean v[][];
	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input_D4_5643.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		T = Integer.parseInt(br.readLine().trim());
		
		for(int tc=1;tc<=T;tc++) {
			nums = 0;
			N = Integer.parseInt(br.readLine().trim());
			if(N==1) { //1명이면 볼것도 없으므로 추가해 주기
				sb.append('#').append(tc).append(' ').append(1).append('\n');
				continue;
			}
			stud = new int[N][2]; //0은 가벼운 사람수, 1은 무거운 사람수
			for(int n=0;n<N;n++) {
				stud[n][0] = -1;
				stud[n][1] = -1;
			}
			M = Integer.parseInt(br.readLine().trim());
			a = new int[M];
			b = new int[M];
			//v = new int[N][2];
			for(int m=0; m<M; m++) {
				st = new StringTokenizer(br.readLine());
				//a<b 연결상태 저장
				a[m] = Integer.parseInt(st.nextToken())-1;
				b[m] = Integer.parseInt(st.nextToken())-1;
				//graph[N][N]에 큰쪽 작은쪽 비교해서 넣어도 된다.
			}
//			System.out.println(Arrays.toString(a));
//			System.out.println(Arrays.toString(b));
			//입력끝
			v = new boolean[N][2];
			for(int n=0; n<N; n++) {
				//v = new boolean[N][2];
				//v = new boolean[N];
				cnt1 = findlighter(n);
				//v = new boolean[N];
				cnt2 = findheavier(n);
				if(cnt1+cnt2 == N-1) nums++;
//				System.out.println(n+"**");
//				System.out.println(cnt1);
//				System.out.println(cnt2);
			}
			//출력시작
			sb.append('#').append(tc).append(' ').append(nums).append('\n');
		}
		System.out.print(sb);
	}
	private static int findlighter(int n) { //학생n, 그냥 번호m
		if(stud[n][0] != -1) {
			//v[n][0]--;
//			System.out.println(n+"Lchecked");
			//v[n][0] = true;
			return stud[n][0];
		}
/*		if(stud[n][0] == 0) {
			return 0;
		}*/
		//v[n][0] = true;
//		System.out.println(n+"L");
		int cnt = 0;
		for(int m=0; m<M; m++) {
			if(b[m] == n && !v[a[m]][0]) {
				//여기서 비짓처리!!!!
				v[a[m]][0] = true;
//				System.out.println(a[m]);
				cnt += findlighter(a[m])+1; //찾은 경우
			}
		}
//		System.out.println(n+"LR");
		return stud[n][0] = cnt;
		//return cnt;
	}
	private static int findheavier(int n) {
		if(stud[n][1] != -1) {
			//v[n][1]--;
//			System.out.println(n+"Hchecked");
			//v[n][1] = true;
			return stud[n][1];
		}
/*		if(stud[n][1] == 0) {
			return 0;
		}*/
		//v[n][1] = true;
//		System.out.println(n+"H");
		int cnt = 0;
		for(int m=0; m<M; m++) {
			if(a[m] == n && !v[b[m]][1]) {
				//여기서 비짓처리!!!!
				v[b[m]][1] = true;
//				System.out.println(b[m]);
				cnt += findheavier(b[m])+1; //찾은 경우
			}
		}
//		System.out.println(n+"HR");
		return stud[n][1] = cnt;
		//return cnt;
	}
}
