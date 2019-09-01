package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//Prim
public class Solution_D4_1251_하나로_서울9반_김동주_Prim {
	public static double Ans;
	public static int N;
	public static int[] Xs,Ys;
	public static double E;
	public static long[][] L2; //모든 거리의 제곱
	
	public static long INF=Long.MAX_VALUE/2; 
	public static long[] w; //가중치 배열
	public static double prim() {
		//for(int i=0; i<N; i++) w[i]=-1;
		Arrays.fill(w, -1); //위와 같은 코드이다~
		w[0]=0;
		for(int k=1; k<N; k++) {
			long minWeight=INF;
			int minVertax=0;
			for(int i=0; i<N; i++) {
				if(w[i]<0) continue;
				for(int j=0; j<N; j++) {
					if(w[j]>=0) continue; //방문처리 했다면
					if(minWeight>L2[i][j]) {
						minWeight=L2[i][j];
						minVertax=j;
					}
				}
			}
			w[minVertax]=minWeight;
			//System.out.println(Arrays.toString(w));
		}
		
		double sum=0;
		for(int i=1; i<N; i++) sum+=w[i];
		return sum;
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input_D4_1251.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int TC= Integer.parseInt(br.readLine());
		for(int tc=1;tc<=TC;tc++) {
			N = Integer.parseInt(br.readLine());
			Xs = new int[N];
			Ys = new int[N];
			L2 = new long[N][N];
			st = new StringTokenizer(br.readLine());
			int x=0;
			while(st.hasMoreTokens()) {
				Xs[x++] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			int y=0;
			while(st.hasMoreTokens()) {
				Ys[y++] = Integer.parseInt(st.nextToken());
			}
			E = Double.parseDouble(br.readLine());
			//모든 정보를 읽어왔다
			//우선 길이제곱 L2를 모두 구한다.
			w = new long[N];
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) { //여기를 i부터로 해서 i<j일때만 구한다.(행렬의 위쪽 반) //취소
					L2[i][j] = (long) (Math.pow(Xs[i]-Xs[j], 2) + Math.pow(Ys[i]-Ys[j], 2)); //i와 j의 거리제곱
					L2[j][i] = L2[i][j];
				}
			}
			//Ans=0;
			////길이제곱 L2의 합이 최소가 되도록 모든 섬을 연결한다!
			Ans = prim() * E;	
			
			////
			//E를 곱한다.
			//Ans*=E;
			sb.append("#"+tc+" "+Math.round(Ans)+"\n");//모든 섬들을 잇는 최소 환경 부담금 //소수첫째에서 반올
		}
		System.out.println(sb);
	}
}
