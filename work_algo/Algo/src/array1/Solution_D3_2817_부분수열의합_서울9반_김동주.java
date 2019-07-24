package array1;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D3_2817_부분수열의합_서울9반_김동주 {
/*	public static void solve(int sum, int pos) {
		if(sum>K) return;
		if(sum==K) {
			count++;
			return;
		}
		if(pos>N-1) {
				return;
		}
		solve(sum, pos+1);
		solve(sum+A[pos], pos+1);
	}
	*/
	
	
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("res/input_D3_2817.txt")); //제출할때는 입력 삭제!!!
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt(); 
		for(int tc = 1; tc <= T; tc++)
		{
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			int count =0;
			int[] A = new int[N];
			for(int i=0; i<N; i++) {
				A[i] = sc.nextInt();
			}
			
			for(int i=0; i<(1<<N); i++) {
				int sum =0;
				for(int j=0; j<N; j++) {
					if((i&(1<<j))>0) { 
						sum = sum + A[j];
					}
				}
				if(sum == K) count++;
			}
			System.out.println("#" + tc + " "+ count); //합이 k가 되는 경우의 수
		}
	}
}
