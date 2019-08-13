package 보충;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_기지국 {
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("res/input_기지국.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++){
//			입력받기
			int N = sc.nextInt();
			char[][] map = new char[N][N];
			for (int i = 0; i < map.length; i++) {
				String str = sc.next(); // 문자열 입력 한덩어리
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			for(int i=0; i<map.length;i++) { //잘 되었는지 Arrays.toString(1차배열)로 출력하면 된다.
				System.out.println(Arrays.toString(map[i]));
			}
			System.out.println();
//			2차원배열 맵을 전체 순회하면서 기지국을 찾기
//				A,B,C 타입에 따라 1,2,3 커버 (H 이 있으면)
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] != 'X' && map[i][j] != 'H') { // 기지국이면
						for (int k = 1; k < map[i][j]-'A'+2; k++) {
//							상하좌우 1칸씩 증가하면서 제거
							if (j+k < N && map[i][j+k] == 'H') { // 동
								map[i][j+k] = 'X'; // 집을 제거
							}
							if (j-k > -1 && map[i][j-k] == 'H') { // 서
								map[i][j-k] = 'X';
							}
							if (i+k < N && map[i+k][j] == 'H') { // 남
								map[i+k][j] = 'X';
							}
							if (i-k > -1 && map[i-k][j] == 'H') { // 북
								map[i-k][j] = 'X';
							}
						}
					}
				}
			}
			for(int i=0; i<map.length;i++) { //잘 되었는지 Arrays.toString(1차배열)로 출력하면 된다.
				System.out.println(Arrays.toString(map[i]));
			}
			System.out.println();
//			2차원배열 맵에 남아있는 H 가 답 카운팅
			int count = 0;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] == 'H') {
						count++;
					}
				}
			}
			
			System.out.println("#"+tc+" "+count); // 결과출력
		}
	}
}



















