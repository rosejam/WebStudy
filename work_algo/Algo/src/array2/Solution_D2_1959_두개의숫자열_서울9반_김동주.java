package array2;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D2_1959_두개의숫자열_서울9반_김동주 {

	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("res/input_D2_1959.txt")); //제출할때는 입력 삭제!!!
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt(); 
		for(int tc = 1; tc <= T; tc++)
		{
			int N=sc.nextInt(); 
			int M=sc.nextInt(); 
			int P;
			int[] A = new int[N];
			int[] B = new int[M];
			
			for(int i=0; i<N; i++) {
				A[i] =sc.nextInt();
			} 
			for(int j=0; j<M; j++) {
				B[j] =sc.nextInt();
			} 
			///모두 input
			int sum;
			int max=Integer.MIN_VALUE;;
			if(N>M) {
				P=N-M+1;
				for(int k=0; k<P; k++) {
					sum=0; 
					for(int j=0; j<M; j++) {
						sum+=B[j]*A[j+k];
					}
					if(max<sum) max=sum;
				}
				System.out.println("#"+tc+" "+max);
			}else{
				P=M-N+1;
				
				for(int k=0; k<P; k++) {
					sum=0; 
					for(int i=0; i<N; i++) {
						sum+=A[i]*B[i+k];
					}
					if(max<sum) max=sum;
				}
				System.out.println("#"+tc+" "+max);
			}
		}
		sc.close();
	}
}
