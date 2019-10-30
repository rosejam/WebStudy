package queue;

import java.util.LinkedList;
import java.util.Queue;

public class _QueueCircular {
	public static int n =3; 
	public static int[] queue = new int[n];
	public static int front = 0;
	public static int rear = 0;
	
	public static boolean isEmpty() {
		if(front == rear) return true;
		else return false;
		//return front == rear;
	}
	public static boolean isFull() {
		if((rear+1)%n == front) return true; //rear가 front보다 1작으면 Full(1칸은 사용안함) //n-1개의 데이터 넣을수 있음
		else return false;
	}
	public static void enqueue(int item) {
		if(isFull()) {
			System.out.println("Queue Full");
			return;
		}
		//rear++;
		queue[(++rear)%n]=item; //%n (0~n-1)
	}
	public static int dequeue() {
		if(isEmpty()) {
			System.out.println("Queue Empty");
			return -1; //이렇게 밖에 표현못하나.
		}
		return queue[(++front)%n]; //%n
	}
	public static int qpeek() {
		if(isEmpty()) {
			System.out.println("Queue Empty");
			return -1; //이렇게 밖에 표현못하나.
		}
		return queue[(front+1)%n]; //%n
	}
	
	public static void main(String[] args) {
		enqueue(1);
		enqueue(2);
		enqueue(3);
		System.out.println(qpeek());
		System.out.println(dequeue());
		System.out.println(dequeue());
		System.out.println(dequeue());
		System.out.println();
	}
}
