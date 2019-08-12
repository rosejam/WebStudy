package array2;

import java.io.FileInputStream;
import java.util.Scanner;


public class Solution_D4_1210_Ladder1_서울9반_김동주 {
	
//	public static int[] r = {-1,0,0};
//	public static int[] c = {0,-1,1};//위, 좌, 우
	
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("res/input_D4_1210.txt")); //제출할때는 입력 삭제!!!
		Scanner sc = new Scanner(System.in);
		//int T=sc.nextInt();  10개의 테스트 케이스
		int[][] A = new int[100][100];
		for(int tc = 1; tc <= 10; tc++)
		{
			sc.nextInt(); //번호 버리기
			for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					A[i][j] = sc.nextInt();
				}
			}//배열 완성 입력끝
			//우선 도착지점2 찾기
			int goal=0; 
			for (int k=0; k<100; k++) {
				if (A[99][k] == 2) {
					goal = k;
					break;
				}
			}//시작지점 A[99][goal]
			int row = 98;
			int col = goal;
			
			while(row!=0) {
				if(col>=1 && A[row][col-1] == 1) { //좌체크, 
					do {// 좌로 이동 시작
						col--;
					} while(col>=1 && A[row][col-1] == 1);
					row--;
					continue;
				}else if(col<99 && A[row][col+1] == 1){ //우체크
					do { //우로 이동 시작
						col++;
					}while(col<99 && A[row][col+1] == 1);
					row--;
					continue;
				}else { //옆없으니까 위로 직진
					row--;
					continue;
				}
				
			}
			System.out.println("#" + tc + " "+ col);//도착하게 되는 출발점의 x좌표를 출력

		}
		sc.close();
	}
}