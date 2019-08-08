package list;

import java.util.LinkedList;
import java.util.Queue;

public class PriorityQueueTest {
	public static int[] queue = new int[100];
	public static int front = -1;
	public static int rear = -1;
	
	public static boolean isEmpty() {
		if(front == rear) return true;
		else return false;
		//return front == rear;
	}
	public static boolean isFull() {
		if(rear == queue.length-1) return true;
		else return false;
	}
	public static void enqueue(int item) { //"insertion sort"를 적용시켜서 넣는다.
		if(isFull()) {
			System.out.println("Queue Full");
			return;
		}
		queue[++rear]=item; 
		////////////////////////
		int k=rear;
		for(int j=rear-1; j>=0; j--) { 
			if(queue[j]>queue[k]) {
				int T=queue[j]; queue[j]=queue[k]; queue[k]=T; //
				k=j; //스왑
			}
		}
		////////////////////////
	}
	public static int dequeue() {
		if(isEmpty()) {
			System.out.println("Queue Empty");
			return -1; //이렇게 밖에 표현못하나.
		}
		return queue[++front]; //먼저 1더하고 수행
	}
	public static int qpeek() {
		if(isEmpty()) {
			System.out.println("Queue Empty");
			return -1; //
		}
		return queue[front+1]; //front는 그대로 둠
	}
	
	public static void main(String[] args) {
		enqueue(2);
		enqueue(3);
		enqueue(1);
		System.out.println(qpeek());
		System.out.println(dequeue());
		System.out.println(dequeue());
		System.out.println(dequeue());
		System.out.println(dequeue());
		System.out.println();
		
	}
}
