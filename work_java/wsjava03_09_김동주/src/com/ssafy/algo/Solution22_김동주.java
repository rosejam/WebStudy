package com.ssafy.algo;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution22_김동주_끝_ {

	public static void main(String[] args) throws Exception 
	{
		System.setIn(new FileInputStream("res/Solution22.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] d4 = {{-1,1,0,0}, 
					  {0,0,-1,1}}; //dir 1,2,3,4,
//		int[][] d8 = {{-1,-1,0,1,1,1,0,-1},
//			      	  {0,1,1,1,0,-1,-1,-1}};
		for (int tc=1; tc<=T; tc++) {
			//int max = 0;
			int N = sc.nextInt();
			int[][] X = new int[N][N]; //연못
			int FirstBugs = sc.nextInt();
			int FinalBugs = 0;
			int[] row = new int[FirstBugs];
			int[] col = new int[FirstBugs];
			int[] dir = new int[FirstBugs];
			
			for(int b=0;b<FirstBugs;b++) {//b번 소금쟁이 시작
				row[b] = sc.nextInt();
				col[b] = sc.nextInt();
				dir[b] = sc.nextInt()-1; //소금쟁이b번의 행,열,방향을 입력받았다.
				
				
				if(X[row[b]][col[b]] == 1) { //시작시에 체크, 이미있으면(1) 죽는다
					//FinalBugs--; 
					continue;
				}
				
				row[b] = row[b] + d4[0][dir[b]] * 3;
				col[b] = col[b] + d4[1][dir[b]] * 3;//3뛰기
				
				if((row[b]<0) || (row[b]>=N) || (col[b]<0) || (col[b]>=N)) { //밖으로 나갔다면 죽는다.
					//FinalBugs--; 
					continue;
				}else if(X[row[b]][col[b]] == 1) { //체크, 이미있으면(1) 죽는다
					//FinalBugs--; 
					continue;
				}
				
				row[b] = row[b] + d4[0][dir[b]] * 2;
				col[b] = col[b] + d4[1][dir[b]] * 2;//2뛰기
				
				if((row[b]<0) || (row[b]>=N) || (col[b]<0) || (col[b]>=N)) { //밖으로 나갔다면 죽는다.
					//FinalBugs--; 
					continue;
				}else if(X[row[b]][col[b]] == 1) { //체크, 이미있으면(1) 죽는다
					//FinalBugs--; 
					continue;
				}
				
				row[b] = row[b] + d4[0][dir[b]] * 1;
				col[b] = col[b] + d4[1][dir[b]] * 1;//1뛰기
				
				if((row[b]<0) || (row[b]>=N) || (col[b]<0) || (col[b]>=N)) { //밖으로 나갔다면 죽는다.
					//FinalBugs--; 
					continue;
				}else if(X[row[b]][col[b]] == 1) { //체크, 이미있으면(1) 죽는다
					//FinalBugs--; 
					continue;
				}
				
				X[row[b]][col[b]] = 1; //안죽었을 경우 도착하고 머문다(1)
				FinalBugs++;
				
			}//b번 소금쟁이 완료
			System.out.println("#"+tc+" "+ FinalBugs);
		}
	}
}
