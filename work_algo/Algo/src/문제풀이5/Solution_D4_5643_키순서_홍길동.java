package 문제풀이5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_5643_키순서_홍길동 {
	public static int N, M, student[][], cnt;
	public static boolean v[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().replace(" ", ""));

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().replace(" ", "")); // 사람 수
			M = Integer.parseInt(br.readLine().replace(" ", "")); // 비교횟수
			student = new int[N][N];
			v = new boolean[N];
			cnt = 0;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int one = Integer.parseInt(st.nextToken()) - 1; // 얘가 더 작음
				int two = Integer.parseInt(st.nextToken()) - 1;

				student[one][two] = -1;
				student[two][one] = 1;
			}

			int ans = 0;
			if (N == 1)
				sb.append("#" + tc + " " + 1 + "\n");
			else {
				for (int i = 0; i < N; i++) {
					cnt = 0;
					v = new boolean[N];
					DFS(i, -1);
					DFS(i, 1);
					if (cnt == N - 1)
						ans++;
				}
				sb.append("#" + tc + " " + ans + "\n");
			}
		} // TEST CASE END
		System.out.print(sb);

	}

	public static void DFS(int now, int dir) {
		v[now] = true;
		for (int i = 0; i < N; i++) {
			if (!v[i] && student[now][i] == dir) {
				cnt++;
				DFS(i, dir);
			}
		}
	}

}
