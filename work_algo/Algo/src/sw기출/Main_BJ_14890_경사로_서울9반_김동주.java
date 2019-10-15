package sw기출;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_14890_경사로_서울9반_김동주 { //지나갈 수 있는 길의 개수
	public static int N,L,ans;
	public static int[][] map;
	public static boolean[][] low;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_BJ_14890.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer nl = new StringTokenizer(br.readLine());
		StringTokenizer st;
		N = Integer.parseInt(nl.nextToken());
		L = Integer.parseInt(nl.nextToken());
		map = new int[N][N];
		low = new boolean[N][N];
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			int m=0;
			//for(int m=0; m<N; m++) {
			while(st.hasMoreTokens()) {
				map[n][m++] = Integer.parseInt(st.nextToken());
			}
			//System.out.println(Arrays.toString(map[n]));
		}//입력다받음
		
		//2N개의 길을 체크한다.
here:	for(int n=0; n<N; n++) { //가로길 map[n][]
			int cnt=1;
			for(int m=0; m<N-1; m++) {
				if(Math.abs(map[n][m+1]-map[n][m+1]) > 1) { //차이가 1보다 큰곳이 있으면
					continue here; //이길은 넘어가기
				}else if(map[n][m]-1==map[n][m+1]) { //내려감
					low[n][m+1] = true;
					cnt++; //바닥의 길이
				}else if(map[n][m]+1==map[n][m+1]) { //올라감
					low[n][m] = true;
				}else {
					if(low[n][m]) {
						low[n][m] = true;
					}
				}
			}
			ans++;
		}
		for(int m=0; m<N; m++) { //세로길 map[][m]
			for(int n=0; n<N; n++) {
				
			}
		}
		
		System.out.println(ans);
	}

}
