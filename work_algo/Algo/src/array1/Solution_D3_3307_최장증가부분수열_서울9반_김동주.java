package array1; //제출할때는 패키지명 삭제!!!

import java.util.Scanner;
import java.io.FileInputStream;

class Solution_D3_3307_최장증가부분수열_서울9반_김동주{ //제출할 때 클래스명은 솔루션으로 바꿔야함!!! F2키로 파일이름 바꿀수 있음
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("res/input_D3_3307.txt")); //제출할때는 입력 삭제!!!
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();

		for(int tc = 1; tc <= T; tc++)
		{
		
			/////////////////////////이 부분에 여러분의 알고리즘 구현이 들어갑니다.///////////////////////////////////
			
			int N=sc.nextInt(); //수열안의 개수N 
			 
			long[] A = new long[N];
			long[][] B = new long[N][N];	
			for(int i=0; i<N; i++) { 
				A[i]=sc.nextLong();
			} //수열A에 다 넣기
			for(int j=0; j<N; j++) {
				B[j][0] = A[j];
				//B[j][1] = A[j];
				for(int k=1; k<N-j; k++) {
					int l=0;
					if(A[j+k] > B[j][l]) {
						B[j][l+1] = A[j+k]; // if A[j]
						l++;
					}	
				}
			} //다양한 B만들기

			
			//B의 행에서 0이아닌 길이 중 가장 긴 것
			

			//String Y=sc.next(); //수열 -> 공백으로 나누기
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					//System.out.print("#" + tc + " " + B[i][j]);
					System.out.print(B[i][j]);
				}
				System.out.println();
			}
			/////////////////////////////////////////////////////////////////////////////////////////////

		}
	}
}