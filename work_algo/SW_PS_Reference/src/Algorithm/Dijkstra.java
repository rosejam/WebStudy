package Algorithm;

import java.util.Scanner;

class Dijkstra
{
	static final int N = 100;
	static final int INF = 100000;
	static int[][] map = new int[N+1][N+1];
	static boolean[] visit = new boolean[N+1];
	static int[] dist = new int[N+1];
	static int vertex;
	static int edge;
	static int start;
	static int end;
	
	public static void dijkstra()
	{
		int v = 0;
		dist[start] = 0;
		for (int i = 1; i <= vertex; i++)
		{
			int min = INF;
			for (int j = 1; j <= vertex; j++)
			{
				if (visit[j] == false && min > dist[j])
				{
					min = dist[j];
					v = j;
				}
			}

			visit[v] = true;

			for (int j = 1; j <= vertex; j++)
			{
				if (dist[j] > dist[v] + map[v][j])
				{
					dist[j] = dist[v] + map[v][j];
				}
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
			start = sc.nextInt();
			end = sc.nextInt();
			edge = sc.nextInt();
			
			for (int i = 1; i <= vertex; i++)
			{
				for (int j = 1; j <= vertex; j++)
				{
					if (i != j)
					{
						map[i][j] = INF;
					}
				}
			}
			
			for (int i = 1; i <= edge; i++) 
			{
				int from = sc.nextInt();
				int to = sc.nextInt();
				int value = sc.nextInt();
				map[from][to] = value;
			}
			
			for (int i = 1; i <= vertex; i++)
			{
				dist[i] = INF;
				visit[i] = false;
			}
			
			dijkstra();
			System.out.printf("#%d %d\n", test_case, dist[end]);
		}
		sc.close();
	}
}