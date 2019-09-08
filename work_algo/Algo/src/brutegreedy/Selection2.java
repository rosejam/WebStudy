package brutegreedy;

import java.util.Arrays;

public class Selection2 { //재귀로
	public static int n=5; //a.length
	public static int[] a = {64,25,10,22,11};
	
	public static int minindex(int i, int j) {
		if(i==j) return i;
		int min=minindex(i+1,j);
		return a[i]<a[min]? i:min;
	}
	public static void selection(int index) { //a[index]에 뒤중 최소의 값을 가져와서 고정
		if(index==n) return; 
		int min=minindex(index, n-1); //index에서 n-1중 최소값의 인덱스를 가져옴
		if(index!=min) {
			int T=a[index]; a[index]=a[min]; a[min]=T;
			System.out.println(Arrays.toString(a));
		}
		selection(index+1); //마지막 인덱스까지 진행
	}
	public static void main(String[] args) {
		System.out.println(Arrays.toString(a)+"\n");
		selection(0);
/*		for(int i=0; i<a.length-1; i++) { //제일 마지막은 제외해도 되므로
			int min = i;
			for(int j=i+1; j<a.length; j++) { //나머지 전체에서 min값을 찾는것을 반복~
				if(a[j]<a[min]) min = j;
			}
			int T=a[i]; a[i]=a[min]; a[min]=T;
			System.out.println(Arrays.toString(a));
		}*/
		System.out.println("\n"+Arrays.toString(a));
	}
}
