package 문제풀이2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class Solution_D4_4302_콩많이심기_서울9반_김동주 { //재구성 -> 부분문자열
    public static int T,ans;
    public static void main(String[] args) throws Exception{
    	System.setIn(new FileInputStream("res/input_D4_4672.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){


            sb.append("#"+tc +" "+ans+"\n");
        }
        System.out.print(sb);
    }
}
