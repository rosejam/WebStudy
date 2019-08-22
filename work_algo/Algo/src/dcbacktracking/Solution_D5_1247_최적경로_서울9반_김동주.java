package dcbacktracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//회사 > n명 고객 모두 > 집 최단거리
public class Solution_D5_1247_최적경로_서울9반_김동주 {
	//public static byte A, B;
	public static byte N;
	public static byte[] nx;
	public static byte[] ny;
	public static byte[] d;
	public static int[][] len;
	public static int ans;
	public static int min;
	
	public static void permutation(int flag, int count) { 
		if(count == N){ 
			//N!중 한가지의 순열이 d[N]에생성됨
			///////////////////////////////////////////////
			ans = 0;
			ans += len[d[0]][N]; //처음회사에서 출발
			for(byte j=0; j<N-1; j++) {
				ans += len[d[j]][d[j+1]];
			}
			ans += len[d[N-1]][N+1]; //마지막에 집에 도착
			///////////////////////////////////////////////
			if(min > ans) min = ans;
			return;
		}
		for(byte i=0; i<N; i++) {
			if((flag&(1<<i))==0) {
				d[count]=i;
				permutation(flag|(1<<i),count+1); 
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_D5_1247.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		br.readLine(); //항상 10
		for(int tc=1; tc<=10; tc++) {
			N = Byte.parseByte(br.readLine());
			//N=(byte)3;
			nx = new byte[N+2];
			ny = new byte[N+2];
			d = new byte[N];
			len = new int[N+2][N+2];
			//permutation(0,0);
			StringTokenizer st = new StringTokenizer(br.readLine());
			nx[N] = Byte.parseByte(st.nextToken());
			ny[N] = Byte.parseByte(st.nextToken()); //회사 N
			nx[N+1] = Byte.parseByte(st.nextToken());
			ny[N+1] = Byte.parseByte(st.nextToken()); //집 N+1
			for(int n=0; n<N; n++) { //N명의 고객 0~N-1
				nx[n] = Byte.parseByte(st.nextToken());
				ny[n] = Byte.parseByte(st.nextToken());
			}//입력 다받음
			
			//모든 점 사이 이은 거리 구하기 (N+2)C2 말고 그냥 (N+2)*(N+2) - 메모이제이션
			for (int i = 0; i < N+2; i++) {
				for (int j = 0; j < N+2; j++) {
					//if(i<j)
					len[i][j] = Math.abs(nx[i]-nx[j]) + Math.abs(ny[i]-ny[j]); //i와 j의 거리
				}
			}
			//N+2개의 점을 순서대로 이어서 N+1개의 길이를 얻는다. (조건 N -> n명 고객 모두 -> N+1)
			//(N)P(N) = N! (회사부터 집까지 경우의 수 전부 d[]배열에 넣음) 각각에서 ans를 구하고 최소를 출력하면 된다.
			min = Integer.MAX_VALUE;
			permutation(0,0);
			
			sb.append("#"+tc+" "+min+"\n"); //최단 경로의 이동거리 min
		}
		System.out.print(sb);
		br.close();
	}
}
