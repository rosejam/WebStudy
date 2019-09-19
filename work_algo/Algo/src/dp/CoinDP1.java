package dp;

import java.util.Arrays;

public class CoinDP1 {
	public static int[] coin= {1,4,6};
	public static int[] m;
	public static void main(String[] args) {
		int N=8;
		m=new int[N+1]; 
		
		for(int i=1; i<=N; i++) { //i원을 거슬러줄때의 최적을 m에 저장
			int min = Integer.MAX_VALUE/2;
			for(int j=0; j<coin.length; j++) { //동전가지를 모두 체크 그중 최소를 구하기
				if(i-coin[j] >= 0) { //동전을 뺄 수 있는 경우
					if(min > m[i-coin[j]]) min=m[i-coin[j]];
				}
			}
			m[i]=min+1; //뺐을 때 최적을 구하고 +1, 최적이 없을 경우 max/2+1
		}
		System.out.println(m[N]);
		System.out.println("m"+Arrays.toString(m));
	}
}
