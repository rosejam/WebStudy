package dcbacktracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_정올_1335_색종이만들기_서울9반_김동주_미완 {
	public static boolean[][] blue;
	public static int ws, bs;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_JO_1335.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()); //2^1~2^7
		int M = (int) (Math.log(N)/Math.log(2)); //M번쪼개면 1개로 나뉘어짐
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
		//쪼개기 시작
		for(int m=M-1; m>=0; m--) {//2^M-1~2^0개
			for(int n=0;n<M-m;n++){ //2^1~2^M크기
				
			}
		}
		
		System.out.println(ws);//하양
		System.out.print(bs); //파랑
	}
	public static void dividing() {
		
	}
	public static boolean ifsame() {
		
		return false;
	}
}
