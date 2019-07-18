package array1;

import java.util.Arrays;

public class Array2Test {
	public static void main(String[] args) {
		//1.선언
		int[][] a; //int a[][]; int[] a[];
		//2.생성
		a = new int[3][3];
		//1+2동시에
		int[][] b = new int[3][3]; // 몇차원 배열이든 제일 앞[]에는 값을 꼭 넣어야 하고 나머지 뒤[]들에는 비워두어도 됀다. 
		
		//3.초기화
		b[0][0]=10;
		b[1][1]=11;
		b[2][2]=12;
		//b[0][3]=13; //java.lang.ArrayIndexOutOfBoundsException: 3
		//b[0][-1]=14; //java.lang.ArrayIndexOutOfBoundsException: -1
		
		//1+2+3
		int[][] c = {{10,11,12}, 
			    	 {10,11,12},
		             {10,11,12}};
		
		
		int[][] d = new int[][] {{10,11,12}, 
				                 {10,11,12},
                                 {10,11,12}};

		//1, 2+3
		int[][] e;
		//e = {10,11,12}
		//    {10,11,12}
        //    {10,11,12}};; //2과정이 없으므로 ERR 
		e = new int[][] {{10}, //2+3과정
						 {0,11,0,0},
						 {0,11,12}};
		
		//4-1.출력
		for(int i=0; i<e.length; i++) {
			for (int j=0; j<e[i].length; j++) {
				System.out.print(e[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		//4-2.
		for(int[] va:e) {
			for(int v:va) {
				System.out.print(v + " ");
			}
			System.out.println();
		}
		System.out.println();
		//4-3.
		for(int[] v:e)System.out.println(Arrays.toString(v));
		
		//5.복제
		int[][] f= new int[e.length][];
		for(int i=0; i<e.length; i++) {
			//f[i] = new int[e[i], 0, f[i], 0, e[i].length);
			//System.arraycopy(e[i],0,f[i],0,e[i].length);
			f[i]=Arrays.copyOf(e[i], e[i].length); 
		}

		e[0][0]=0;
		for(int v:e) System.out.println(Arrays.toString(v));
		for(int v:f) System.out.println(Arrays.toString(v));
	}
}
