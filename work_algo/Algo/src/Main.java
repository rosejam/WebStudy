/*public class Main {
	public static final int[] pool = {0,7,6};
	//public static final int n=10, r=4;
	public static int cnt, x;
	public static boolean[] v;
	public static int[] Lotto;//, a;
	public static void main(String[] args) { //10P4 = 5040가지
		Lotto = new int[4];
		Lotto[3] = 9;
		////
		x = 2; //1이상 5040이하	//이 값만 변경시키자
		////
		cnt=0;
		v = new boolean[10];
		permcomb(0);
		
		for(int i=0; i<4; i++) {
			System.out.print(Lotto[i]+" ");
		}
	}
	// XX6X . 7, 9포함 8X
	public static boolean permcomb(int depth) {
		if(depth == 3) {
			cnt++;
			if(cnt == x) return true;
			return false;
		}
		for(int i=0;i<3;i++) {
			if(!v[i]) {
				v[i]=true;
				Lotto[depth] = pool[i]; //pool을 셔플고정 해놓고 pool[i]를 넣어도 됀다.
				if(permcomb(depth+1)) return true;
				v[i]=false;
			}
		}
		return false;
	}
}*/
public class Main {
	public static void main(String[] args) {
		System.out.print("5 7 0 6");  //06 //X: 127934 //58
	}
}