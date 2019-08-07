package stack2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D3_2806_NQueen_서울9반_김동주 {
	public static int N;
	public static int result;
	public static int[] col;
	
	private static boolean promising(int i) {
		for(int j=0; j<i; j++) {
			if(col[j]==col[i] || Math.abs(col[i]-col[j])==(i-j)) return false; //같은 열에 있는지 || 대각선에 있는지
		}
		return true;
	}
	private static void nqueen(int i) {
		if(i==N) {
			result++;
			return;
		}
		for(int j=0; j<N; j++) {
			col[i]=j;
			if(promising(i)) nqueen(i+1); //가지치기(확인후 재귀호출하기)
		}
		
	}
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("res/input_D3_2806.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		String line = br.readLine(); //라인단위로 String으로 읽어들임.
		
		int T = Integer.parseInt(line);
		
		for(int tc = 1; tc <= T; tc++){
			String n = br.readLine(); 
			N = Integer.parseInt(n); //여기서 int로 선언하면 안되고 static변수에 대입해야함!
			col = new int[N];
			result=0; //다음 tc에서 다시 0부터 시작하게 해야함!
			nqueen(0);
			System.out.println("#" + tc + " " + result);
		}
		br.close();
	}
}
