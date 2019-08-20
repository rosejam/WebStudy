package array2;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;
//32쪽
public class Babygin2 {
	public static final int N=6;
	public static int[] n = new int[6];
	public static int[] a = new int[6];
	public static int[] c; //이 배열들은 계속 쓰니까 한번만 만들자 
	//그리디
	public static boolean solve() { //p2의 int start는 필요없으니 삭제
		int tri = 0;
		int run = 0;
		for(int i=0; i<c.length; i++) {
			if(c[i]>=3) {
				c[i] = c[i] -3;
				tri++;
				i--;
			}else if(i<=7&&c[i]>=1&&c[i+1]>=1&&c[i+2]>=1) { //범위가 넘지 않게 i가 7이하로 //i<=7이 앞에와야 하는지? 확인하자
				c[i]--;
				c[i+1]--;
				c[i+2]--;
				run++; i--;
			}
		}
		if(tri+run ==2) return true;
		else return false; //
	}

	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_babygin.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			c = new int[10];
			for(int i=0; i<N; i++) {
				n[i] = sc.nextInt();
				c[n[i]]++;
			}
			System.out.println("#" + tc+ " " + solve());
		}
		sc.close();
	}

}
