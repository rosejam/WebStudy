package stack2;

import java.util.Scanner;

public class NQueen {
	public static int N;
	public static int result;
	public static int[] col; //인덱스를 i, 안에들어 있는 값을 j라고 생각하면 2차원평면을 1차원 배열로 표현가능
	
	private static boolean promising(int i) {
		for(int j=0; j<i; j++) {
			if(col[j]==col[i] || Math.abs(col[i]-col[j])==(i-j)) return false; //같은 열에 있는지 || 대각선에 있는지
		}
		return true;
	}
	private static void nqueen(int i, String ij) {
		if(i==N) {
			result++;
			System.out.println(ij);//출력용
			return;
		}
		for(int j=0; j<N; j++) {
			col[i]=j;
			if(promising(i)) { //가지치기(확인후 재귀호출하기)
				nqueen(i+1,ij+"("+i+","+col[i]+") "); //출력용
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N];
		nqueen(0,"");
		System.out.println(result);
	}
}
