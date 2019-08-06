package stack2;

import java.util.Stack;

public class In2Postfix {
	public static String msg1 = "(6+5*(2-8)/2)"; //"6528-*2/+"
	public static String msg = "2 + 3 * 4 / 5"; //234*5/+
	public static Stack<Character> stack = new Stack<Character>();
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<msg.length(); i++) {
			char c=msg.charAt(i);
			if ('0'<=c && c<='9') { //(Character.isDigit(c)) //숫자이면
				sb.append(c);
			}else if(c == ' ') { //공백일때 스킵하는 부분
			}else if(c == ')') {
				char s='\u0000'; //유니코드의 null문자로 초기화하였다. 2바이트.
				while((s=stack.pop())!= '(') {
					sb.append(s);
				}
			}else { //연산자 +-*/들
				while(getIcp(c)<=getIsp()) {
					sb.append(stack.pop());
				}
				stack.push(c);
			}
		}
		while(!stack.empty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb.toString());
	}
	public static int getIcp(char c) {
		switch(c) {
			case '+':
			case '-':
				return 1;
			case '*':
			case '/':
				return 2;
			case '(':
				return 3;
			default : 
				return 0;
		}
	}
	public static int getIsp() { //스택
		char c = stack.empty()? '\u0000' : stack.peek();
		switch(c) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '(':
			return 0;
		default : 
			return 0;
		}
	}
}
