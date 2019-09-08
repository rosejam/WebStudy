import java.util.Arrays;

public class pctest2 {
	public static int cnt,n,r,a[];
	public static boolean v[];
	public static void permcomb(int start, int depth) {
		if(depth == r) {
			cnt++;
			System.out.println(Arrays.toString(a));
			return;
		}
		for(int i=0;i<n;i++) {
			if(!v[i]) {
				v[i]=true;
				a[depth] = i;
				permcomb(i,depth+1);
				v[i]=false;
			}
		}
	}
	public static void main(String[] args) {
		cnt=0;
		n=5;
		r=3;
		v = new boolean[n];
		a = new int[r];
		permcomb(0,0);
		System.out.println(cnt);
	}
}
