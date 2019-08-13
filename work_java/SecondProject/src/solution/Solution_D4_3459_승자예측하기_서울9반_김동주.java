package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D4_3459_승자예측하기_서울9반_김동주 { //나는 안넘게, 상대는 2x하면 N초과 되도록 2x +1
	static long N;
	static long x;
	static int n;
	static int curr;
	static boolean w; //false이면 alice true면 bob
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_D4_3459.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(br.readLine());
		//int T=sc.nextInt();

		for(int tc=1; tc<=T; tc++) {
			N = Long.parseLong(br.readLine());
			x = 1; curr=0;w = false;
			n = getpow(0);
			if (game(1,0,false)==false)System.out.println("#" + tc + " Alice");
			else System.out.println("#" + tc + " Bob");
		}
		br.close();
	}
	public static int getpow(int n) { //주어진 값이 몇층인지
		if(N < Math.pow(2, n)) return n;
		else return getpow(++n);
	}
		
	public static boolean game(long x, int curr, boolean w) { 
		if(N == Math.pow(2, n)-1) { //끝을 만남
			if((n-curr)%2 == 0) return w; //짝수층 차이나면 !w가 이김
			else return !w;
		}else if(N == Math.pow(2, n-1)+Math.pow(2, n-2)-1){ //반띵
			if((n-curr)%2 == 0) return !w; //짝수층 차이나면 !w가 이김
			else return w;
		}else if(N > Math.pow(2, n-1)+Math.pow(2, n-2)-1){ //N이 오른쪽
			if((n-curr)%2 == 0) return game(x*2+1, curr+1, !w); //짝수층 차이나면 !w가 이김
			else return game(x*2, curr+1, !w);
		}else {
			if((n-curr)%2 == 0) return game(x*2+1, curr+1, !w); //짝수층 차이나면 !w가 이김
			else return game(x*2, curr+1, !w);
		}
		
			
		
/*		if(2*x > N) return !w; //2x가 N초과. 지금 사람이 진다. 
		else if(2*x+1 > N) return w; //2x는 N초과 안하는데 2x+1이 N초과. 다음사람이 진다.
		else return game(2*x, !w);*/
	}
}