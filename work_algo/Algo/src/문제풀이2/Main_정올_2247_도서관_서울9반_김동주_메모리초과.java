package 문제풀이2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_정올_2247_도서관_서울9반_김동주_메모리초과 { //int범위 long범위 알아둘 것
												//visited체크하면 메모리초과.. 알고리즘을 생각해야한다
	public static int N;
	public static int diff, mx, mn;
	public static boolean[] V;
	public static int[] X, Y;
	public static HashSet<Integer> VV;
	//public static int[] X, Y;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_JO_2247.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		for(int n=0; n<N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			X[n] = Integer.parseInt(st.nextToken());//-1
			Y[n] = Integer.parseInt(st.nextToken());//-1
			
			diff = Y-X;
			//if(max < diff) max = diff;
			for(int i=0; i<diff; i++) {
				V[X+i-1] = true;
			}			//범위 구하기
			if(mn > X) mn = X;
			if(mx < Y) mx = Y;
		}
		
	}
	
/*	public static int N;
	public static int mx, mn;
	//public static boolean[] V;
	public static HashSet<Integer> VV;
	//public static int[] X, Y;
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_JO_2247.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		//X = new int[N];
		//Y = new int[N];
		
		//V = new boolean[2147483647]; //2^31 - 1
		mx = 0;
		mn = Integer.MAX_VALUE;
		VV = new HashSet<>();
		
		for(int n=0; n<N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken())-1;//-1
			int Y = Integer.parseInt(st.nextToken())-1;//-1
			
//			diff = Y-X;
//			//if(max < diff) max = diff;
//			for(int i=0; i<diff; i++) {
//				V[X+i] = true;
//			}
			
			int diff = Y-X;
			//if(max < diff) max = diff;
			for(int i=0; i<diff; i++) { //for문도 long으로 돌려주어야 함!
				VV.add(X+i); //X~Y-1까지 체크
			}
			//범위 구하기
			if(mn > X) mn = X;
			if(mx < Y) mx = Y;
		}
		
//		int max = 0; 
//		int cnt1 =0;
//		int v1=mn-1;
//		while(v1<mx-1) {
//			//if(!V[v1]) {
//			if(!VV.contains(v1)) {
//				if(max < cnt1) max = cnt1;
//				cnt1 = 0;
//				v1++;
//				continue;
//			}
//			cnt1++;
//			v1++;
//		}
//		if(max < cnt1) max = cnt1;
//		
//		int blank=0;//학생들이 다녀간 전체 시간 중 가장 긴시간 .. 24시간 중 아님
//		int cnt =0;
//		int v=mn-1;
//		while(v<mx-1) {
//			//if(V[v]) {
//			if(VV.contains(v)) {
//				if(blank < cnt) blank = cnt;
//				cnt = 0;
//				v++;
//				continue;
//			}
//			cnt++;
//			v++;
//		}
//		if(blank < cnt) blank = cnt;
		
		int max = 0; 
		int blank=0;//학생들이 다녀간 전체 시간 중 가장 긴시간 .. 24시간 중 아님
		int v=mn;
		int cnt =0;
		int cnt1 =0;
		while(v<mx) {
			if(!VV.contains(v)) {
				if(max < cnt1) max = cnt1;
				cnt1 = 0;
				cnt++;
				v++;
			}else{
				if(blank < cnt) blank = cnt;
				cnt = 0;
				cnt1++;
				v++;
			}
		}
		if(max < cnt1) max = cnt1;
		if(blank < cnt) blank = cnt;
		
		System.out.println(max+" "+blank);
	}*/
}
