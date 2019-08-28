package graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//유향 그래프 + BFS
public class Solution_D4_1238_Contact_서울9반_김동주_미완 {

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
