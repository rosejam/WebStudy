package 문제풀이2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//		1	2		3	3	4	4
//	1	1	2	2		3	4
public class Main_JO_2543_타일채우기_서울9반_김동주_시간초과_ { //분할 정복 //한번의 분할로 끝내도록 만들어야 함
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
        
        B = new int[N][N]; //화장실
        B[X][Y] = -1;//나중에 다시 0으로
        //배수구 근처 먼저 채우기 //필요없음
        do {
        	flag = true;
	        B = tiling(0,0,N,B); ////
here:       for(int i=0; i<N; i++) {
	        	for(int j=0; j<N; j++) {
	        		if(B[i][j] == 0) { //0이 있다면
	        			flag = false;
	        			break here;
	        		}
	        	}
        	}
        }while(!flag);
        //B = tiling(0,0,N,B);
        //B = tiling(0,0,N);A
        
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
	private static int[][] tiling(int i, int j, int n, int[][] b) {
		//int[][] b = new int[n][n];
		if(n == 2) { //최소단위시드
			
			int[][] b1 = {{b[i][j]}};
			int[][] b2 = {{b[i][j+1]}};
			int[][] b3 = {{b[i+1][j]}};
			int[][] b4 = {{b[i+1][j+1]}};
			return merge(b1,b2,b3,b4,2);
/*			if(B[i][j] != 0 && B[i][j+1]==0 && B[i+1][j]==0 && B[i+1][j+1]==0) B[i][j+1] = B[i+1][j] = B[i+1][j+1] = 1;
	        else if(B[i][j+1] != 0 && B[i][j]==0 && B[i+1][j]==0 && B[i+1][j+1]==0) B[i][j] = B[i+1][j] = B[i+1][j+1] = 2;
	        else if(B[i+1][j] != 0 && B[i][j+1]==0 && B[i][j]==0 && B[i+1][j+1]==0) B[i][j] = B[i][j+1] = B[i+1][j+1] = 3;
	        else if(B[i+1][j+1] != 0 && B[i][j+1]==0 && B[i+1][j]==0 && B[i][j]==0) B[i][j] = B[i][j+1] = B[i+1][j] = 4;
			return new int[][] {{B[i][j],B[i][j+1]},{B[i+1][j],B[i+1][j+1]}};*/
		}
		
		int[][] b1 = tiling(i, j, n/2, b);
		int[][] b2 = tiling(i, j+n/2, n/2, b);
		int[][] b3 = tiling(i+n/2, j, n/2, b);
		int[][] b4 = tiling(i+n/2, j+n/2, n/2, b);
		return merge(b1,b2,b3,b4,n);
	}
	private static int[][] merge(int[][] b1, int[][] b2, int[][] b3, int[][] b4, int n) {
/*		if(b1[n/2-1][n/2-1]*b2[n/2-1][0]*b3[0][n/2-1]*b4[0][0] !=0) {
			return putin(b1,b2,b3,b4,n);//합치려는 중간 부분에 0이 없는 경우
		}*/
			
		if(b1[n/2-1][n/2-1] != 0 && b2[n/2-1][0]==0 && b3[0][n/2-1]==0 && b4[0][0]==0) {
			b2[n/2-1][0] = b3[0][n/2-1] = b4[0][0] = 1;
			int[][] b = putin(b1,b2,b3,b4,n);
//			b2 = tiling(0, n/2, n/2, b);
//			b3 = tiling(n/2, 0, n/2, b);
//			b4 = tiling(n/2, n/2, n/2, b);
			return b;
		}
		else if(b2[n/2-1][0] != 0 && b1[n/2-1][n/2-1]==0 && b3[0][n/2-1]==0 && b4[0][0]==0) {
			b1[n/2-1][n/2-1] = b3[0][n/2-1] = b4[0][0] = 2;
			int[][] b = putin(b1,b2,b3,b4,n);
//			b2 = tiling(0, n/2, n/2, b);
//			b3 = tiling(n/2, 0, n/2, b);
//			b4 = tiling(n/2, n/2, n/2, b);
			return b;
		}
		else if(b3[0][n/2-1] != 0 && b1[n/2-1][n/2-1]==0 && b2[n/2-1][0]==0 && b4[0][0]==0) {
			b1[n/2-1][n/2-1] = b2[n/2-1][0] = b4[0][0] = 3;
			int[][] b = putin(b1,b2,b3,b4,n);
//			b2 = tiling(0, n/2, n/2, b);
//			b3 = tiling(n/2, 0, n/2, b);
//			b4 = tiling(n/2, n/2, n/2, b);
			return b;
		}
		else if(b4[0][0] != 0 && b1[n/2-1][n/2-1]==0 && b2[n/2-1][0]==0 && b3[0][n/2-1]==0) {
			b1[n/2-1][n/2-1] = b2[n/2-1][0] = b3[0][n/2-1] = 4;
			int[][] b = putin(b1,b2,b3,b4,n);
//			b2 = tiling(0, n/2, n/2, b);
//			b3 = tiling(n/2, 0, n/2, b);
//			b4 = tiling(n/2, n/2, n/2, b);
			return b;
		}
		else return putin(b1,b2,b3,b4,n);
		//b = putin(b1,b2,b3,b4,n);
		//return b;
	}
	private static int[][] putin(int[][] b1, int[][] b2, int[][] b3, int[][] b4, int n) { //4개를 단순히 붙이기
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

/*import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JO_2543_타일채우기_서울9반_김동주_예시답안_ {
	public static int[][] T;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		T = new int[N][N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());

		tile(0, 0, N - 1, N - 1, X, Y, 0);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(T[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void tile(int si, int sj, int ei, int ej, int hi, int hj, int hv) {
		if (si == ei) {
			T[si][sj] = hv; // 구멍의 value값
			return;
		}

//가운데 좌표 구하기
		int mi = (si + ei) / 2;
		int mj = (sj + ej) / 2;

		if (si <= hi && hi <= mi && sj <= hj && hj <= mj) {
			tile(si, sj, mi, mj, hi, hj, hv);
			tile(si, mj + 1, mi, ej, mi, mj + 1, 1); // 오른쪽
			tile(mi + 1, sj, ei, mj, mi + 1, mj, 1); // 아래
			tile(mi + 1, mj + 1, ei, ej, mi + 1, mj + 1, 1); // 오른쪽 대각선 아래
		}

		else if (si <= hi && hi <= mi && mj + 1 <= hj && hj <= ej) {
			tile(si, sj, mi, mj, mi, mj, 2); // 왼쪽
			tile(si, mj + 1, mi, ej, hi, hj, hv);
			tile(mi + 1, sj, ei, mj, mi + 1, mj, 2); // 아래
			tile(mi + 1, mj + 1, ei, ej, mi + 1, mj + 1, 2); // 왼쪽 대각선 아래
		}

		else if (mi + 1 <= hi && hi <= ei && sj <= hj && hj <= mj) {
			tile(si, sj, mi, mj, mi, mj, 3); // 위
			tile(si, mj + 1, mi, ej, mi, mj + 1, 3); // 오른쪽 대각선 위
			tile(mi + 1, sj, ei, mj, hi, hj, hv);
			tile(mi + 1, mj + 1, ei, ej, mi + 1, mj + 1, 3); // 오른쪽
		}

		else if (mi + 1 <= hi && hi <= ei && mj + 1 <= hj && hj <= ej) {
			tile(si, sj, mi, mj, mi, mj, 4); // 왼쪽 대각선 위
			tile(si, mj + 1, mi, ej, mi, mj + 1, 4); // 위
			tile(mi + 1, sj, ei, mj, mi + 1, mj, 4);
			tile(mi + 1, mj + 1, ei, ej, hi, hj, hv); // 왼쪽
		}
	}
}*/