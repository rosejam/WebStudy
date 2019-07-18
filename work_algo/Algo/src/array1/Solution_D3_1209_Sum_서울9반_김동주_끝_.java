package array1;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D3_1209_Sum_서울9반_김동주_끝_ {
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("res/input_D3_1209.txt")); 
		Scanner sc = new Scanner(System.in);

		for(int tc = 0; tc < 10; tc++)
		{
			sc.nextInt(); //1~10
			//int[] add = new int[12];
			int[][] A = new int[100][100]; //A도 매번 초기화하면 되고 3차배열일필요는없음
			int[] R = new int[100]; //매번초기화되는 row합
			int[] C = new int[100];
			int X1=0, X2=0; 
			
			//R들, C들, X들중 가장 큰값max 찾아야함
			int max = Integer.MIN_VALUE ;
			for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					A[i][j] = sc.nextInt();
					R[i] += A[i][j];
					if(max<R[i]) max=R[i];
					C[j] += A[i][j];
					if(max<C[j]) max=C[j];
					if (i==j) 
						X1 += A[i][i];
					if ((i+j)==99) //N-1
						X2 += A[i][j];
				}
			}//같은 for문안에서 다돌리는게 좋다.
			if(max<X1) max=X1;
			if(max<X2) max=X2;
/*			int maxC = C[0];
			int max_X = X1;
			for(int i=0; i<100; i++) {
				if(maxR < R[i])
					maxR = R[i];  //이 이프문만
			}
			for(int i=0; i<100; i++) {
				if(maxC < C[i])
					maxC = C[i];
			}
			if(X1<X2)
				max_X=X2;
			
			int max = max_X;
			if (maxR>max) max=maxR;
			if (maxC>max) max=maxC;     */

			//System.out.println(Arrays.toString(A[9][1]));
			System.out.println("#"+(tc+1)+" "+max);
		}
		
	}
}
	
