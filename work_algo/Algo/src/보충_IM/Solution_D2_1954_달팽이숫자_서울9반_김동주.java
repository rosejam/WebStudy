package 보충_IM;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_1954_달팽이숫자_서울9반_김동주 {
	public static byte N;
	public static byte i;
	public static byte j;
	public static byte cnt;
	public static byte[][] X;
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_D2_1954.txt")); //제출할때는 입력 삭제!!!
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Byte.parseByte(br.readLine());
			X = new byte[N][N];
			X[0][0]=1;
			cnt=1;
			i=0;j=0;
			while((j+1<N && X[i][j+1] ==0)||(i+1<N && X[i+1][j] ==0)||(0<=j-1 && X[i][j-1] ==0)||(0<=i-1 && X[i-1][j] ==0)) { //주변에 0(not visited)이 있을 때
				while(j+1<N && X[i][j+1] ==0) { //우 //가 갈 수 있는 상태이면
					j++;
					cnt++;
					X[i][j]=cnt;
				}
				while(i+1<N && X[i+1][j] ==0) { //하 
					i++;
					cnt++;
					X[i][j]=cnt;
				}
				while(0<=j-1 && X[i][j-1] ==0) { //좌 
					j--;
					cnt++;
					X[i][j]=cnt;
				}
				while(0<=i-1 && X[i-1][j] ==0) { //상
					i--;
					cnt++;
					X[i][j]=cnt;
				}
			}
			System.out.println("#"+tc);
			//달팽이 출력하기
			for(int a=0; a<X.length; a++) {
				for(int b=0; b<X[a].length; b++) {
					System.out.print(X[a][b]+" ");
				}
				System.out.println();
			}
		}
	}
}