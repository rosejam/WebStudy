package list;

public class PriorityLinkedQueueTest {
	public static Node front = null;
	public static Node rear = null;
	
	public static boolean isEmpty() {
		if(front == null) 	return true;
		else 				return false;
		//return front == rear;
	}
	public static void enqueue(int item) { //"insertion sort"를 적용시켜서 넣는다.
		Node n = new Node();
		n.data = item;

		if(isEmpty()) {
			front = n;
			rear = n;
		}else {
			//rear.link=n;
			//rear = n;
			///////////////////////
			if(front.data>item) {
				n.link=front;
				front=n;
			}else {
				Node t = front;
				while(t.link!=null) {
					if(t.link.data>item) { //찾으면
						n.link=t.link;
						t.link=n;
						return; //while을 빠져나가기 위함
					}else {
						t=t.link;
					}
				}
				t.link=n;
				rear=n; //append
			}
			//////////////////////
		}
	}
	public static int dequeue() {
		if(isEmpty()) {
			System.out.println("Queue Empty");
			return -1; 
		}
		int item = front.data;
		front = front.link;
		if(isEmpty()) rear = null;
		return item;
	}
	public static int qpeek() {
		if(isEmpty()) {
			System.out.println("Queue Empty");
			return -1; 
		}
		int item = front.data;
		//front = front.link;
		//if(isEmpty()) rear = null;
		return item;
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
