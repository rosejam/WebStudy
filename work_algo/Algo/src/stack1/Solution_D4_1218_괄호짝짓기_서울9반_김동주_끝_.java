package stack1;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D4_1218_괄호짝짓기_서울9반_김동주_끝_ {
	
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("res/input_D4_1218.txt")); //제출할때는 입력 삭제!!!
		Scanner sc = new Scanner(System.in);
		int istrue = 1; //1또는 0
		int len = 0; 
		int top = -1;
		
		for(int tc = 1; tc <= 10; tc++)
		{
			len = sc.nextInt(); //길이 len 가져올지말지
			sc.nextLine();
			String X = sc.nextLine();
			byte[] stack = new byte[len];
			top = -1;
			istrue = 1;
			//System.out.println(X.length == len);//true
			for(int i =0; i<len; i ++) {
				switch (X.charAt(i)) {
					case '(':
						if(top < stack.length) stack[++top] = 1;
						break;
					case ')':
						if((top != -1)&&(stack[top] == 1)) {
							top--;
						}else {
							istrue = 0;
							break;
						}
						break;
					case '[':
						if(top < stack.length) stack[++top] = 2;
						break;
					case ']':
						if((top != -1)&&(stack[top] == 2)) {
							top--;
						}else {
							istrue = 0;
							break;
						}
						break;
					case '{':
						if(top < stack.length) stack[++top] = 3;
						break;
					case '}':
						if((top != -1)&&(stack[top] == 3)) {
							top--;
						}else {
							istrue = 0;
							break;
						}
						break;
					case '<':
						if(top < stack.length) stack[++top] = 4;
						break;
					case '>':
						if((top != -1)&&(stack[top] == 4)) {
							top--;
						}else {
							istrue = 0;
							break;
						}
						break;
					
					default:
						break;
				} //(일때 모두 push, )일 떄 모두 pop해서 비교하는 내용으로 만들면 된다. Stack 클래스 사용
			}
			
			System.out.println("#" + tc + " "+ istrue);

		}
		sc.close();
	}
}