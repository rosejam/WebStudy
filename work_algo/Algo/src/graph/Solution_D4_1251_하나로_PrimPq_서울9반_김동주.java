package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//Prim1
public class Solution_D4_1251_하나로_PrimPq_서울9반_김동주 {
	public static double Ans;
	public static int N;
	public static int[] Xs,Ys;
	public static double E;
	public static long[][] L2; //모든 거리의 제곱
	
	public static long INF=Long.MAX_VALUE/2; 
	//public static long[] w; //가중치 배열
	public static double prim() {
		PriorityQueue<long[]> pq = new PriorityQueue<>(new Comparator<long[]>() { //long이 아니고 Node 클래스 하나로 정보를 묶는다.
			@Override
			public int compare(long[] o1, long[] o2) {
				return Long.compare(o1[0], o2[0]);//[0]ㄴ
			}
		});
		boolean[] v = new boolean[N];
		v[0]=true;
		double sum=0;
		for(int next=0; next<N; next++) { //for(Node next=l[0]; next!=null; next=next.link){ pq.offer(next); 인접리스트 사용할 경우?
			pq.offer(new long[] {L2[0][next], next}); //[0]
		}
		
		while(!pq.isEmpty()) {
			long[] curra = pq.poll(); //[0]이 작은것부터 나올것~ pq
			long weight = curra[0];
			int curr = (int) curra[1];
			
			if(!v[curr]) { //방문하지 않았으면
				v[curr]=true; //방문처리하고 넣는다
				sum+=weight;
				//System.out.println("curr="+curr+" weight="+weight+" sum= "+sum);
				for(int next=0; next<N; next++) {
					pq.offer(new long[] {L2[curr][next], next});
				}
			}
		}
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
			//w = new long[N];
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
