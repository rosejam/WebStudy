package 보충2;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//지금 이 소스는 딥 카피 안 되어있음 그 부분 추가해 줄것~~~~
public class Main_BJ_17406_배열돌리기4_홍길동 {
	public static class Rotate {
		int r, c, s;

		public Rotate(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}

	public static int N, M, K;
	public static int[][] maps;
	public static Point[] points;
	public static boolean[] visit;
	public static Rotate[] rt;
	public static int[] a; // -> 순열 구하는 애
//배열 A의 최솟값을 출력한다.

	public static void main(String[] args) throws Exception {
		INIT();
		rot(rt[0]);
	}

	public static void INIT() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

// 배열의 크기 N, M: 3<= N,M <=50
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

// 1<= maps[i][j] <= 100
		maps = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//회전연산 정보: 1 <= K <=6
// r, c, s 가장 윗칸 (r-s, c-s)에서 가장 아랫칸(r+s, c+s) 까지 돌린다
// r-1, c-1로 만들어줘야 편함
		rt = new Rotate[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			rt[i] = new Rotate(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
					Integer.parseInt(st.nextToken()));
		}

		br.close();
	}

	public static void dfs(int depth, int oper, int[][] map) {
		if (oper != -1)
			rotate(points[oper], map);
		if (depth == K) {
			Rsum();
			return;
		}
		for (int i = 0; i < K; i++) {
			if (!visit[i]) {
				visit[i] = true;
				dfs(depth + 1, i, map);
				visit[i] = false;
			}
		}
	}

	public static void rot(Rotate x) {
		int[][] copys = new int[N][M];

		for (int s = 1; s <= x.s; s++) {
			int tr = x.r - s;
			int tc = x.c - s;

//맵 카피
			int tmp = copys[tr][tc];
			int dir = 0;
//우하좌상
			int[] dr = { 0, 1, 0, -1 };
			int[] dc = { 1, 0, -1, 0 };
			do {
				int nr = tr + dr[dir];
				int nc = tc + dr[dir];

				int prev = tmp;
				tmp = copys[nr][nc];
				copys[nr][nc] = prev;

				tr = nr;
				tc = nc;

				if (tr == x.r - s && tc == x.c + s)
					dir = 1;
				if (tr == x.r + s && tc == x.c + s)
					dir = 2;
				if (tr == x.r + s && tc == x.c - s)
					dir = 3;

			} while (tr != x.r - s || tc != x.c - s);

		}
	}

//pts는 로테이션 위치 횟수
	public static void rotate(int[] pts) {
		for (int s = pts[2]; s > 0; s--) {
			int len = s * 2 + 1;
			int r = pts[0] - s;
			int c = pts[1] - s;

			int temp = tap[r][c];
//하우상좌
			for (int i = 1; i < len; i++) {
				tap[r][c] = tap[r + 1][c];
				r++;
			}
			for (int i = 1; i < len; i++) {
				tap[r][c] = tap[r][c + 1];
				c++;
			}
			for (int i = 1; i < len; i++) {
				tap[r][c] = tap[r - 1][c];
				r--;
			}
			for (int i = 1; i < len; i++) {
				tap[r][c] = tap[r][c - 1];
				c--;
			}
			tap[r][c + 1] = temp;

		}

	}

	public static int Rsum() {
		int min = 987654321;
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < M; j++) {
				sum += maps[i][j]; // 지금은 오리진인데 바뀔지도 모름
			}
			min = min < sum ? min : sum; // 삼항연산자
		}
		return min;
	}
}