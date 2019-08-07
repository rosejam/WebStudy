package stack2;

import java.util.Arrays;
import java.util.Scanner;
//순열 nPr =n*(n-1)*...*(n-r),  5PI3
//중복순열 nPIr =n^r,  5PI3
//조합 nCr =nPr/r!,  5C3 = 5P3/3! = 5*4*3/3*2*1
//중복조합 nHr =n+r-1Cr,  5H3 = 5+3-1C3 = 7C3 = 7P3/3!

public class PermComb {
	public static int n, r, cnt, a[], v[], d[]={1,2,3,4,5};
	
	public static void permcomb(int start, int count) {
		if(count == r){
			cnt++;
			System.out.println(Arrays.toString(a));
			return;
		}
		////////////////
		for(int i=start; i<n; i++) { //start부터 조합. 0부터는 순열!!!!
			if(v[i]==0) { //방문안했을 경우
				v[i]=1; //방문처리
				a[count]=d[i];        ////
				permcomb(i, count+1); ////이 두줄은 항상 유지
				v[i]=0; //방문후 방문해제
			}//v확인 및 사용은 중복부분을 없애는 부분!!!!
		}
		////////////////
	} 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = 5; //sc.nextInt();
		r = 3; //sc.nextInt();
		v = new int[n];
		a = new int[r]; //데이터를 담으려함
		permcomb(0, 0);
		System.out.println(cnt);
		sc.close();
	}

}
