import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JO_1024_BJ_1520_내리막길_서울9반_김동주 { //dfs(bfs)에 백트래킹 및 메모이제이션을 적용해야 한다.
														//Algo5
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	public static int H,W,result;
	public static boolean[][] v;
	public static int[][] X, memo;
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_JO_1024.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer hw = new StringTokenizer(br.readLine());
		H = Integer.parseInt(hw.nextToken());
		W = Integer.parseInt(hw.nextToken());
		X = new int[H][W];
		v = new boolean[H][W]; //
		memo = new int[H][W];
		for(int h=0; h<H; h++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int w=0; w<W; w++) {
				X[h][w] = Integer.parseInt(st.nextToken());
			}
			//System.out.println(Arrays.toString(X[h]));
		}//인풋다받음
		
//		result = 0;
//		dfs(0,0); //시간초과...
		
		result = dfsm(0,0);
		System.out.print(result);
	}

	public static void dfs(int i, int j) {
		if(i==H-1 && j ==W-1) { //도착
			result++;
			return;
		}
		v[i][j] = true;
		for(int x=0; x<4; x++) {
			int ni = i+di[x];
			int nj = j+dj[x];
			if(ni>=0 && nj>=0 && ni<H && nj<W && !v[ni][nj] && X[ni][nj] < X[i][j]) {
				dfs(ni,nj);
			}
		}
		v[i][j] = false; //필수
	}
	
	public static int dfsm(int i, int j) {
		if(i==H-1 && j ==W-1) { //최소단위
			return 1;
		}
		if(memo[i][j] != 0) return memo[i][j]; //백트래킹!!!!
		if(!v[i][j]) {
			v[i][j] = true;
			for(int x=0; x<4; x++) {
				int ni = i+di[x];
				int nj = j+dj[x];
				if(ni>=0 && nj>=0 && ni<H && nj<W && !v[ni][nj] && X[ni][nj] < X[i][j]) {
					//dfs(ni,nj);
					memo[i][j] += dfsm(ni,nj);
				}
			}
			//v[i][j] = false; //필수
		}
		return memo[i][j];
	}
}
