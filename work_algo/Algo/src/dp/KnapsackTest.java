package dp;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class KnapsackTest { //505
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_knapsack.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N=sc.nextInt(); //물건 개수
		int W=sc.nextInt(); //최대 무게 용량
		
		int[] w= new int[N+1]; //무게
		int[] v= new int[N+1]; //가치
		int[][] k = new int[N+1][W+1]; //i번 물건"까지" 고려하고 무게가 j일 경우 최대 가치
		
		for(int i=1; i<=N; i++) {
			w[i]=sc.nextInt();
			v[i]=sc.nextInt();
		}//입력다받음 (1-base)
		
		for(int i=1; i<=N; i++) { //i는 물건의 번호
			for(int j=1; j<=W; j++) { //j는 임시 용량!!!!
				if(w[i]>j){ //배낭에 안들어갈 때
					k[i][j]=k[i-1][j];
				}else {
					k[i][j]=Math.max(k[i-1][j-w[i]]+v[i], k[i-1][j]);
				}
			}
		}
		
		System.out.println(k[N][W]);
		for(int[] a:k) System.out.println(Arrays.toString(a));
		sc.close();
	}
}
