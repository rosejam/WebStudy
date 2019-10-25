package Algorithm;

import java.util.Scanner;

class Dynamic_Programming {

	static int N;
	static int dp[][];
	static int board[][];

	static int max(int a, int b) 
	{
		return (a<b) ? b : a;
	}

	static void findSticker() 
	{
		dp[0][0] = board[0][0];
		dp[1][0] = board[1][0];
		dp[0][1] = dp[1][0] + board[0][1];
		dp[1][1] = dp[0][0] + board[1][1];

		for (int i = 2; i < N; i++) 
		{
			dp[0][i] = max(dp[0][i - 2], dp[1][i - 2]);
			dp[0][i] = max(dp[1][i - 1], dp[0][i]);
			dp[0][i] += board[0][i];

			dp[1][i] = max(dp[0][i - 2], dp[1][i - 2]);
			dp[1][i] = max(dp[0][i - 1], dp[1][i]);
			dp[1][i] += board[1][i];
		}
	}

	public static void main(String arg[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) 
		{
			N = sc.nextInt();
			
			board = new int[2][N];
			dp = new int[2][N];

			for (int j = 0; j < 2; j++) 
			{
				for (int i = 0; i < N; i++) 
				{
					board[j][i] = sc.nextInt();
				}
			}
			findSticker();
			
			System.out.println("#" + test_case + " " + max(dp[0][N - 1], dp[1][N - 1]));
		}

		sc.close();
	}
}