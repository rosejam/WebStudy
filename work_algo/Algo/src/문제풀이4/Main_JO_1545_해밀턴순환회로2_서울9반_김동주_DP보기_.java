package 문제풀이4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1과 같으나 N범위가 12에서 19로 늘어나서 "DP"로 해야함!!
//TSP문제!!
public class Main_JO_1545_해밀턴순환회로2_서울9반_김동주_DP보기_ { //복습하기
	public static int INF=987654321;
	public static int N;
	public static int[][] road;
	public static int[][] d;
	//
	public static int[][] m;//메모이제이션용!
	
	public static int solve(int pos, int visited, int start) {
		//
		if(m[pos][visited]!=0) return m[pos][visited];//
		if(visited==(1<<N)-1) ////return d[pos][start]; //
			return m[pos][visited]=d[pos][start];//
		
		int ret=INF;
		for(int next=0; next<N; next++) {
			if((visited&(1<<next))==0 && d[pos][next]!=0){
				int tmp=d[pos][next]+solve(next,visited|(1<<next),start);
				ret=Math.min(ret,tmp);
			}
		}
		//
		m[pos][visited]=ret;//
		//for(int[] a:m) System.out.println(Arrays.toString(a));
		//System.out.println();
		return ret;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim()); // 장소 개수
		StringTokenizer st;
		// 장소를 이동하는 비용 (단방향 가중 그래프) //출발지는 0 도착지도 0
		road = new int[N][N];
		d=new int[N][N];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < N; m++) {
				road[n][m] = Integer.parseInt(st.nextToken());
				if(n!=m & road[n][m]==0) road[n][m]=INF;
			}
			// System.out.println(Arrays.toString(road[n]));
		}
		// 행 -> 열 인덱스로 가는 비용
		// 입력
		
		int ans=INF;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				d[j]=road[j].clone();
			}
			//
		}
		m=new int[N][1<<N];// 2^N 길이의 메모이제이션 배열을 만든다.
		int tmp=solve(0,1<<0,0);//JO_1545용		//int tmp=solve(i,1<<i,i);
		ans=Math.min(ans,tmp);
		
		System.out.print(ans);
	}
}
