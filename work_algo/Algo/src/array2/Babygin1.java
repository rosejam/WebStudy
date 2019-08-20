package array2;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;
//permutation2 사용, nPn
public class Babygin1 {
	public static final int N=6;
	public static int[] n = new int[6];
	public static int[] a = new int[6]; //이 배열들은 계속 쓰니까 한번만 만들자 
	
	public static boolean permutation(int flag, int count) { //p2의 int start는 필요없으니 삭제
		if(count == N){ 
			int tri = 0;
			int run = 0;
			////////무식하게 비교
/*			if(a[0]==a[1] && a[1]==a[2]) tri ++;
			if(a[3]==a[4] && a[4]==a[5]) tri ++;
			if(a[0]+1==a[1] && a[1]+1==a[2]) run++;
			if(a[3]+1==a[4] && a[4]+1==a[5]) run++;*/
			for(int i=0; i<2; i++) { //모든 순열을 3개/3개 앞뒤로 갈라서 tri와 run 여부를 판별한다.
				if(a[3*i] == a[3*i+1] && a[3*i+1] == a[3*i+2]) tri++;
				if(a[3*i]+1 == a[3*i+1] && a[3*i+1]+1 == a[3*i+2]) run++;
			}
			////////
			if(tri+run ==2) return true;
			else return false; //
		} 
		for(int i=0; i<N; i++) { 
			if((flag&(1<<i))==0) {
				a[count]=n[i];
				if(permutation(flag|(1<<i),count+1)) return true; //!!!!
			}
		}
		return false; //
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_babygin.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			for(int i=0; i<N; i++) n[i] = sc.nextInt(); //input6numbers
			System.out.println("#" + tc +" "+ permutation(0,0));
		}
		sc.close();
	}

}
