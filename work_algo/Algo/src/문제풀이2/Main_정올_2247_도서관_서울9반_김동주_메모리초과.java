package 문제풀이2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_정올_2247_도서관_서울9반_김동주_메모리초과 { //int범위 long범위 알아둘 것
												//visited체크하면 메모리초과.. 알고리즘을 생각해야한다
	public static int N;
	public static long mx, mn;
	public static long[] X, Y;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_JO_2247.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		X = new long[N];
		Y = new long[N];
		
		mx = 0;
		mn = Long.MAX_VALUE;
		
		for(int n=0; n<N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			X[n] = Long.parseLong(st.nextToken());
			Y[n] = Long.parseLong(st.nextToken());
			if(mn > X[n]) mn = X[n];
			if(mx < Y[n]) mx = Y[n];
		}
		
		System.out.println(max+" "+blank);
	}
	
	
/*	public static int N;
	public static long diff, mx, mn;
	//public static boolean[] V;
	public static HashSet<Long> VV;
	//public static long[] X, Y;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_JO_2247.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		//X = new long[N];
		//Y = new long[N];
		
		mx = 0;
		mn = Long.MAX_VALUE;
		VV = new HashSet<>();
		
		for(int n=0; n<N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long X = Long.parseLong(st.nextToken());
			long Y = Long.parseLong(st.nextToken());
			diff = Y-X;
			//if(max < diff) max = diff;
			for(int i=0; i<diff; i++) {
				V[X+i] = true;
			}
			diff = Y-X;
			//if(max < diff) max = diff;
			for(long i=0; i<diff; i++) { //for문도 long으로 돌려주어야 함!
				VV.add(X+i); //X~Y-1까지 체크
			}
			//범위 구하기
			if(mn > X) mn = X;
			if(mx < Y) mx = Y;
		}
		
		for(int n=0; n<N; n++) {

		}
		
		long max = 0; 
		long cnt1 =0;
		long v1=mn;
		while(v1<mx) {
			//if(!V[v1]) {
			if(!VV.contains(v1)) {
				if(max < cnt1) max = cnt1;
				cnt1 = 0;
				v1++;
				continue;
			}
			cnt1++;
			v1++;
		}
		if(max < cnt1) max = cnt1;
		
		long blank=0;//학생들이 다녀간 전체 시간 중 가장 긴시간 .. 24시간 중 아님
		long cnt =0;
		long v=mn;
		while(v<mx) {
			//if(V[v]) {
			if(VV.contains(v)) {
				if(blank < cnt) blank = cnt;
				cnt = 0;
				v++;
				continue;
			}
			cnt++;
			v++;
		}
		if(blank < cnt) blank = cnt;
		
		System.out.println(max+" "+blank);
	}*/
}
