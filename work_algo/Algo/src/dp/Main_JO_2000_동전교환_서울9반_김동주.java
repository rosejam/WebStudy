package dp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JO_2000_동전교환_서울9반_김동주 {// 잔돈 W를 구성하는 최소의 동전 수
	public static int N, W, sum;
	public static int[] coin;// ,m;
	public static int[][] m;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_JO_2000.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		coin = new int[N];
		for(int n=0; n<N; n++) {
			coin[n] = Integer.parseInt(st.nextToken());
		}
		W = Integer.parseInt(br.readLine());
		//입력다받음
		
/*		m=new int[W+1];
		for(int i=1; i<=W; i++) { //i원을 거슬러줄때의 최적을 m에 저장
			int min = Integer.MAX_VALUE/2;
			for(int j=0; j<coin.length; j++) { //동전가지를 모두 체크 그중 최소를 구하기
				if(i-coin[j] >= 0) { //동전을 뺄 수 있는 경우
					if(min > m[i-coin[j]]) min=m[i-coin[j]];
				}
			}
			m[i]=min+1; //뺐을 때 최적을 구하고 +1, 최적이 없는 경우 max/2+1
		}
		if(m[W]==Integer.MAX_VALUE/2+1) System.out.print("impossible");
		else System.out.print(m[W]); //잔돈 W를 구성하는 최소의 동전 수*/
		
		m=new int[coin.length][W+1]; //coin[i]로 j원을 거슬러줄 때의 최적

		for(int i=0; i<coin.length; i++) {
			for(int j=1; j<=W; j++) {
				if(i<1 && j>=coin[i]) { //첫번째 코인일때 &&(j>=coin[i])
					m[0][j]=m[0][j-coin[i]]+1;
				}else if(i<1) { //j<coin[i]
					m[0][j]=Integer.MAX_VALUE/2;
				}else if(j<coin[i]) {
					m[i][j]=m[i-1][j];
				}else {
					m[i][j]=Math.min(m[i][j-coin[i]]+1, m[i-1][j]);
				}
			}
		}
		if(m[coin.length-1][W]>Integer.MAX_VALUE/2) System.out.println("impossible");
		else System.out.print(m[coin.length-1][W]);
		
		System.out.println();
		System.out.println(Integer.MAX_VALUE/2);
		//for(int[] a:m) System.out.println(Arrays.toString(a));
	}
}
