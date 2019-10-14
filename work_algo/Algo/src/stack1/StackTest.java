package stack1;

import java.util.Stack;

public class StackTest {
	public static int[] stack = new int[100];
	public static int top = -1;
	
	public static boolean push(int value) {
		if(top >= stack.length-1) return false; //full (-1을 내가 붙였다.)
		stack[++top] = value;
		return true;
	}
	public static int pop() {
		if(isEmpty()) {
			System.out.println("Stack Empty");
			return -1; 
		}
		return stack[top--];
	}
	
	public static int peek() {
		if(isEmpty()) {
			System.out.println("Stack Empty");
			return -1; 
		}
		return stack[top];
	}
	
	public static boolean isEmpty() {
		return top==-1;//else임
	}
	public static void main(String[] args) {
		push(1);
		System.out.println(isEmpty());
		push(2);
		push(3);
		System.out.println(pop());
		System.out.println(peek());
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
		System.out.println();
		
		Stack<Character> st = new Stack<>(); //A형이면 그냥 이걸 쓰면 된다.
		st.push('A');
		System.out.println(st.empty());
		st.push('B');
		st.push('C');
		System.out.println(st.pop());
		System.out.println(st.peek());
		System.out.println(st.pop());
		System.out.println(st.pop());
		//System.out.println(stack.pop()); //한번 더빼면 익셉션 발생
		String[] rec = {"1","2"};
		System.out.println(rec.length);
		String[] ans = {};
		

	}

	
}
