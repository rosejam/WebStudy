package 문제풀이4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1과 같으나 N범위가 12에서 19로 늘어나서 "DP"로 해야함!!
//TSP문제
public class Main_정올_1545_해밀턴순환회로2_서울9반_김동주 {
	public static boolean[] v;
	public static int[] a;
	public static int N ,road[][], min, len;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim()); //장소 개수
		StringTokenizer st;
		//장소를 이동하는 비용 (단방향 가중 그래프) //출발지는 0 도착지도 0
		road = new int[N][N];
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m=0; m<N; m++) {
				road[n][m] = Integer.parseInt(st.nextToken());
				if(n != m && road[n][m] ==0) road[n][m] = 5000;
			}
			//System.out.println(Arrays.toString(road[n]));
		}
		//행 -> 열 인덱스로 가는 비용
		//입력
		min = Integer.MAX_VALUE;
		v= new boolean[N];
		a= new int[N];
		len = 0;
		permcomb(1); //(N-1)! 모든경우의 수 //1~N-1까지
		//출력
		System.out.print(min);
	}

	private static void permcomb(int depth) {
/*		if(depth == N) { //a[1]~a[N-1]까지 입력 완료
			int len = 0;
			for(int i=0; i<N-1; i++) {
				len += road[a[i]][a[i+1]];
			}
			len += road[a[N-1]][0];
			if(min > len) min = len;
			return;
		}*/
		if(depth == N) {
			len += road[a[N-1]][0];
			//min = (len<min)? len : min;
			if(min > len) min = len; //{min = len; System.out.println(Arrays.toString(a));}
			len -= road[a[N-1]][0]; //이게 필수 !!!! 말단에서 더해준것도 빼고 리턴해야함!!!!
			return;
		}
		if(len > min){ //백트래킹
			return;
		}
		
		for(int i=1; i<N; i++) {
			if(!v[i]) {
				v[i] = true;
				a[depth] = i;
				len += road[a[depth-1]][a[depth]];//
				permcomb(depth+1);
				len -= road[a[depth-1]][a[depth]];//
				v[i] = false;
			}
		}
	}

}
