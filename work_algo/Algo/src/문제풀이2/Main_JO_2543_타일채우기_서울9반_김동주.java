package 문제풀이2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//		1	2		3	3	4	4
//	1	1	2	2		3	4
public class Main_JO_2543_타일채우기_서울9반_김동주 { //분할 정복
	public static int N,X,Y;// ,M;
	public static int[][] B;
	public static boolean flag;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_JO_2543.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine()); //2^1~2^9 -> 한변을 반으로 계속 나눠서 2까지 나눌 수 있음
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken()); //배수구 인덱스 좌표
        //입력끝
        
        //M = (int) (Math.log(N)/Math.log(2)); //2의 몇승인지
        B = new int[N][N]; //화장실
        B[X][Y] = -1;//나중에 다시 0으로
/*        //배수구 근처 먼저 채우기 //필요없음
        //int x = (int) (Math.log(X)/Math.log(2)); 
        //int y = (int) (Math.log(Y)/Math.log(2));
        int x = X - X%2;
        int y = Y - Y%2;
        //x = x*2;
        //y = y*2;
        if(B[x][y] != 0) B[x+1][y] = B[x][y+1] = B[x+1][y+1] = 1;
        else if(B[x][y+1] != 0) B[x][y] = B[x+1][y] = B[x+1][y+1] = 2;
        else if(B[x+1][y] != 0) B[x][y] = B[x][y+1] = B[x+1][y+1] = 3;
        else if(B[x+1][y+1] != 0) B[x][y] =B[x][y+1] = B[x+1][y] = 4;*/
/*        //가장자리도 먼저 채우기 //아님
        B[0][0] = B[0][1] = B[1][0] = 4;
        B[0][N-1] = B[0][N-2] = B[1][N-1] = 3;
        B[N-1][0] = B[N-1][1] = B[N-2][0] = 2;
        B[N-1][N-1] = B[N-1][N-2] = B[N-2][N-1] = 4;*/
        
        do {
        	flag = true;
	        B = tiling(0,0,N); ////
here:       for(int i=0; i<N; i++) {
	        	for(int j=0; j<N; j++) {
	        		if(B[i][j] == 0) { //0이 있다면
	        			flag = false;
	        			break here;
	        		}
	        	}
        	}
        }while(!flag);
        //B = tiling(0,0,N);
        //B = tiling(0,0,N);
        
        //출력시작
        B[X][Y] = 0;
        for(int i=0; i<N-1; i++) {
        	for(int j=0; j<N-1; j++) {
        		sb.append(B[i][j]).append(" ");
        	}
        	sb.append(B[i][N-1]).append("\n");
        }
        for(int j=0; j<N-1; j++) {
        	sb.append(B[N-1][j]).append(" ");
        }
        sb.append(B[N-1][N-1]);
        System.out.println(sb);
	}
	private static int[][] tiling(int i, int j, int n) {
		//int[][] b = new int[n][n];
		if(n == 2) { //최소단위시드
			int[][] b1 = {{B[i][j]}};
			int[][] b2 = {{B[i][j+1]}};
			int[][] b3 = {{B[i+1][j]}};
			int[][] b4 = {{B[i+1][j+1]}};
			return merge(b1,b2,b3,b4,2);
			
/*			if(B[i][j] != 0 && B[i][j+1]==0 && B[i+1][j]==0 && B[i+1][j+1]==0) B[i][j+1] = B[i+1][j] = B[i+1][j+1] = 1;
	        else if(B[i][j+1] != 0 && B[i][j]==0 && B[i+1][j]==0 && B[i+1][j+1]==0) B[i][j] = B[i+1][j] = B[i+1][j+1] = 2;
	        else if(B[i+1][j] != 0 && B[i][j+1]==0 && B[i][j]==0 && B[i+1][j+1]==0) B[i][j] = B[i][j+1] = B[i+1][j+1] = 3;
	        else if(B[i+1][j+1] != 0 && B[i][j+1]==0 && B[i+1][j]==0 && B[i][j]==0) B[i][j] = B[i][j+1] = B[i+1][j] = 4;
			return new int[][] {{B[i][j],B[i][j+1]},{B[i+1][j],B[i+1][j+1]}};*/
		}
		
		int[][] b1 = tiling(i, j, n/2);
		int[][] b2 = tiling(i, j+n/2, n/2);
		int[][] b3 = tiling(i+n/2, j, n/2);
		int[][] b4 = tiling(i+n/2, j+n/2, n/2);
		return merge(b1,b2,b3,b4,n);
	}
	private static int[][] merge(int[][] b1, int[][] b2, int[][] b3, int[][] b4, int n) {
		if(b1[n/2-1][n/2-1]*b2[n/2-1][0]*b3[0][n/2-1]*b4[0][0] ==0) { //합치려는 중간 부분에 0이 있을 경우
			if(b1[n/2-1][n/2-1] != 0 && b2[n/2-1][0]==0 && b3[0][n/2-1]==0 && b4[0][0]==0) {
				b2[n/2-1][0] = b3[0][n/2-1] = b4[0][0] = 1;
			}
			else if(b2[n/2-1][0] != 0 && b1[n/2-1][n/2-1]==0 && b3[0][n/2-1]==0 && b4[0][0]==0) {
				b1[n/2-1][n/2-1] = b3[0][n/2-1] = b4[0][0] = 2;
			}
			else if(b3[0][n/2-1] != 0 && b1[n/2-1][n/2-1]==0 && b2[n/2-1][0]==0 && b4[0][0]==0) {
				b1[n/2-1][n/2-1] = b2[n/2-1][0] = b4[0][0] = 3;
			}
			else if(b4[0][0] != 0 && b1[n/2-1][n/2-1]==0 && b2[n/2-1][0]==0 && b3[0][n/2-1]==0) {
				b1[n/2-1][n/2-1] = b2[n/2-1][0] = b3[0][n/2-1] = 4;
			}
		}
		int[][] b = new int[n][n];
		for(int i=0; i<n/2; i++) {
			for(int j=0; j<n/2; j++) {
				b[i][j] = b1[i][j];
			}
		}
		for(int i=0; i<n/2; i++) {
			for(int j=0; j<n/2; j++) {
				b[i][j+n/2] = b2[i][j];
			}
		}
		for(int i=0; i<n/2; i++) {
			for(int j=0; j<n/2; j++) {
				b[i+n/2][j] = b3[i][j];
			}
		}
		for(int i=0; i<n/2; i++) {
			for(int j=0; j<n/2; j++) {
				b[i+n/2][j+n/2] = b4[i][j];
			}
		}
		return b;
	}
}
