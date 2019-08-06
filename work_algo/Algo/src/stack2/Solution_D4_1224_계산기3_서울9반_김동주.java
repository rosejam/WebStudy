package stack2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
 
public class Solution_D4_1224_계산기3_서울9반_김동주 {
    public static char[] line;
    public static int num;
    public static char ch;
    public static Stack<Character> stack;
    public static Stack<Integer> stack2;
     
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("res/input_D4_1224.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //시간 감소
        for(int tc = 1; tc <= 10; tc++){
            StringBuilder sb = new StringBuilder(); //시간 감소
            num = Integer.parseInt(br.readLine());
            line = br.readLine().toCharArray(); 
            stack = new Stack<Character>();
            stack2 = new Stack<Integer>();
            for(int i =0 ; i< num; i++) {
                ch =line[i];
                if ('0'<=ch && ch<='9') { //(Character.isDigit(c)) //숫자이면
                    sb.append(ch);
                }else if(ch == ' ') { //공백일때 스킵하는 부분
                }else if(ch == ')') {
                    char s='\u0000'; //유니코드의 null문자로 초기화하였다. 2바이트.
                    while((s=stack.pop())!= '(') {
                        sb.append(s);
                    }
                }else { //연산자 +-*/들
                    while(getIcp(ch)<=getIsp()) {
                        sb.append(stack.pop());
                    }
                    stack.push(ch);
                }
            }
            while(!stack.empty()) {
                sb.append(stack.pop());
            }
            for(char c : sb.toString().toCharArray()) {
                if ('0'<=c && c<='9') {
                    stack2.push(c-'0'); //숫자화 //Character.getNumericValue(c)
                }else {
                    int n2 = stack2.pop();
                    int n1 = stack2.pop();
                    int nn = 0;
                    switch(c) {
                        case '+' : nn =n1+n2; break;
                        case '-' : nn =n1-n2; break;
                        case '*' : nn =n1*n2; break;
                        case '/' : nn =n1/n2; break;
                    }
                    stack2.push(nn);
                }
            }
            System.out.println("#" + tc + " " + stack2.pop());
        }
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