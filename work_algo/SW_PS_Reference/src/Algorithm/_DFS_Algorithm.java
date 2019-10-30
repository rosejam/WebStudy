package Algorithm;

import java.util.Scanner;

class _DFS_Algorithm
{
	static final int MAX_VERTEX = 30;
	static int[][] map = new int[MAX_VERTEX][MAX_VERTEX];
	static boolean[] visit = new boolean[MAX_VERTEX];
	static int vertex;
	static int edge;
	static int maxEdge;
	static int start;
	static int end;
	
	public static void depthFirstSearch(int v, int depth)
	{
		if (v == end)
		{
			if (maxEdge < 0 || depth < maxEdge)
			{
				maxEdge = depth;
			}
			return;
		}
		visit[v] = true;
		for (int i = 1; i <= vertex; i++) 
		{
			if (map[v][i] == 1 && !visit[i]) 
			{
				depthFirstSearch(i, depth + 1);
				visit[i] = false;
			}
		}		
	}
	
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++)
		{
			vertex = sc.nextInt();
			edge = sc.nextInt();
			start = sc.nextInt();
			end = sc.nextInt();
			for (int i = 0; i < edge; i++)
			{
				int v1 = sc.nextInt();
				int v2 = sc.nextInt();
				map[v1][v2] = 1;
			}
			maxEdge = -1;
			depthFirstSearch(start, 0);
			System.out.printf("#%d %d\n", test_case, maxEdge);
		}
		sc.close();
	}
}