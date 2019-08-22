package dcbacktracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1335_색종이만들기_서울9반_김동주_미완 {
	public static byte[][] arr;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_JO_1335.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		arr = new byte[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				if(st.nextToken().equals("1")) {
					
				}
				
				arr[i][j] = Byte.parseByte
			}
		}
		
		System.out.println(); //잘라진하양0
		System.out.print(" "); //파랑1
	}
}
