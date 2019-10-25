package Algorithm;

import java.util.Scanner;

class BFS_Searching {

	static final int MAX_VERTEX = 30;

	static int num;
	static int map[][];
	static int visit[];
	static int queue[];
	static int rear, front;

	static void breadthFirstSearch(int vertex)
	{
		visit[vertex] = 1; 
		System.out.print(vertex + " ");
		queue[rear++] = vertex;
		while (front < rear)
		{
			vertex = queue[front++];
			for (int i = 1; i <= num; i++)
			{
				if (map[vertex][i] == 1 && visit[i] == 0)
				{
					visit[i] = 1;
					System.out.printf("%d ", i);
					queue[rear++] = i;
				}
			}
		}
	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++)
		{
			map = new int[MAX_VERTEX][MAX_VERTEX];
			visit = new int[MAX_VERTEX];
			queue = new int[MAX_VERTEX];
			
			num = sc.nextInt();
			int start = sc.nextInt();

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
			breadthFirstSearch(start);
			System.out.printf("\n");
		}
		
		sc.close();
	}
}