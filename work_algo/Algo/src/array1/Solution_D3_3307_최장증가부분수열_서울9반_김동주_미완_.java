package array1; //제출할때는 패키지명 삭제!!!

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Solution_D3_3307_최장증가부분수열_서울9반_김동주_미완_{ //제출할 때 클래스명은 솔루션으로 바꿔야함!!! F2키로 파일이름 바꿀수 있음
	public static Stack<Integer> stack;
	static long[] A;
	static long[] V;
	static int N;
	static int cnt;
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_D3_3307.txt")); //제출할때는 입력 삭제!!!
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= T; tc++){
			stack = new Stack<>();
			N = Integer.parseInt(br.readLine()); //수열안의 개수N 
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			A = new long[N];
			V = new long[N];
			//long[][] B = new long[N][N];	
			for(int i=0; i<N; i++) {
				A[i]=Long.parseLong(st.nextToken());
			} //수열A에 다 넣기
			cnt = 0;
			counting(0);
/*			for(int j=0; j<N; j++) {
				B[j][0] = A[j];
				//B[j][1] = A[j];//B의 행에서 0이아닌 길이 중 가장 긴 것
				for(int k=1; k<N-j; k++) {
					int l=0;
					if(A[j+k] > B[j][l]) {
						B[j][l+1] = A[j+k]; // if A[j] 
						l++;
					}	
				}
			} //다양한 B만들기
*/
			//String Y=sc.next(); //수열 -> 공백으로 나누기
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					//System.out.print("#" + tc + " " + B[i][j]);
					System.out.print(B[i][j]);
				}
				System.out.println();
			}
		}
	}
	

	public static int counting(int a) {
		stack.push(a);
		while(!stack.empty()) {
			int curr = stack.pop();
			if(V[curr]!=1) {
				V[curr]=1;
				if(curr == N-1) return cnt;
				for(int d=curr; d<N-1; d++) {
					if(A[d]>A[curr]) {
						cnt++;
						stack.push(d);
					}
				}
			}
		}
		return cnt;
	}
}