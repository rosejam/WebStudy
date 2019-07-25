package array2;

import java.util.Arrays;
import java.util.Scanner;

//순열 nPr =n*(n-1)*...*(n-r),  5PI3
public class Permutation2 { //재귀로 표현
	public static int n, r, cnt, a[];
	
	public static void permutation(int start, int flag, int count) {
		if(count == r){ //중복체크부분을 없애고,
			cnt++;
			System.out.println(Arrays.toString(a));
			return;
		}
		for(int i=1; i<=n; i++) {
			if((flag&(1<<i))==0) { //반대로 비트가 0일때 찍기 해당비트가 사용되었는지 확인해서 사용안된 부분만
				a[count]=i;
				permutation(i+1,flag|(1<<i),count+1); //사용했음을 or로 표시
			}
			
		}
		
	} //count 0,1,2자리에 DFS?로 입력 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = 5; //sc.nextInt();
		r = 3; //sc.nextInt();
		a = new int[r];
		permutation(1,0,0);
		System.out.println(cnt);
		sc.close();
	}

}
