import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo1_서울_9반_김동주_끝_ {
	public static int N,M;
	public static int ni,nj;
	public static char[][] map;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1}; //�긽�븯醫뚯슦
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			StringTokenizer nm = new StringTokenizer(br.readLine());
			N = Integer.parseInt(nm.nextToken()); //�뻾
			M = Integer.parseInt(nm.nextToken()); //�뿴
			map = new char[N][M];
			for(int i=0; i<N; i++) { //留� �뻾
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					map[i][j] = st.nextToken().charAt(0);
				}
			} //�엯�젰 �떎諛쏆쓬
			//System.out.println(Arrays.toString(map[1]));
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] == 'G') { //珥앹옟�씠�씤 寃쎌슦
loop:					for(int d=0; d<di.length; d++) { //�궗諛� �꽌移�
							for(int l=1; l<20; l++) {
								ni = i+ di[d]*l;
								nj = j+ dj[d]*l;
								if(ni<0||ni>=N||nj<0||nj>=M||map[ni][nj]=='G'||map[ni][nj]=='W'||map[ni][nj] =='X') { //여기때문에 틀림 ㅜㅜ!! 맞춘 장애물도 통과가 안되게 해주어야 함!!
									continue loop; //踰붿쐞 諛뽰쑝濡� 媛�嫄곕굹 �꽆�뼱 蹂쇱닔�뾾�쑝硫� �떎瑜� 諛⑺뼢�꽌移섎줈 �꽆�뼱媛�
								}
								if(map[ni][nj]=='T') {
									map[ni][nj] = 'X';////또는 여기서 'W'로 만든다.
									continue loop; //�떎瑜� 諛⑺뼢�꽌移섎줈 �꽆�뼱媛�
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
		System.out.println(sb); //珥앹옟�씠�쓽 紐⑺몴媛� �릺�뒗 紐⑺몴臾쇱쓽 珥� 媛쒖닔 T->X濡� 諛붽씀�옄
		br.close();
	}
}
