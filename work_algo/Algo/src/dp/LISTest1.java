package dp;

import java.util.Arrays;

public class LISTest1 {
	public static void main(String[] args) {
		int[] a = {3,2,6,4,5,1};
		int n = a.length;
		
		int[] l = new int[n];
		int max = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			l[i]=1;
			for(int j=0; j<i; j++) {
				if(a[j]<a[i] && l[i]<1+l[j]) {
					 			l[i]=1+l[j];
				}
			}
			max = Math.max(max, l[i]);
		}
		System.out.println(max);
		//System.out.println(Arrays.stream(l).max().getAsInt()); //이 한줄로 어레이의 최대값을 구할 수 있다.
		System.out.println(Arrays.toString(l));
	}
}
