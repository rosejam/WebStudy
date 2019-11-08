package 기타;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_9376_탈옥_서울9반_김동주 {
	//빈공간., 벽*, 문#, 죄수$ 2명 위치
	//열어야 하는 문의 최소값 출력
	public static int T,H,W,min, juein[][];
	public static char[][] map;
	//public static ArrayList<int[]> exit;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_BJ_9376.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String line;
		
		T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			int xx = 0;
			juein = new int[2][2]; //죄인 2명의 위치
			//exit = new ArrayList<>();
			for(int h=0; h<H; h++) {
				line = br.readLine();
				for(int w=0; w<W; w++) {
					map[h][w] = line.charAt(w);
					if(map[h][w] == '$') {
						juein[xx][0] = h;
						juein[xx++][1] = w;
						map[h][w] = '.';
					}
					if(h==0 || w==0 || h==H-1 || w==W-1) { //출구 찾기
						if(map[h][w] != '*') {
							//exit.add(new int[] {h,w});
							if(map[h][w] == '#') map[h][w] = 'D'; //나가는 문#
							else map[h][w] = 'W'; //나가는 길.
						}
					}
				}
			}//입력
			//for(char[] x:map) System.out.println(Arrays.toString(x));
			
			bfs(juein[0][0], juein[0][1], 0);
			bfs(juein[1][0], juein[1][1], 0);
			
			sb.append('#').append(tc).append(' ').append(min).append('\n');//출력
		}
		System.out.print(sb);
	}
	private static void bfs(int i, int j, int doors) {
		// TODO Auto-generated method stub
		
	}

}
