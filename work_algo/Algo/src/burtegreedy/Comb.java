package burtegreedy;

import java.util.Arrays;
import java.util.Scanner;

//조합 nCr =nPr/r!,  5C3 = 5P3/3! = 5*4*3/3*2*1 :10

public class Comb {
	public static int n, r, cnt, a[], d[]={1,2,3,4,5};
	
	public static void comb (int n, int r) { //count는 레벨(깊이)를 의미한다.
		if(r==0){ 
			cnt++;
			System.out.println(Arrays.toString(a));
			return;
		}else if(n<r) return;
		a[r-1] = d[n-1];
		comb(n-1, r-1);
		comb(n-1, r);
	} 
	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		n = 5;
		r = 2;
		a = new int[r]; //데이터를 담으려함
		comb(n, r); //조합에 이용하기 위해 start 0도 받는다.
		System.out.println(cnt); //
		//sc.close();
	}
}
