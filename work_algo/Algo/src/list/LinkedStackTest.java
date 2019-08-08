package list;

public class LinkedStackTest {
	//public static int top = -1;
	public static Node top = null; //맨앞의 Node
	
	public static void push(int value) { //full체크는 필요없어짐ㄴ
		Node n = new Node();
		n.data=value;
		n.link=top;
		top=n;
	}
	public static int pop() {
		if(isEmpty()) {
			System.out.println("Stack Empty");
			return -1; 
		}
		int value=top.data;
		top=top.link;
		return value;
	}
	
	public static int peek() {
		if(isEmpty()) {
			System.out.println("Stack Empty");
			return -1; 
		}
		int value=top.data;
		//top=top.link;
		return value;
	}
	
	public static boolean isEmpty() {
		return top==null;
	}
	public static void main(String[] args) {
		push(1);
		push(2);
		push(3);
		System.out.println(pop());
		System.out.println(peek());
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
		System.out.println();
	}
}
