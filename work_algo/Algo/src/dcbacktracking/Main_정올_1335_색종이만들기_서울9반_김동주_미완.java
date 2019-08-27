package dcbacktracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_정올_1335_색종이만들기_서울9반_김동주_미완 {
	public static boolean[][] blue;
	public static int ws, bs;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_JO_1335.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()); //2^1~2^7
		int M = (int) (Math.log(N)/Math.log(2)); //M번 쪼개면(4부분으로 나누면) 1개씩으로 나뉘어짐
		blue = new boolean[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				if(st.nextToken().equals("1")) {
					blue[i][j] = true;
				}
			}
		} //내용 다 가져옴
		//System.out.println(Arrays.toString(blue[7]));
		//작은 부분부터
		for(int m=M-1; m>=0; m--) {//2^(M-1)~2^0개의 조각
			for(int n=0;n<M-m;n++){ //2^1~2^M크기
				//dividing(m, );
			}
		}
		dividing(blue, M);
		System.out.println(ws);//하양
		System.out.print(bs); //파랑
	}
	public static boolean[][] dividing(boolean[][] whole, int m) { //변이 2^m을넣는다.
		if(m==1) return whole;
		boolean[][] quarter1 = new boolean[m/2][m/2];
		boolean[][] quarter2 = new boolean[m/2][m/2];
		boolean[][] quarter3 = new boolean[m/2][m/2];
		boolean[][] quarter4 = new boolean[m/2][m/2];
		for(int x=0; x<4; x++) {
			dividing(half, m-1);
		}
/*		if(m.size()==1) return m;
		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();
		int mid = m.size()/2; //분할
		
		for(int i=0; 	i<mid; 		i++) left.add(m.get(i));
		for(int i=mid; 	i<m.size(); i++) right.add(m.get(i));
		
		left = mergesort(left); //정복
		right = mergesort(right); //정복
		return merge(left, right); //병합
		//System.out.println(Arrays.toString(a));
*/	}
	public static boolean[][] merging() {
		
	}
	public static boolean ifsame() {
		
		return false;
	}
}
