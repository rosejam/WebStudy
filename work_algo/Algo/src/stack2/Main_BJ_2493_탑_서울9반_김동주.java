package stack2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2493_탑_서울9반_김동주 { //탑의 번호는 인덱스+1 //원래 스택으로 푸는 문제임.
	public static int[] tower;
	public static void main(String[] args) throws Exception {
/*		System.setIn(new FileInputStream("res/input_BJ_2493.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] T = new int[num];
		int[] N = new int[num];
		
		String line = br.readLine(); 
		StringTokenizer st = new StringTokenizer(line);
		for(int i=0; i<num; i++) {
			T[i] = Integer.parseInt(st.nextToken()); //int array로 만듬 //sa[i]
			for(int j=i-1; j>=0; j--) {
				if(T[j]>=T[i]) {
					N[i]=j+1;
					break;
				}
			}
		}
		for(int i=0; i<num-1; i++) System.out.print(N[i]+" ");
		System.out.print(N[num-1]);
		br.close();	*/
		
		//스택으로 다시 풀어보자
		System.setIn(new FileInputStream("res/input_BJ_2493.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		tower = new int[num];
		int index=0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			tower[index++] = Integer.parseInt(st.nextToken());
		}
		
	}
}
/* 모범답안
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String... args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder(n);
		int[] stack = new int[n];
		int[] index = new int[n];
		int top = -1;
		for(int i = 0; i < n; i++){
			int height = Integer.parseInt(st.nextToken()); //arr[i] = Integer.parseInt(sa[i]);
			while(top > -1 && stack[top] <= height){ //while(!stack.empty() && arr[stack.peek()] < arr[i])
				top--; //stack.pop();
			}
			if(top == -1){ //stack.empty()
				sb.append(0);
			} else{				
				sb.append(index[top] + 1); //sysout(stack.peek()+1)
			}
			top++;	 //
			stack[top] = height; //
			index[top] = i;     //stack.push(i);
			if(i != n - 1) sb.append(" "); 
		}
		System.out.print(sb);
	}
}
*/
