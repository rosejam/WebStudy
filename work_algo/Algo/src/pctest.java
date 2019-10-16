import java.util.Arrays;

public class pctest {
	public static int cnt,n,r,a[],b[],d[] = {8,7,6,5,4,3,2,1};
	public static boolean v[];
	public static void permcomb(int start, int depth) {
		if(depth == r) { //	리프
			cnt++;
			//System.out.println("인덱스배열");
			System.out.println(Arrays.toString(a));
			System.out.println("실제배열조작");
			System.out.print("[");
			for(int j=0;j<r-1;j++) { //0~r-1까지 r개
				System.out.print(d[a[j]]+", ");
			}
			System.out.println(d[a[r-1]]+"]");
/*			System.out.println("주어진코드");
			System.out.println(Arrays.toString(b));*/
			System.out.println("*****************************");
			return;
		}
		//
		for(int i=start; i<n; i++) { //start부터는 조합
			if(!v[i]) {
				v[i] = true;
				a[depth] = i; //인덱스 배열
				b[depth] = d[i]; //실제배열조작
				permcomb(i, depth+1);
				v[i] = false;
			}
		}
		//
	}
	public static void main(String[] args) {
		n=8;
		r=4;
		cnt=0;
		v = new boolean[n];
		a = new int[r];
		b = new int[r];
		permcomb(0,0);
		System.out.println("개수="+cnt);
	}
}
