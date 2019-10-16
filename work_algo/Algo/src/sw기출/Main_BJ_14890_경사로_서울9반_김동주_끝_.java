package sw기출;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_14890_경사로_서울9반_김동주_끝_ {
	public static int N, L, ans;
	public static int[][] map;
	public static boolean[][] v;

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input_BJ_14890.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer nl = new StringTokenizer(br.readLine());
		StringTokenizer st;
		N = Integer.parseInt(nl.nextToken());
		L = Integer.parseInt(nl.nextToken());
		map = new int[N][N];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int m = 0;
			// for(int m=0; m<N; m++) {
			while (st.hasMoreTokens()) {
				map[n][m++] = Integer.parseInt(st.nextToken());
			}
			// System.out.println(Arrays.toString(map[n]));
		} // 입력다받음
		ans = 0;
		// 2N개의 길을 체크한다.
		v = new boolean[N][N];
		here: for (int n = 0; n < N; n++) { // 가로길 map[n][]
			for (int m = 0; m < N - 1; m++) {
				if (Math.abs(map[n][m] - map[n][m + 1]) > 1) { // 차이가 1보다 큰곳이 있으면
					continue here; // 이길은 넘어가기
				} else if (map[n][m] - 1 == map[n][m + 1]) { // 내려감
					if (m + L >= N)
						continue here;
					for (int i = 0; i < L; i++) {
						if (map[n][m + 1 + i] != map[n][m + 1] || v[n][m + 1 + i]) {
							// System.out.println("행내"+n+","+m);
							continue here;
						}
						v[n][m + 1 + i] = true;
					}
				} else if (map[n][m] + 1 == map[n][m + 1]) { // 올라감
					if (m - L + 1 < 0)
						continue here;
					for (int i = 0; i < L; i++) {
						if (map[n][m - i] != map[n][m] || v[n][m - i]) {
							// System.out.println("행올"+n+","+m);
							continue here;
						}
						v[n][m - i] = true;
					}
				}
			}
			ans++;
		}
		v = new boolean[N][N];
		here2: for (int m = 0; m < N; m++) { // 세로길 map[][m]
			for (int n = 0; n < N - 1; n++) {
				if (Math.abs(map[n][m] - map[n + 1][m]) > 1) { // 차이가 1보다 큰곳이 있으면
					continue here2; // 이길은 넘어가기
				} else if (map[n][m] - 1 == map[n + 1][m]) { // 내려감
					if (n + L >= N)
						continue here2;
					for (int i = 0; i < L; i++) {
						if (map[n + 1 + i][m] != map[n + 1][m] || v[n + 1 + i][m]) {
							// System.out.println("열내"+n+","+m);
							continue here2;
						}
						v[n + 1 + i][m] = true;
					}
				} else if (map[n][m] + 1 == map[n + 1][m]) { // 올라감
					if (n - L + 1 < 0)
						continue here2;
					for (int i = 0; i < L; i++) {
						if (map[n - i][m] != map[n][m] || v[n - i][m]) {
							// System.out.println("열올"+n+","+m);
							continue here2;
						}
						v[n - i][m] = true;
					}
				}
			}
			ans++;
		}
		System.out.print(ans);
	}
}
