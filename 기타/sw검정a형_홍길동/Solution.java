
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	static int[] dR = { 0, -1, 0, 1 }, dC = { 1, 0, -1, 0 }; // 우상좌하
	private static int N;
	private static int[] totalMan = new int[4];
	private static int[][] land = new int[10][10];
	private static int[][] man = new int[10][10];
	private static int[][] minus = new int[10][10];
	private static int[][] plus = new int[10][10];
	private static int[][] suppl = new int[10][10];
	private static int[][] sum = new int[10][10];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int t = 1; t <= T; t++) {
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					minus[i][j] = 0;
					sum[i][j] = 0;
					plus[i][j] = 0;
				}
			}
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					land[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int tmp = Integer.parseInt(st.nextToken());
					totalMan[land[i][j]] += tmp;
					man[i][j] = tmp;

				}
			}
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					suppl[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int num = 1;
			int result = 0;
			while (true) {
				attack(num);
				supply(num);
				plus();
				num++;
				num %= 4;
				if(num == 0) num++;
				
				if((result = check()) > 0) {
					break;
				}
			}

			int sum = 0;
			if(result>0) {
				for (int i = 0; i < 10; i++) {
					for (int j = 0; j < 10; j++) {
						sum += man[i][j];
					}
				}
				System.out.println(sum);
			}
//			System.out.printf("#%d %d\n", t, max);
		} // end of TC
	}

	private static int check() {
		int tmp = 0;
		boolean find = false;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if(land[i][j]!=0 && land[i][j] != tmp) {
					if(!find) {
						tmp = land[i][j];
						find = true;
					} else {
						return 0;
					}
				}
			}
		}
		return tmp;
	}

	private static void plus() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				man[i][j] += suppl[i][j];
			}
		}
	}

	private static void supply(int n) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				minus[i][j] = 0;
				sum[i][j] = 0;
				plus[i][j] = 0;
			}
		}
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (land[r][c] == n) {
					int newR, newC;
					boolean find = false;
					for (int k = 0; k < 4; k++) {
						newR = r + dR[k];
						newC = c + dC[k];
						if (newR < 0 || newR >= N || newC < 0 || newC >= N)
							continue;
						if (land[newR][newC] != 0 && land[newR][newC] != n) {
							find = true;
							break;
						}
					}
					if(find) {
						for (int k = 0; k < 4; k++) {
							newR = r + dR[k];
							newC = c + dC[k];
							if (newR < 0 || newR >= N || newC < 0 || newC >= N)
								continue;
							if(man[newR][newC]*5 < man[r][c]) {
								plus[newR][newC] += man[r][c] / 5;
								minus[newR][newC] += man[r][c] / 5;
							}
						}
					} else {
						for (int k = 0; k < 4; k++) {
							newR = r + dR[k];
							newC = c + dC[k];
							if (newR < 0 || newR >= N || newC < 0 || newC >= N)
								continue;
							plus[newR][newC] += man[r][c] / 5;
							minus[newR][newC] += man[r][c] / 5;
						}
					}
				}
			}
		}
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(minus[r][c] > 0) man[r][c] -= minus[r][c];
				if(plus[r][c] > 0) man[r][c] += plus[r][c];
			}
		}
	}

	private static void attack(int n) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				minus[i][j] = 0;
				sum[i][j] = 0;
				plus[i][j] = 0;
			}
		}
		ArrayList<int[]> list = new ArrayList<>();
		// r, c, 얼만큼
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (land[r][c] == n) {
					int newR, newC;
					boolean find = false;
					int eR, eC;
					eR = eC = -1;
					for (int k = 0; k < 4; k++) {
						newR = r + dR[k];
						newC = c + dC[k];
						if (newR < 0 || newR >= N || newC < 0 || newC >= N)
							continue;
						if (land[newR][newC] != 0 && land[newR][newC] != n) {
							eR = newR;
							eC = newC;
							find = true;
						}
						if (find) {
							int mySum = 0;
							for (int k2 = 0; k2 < 4; k2++) {
								newR = eR + dR[k2];
								newC = eC + dC[k2];
								if (newR < 0 || newR >= N || newC < 0 || newC >= N)
									continue;
								if (land[newR][newC] == n) {
									mySum += man[newR][newC];
								}
							}
							if (mySum > man[eR][eC] * 5) {
								list.add(new int[] {eR, eC});
							}
						}
					}
				}
			}
		}
		int newR, newC;
		for (int[] is : list) {
			int r = is[0];
			int c = is[1];
			for (int k = 0; k < 4; k++) {
				newR = r + dR[k];
				newC = c + dC[k];
				if (newR < 0 || newR >= N || newC < 0 || newC >= N)
					continue;
				if (land[newR][newC] == n) {
					minus[newR][newC] += man[newR][newC] / 5;
					sum[r][c] += man[newR][newC] / 5;
				}
			}
		}
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(minus[r][c] > 0) man[r][c] -= minus[r][c];
				if(sum[r][c] > 0) {
					man[r][c] = sum[r][c] - man[r][c];
					land[r][c] = n;
				}
			}
		}
	}
}
