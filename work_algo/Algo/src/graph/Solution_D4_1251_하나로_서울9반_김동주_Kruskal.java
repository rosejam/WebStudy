package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

//Kruskal
public class Solution_D4_1251_하나로_서울9반_김동주_Kruskal {
	public static double Ans;
	public static int N;
	public static int[] Xs,Ys;
	public static double E;
	public static long[][] L2; //모든 거리의 제곱
	
	public static List<long[]> v;
	public static int[] p;
	public static int findSet(int x) { //getParent와 동일, p를 위에 선언했으므로 아규먼츠에서 삭제
		if(p[x]==x) return x;
		else return p[x]=(int)findSet(p[x]);
	}
	public static void union(int[] p, int a, int b) {
		a=findSet(a);
		b=findSet(b);
		if(a<b) p[b]=a;
		else 	p[a]=b; //이 대소비교는 상관X
	}
	
	public static double kruskal() {
		Collections.sort(v, new Comparator<long[]>() {
			@Override
			public int compare(long[] o1, long[] o2) {
				return Long.compare(o1[2], o2[2]); //가중치 기준 소팅
			}
		});
		//for(double[] e:v) System.out.println(Arrays.toString(e));

		//System.out.println();
		//Make-Set
		p = new int[N+1]; //+1
		for(int i=0; i<N+1; i++) p[i]=i; //+1
		
		//
		long sum=0;
		for(int i=0; i<v.size(); i++) {
			//if(!findParent(p, v.get(i).a -1, v.get(i).b -1)){
			if(findSet((int) v.get(i)[0])!=findSet((int) v.get(i)[1])) {
				//System.out.println("->"+Arrays.toString(v.get(i)));
				sum += v.get(i)[2];
				union(p, (int) v.get(i)[0], (int) v.get(i)[1]); //그래프가 사이클인지 확인할 수 있음
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
			//Ans=0;
			v = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) { //여기를 i부터로 해서 i<j일때만 구한다.(행렬의 위쪽 반)
					L2[i][j] = (long) (Math.pow(Xs[i]-Xs[j], 2) + Math.pow(Ys[i]-Ys[j], 2)); //i와 j의 거리제곱
					v.add(new long[] {i,j,L2[i][j]});
				}
			}
			////길이제곱 L2의 합이 최소가 되도록 모든 섬을 연결한다!
			Ans = kruskal() * E;			
			////
			//E를 곱한다.
			//Ans*=E;
			sb.append("#"+tc+" "+Math.round(Ans)+"\n");//모든 섬들을 잇는 최소 환경 부담금 //소수첫째에서 반올
		}
		System.out.println(sb);
	}
}
