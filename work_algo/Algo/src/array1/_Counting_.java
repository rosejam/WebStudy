package array1;

import java.util.Arrays;

public class _Counting_ {
	public static void main(String[] args) {
		int[] a = {0,4,1,3,1,2,4,1};
		int k = Arrays.stream(a).max().getAsInt(); // a배열의 최대값~~
		int[] c = new int[k+1]; //count배열
		int[] s = new int[a.length]; //sorted배열
		
		for(int i=0; i<a.length; i++) c[a[i]]++; //a의 값을 c의 인덱스로 사용!
		for(int i=1; i<c.length; i++) c[i] += c[i-1]; //c를 누적
		for(int i=0; i<a.length; i++) {
			c[a[i]]--;
			s[c[a[i]]] = a[i];
		}
		System.out.println(Arrays.toString(s));
		//System.out.println(a.length);
	}
}
