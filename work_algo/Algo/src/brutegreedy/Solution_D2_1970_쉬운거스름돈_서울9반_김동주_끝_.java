package brutegreedy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D2_1970_쉬운거스름돈_서울9반_김동주_끝_ {
	public static int N;
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("res/input_D2_1970.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		byte T = Byte.parseByte(br.readLine());
		StringBuilder sb = new StringBuilder(); //스트링 빌더는 매 테스트케이스 시작때 초기화 하지 않는다. 모아서 출력하는 용도 이기 때문
		for(int tc = 1; tc <= T; tc++){
			N = Integer.parseInt(br.readLine());
			sb.append("#"+ tc+"\n");
			sb.append(N/50000);
			N = N%50000;
			sb.append(" "+N/10000);
			N = N%10000;
			sb.append(" "+N/5000);
			N = N%5000;
			sb.append(" "+N/1000);
			N = N%1000;
			sb.append(" "+N/500);
			N = N%500;
			sb.append(" "+N/100);
			N = N%100;
			sb.append(" "+N/50);
			N = N%50;
			sb.append(" "+N/10+"\n");
			N = N%10;
		}//또는 돈의 가지수를 배열로 만들어놓고 for each문으로 꺼내쓰면 된다
		System.out.println(sb);
		br.close();
	}
}
