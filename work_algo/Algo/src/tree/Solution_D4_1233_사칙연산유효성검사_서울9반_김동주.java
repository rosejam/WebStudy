package tree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_D4_1233_사칙연산유효성검사_서울9반_김동주 {
	public static int N;
	//public static int n;
//	public static char[] a;
	public static int[] node;
	public static StringBuilder sb;
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("res/input_D4_1233.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		sb = new StringBuilder();
		
loop:	for(int tc = 1; tc <= 10; tc++){
			N = Integer.parseInt(br.readLine());
			//a = new char[N+1];
			node = new int[N+1];
			for(int i=1; i<=N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				//n = Integer.parseInt(st.nextToken());
				st.nextToken();
				char op = st.nextToken().charAt(0);
/*				if((N%2==0 && (i<N/2)) || (N%2==1 && (i<=(N-1)/2))){
				}else if(N%2==0 && i==N/2) {
				}*/
				node[i] = op;
			}
			//
            int nn = (N % 2 == 0) ? N / 2 : (N - 1) / 2;
            for (int i = 1; i <= nn; i++) { //반 이하는 연산자아니면 0;
                if (!(node[i] == '+' || node[i] == '-' || node[i] == '*' || node[i] == '/')) {
                	sb.append("#" + tc + " 0" + "\n");
                    continue loop;
                }
            }
            for (int i2 = (nn) + 1; i2 <= N; i2++) { //반 초과는 숫자아니면 0; 
                if (node[i2] < '0' || '9' < node[i2]) {
                	sb.append("#" + tc + " 0" + "\n");
                    continue loop;
                }
            }
            sb.append("#" + tc + " 1" + "\n"); //그 다음 0에 안결렸을 경우 1;
		}
		System.out.println(sb);
		br.close();
	}
}

