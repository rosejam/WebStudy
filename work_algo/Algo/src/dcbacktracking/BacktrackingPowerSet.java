package dcbacktracking;

import java.util.Arrays;

public class BacktrackingPowerSet { //0과 1
	public static int[] d = {11,22,33};
	public static int cnt;
	public static int candidate(int[] a, int k, int[] c) {
		c[0]=0;
		c[1]=1;
		return 2;
	}
	public static void backtrack(int[] a, int k, int input) {
		//for(int i=0; i<k; i++) System.out.print("\t"); //
		//System.out.println(Arrays.toString(a)+" k="+k+" input="+input); //상태공간 트리를 그려줌
		int[] c =new int[a.length];
		if(k==input) {
			cnt++;
			System.out.print(Arrays.toString(a));
			for(int i=0; i<input; i++) {
				if(a[i]==1) System.out.print(" "+d[i]);
			}
			System.out.println();
			return;
		} //else대신 위에 return을 적어준다.
		int ncands = candidate(a,k,c);
		for(int i=0; i<ncands; i++) { //2개만
			a[k] = c[i]; //캔디데이트를 입력
			backtrack(a,k+1,input);
		}
	}

	public static void main(String[] args) {
		int[] a = new int[d.length];
		backtrack(a,0,a.length);
		System.out.println(cnt);
	}
}
