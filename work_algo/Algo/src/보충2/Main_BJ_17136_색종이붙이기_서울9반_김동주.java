package 보충2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_17136_색종이붙이기_서울9반_김동주 { //1~5 각 5개
	public static boolean[][] pan;
	public static void main(String[] args) throws Exception { //모든 1을 덮는데 필요한 색종이의 최소 개수를 출력한다. 1을 모두 덮는 것이 불가능한 경우에는 -1을 출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		pan = new boolean[10][10];
		for(int i=0;i<10;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<10;j++) {
				if(st.nextToken().equals("1")) {
					pan[i][j] = true;
				}
			}
			//System.out.println(Arrays.toString(pan[i]));
		}//모든 정보 받음 
		
		
	}

}
