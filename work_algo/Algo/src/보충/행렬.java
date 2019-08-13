package 보충;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 행렬 {
	
	static int n;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		//행 우선 출력 
		for(int i=0; i<arr.length; i++) { //행의 개수
			for(int j=0; j<arr[i].length; j++) { //어떤 행의 열의 개수
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		//열 우선 출력
		for(int i=0; i<arr[0].length; i++) {
			for(int j=0; j<arr.length; j++) {
				System.out.print(arr[j][i]+" "); //행렬이 바뀜
			}
			System.out.println();
		}
	}
}