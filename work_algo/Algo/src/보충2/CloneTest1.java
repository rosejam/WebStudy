package 보충2;

import java.util.Arrays;

public class CloneTest1 {
	public static void main(String[] args) {
		//1차원 배열
/*		int[] a = {1,2,3,4,5,6,7,8,9};
		
		int[] a1 =a; //pass by reference
		
		//int[] b = a.clone(); //pass by value//1
		int[] c = Arrays.copyOf(a, a.length); //2//아래 두줄과 같다.
		
		//3
		int[] d = new int[a.length]; //배열 생성해야 아래줄 사용 가능
		System.arraycopy(a, 0, d, 0, a.length); //배열이 미리 만들어져 있다면 */
		
		//2차원 배열인 경우
		int[][] a = {{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}};
		int[][] b = new int[a.length][a.length];
		for(int i=0; i<a.length; i++) {
			b[i]=a[i].clone();
			b[i]=Arrays.copyOf(a[i], a[i].length);
			System.arraycopy(a[i],0,b[i],0, a[i].length); //셋중 하나 골라서 사용
			//System.out.println(Arrays.toString(b[i]));
		}
	}
}
