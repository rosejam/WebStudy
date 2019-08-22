package dcbacktracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//완제품이 최소 1명이라도 소수일 확률 (1-둘다 완제품이 소수개가 아닐 확률) = 1-Anot*Bnot
//소수 : 2 3 5 7 11 13 17
//0 1 4 6 8 9 10 12 14 15 16 18
public class Solution_D6_1266_소수완제품확률_서울9반_김동주 {
	//public static byte A, B;
	public static double A, B;
	public static double Anot, Bnot;
	public static double prob;
	public static int[] notsosu = {0,1,4,6,8,9,10,12,14,15,16,18};
	public static double nCr(int n, int r) {
		if(n<r) return 0.0;
		if(r==0) return 1.0;
		return nCr(n-1,r-1)+nCr(n-1,r);
	}
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_D6_1266.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A = Double.parseDouble(st.nextToken())*0.01; //0~1 
			B = Double.parseDouble(st.nextToken())*0.01; //0~1 //형변환이 적도록 더블로받음
			//각각 18번 만듬
			//A가 18번 만들었는데 소수가 아닐 확률 Anot
			Anot=0.0; Bnot=0.0; //형변환이 적도록 더블로
			for(int x : notsosu) { 
				Anot += nCr(18,x)*Math.pow(1-A, 18-x)*Math.pow(A, x); //x개 될 확률
				Bnot += nCr(18,x)*Math.pow(1-B, 18-x)*Math.pow(B, x);
			}
			//prob = 1.0-Anot*Bnot;
			//sb.append("#"+tc +" "+String.format("%.6f", 1.0-Anot*Bnot)+"\n"); //소수점 7번 자리에서 반올림
			System.out.printf("#%d %f\n",tc,1.0-Anot*Bnot);
		}
		//System.out.print(sb);
		br.close();
	}
}
