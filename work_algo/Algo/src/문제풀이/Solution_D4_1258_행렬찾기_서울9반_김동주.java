package 문제풀이;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_D4_1258_행렬찾기_서울9반_김동주 {
	public static int TC, num, N;
	public static int[][] rc;
	public static ArrayList<int[]> rcset;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_D4_1258.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			N = Integer.parseInt(br.readLine());
			rc = new int[N][N];
			for(int n=0; n<N; n++) {
				st = new StringTokenizer(br.readLine());
				for(int m=0; m<N; m++) {
					rc[n][m] = Integer.parseInt(st.nextToken()); //0또는 1~9
				}
				//System.out.println(Arrays.toString(rc[n]));
			}//입력 다받음
			//사각행렬들의 개수와 크기를 찾기!!
			rcset = new ArrayList<>();
			num=0;
			for(int n=0;n<N;n++) {
				for(int m=0;m<N;m++) {
					if(rc[n][m]!=0) {
						//rcset.add(findrc(n,m));
						findrc(n,m);
						//또는 이 내부에서 findrc한 후
						//rcset.add(new int[] { , , });
						num++;
					}
				}
			} //모두 체크하였다.
			Collections.sort(rcset, new Comparator<int[]>(){
				@Override
				public int compare(int[] o1, int[] o2) {
					int rr = Integer.compare(o1[2], o2[2]);
					if(rr==0) return Integer.compare(o1[0], o2[0]);
					return rr;
				}
			}); //크기우선->행우선으로 소팅됨
			
			sb.append("#"+tc+" "+num);
			for(int c=0; c<num; c++) {
				sb.append(" "+rcset.get(c)[0]+" "+rcset.get(c)[1]);
			}
			sb.append("\n"); //부분행렬개수, 행/렬
														//행*열 작은 것부터 순서대로(같으면 행이 작은 것 먼저)
		}
		System.out.println(sb);
	}
	public static void findrc(int n, int m) { //
		int rc2[] = new int[3];
		int nn = n;
		int mm = m;
		while(nn<N && rc[nn][mm]!=0) {
			nn++;
			rc2[0]++;
		}
		nn--;
		while(mm<N && rc[nn][mm]!=0) {
			mm++;
			rc2[1]++;
		}
		rc2[2] = rc2[0]*rc2[1];
		setzero(n,m,rc2);
		//return rc2;
		rcset.add(rc2);
	}
	public static void setzero(int n, int m, int[] rc2) {
		for(int i=n; i<n+rc2[0]; i++) {
			for(int j=m; j<m+rc2[1]; j++) {
				rc[i][j] = 0;
			}
		}
	}
}
