package 보충;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class My_기지국 {
	//static int [] dx = {-1,0,1,0};
	//static int [] dy = {0,1,0,-1}; //상우하좌
	static int n;
	static char[][] X;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_기지국.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			//입력받기
			n = Integer.parseInt(br.readLine());
			X = new char[n][n];
			for(int i=0; i<X.length; i++) {
				//st = new StringTokenizer(br.readLine()); //이건 띄어쓰기 구분자일때만!!!!
				X[i] = br.readLine().toCharArray();
				//for(int j=0; j<X[i].length; j++) {
					//X[i][j] = st.nextToken();
				//}
			}
			for(int m=0; m<X.length;m++) { //잘 되었는지 Arrays.toString(1차배열)로 출력하면 된다.
				System.out.println(Arrays.toString(X[m]));
			}
			System.out.println();
			
			//2차원 맵을 전체 순회하면서 기지국을 찾기
			//	A,B,C타입에 따라 1,2,3커버(H가 있으면)
/*			int total = 0;
			int ii=0;
			int jj=0;*/
			for(int i=0; i<X.length; i++) {
				for(int j=0; j<X[i].length; j++) {
					if(X[i][j] != 'X' && X[i][j]!='H') { //기지국이면!
						for(int k=1; k<X[i][j]-'A'+2; k++) { //A,B,C에 따라 1,2,3돌게 아스키코드의 차이 이용!
							//상하좌우 한칸씩 증가하면서 제거
							if(j+k< n && X[i][j+k]=='H') { //동 //이동했으니 범위체크먼저
								X[i][j+k]='X';
							}
							if(j-k>=0 && X[i][j-k]=='H') { //서  //이동했으니 범위체크먼저
								X[i][j-k]='X';
							}
							if(i+k< n && X[i+k][j]=='H') { //남  //이동했으니 범위체크먼저
								X[i+k][j]='X';
							}
							if(i-k>=0 && X[i-k][j]=='H') { //북 //이동했으니 범위체크먼저
								X[i-k][j]='X';
							}
						}
					}
					/*switch (X[i][j]) {
					case "H":
						//total++;
						break;
					case "A":
						for(int d=0; d<4; d++) {
							ii = i+ dx[d];
							jj = j+ dy[d];
							if(X[ii][jj] == "H") {
								X[ii][jj] = "C";
							}
						}
						break;
					case "B":
						for(int f=0; f<2; f++) {
							for(int d=0; d<4; d++) {
								ii = i+ dx[d];
								jj = j+ dy[d];
								if(X[ii][jj] == "H") {
									X[ii][jj] = "C";
								}
							}
						}
						break;
					case "C":
						
						break;
					default:
						break;
					}*/
				}
			}
			//결과테스트출력1
			for(int m=0; m<X.length;m++) { //잘 되었는지 Arrays.toString(1차배열)로 출력하면 된다.
				System.out.println(Arrays.toString(X[m]));
			}
			System.out.println();
			//결과테스트출력2!! by 포이치 문
			for(char[] x: X) System.out.println(Arrays.toString(x));
			System.out.println();
			
			//남아있는 H를 카운팅
			int count = 0;
			for (int i = 0; i < X.length; i++) {
				for (int j = 0; j < X[i].length; j++) {
					if (X[i][j] == 'H') {
						count++;
					}
				}
			}
			System.out.println("#"+tc+" "+ count);
		}
	}
}