package 문제풀이_PS;

import java.util.Scanner;

public class Main_JO_1719_별삼각형2_서울9반_김동주_끝_ {
	public static int T,N,M;
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_D1_2056.txt"));
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		N = sc.nextInt();
		M = sc.nextInt();
		if(N>99 || N<1 || N%2 ==0) sb.append("INPUT ERROR!");
		else {
			switch (M) {
			case 1:
				for(int i=0; i<=N/2; i++) {
					for(int j=0; j<=i; j++) {
						sb.append('*');
					}
					sb.append('\n');
				}
				for(int i=N/2-1; i>=0; i--) {
					for(int j=0; j<=i; j++) {
						sb.append('*');
					}
					sb.append('\n');
				}
				
				break;
			case 2:
				for(int i=0; i<=N/2; i++) {
					for(int j=0; j<N/2-i; j++) {
						sb.append(' ');
					}
					for(int j=0; j<i+1; j++) {
						sb.append('*');
					}
					sb.append('\n');
				}
				for(int i=N/2-1; i>=0; i--) {
					for(int j=0; j<N/2-i; j++) {
						sb.append(' ');
					}
					for(int j=0; j<i+1; j++) {
						sb.append('*');
					}
					sb.append('\n');
				}
				
				break;
			case 3:
				for(int i=0; i<=N/2; i++) {
					for(int j=0; j<i; j++) {
						sb.append(' ');
					}
					for(int j=0; j<N-2*i; j++) {
						sb.append('*');
					}
					sb.append('\n');
				}
				for(int i=N/2-1; i>=0; i--) {
					for(int j=0; j<i; j++) {
						sb.append(' ');
					}
					for(int j=0; j<N-2*i; j++) {
						sb.append('*');
					}
					sb.append('\n');
				}
				
				break;
			case 4:
				for(int i=0; i<=N/2; i++) {
					for(int j=0; j<i; j++) {
						sb.append(' ');
					}
					for(int j=0; j<=N/2-i; j++) {
						sb.append('*');
					}
					sb.append('\n');
				}
				for(int i=N/2-1; i>=0; i--) {
					for(int j=0; j<N/2; j++) {
						sb.append(' ');
					}
					for(int j=0; j<=N/2-i; j++) {
						sb.append('*');
					}
					sb.append('\n');
				}
				
				break;
			default:
				sb.append("INPUT ERROR!");
				break;
			}
		}
		System.out.print(sb);
	}

}
