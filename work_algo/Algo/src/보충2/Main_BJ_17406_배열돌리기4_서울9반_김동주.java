package 보충2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_17406_배열돌리기4_서울9반_김동주 {
	public static int N,M,K,Ans;
	public static int[][] A,B;//,C;
	public static int[] r,c,s,d;
	public static void main(String[] args) throws Exception{
		System.setIn(new java.io.FileInputStream("res/input_BJ_17406.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		A = new int[N][M];
		B = new int[N][M]; //copy용
		//C = new int[N][M]; //copy용
		r = new int[K];
		c = new int[K];
		s = new int[K]; //이 세개를 하나의 클래스로 정의해도 된다.
		d = new int[K]; //순서 정하는 용도(순열의 인덱스를 가지고 있는 배열)
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			int m=0;
			while(st.hasMoreTokens()) {
				A[n][m++] = Integer.parseInt(st.nextToken());
			}
			//System.out.println(Arrays.toString(A[n]));
		}//A를 받음
		for(int k=0; k<K; k++) {
			st = new StringTokenizer(br.readLine());
			r[k] = Integer.parseInt(st.nextToken())-1;
			c[k] = Integer.parseInt(st.nextToken())-1;
			s[k] = Integer.parseInt(st.nextToken());
			d[k]=k;
			//System.out.println(r[k]);
		}//회전방법 k개를 받음
		//입력 끝
		
		Ans=Integer.MAX_VALUE;
		perm(0);
		//1.K의 순서 K!을 구하자 
		//2.회전연산
		//3.A의 값을 구하면서 최소값 갱신
		System.out.println(Ans); //배열 A의 값의 최솟값을 출력한다.
	}
	public static void swap(int i, int j) {
		if(i==j) return;
		int T=d[i]; d[i]=d[j]; d[j]=T;
	}
	public static void perm(int depth) {
		////K배열이 만들어 졌을 때 돌리는게 아니고 
		if(depth == K) {
			//1.완성 K!번
			B = copy(A); //매 K순서 시작 전 카피해서 초기화 하고 시작
			kturn(B);//2.
			return;
		}
		for(int k=depth; k<K; k++) {
			swap(depth,k);
			perm(depth+1);
			swap(depth,k);
		}
	}
	public static void kturn(int[][] br) {
		for(int k=0; k<K; k++) {
			turnforreal(br, d[k]);
		}//만든 순서대로 K번 돌리기
		//int a = getA(br); //A를 구하기
		getA(br);
		//if(Ans>a) Ans = a; //3.
	}
	public static void turnforreal(int[][] B, int dk) { //돌리기...ㅜㅜ어렵
		int rr = r[dk];
		int cc = c[dk];
		int ss = s[dk];

		for(int s=1; s<=ss; s++) {
			int temp = B[rr-s][cc-s]; //처음꺼 빼놓기(덮어씌워지므로)
			int S = s*2+1; //한변의 길이 s번째에서
			for(int i=1; i<S; i++) { //하
				B[rr-s+i-1][cc-s] = B[rr-s+i][cc-s];
			}
			for(int i=1; i<S; i++) { //우
				B[rr+s][cc-s+i-1] = B[rr+s][cc-s+i];
			}
			for(int i=1; i<S; i++) { //상
				B[rr+s-i+1][cc+s] = B[rr+s-i][cc+s];
			}
			for(int i=1; i<S-1; i++) { //좌 //S-1
				B[rr-s][cc+s-i+1] = B[rr-s][cc+s-i];
			}
			B[rr-s][cc-s+1] = temp; //마지막에 여기다 넣기
		}
	}
	public static int[][] copy(int[][] ar){
		for(int i=0; i<N; i++) {
			System.arraycopy(ar[i],0,B[i],0, M); //pass by value
		}
		return B;
	}
	public static void getA(int[][] br) {
		//int min=Integer.MAX_VALUE; //필요없고 그냥 계속 Ans와 비교하면 된다! 최소값의 최소값이므로!
		for(int n=0; n<N; n++) {
			int as=0; //매행의 합!
			for(int m=0; m<M; m++) {
				as += br[n][m];
			}
			if(Ans>as) Ans = as;
		}
		//return Ans;
	}
}
