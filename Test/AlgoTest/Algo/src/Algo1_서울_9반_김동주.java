import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo1_서울_9반_김동주 {
	public static int N,M;
	public static int ni,nj;
	public static char[][] map;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1}; //상하좌우
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			StringTokenizer nm = new StringTokenizer(br.readLine());
			N = Integer.parseInt(nm.nextToken()); //행
			M = Integer.parseInt(nm.nextToken()); //열
			map = new char[N][M];
			for(int i=0; i<N; i++) { //매 행
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					map[i][j] = st.nextToken().charAt(0);
				}
			} //입력 다받음
			//System.out.println(Arrays.toString(map[1]));
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] == 'G') { //총잡이인 경우
loop:					for(int d=0; d<di.length; d++) { //사방 서치
							for(int l=1; l<20; l++) {
								ni = i+ di[d]*l;
								nj = j+ dj[d]*l;
								if(ni<0||ni>=N||nj<0||nj>=M||map[ni][nj]=='G'||map[ni][nj]=='W') {
									continue loop; //범위 밖으로 가거나 넘어 볼수없으면 다른 방향서치로 넘어감
								}
								if(map[ni][nj]=='T') {
									map[ni][nj] = 'X';
									continue loop; //다른 방향서치로 넘어감
								}
							}
						}
					}
				}
			}
			int cnt =0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] =='X') cnt++;
				}
			}
			sb.append("#"+tc+" "+cnt+"\n");
		}
		System.out.println(sb); //총잡이의 목표가 되는 목표물의 총 개수 T->X로 바꾸자
		br.close();
	}
}
