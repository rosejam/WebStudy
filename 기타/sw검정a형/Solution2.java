
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2 {
	static int N, M, map[][] = new int[9][9], copy[][] = new int[9][9];
	static boolean[][] seed = new boolean[9][9];
	static int[][] visit = new int[9][9];
	static int max;
	static int[] next = new int[3];
	static final int INF = 987654321;
	static int[] dR = { 0, -1, 0, 1 }, dC = { 1, 0, -1, 0 }; // 우상좌하

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					copy[i][j] = map[i][j] = Integer.parseInt(st.nextToken()) > 0 ? INF : 0;
				}
			}
			// end of input
			max = 0;
			copy();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 0) {
						for (int k = 0; k < 4; k++) { // 방향 : 우상좌하
							int result = go(i, j, k);
//							System.out.printf("%d %d %d\n",i, j, result);
							max = Math.max(result, max);
							copy();
						}
					}
				}
			}
			System.out.printf("#%d %d\n", t, max);
		} // end of TC
	}

	private static void copy() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				map[i][j] = copy[i][j];
				visit[i][j] = 4;
				seed[i][j] = false;
			}
		}

	}

	private static int go(int R, int C, int K) { // 출발 위치, 방향
		int sum = 0; // 수확량
		int r = R;
		int c = C;
		int k = K;

		for (int m = 1; m <= M; m++) { // M일 간
			// 싹 성장
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (seed[i][j]) {
						map[i][j]++;
					}
				}
			}
			// 로봇 오전
			boolean find = false;
			if (!seed[r][c]) { // 빈 농지
				if (find = find(r, c, k)) { //이동가능할때
					seed[r][c] = true; // 씨 심기
					map[r][c] = -1;
				}
				// 아무것도 안 하기
			} else { // 심어진 곳 = 곡식
				// 수확
				sum++;
				map[r][c] = 0;
				seed[r][c] = false;
				visit[r][c]++;
				find = find(r, c, k);
			}
			// 로봇 오후
			if (find) { // 이동 가능한 경우
				r = next[0];
				c = next[1];
				k = next[2];
			} // 아무것도 안 하기
		}
		return sum;
	}

	private static boolean find(int R, int C, int K) {
		int newR, newC;
		int k = K - 1 >= 0 ? K - 1 : 3;
		for (int tmp = 0; tmp < 4; tmp++, k++) {
			k %= 4;
			newR = R + dR[k];
			newC = C + dC[k];
			if (newR < 0 || newR >= N || newC < 0 || newC >= N)
				continue;
			int curV = map[newR][newC]; // 위치의 값
			int curG = visit[newR][newC];
			boolean curS = seed[newR][newC];// 위치 심은 상태
			if ((curV == 0 && !curS) || (curS && curV >= curG)) {
				next[0] = newR;
				next[1] = newC;
				next[2] = k;
				return true;
			}
		}
		return false;
	}
}
