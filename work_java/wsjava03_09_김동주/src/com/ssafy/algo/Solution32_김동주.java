package com.ssafy.algo;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution32_김동주_끝_ {
public static final int[][] d4 = {{0,1,0,-1}, 
								  {1,0,-1,0}}; //동남서북0123
	public static void main(String[] args) throws Exception 
	{
		System.setIn(new FileInputStream("res/Solution32.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc=1; tc<=T; tc++) {
			//int max = 0;
			int Y = sc.nextInt();
			int X = sc.nextInt();
			int N = sc.nextInt();
			
//			int A=0;
			int dir=0, jump=0, r =0, c =0 , total = (-1000)*N;
			int[][] A = new int[Y][X]; //숫자판 만들기
			
			for(int i=0; i<Y; i++) {
				for(int j=0; j<X; j++) {
					A[i][j]= sc.nextInt();	
				}
			}//숫자판 적기 + 방향, 점프칸수등 정보
			
			int[] row = new int[N];
			int[] col = new int[N];
			int[] num = new int[N]; //N명의 참가자 만들기
			
			for(int n=0; n<N; n++) {
				row[n] = sc.nextInt()-1; 
				col[n] = sc.nextInt()-1;
				num[n] = sc.nextInt(); //점프횟수
			} //참가자 정보(시작좌표, 점프횟수)
			
			int TR = sc.nextInt(); //함정수

			int[] trow = new int[TR];
			int[] tcol = new int[TR]; //X개의 함정 만들기
			
			for(int x=0; x<TR; x++) {
				trow[x] = sc.nextInt()-1;
				tcol[x] = sc.nextInt()-1;
				A[trow[x]][tcol[x]] = 0; 
			}//함정 정보, 0으로 함정 표시
			//입력전부받음
			
			for(int n=0; n<N; n++) { //참가자n은
				for(int i=0; i<num[n]; i++) { //점프횟수만큼
					dir= A[row[n]][col[n]]/10 -1; ////여기서, 매번 1을 빼는 것 보다 인덱스0번째에 쓰레기 값을 넣어주는것이 좋다.
					jump= A[row[n]][col[n]]%10; //좌표분석
					row[n] = row[n] + d4[0][dir] * jump;
					col[n] = col[n] + d4[1][dir] * jump;//점프(좌표이동)
					if((row[n]<0) || (row[n]>=Y) || (col[n]<0) || (col[n]>=X) || (A[row[n]][col[n]]==0))  //범위 밖이면 다음
						break;
				}
				//n의 점프모두끝
				if((row[n]>=0) && (row[n]<Y) && (col[n]>=0) && (col[n]<X))
					total += (A[row[n]][col[n]]*100);
			}
			System.out.println("#"+tc+" "+ total);
		}
	}
}
