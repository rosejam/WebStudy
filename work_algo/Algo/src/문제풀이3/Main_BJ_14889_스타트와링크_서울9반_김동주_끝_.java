package 문제풀이3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//N을 두팀으로 반반나누기 //NC(N/2)
public class Main_BJ_14889_스타트와링크_서울9반_김동주_끝_ { 
	public static int N, S[][], team0[], mindiff; //team1[], a[], mindiff;
	public static boolean[] v;
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_BJ_14889.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new int[N][N];
		StringTokenizer st;
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m=0; m<N; m++) {
				if(n>m) { //왼쪽아래로 접어서 받음
					S[n][m] += Integer.parseInt(st.nextToken());
				}else {
					S[m][n] += Integer.parseInt(st.nextToken());
				}
			}
			//System.out.println(Arrays.toString(S[n]));
		}
		//
		mindiff = Integer.MAX_VALUE;
		v = new boolean[N];
		//a = new int[N/2];
		team0 = new int[N/2];
		//team1 = new int[N/2];
		//1.반반 조합 //2.같은팀의 역량을 합하기!
		permcomb(0,0);
		System.out.print(mindiff);
	}
	
	//예시답안 dfs로 permcomb
	private static void permcomb(int index, int cnt) {
		if(mindiff ==0) return; //이 백트래킹을 해줘야 답인 0을 찾은후에 돌지 않는다.
		if(cnt == N/2) {
			//boolean t1 = false;
			//boolean t2 = false;
			int sum0 = 0;
			int sum1 = 0;
			for(int n=0; n<N; n++) {
				//t1 = useArraysBinarySearch(team0,n); //n in team0
				for(int m=0; m<n; m++) {
					//t2 = useArraysBinarySearch(team0,m); //m in team0
					if(v[n] && v[m]) {
						sum0 += S[n][m];
					}else if(!v[n] && !v[m]) {
						sum1 += S[n][m];
					}
				}
			}
			if(Math.abs(sum0-sum1) < mindiff) mindiff = Math.abs(sum0-sum1);
			return;
		}
		
		//v[0~N-1]이 true반 false반이 되도록 조합 작성!!!!
		//끝까지 간 경우 리턴! 돌아가기 //끝까지 가기전에 true가 반인 경우!! 계산 실행
		if(index == N) return;
		v[index] = false;
		permcomb(index+1, cnt);
		v[index] = true;
		permcomb(index+1, cnt+1);
	}
	
/*	private static void permcomb(int start, int depth) {
		if(mindiff ==0) return; //이 백트래킹을 해줘야 답인 0을 찾은후에 돌지 않는다.
		if(depth == N/2) {
			boolean t1 = false;
			boolean t2 = false;
			int sum0 = 0;
			int sum1 = 0;
			for(int n=0; n<N; n++) {
				t1 = useArraysBinarySearch(team0,n); //n in team0
				for(int m=0; m<n; m++) {
					t2 = useArraysBinarySearch(team0,m); //m in team0
					if(t1 && t2) {
						sum0 += S[n][m];
					}else if(!t1 && !t2) {
						sum1 += S[n][m];
					}
				}
			}
			if(Math.abs(sum0-sum1) < mindiff) mindiff = Math.abs(sum0-sum1);
			return;
		}
		
		for(int i=start; i<N; i++) { //조합
			if(!v[i]) {
				v[i] = true;
				team0[depth] = i; //team0는 정렬된 상태이므로 바이너리 서치 가능
				permcomb(i,depth+1);
				v[i] = false;
			}
		}
	}
	
	public static boolean useArraysBinarySearch(int[] arr, int targetValue) { 
	    int a =  Arrays.binarySearch(arr, targetValue);
	    if(a >= 0 && a < arr.length) return true;
	    else return false;
	}*/
}
