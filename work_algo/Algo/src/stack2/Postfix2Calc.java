package stack2;

import java.util.Stack;

public class Postfix2Calc {
	public static String msg = "6528-*2/+"; //-9
	public static Stack<Integer> stack = new Stack<Integer>();
	
	public static void main(String[] args) {
		//for(int i=0; i<msg.length(); i++) {
		for(char c : msg.toCharArray()) {
			//char c=msg.charAt(i);
			if ('0'<=c && c<='9') {
				stack.push(c-'0'); //숫자화 //Character.getNumericValue(c)
			}else {
				int n2 = stack.pop();
				int n1 = stack.pop();
				int nn = 0;
				switch(c) {
					case '+' : nn =n1+n2; break;
					case '-' : nn =n1-n2; break;
					case '*' : nn =n1*n2; break;
					case '/' : nn =n1/n2; break;
				}
				stack.push(nn);
			}
		}
		System.out.println(stack.pop());
	}

}
