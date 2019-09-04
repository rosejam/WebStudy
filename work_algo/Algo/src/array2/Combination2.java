package array2;

import java.util.Arrays;
import java.util.Scanner;

//조합 nCr =nPr/r!,  5C3 = 5P3/3! = 5*4*3/3*2*1
public class Combination2 { //재귀로 표현
	public static int n, r, cnt, a[];
	
	public static void combination(int start, int flag, int count) {
		if(count == r){ //중복처리 부분은 비트연산으로 대신함
			cnt++;
			System.out.println(Arrays.toString(a));
			return;
		}
		for(int i=start; i<n; i++) { //조합은 1이 아닌 start부터 시작
			if((flag&(1<<i))==0) {
				a[count]=i;
				combination(i, flag|(1<<i), count+1); //i 추가
			}
		}
		
	} //count 0,1,2자리에 DFS?로 입력 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = 5; //sc.nextInt();
		r = 3; //sc.nextInt();
		a = new int[r];
		combination(0,0,0); //1추가
		System.out.println(cnt);
		sc.close();
	}

}
