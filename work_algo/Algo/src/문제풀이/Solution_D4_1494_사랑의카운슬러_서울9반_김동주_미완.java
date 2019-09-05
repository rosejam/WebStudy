package 문제풀이;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_D4_1494_사랑의카운슬러_서울9반_김동주_미완 {
	public static int TC, N, M;
	public static int[] half;
	public static long Ans, X, Y;
	public static ArrayList<Point> list;
	public static class Point{
		int x;  
		int y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void combination(int start, int flag, int count) {
		if(count == M){ //중복처리 부분은 비트연산으로 대신함
			//nCm 반뽑은 인덱스 배열 half 완성
			getSize(half);
			return;
		}
		for(int i=start; i<N; i++) { //조합은 1이 아닌 start부터 시작
			if((flag&(1<<i))==0) {
				half[count]=i;
				combination(i, flag|(1<<i), count+1); //i 추가
			}
		}
	}

	public static void getSize(int[] half) {
		//nCm이 만들어짐 half[]
		boolean[] visited = new boolean[N];
		for(int m=0; m<M; m++) {
			X -= list.get(half[m]).x;
			Y -= list.get(half[m]).y;
			visited[half[m]] = true;
		}
/*		for(int m=M-1; m>=0; m--) {
			list.remove(half[m]);
		}*/ //리스트에서 빼면 안됨!!! visited 배열 대신 쓰기!
		for(int m=0; m<N; m++) {
			if(!visited[m]) {
				X += list.get(m).x;
				Y += list.get(m).y;
			}
		}
		long Size = X*X+Y*Y;
		if(Size<Ans) Ans = Size;
	}

	public static void main(String[] args) throws Exception {
			//전체를 반으로 나눔 N_C_(N/2)가지, 한쪽은 x,y모두 -해서 더한다.
		
		System.setIn(new FileInputStream("res/input_D4_1494.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			N = Integer.parseInt(br.readLine());
			M = N/2;
			list = new ArrayList<>();
			for(int n=0; n<N; n++) {
				st = new StringTokenizer(br.readLine());
				list.add(new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
				//System.out.print(list.get(n).x+" ");
			}//point N개 모두 받음
			X=0; Y=0;
			half = new int[M];
			Ans = Long.MAX_VALUE;
			combination(0,0,0);
			//System.out.println(Ans);
			sb.append("#"+tc+" "+Ans+"\n");
		}
		System.out.println(sb);
	}

}
