package array2;

import java.util.Arrays;
import java.util.Scanner;

//조합 nCr =nPr/r!,  5C3 = 5P3/3! = 5*4*3/3*2*1
public class Combination {
	public static int n, r, cnt, a[];
	
	public static void combination(int start, int count) {
		if(count == r){
			for(int i=0; i<r; i++) { 
				for(int j=i+1; j<r; j++) {
					if(a[i]==a[j]) return;
				}
			} // 이 부분을 중복되지 않도록 추가해준다!!(중복조합이 아닌 조합)
			cnt++;
			System.out.println(Arrays.toString(a));
			return;
		}
		for(int i=start; i<=n; i++) { //조합은 1이 아닌 start부터 시작
			a[count]=i;
			combination(i, count+1); //i 추가
		}
		
	} //count 0,1,2자리에 DFS?로 입력 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = 5; //sc.nextInt();
		r = 3; //sc.nextInt();
		a = new int[r];
		combination(1,0); //1추가
		System.out.println(cnt);
		sc.close();
	}

}
