package array2;

import java.util.Arrays;
import java.util.Scanner;
//비트연산을 이용한 중복체크
//순열 nPr =n*(n-1)*...*(n-r),  5PI3
public class _Permutation2 { //재귀로 표현
	public static int n, r, cnt, a[];
	
	public static void permutation(int start, int flag, int count) { //start는 사용되지 않긴 함 
		if(count == r){ //중복처리 부분은 비트연산으로 대신함
			cnt++;
			System.out.println(Arrays.toString(a));//
			return;
		}
		for(int i=1; i<=n; i++) {
			if((flag&(1<<i))==0) { //반대로 비트가 0일때 찍기 해당비트가 사용되었는지 확인해서 방문안한 부분만 간다(중복처리)
									//배열인덱스가 다르면 다른 값
				a[count]=i;
				permutation(i,flag|(1<<i),count+1); //사용했음을 or로 표시
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
