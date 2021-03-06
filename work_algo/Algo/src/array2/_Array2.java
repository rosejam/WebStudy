package array2;

import java.util.Arrays;

public class _Array2 {

	public static void main(String[] args) {
		int[][] a = {{1,2,3},
					 {4,5,6},
					 {7,8,9}};
		for(int i=0; i<a.length; i++) { 
			for(int j=0; j<a[i].length; j++) { //이 두줄이 2차원배열 for
				System.out.print(a[i][j]+ " ");
			}
			System.out.println();
		}
		System.out.println();
		
		for(int j=0; j<a.length; j++) { 
			for(int i=0; i<a[j].length; i++) { ////
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}//열우선순회
		System.out.println();
		
		for(int i=0; i<a.length; i++) { 
			for(int j=0; j<a[i].length; j++) { 
				System.out.print(a[i][j+(a[j].length-1-2*j)*(i%2)]+ " ");
			}
			System.out.println();
		}//지그재그
		System.out.println();
		
		int[][] b = new int[a.length][];
		for(int i=0; i<a.length; i++) 
			b[i]=Arrays.copyOf(a[i],a[i].length);
		for(int[] v:b) System.out.println(Arrays.toString(v));
		System.out.println();
		for(int i=0;i<b.length; i++) { //전치행렬(행<->렬)
			for(int j=0; j<b[i].length; j++) {
				if(i<j) { //
					int T = b[i][j];
					b[i][j]=b[j][i];
					b[j][i] = T;
				}
			}
		}
		for(int[] v:b) System.out.println(Arrays.toString(v));
		System.out.println(); //전치
		
/*		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[i].length; j++) {
				if(a[i][j]==5) {
					System.out.print(a[i-1][j+0]+" ");//2위
					System.out.print(a[i-0][j+1]+" ");//6우
					System.out.print(a[i+1][j+0]+" ");//8하
					System.out.print(a[i+0][j-1]+" ");//4좌
					System.out.println();
					
					int[] di = {-1,0,1,0}; 
					int[] dj = {0,1,0,-1};
					for(int d=0; d<di.length; d++) {
						int newi = i + di[d];
						int newj = j + dj[d];
						System.out.print(a[newi][newj]+" ");
					}
				}
			}
		}//+ 4방향
		System.out.println();
		
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[i].length; j++) {
				if(a[i][j]==5) {
					System.out.print(a[i-1][j+1]+" ");//3
					System.out.print(a[i+1][j+1]+" ");//9
					System.out.print(a[i+1][j-1]+" ");//7
					System.out.print(a[i-1][j-1]+" ");//1
					System.out.println();
					
					int[] di = {-1,1,1,-1}; 
					int[] dj = {1,1,-1,-1};
					for(int d=0; d<di.length; d++) {
						int newi = i + di[d];
						int newj = j + dj[d];
						System.out.print(a[newi][newj]+" ");
					}
				}
			}
		}//X 4방향
		System.out.println();*/
			
		//루프문 안에서 함수호출 및 변수선언을 자제!!!!
		int[][] di = {{-1,-1,0,1,1,1,0,-1},
				{0,1,1,1,0,-1,-1,-1}};
		
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[i].length; j++) {
				if(a[i][j]==2) { //중심부분 입력값:2
					//여기에 있던 루프문을 꺼냈다.
					for(int d=0; d<di[0].length; d++) {
						int newi = i + di[0][d];
						int newj = j + di[1][d];
						if(newi>=0 && newj>=0 && newi<a.length && newj<a[i].length) //범위안쪽만 출력하도록 함
							System.out.print(a[newi][newj]+" ");
					}
				}
			}
		}//8방향탐색
		System.out.println();
		
	}


}
