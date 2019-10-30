package Algorithm;

import java.util.Scanner;

class _DFS_Searching {

	static final int MAX_VERTEX = 30;

	static int vertex;
	static int map[][] = new int[MAX_VERTEX][MAX_VERTEX];
	static int visit[] = new int[MAX_VERTEX];

	static void depthFirstSearch(int v)
	{
		visit[v] = 1;
		for (int i = 1; i <= vertex; i++)
		{
			if (map[v][i] == 1 && visit[i] == 0)
			{
				System.out.printf("%d ", i);
				depthFirstSearch(i);
			}
		}
	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++)
		{
			vertex = sc.nextInt();
			int start = sc.nextInt();

			map = new int[MAX_VERTEX][MAX_VERTEX];
			visit = new int[MAX_VERTEX];
			
			while (true)
			{
				int v1 = sc.nextInt();
				int v2 = sc.nextInt();
				if (v1 == -1 && v2 == -1)
				{
					break;
				}
				map[v1][v2] = map[v2][v1] = 1;
			}
			System.out.printf("#%d ", test_case);
			System.out.printf("%d ", start);
			depthFirstSearch(start);
			System.out.printf("\n");
		}

		sc.close();
	}
}