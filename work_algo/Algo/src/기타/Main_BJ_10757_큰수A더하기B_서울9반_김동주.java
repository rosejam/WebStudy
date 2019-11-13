package 기타;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

//long은 10^19좀 안됨
//int는 2*10^9 정도
//A와 B는 10^10000 -> BigInteger
public class Main_BJ_10757_큰수A더하기B_서울9반_김동주 {
	public static BigInteger A,B,C;
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_JO_2577.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new BigInteger(st.nextToken());
        B = new BigInteger(st.nextToken());
        
        System.out.print(A.add(B).toString());
	}

}
