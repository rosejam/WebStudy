package stack2;

import java.util.Arrays;

public class QuickSort {
	//public static int[] a= {69,10,30,2,16,8,31,22};
	public static int[] a= {69,19,40,2,16,8,31,22};
	
	public static int partition(int begin, int end) {
		int P = (begin+end)/2; //임시 pivot
		int L = begin;
		int R = end;
		
		while(L<R) {
			while(a[L]<a[P] && L<R) L++; //L<R부분은 빠져도 괜찮음
			while(a[R]>=a[P] && L<R) R--; //등호가 있으므로 피봇을 지나 갈 수 있다.
			if(L<R) {
				if(L==P) P=R; //이 부분이 교재에서 빠짐(빠지면 안됨!!!)
				int T=a[L]; a[L]=a[R]; a[R]=T;
			}
		}
		int T=a[P]; a[P]=a[R]; a[R]=T;
		return R;
	}
	public static void quick(int begin, int end) {
		if(begin<end) {
			int p = partition(begin,end);
			quick(begin, p-1);
			quick(p+1, end);
		}
	}
	public static void main(String[] args) {
		System.out.println(Arrays.toString(a));
		quick(0,a.length-1);
		System.out.println(Arrays.toString(a));
	}
}
