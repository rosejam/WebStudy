package array2;

import java.util.Arrays;
import java.util.Scanner;

//중복조합 nHr =n+r-1Cr,  5H3 = 5+3-1C3 = 7C3 = 7P3/3!
public class Homogeneous {
	public static int n, r, cnt, a[];
	
	public static void homogeneous(int start, int count) {
		if(count == r){
			cnt++;
			System.out.println(Arrays.toString(a));
			return;
		}
		for(int i=start; i<=n; i++) { //조합은 1이 아닌 start부터 시작
			a[count]=i;
			homogeneous(i, count+1);
		}
		
	} //count 0,1,2자리에 DFS?로 입력 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = 5; //sc.nextInt();
		r = 3; //sc.nextInt();
		a = new int[r];
		homogeneous(1, 0);
		System.out.println(cnt);
		sc.close();
	}

}
