package 문제풀이3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//N을 두팀으로 반반나누기 //NC(N/2)
public class Main_BJ_14889_스타트와링크_서울9반_김동주 { 
	public static int N, S[][], team0[], team1[], mindiff;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_BJ_14889.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new int[N][N];
		team0 = new int[N/2];
		team1 = new int[N/2];
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
		}
		//
		mindiff = Integer.MAX_VALUE;
		permcomb(0,0); //1.조합 //2.
		System.out.print(mindiff);
	}
	
	private static void permcomb(int start, int depth) {
		if(depth == N/2) {
			
			return;
		}
		
	}
}
