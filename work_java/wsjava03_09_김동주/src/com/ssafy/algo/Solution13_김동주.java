package com.ssafy.algo;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution13_김동주_끝_ {

public static final int[][]	d8 = {{-1,-1,0,1,1,1,0,-1},
    	  						{0,1,1,1,0,-1,-1,-1}};
	
	public static void main(String[] args) throws Exception 
	{
		System.setIn(new FileInputStream("res/Solution13.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
//		int[][] d4 = {{-1,0,1,0}, 
//					{0,1,0,-1}};
//		int[][] d8 = {{-1,-1,0,1,1,1,0,-1},
//			      	  {0,1,1,1,0,-1,-1,-1}}; //변수선언은 왠만하면 꺼내자밖으로
		for (int tc=1; tc<=T; tc++) {
			int max = 0;
			int N = sc.nextInt();
			int[][] X = new int[N][N]; //부지
			
			for(int i=0 ; i<N ; i++) {
				for(int j=0; j<N; j++) {
					String get=sc.next();
					char get_c = get.charAt(0);////하면 첫번째 글짜를 char형으로 바꿔준다~
					if (get_c == 'G') { //G공원은 -1로 고정!
						X[i][j] = -1;
					}
					else if(get_c == 'B'){
						X[i][j] = 1; //B는 우선 1층
					}
					//System.out.println(X[i][j]);
				}
				//System.out.println();
			}//부지완성(스트링)
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(X[i][j]!= -1) { //빌딩구역이면
						for(int d=0; d < 8; d++) { //8방체크
							int ni = i + d8[0][d];
							int nj = j + d8[1][d];
							if(ni>=0 && nj>=0 && ni<N && nj<N) { //범위안쪽만 출력하도록 함
								if(X[ni][nj] == -1) {
									X[i][j]=2; 
									break;
								}
									
							}
						}
					} //빌딩구역중 공원인접이면 1->2로 고정!
					if(X[i][j]==1) { //공원인접 아닌 빌딩구역이면 빌딩높이세우기
						for(int d=0; d < 8; d++) {
							if(d%2==0) { //4방향만
								for(int n=1; n<N; n++) {
									int ni = i + d8[0][d]* n;
									int nj = j + d8[1][d]* n;
									if(ni>=0 && nj>=0 && ni<N && nj<N) {
										if(X[ni][nj] !=-1) { //4방향에 빌딩이 있다면
											X[i][j]++; //그 개수만큼쌓기(본인은 이미 1로 되어있으므로 포함)
										}
									}
								}
							}
						}// 이렇게 안하고 그냥 행/열중 1개 고정하고 N개씩 돌려도 된다.
					}
					if (max < X[i][j]) max = X[i][j];
				}
			} 
			System.out.println("#"+tc+" "+ max);
		}		
	}	
}
