package brutegreedy;

import java.util.Arrays;
import java.util.Scanner;

//중복순열 2PIr = 2^r

public class PowerSet2 {
	public static int n, r, cnt, a[], v[], d[]={0,1};
	public static char[] c= {'A','B','C','D'};
	
	public static void powerset(int count) { //count는 레벨(깊이)를 의미한다.
		if(count == r){ //가장 깊은 레벨에 도달하면 return
			cnt++; //그냥 가지의 개수를 세는 용도
			System.out.print(Arrays.toString(a)+" ");
			for(int i=0;i<r;i++) {
				if(a[i]==1) System.out.print(c[i]+" ");
			}
			System.out.println();
			return;
		}
		////////////////
		a[count]=d[0];        
		powerset(count+1); 
		a[count]=d[1];        
		powerset(count+1); 
		////////////////
	} 
	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		n = d.length; //2
		r = c.length; //4
		v = new int[n]; 
		a = new int[r]; //데이터를 담으려함
		powerset(0); //조합에 이용하기 위해 start 0도 받는다.
		System.out.println(cnt); //
		//sc.close();
	}
}
