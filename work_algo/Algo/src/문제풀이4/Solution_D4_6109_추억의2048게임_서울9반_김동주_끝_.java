package 문제풀이4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_6109_추억의2048게임_서울9반_김동주_끝_ {
	//public static int dir;
	//public static final int[] di = {-1,1,0,0};
	//public static final int[] dj = {0,0,-1,1}; //상하좌우
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_D4_6109.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			String S = st.nextToken();
/*			if(S.startsWith("d")) {
				dir = 1;
			}else if(S.startsWith("l")) {
				dir = 2;
			}else if(S.startsWith("r")) {
				dir = 3;
			}else {
				dir = 0;
			}*/
			int[][] grid = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken()); //2^1~10
				}
			}
			//입력
			switch(S) {
			case "up": //상
				for(int j=0; j<N; j++) {
					for(int i=0; i<N-1; i++) { //빈공간 없애기
						if(grid[i][j] == 0) { //끌어와서 채우기
							int ni = i+1; //채울 인덱스 찾기
							while(ni<N && grid[ni][j] == 0) {
								ni++;
							}
							if(ni<N) { //인덱스 찾음
								grid[i][j] = grid[ni][j];
								grid[ni][j] = 0;
								//if(grid[j][i] == grid[j][i+1]) flag = true;
							}
						}
					}
				}
				for(int j=0; j<N; j++) {
					for(int i=0; i<N-1; i++) { //우측부터 벽에 밀기
						if(grid[i][j] == grid[i+1][j]) {
							grid[i][j] *= 2;
							grid[i+1][j] = 0;
						}
					}
				}
				for(int j=0; j<N; j++) {
					for(int i=1; i<N-1; i++) { //빈공간 없애기
						if(grid[i][j] == 0) { //끌어와서 채우기
							int ni = i+1; //채울 인덱스 찾기
							while(ni<N && grid[ni][j] == 0) {
								ni++;
							}
							if(ni<N) { //인덱스 찾음
								grid[i][j] = grid[ni][j];
								grid[ni][j] = 0;
								//if(grid[j][i] == grid[j][i+1]) flag = true;
							}
						}
					}
				}
				break;
			case "down": //하
				for(int j=0; j<N; j++) {
					for(int i=N-1; i>0; i--) { //빈공간 없애기
						if(grid[i][j] == 0) { //끌어와서 채우기
							int ni = i-1; //채울 인덱스 찾기
							while(ni>=0 && grid[ni][j] == 0) {//
								ni--;
							}
							if(ni>=0) { //인덱스 찾음
								grid[i][j] = grid[ni][j];
								grid[ni][j] = 0;
								//if(grid[j][i] == grid[j][i+1]) flag = true;
							}
						}
					}
				}
				for(int j=0; j<N; j++) {
					for(int i=N-1; i>0; i--) { //우측부터 벽에 밀기
						if(grid[i][j] == grid[i-1][j]) {
							grid[i][j] *= 2;
							grid[i-1][j] = 0;
						}
					}
				}
				for(int j=0; j<N; j++) {
					for(int i=N-2; i>0; i--) { //빈공간 없애기
						if(grid[i][j] == 0) { //끌어와서 채우기
							int ni = i-1; //채울 인덱스 찾기
							while(ni>=0 &&  grid[ni][j] == 0) {
								ni--;
							}
							if(ni>=0) { //인덱스 찾음
								grid[i][j] = grid[ni][j];
								grid[ni][j] = 0;
								//if(grid[j][i] == grid[j][i+1]) flag = true;
							}
						}
					}
				}
				break;
			case "left": //좌
				for(int i=0; i<N; i++) {
					for(int j=0; j<N-1; j++) { //빈공간 없애기
						if(grid[i][j] == 0) { //끌어와서 채우기
							int nj = j+1; //채울 인덱스 찾기
							while(nj<N && grid[i][nj] == 0) {
								nj++;
							}
							if(nj<N) { //인덱스 찾음
								grid[i][j] = grid[i][nj];
								grid[i][nj] = 0;
								//if(grid[i][j] == grid[i][j+1]) flag = true;
							}
						}
					}
				}
				for(int i=0; i<N; i++) {
					for(int j=0; j<N-1; j++) { //우측부터 벽에 밀기
						if(grid[i][j] == grid[i][j+1]) {
							grid[i][j] *= 2;
							grid[i][j+1] = 0;
						}
					}
				}
				for(int i=0; i<N; i++) {
					for(int j=1; j<N-1; j++) { //빈공간 없애기
						if(grid[i][j] == 0) { //끌어와서 채우기
							int nj = j+1; //채울 인덱스 찾기
							while(nj<N && grid[i][nj] == 0) {
								nj++;
							}
							if(nj<N) { //인덱스 찾음
								grid[i][j] = grid[i][nj];
								grid[i][nj] = 0;
								//if(grid[i][j] == grid[i][j+1]) flag = true;
							}
						}
					}
				}
				break;
			case "right": //우
				for(int i=0; i<N; i++) {
					for(int j=N-1; j>0; j--) { //빈공간 없애기
						if(grid[i][j] == 0) { //끌어와서 채우기
							int nj = j-1; //채울 인덱스 찾기
							while(nj>=0 && grid[i][nj] == 0) {
								nj--;
							}
							if(nj>=0) { //인덱스 찾음
								grid[i][j] = grid[i][nj];
								grid[i][nj] = 0;
								//if(grid[i][j] == grid[i][j+1]) flag = true;
							}
						}
					}
				}
				for(int i=0; i<N; i++) {
					for(int j=N-1; j>0; j--) { //우측부터 벽에 밀기
						if(grid[i][j] == grid[i][j-1]) {
							grid[i][j] *= 2;
							grid[i][j-1] = 0;
						}
					}
				}
				for(int i=0; i<N; i++) {
					for(int j=N-2; j>0; j--) { //빈공간 없애기
						if(grid[i][j] == 0) { //끌어와서 채우기
							int nj = j-1; //채울 인덱스 찾기
							while(nj>=0 && grid[i][nj] == 0) {
								nj--;
							}
							if(nj>=0) { //인덱스 찾음
								grid[i][j] = grid[i][nj];
								grid[i][nj] = 0;
								//if(grid[i][j] == grid[i][j+1]) flag = true;
							}
						}
					}
				}
				break;
			}
			
			//출력
			sb.append('#').append(tc).append('\n');
			for(int i=0; i<N; i++) {
				for(int j=0; j<N-1; j++) {
					sb.append(grid[i][j]).append(' ');
				}
				sb.append(grid[i][N-1]).append('\n');
			}
		}
		System.out.print(sb);
	}

}
