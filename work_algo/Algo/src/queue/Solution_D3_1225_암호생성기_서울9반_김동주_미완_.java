package queue;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D3_1225_암호생성기_서울9반_김동주_미완_ {
	static int[] X = new int[8];
	static int[] Y = new int[8];
	Queue<String> q = new LinkedList<>(); 

	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("res/input_D3_1225.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		for(int tc = 1; tc <= 10; tc++){
			br.readLine(); //한줄 버리기
			String line = br.readLine(); //라인단위로 String으로 읽어들임.
			StringTokenizer st = new StringTokenizer(line); //8개 들어있음
			for(int i=0; i<8; i++) {
				X[i] = Integer.parseInt(st.nextToken());
				
			}
			
			//출력용
			System.out.print("#" + tc);
			for(int j=0; j<8; j++) {
				System.out.print(" " + Y[j]);
			}
			System.out.println();
		}
		br.close();
	}
}
