package com.ssafy.algo;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution21_김동주 {
	public static final int[][] d2 = {{0,1,0}, 
									  {0,0,1}}; //0,하1,우2
	public static void main(String[] args) throws Exception 
	{
		System.setIn(new FileInputStream("res/Solution21.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc=1; tc<=T; tc++) {
			//int max = 0;
			int N = sc.nextInt();
			int[][] X = new int[N][N]; //연못
			int Bugs = sc.nextInt();
			
			int TheBug = 0;
			int[] row = new int[Bugs];
			int[] col = new int[Bugs];
			int[] dir = new int[Bugs];
			
			for(int b=0;b<Bugs;b++) {
				row[b] = sc.nextInt();
				col[b] = sc.nextInt();
				dir[b] = sc.nextInt(); //소금쟁이b번의 행,열,방향을 입력받았다.
			}
			
			for(int b=0;b<Bugs;b++) {//b번 소금쟁이 시작
				if(X[row[b]][col[b]] == 1) { //시작시에 체크, 이미있으면(1) 끝내고 출력
					TheBug = b+1;
					break;
				}//else {
				//	X[row][col] = 1;
				//}
				
				row[b] = row[b] + d2[0][dir[b]] * 3;
				col[b] = col[b] + d2[1][dir[b]] * 3;//3뛰기
				
				if((row[b]<0) || (row[b]>=N) || (col[b]<0) || (col[b]>=N)) { //밖으로 나갔다면 다음
					continue;
				}else if(X[row[b]][col[b]] == 1) { //체크, 이미있으면(1) 끝내고 출력
					TheBug = b+1;
					break;
				}else {
					X[row[b]][col[b]] = 1;
				}
				
				row[b] = row[b] + d2[0][dir[b]] * 2;
				col[b] = col[b] + d2[1][dir[b]] * 2;//2뛰기
				
				if((row[b]<0) || (row[b]>=N) || (col[b]<0) || (col[b]>=N)) { //밖으로 나갔다면 다음
					continue;
				}else if(X[row[b]][col[b]] == 1) { //체크, 이미있으면(1) 끝내고 출력
					TheBug = b+1;
					break;
				}else {
					X[row[b]][col[b]] = 1;
				}
				
				row[b] = row[b] + d2[0][dir[b]] * 1;
				col[b] = col[b] + d2[1][dir[b]] * 1;//1뛰기
				
				if((row[b]<0) || (row[b]>=N) || (col[b]<0) || (col[b]>=N)) { //밖으로 나갔다면 다음
					continue;
				}else if(X[row[b]][col[b]] == 1) { //체크, 이미있으면(1) 끝내고 출력
					TheBug = b+1;
					break;
				}else {
					X[row[b]][col[b]] = 1;
				}
				
			}//b번 소금쟁이 완료
			System.out.println("#"+tc+" "+ TheBug);
		}
	}
}
