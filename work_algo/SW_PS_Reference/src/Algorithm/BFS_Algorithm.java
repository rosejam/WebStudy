package Algorithm;

import java.util.Scanner;

class Queue
{
	Point queue[];
	int head;
	int rear;
	
	class Point
	{
		int x;
		int y;
		int c;
		
		public Point(int x, int y, int c)
		{
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}
	
	public Queue(int capacity)
	{
		queue = new Point[capacity];
		head = rear = 0;
	}
	
	boolean isEmpty()
	{
		return (head <= rear);
	}
	
	boolean enqueue(int x, int y, int c)
	{
		queue[head++] = new Point(x, y, c);
		return true;
	}
	
	Point dequeue()
	{
			if (isEmpty())
			{
				return null;
			}
			rear++;
			return queue[rear-1];
	}
}

class BFS_Algorithm
{
	static final int MAX_N = 50;
	static int[][] MAP;
	static int row;
	static int column;
	
	public static int breadthFirstSearch()
	{
		Queue queue = new Queue(MAX_N * MAX_N);
		queue.enqueue(1, 1, 0);
		MAP[1][1] = 0;
		while(!queue.isEmpty())
		{
			Queue.Point p = queue.dequeue();
			if (p.x == column && p.y == row)
			{
				return p.c;
			}
			if (p.x + 1 <= column && MAP[p.x + 1][p.y] != 0)
			{
				queue.enqueue(p.x + 1, p.y, p.c + 1);
				MAP[p.x + 1][p.y] = 0;
			}
			if (p.y + 1 <= row && MAP[p.x][p.y + 1] != 0) 
			{
				queue.enqueue(p.x, p.y + 1, p.c + 1);
				MAP[p.x][p.y + 1] = 0;
			}
			if (p.x - 1 > 0 && MAP[p.x - 1][p.y] != 0) 
			{
				queue.enqueue(p.x - 1, p.y, p.c + 1);
				MAP[p.x - 1][p.y] = 0;
			}
			if (p.y - 1 > 0 && MAP[p.x][p.y - 1] != 0) 
			{
				queue.enqueue(p.x, p.y - 1, p.c + 1);
				MAP[p.x][p.y - 1] = 0;
			}
		}
		return -1;
	}
	
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++)
		{
			row = sc.nextInt();
			column = sc.nextInt();
			MAP = new int[column+1][row+1];
			for (int i = 1; i <= row; i++){
				for (int j = 1; j <= column; j++)
				{
					MAP[j][i] = sc.nextInt();
				}
			}
			System.out.printf("#%d %d\n", test_case, breadthFirstSearch());
		}
		sc.close();
	}
}