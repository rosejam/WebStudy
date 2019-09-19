package dp;

import java.util.Arrays;

public class LISTest2 { //Lis배열은 찾지않고 최장ㅇ
	public static void main(String[] args) {
		int[] a = {8,2,4,3,6,11,7,10,14,5};//{3,2,6,4,5,1};
		int n = a.length;
		
		int[] c = new int[n];
		int k=1; //0부터인가?
		c[k] = a[0];
		//int max = Integer.MIN_VALUE;
		for(int i=1; i<n; i++) {
			if(c[k]<a[i]) {
				c[++k] = a[i];
			}else {
				int start =1;
				int end = k;
				while(start<end) {
					int mid = (start+end)/2;
					if(c[mid]>=a[i]) end=mid;
					else start=mid+1;
				}
				c[end]=a[i];
			}
		}
		System.out.println(k);
		System.out.println(Arrays.toString(c));
	}
}
