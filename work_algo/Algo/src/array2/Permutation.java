package array2;

import java.util.Arrays;
import java.util.Scanner;

//순열 nPr =n*(n-1)*...*(n-r),  5PI3
public class Permutation {
	public static int n, r, cnt, a[];
	
	public static void permutation(int count) {
		if(count == r){
			for(int i=0; i<r; i++) { 
				for(int j=i+1; j<r; j++) {
					if(a[i]==a[j]) return;
				}
			} // 이 부분을 중복되지 않도록 추가해준다!!
			cnt++;
			System.out.println(Arrays.toString(a));
			return;
		}
		for(int i=1; i<=n; i++) {
			a[count]=i;
			permutation(count+1);
		}
		
	} //count 0,1,2자리에 DFS?로 입력 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = 5; //sc.nextInt();
		r = 3; //sc.nextInt();
		a = new int[r];
		permutation(0);
		System.out.println(cnt);
		sc.close();
	}

}
