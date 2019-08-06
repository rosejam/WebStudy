package stack2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_백준_2493_탑_서울9반_김동주 { //탑의 번호는 인덱스+1

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_BJ_2493.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		String line = br.readLine(); 
		br.close();
		String[] sa = line.split(" ");
		int[] T = new int[num];
		int[] N = new int[num];
		for(int i=0; i<num; i++) {
			T[i] = Integer.parseInt(sa[i]); //int array로 만듬
			for(int j=i-1; j>=0; j--) {
				if(T[j]>=T[i]) {
					N[i]=j+1;
					break;
				}
			}
		}
		for(int i=0; i<num-1; i++) System.out.print(N[i]+" ");
		System.out.print(N[num-1]);
	}
}
/*
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
			int height = Integer.parseInt(st.nextToken());
			while(top > -1 && stack[top] <= height){
				top--;
			}
			if(top == -1){
				sb.append(0);
			} else{				
				sb.append(index[top] + 1);
			}
			top++;	
			stack[top] = height;
			index[top] = i;
			if(i != n - 1) sb.append(" ");
		}
		System.out.print(sb);
	}
}
*/
