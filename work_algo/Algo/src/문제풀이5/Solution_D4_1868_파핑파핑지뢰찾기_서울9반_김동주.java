package 문제풀이5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//지뢰가 없는 모든 칸에 숫자가 표시되는 최소 클릭수
public class Solution_D4_1868_파핑파핑지뢰찾기_서울9반_김동주 { //한번에 바꿔야함!!..

	public static int T,N,show[][],click,ni,ci,nj,cj,nni,nnj;
	public static char map[][];
	//public static boolean v[][];
	public static boolean thezero,flag;
	public static Queue<int[]> q;
	public static final int[] di = {-1,1,0,0,-1,-1,1,1};
	public static final int[] dj = {0,0,-1,1,-1,1,-1,1}; //대각선까지 8방향
	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input_D4_1868.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		q=new LinkedList<>();
		T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			click = 0;
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			//show = new int[N][N];
			String line = null;
			for(int n=0;n<N;n++) {
				line = br.readLine();
				//System.out.println(line);
				for(int m=0;m<N;m++) {
					map[n][m] = line.charAt(m);
					//‘*1’이면 지뢰가 있다는 뜻이고, ‘.0’이면 지뢰가 없다는 뜻
/*					if(line.charAt(m) == '.') {
						map[n][m] = 0;
					}else {
						map[n][m] = 1;
					}*/
					//-1이면 클릭했다는 뜻
				}
				//System.out.println(Arrays.toString(map[n]));
			}
			//
			/*for(int n=0;n<N;n++) {
				for(int m=0;m<N;m++) {
					if(map[n][m] == '.') { //주변이 다 빈공간인지 체크
						//System.out.println("xbg");
						thezero = true;
						for(int d=0; d<8; d++) {
							ni = n+di[d];
							nj = m+dj[d];
							if(ni>=0&&nj>=0&&ni<N&&nj<N&&map[ni][nj]=='*') { //!!
								thezero = false;
								//System.out.println(map[ni][nj]-'.');
								//System.out.println(n+","+m);
								break;
							}
						}
						if(thezero) {
							//map[n][m] = '0'; //여기서 하나씩 바꾸므로 위에서
												//map !='.'이 아닌 =='*'으로 체크!
							q.offer(new int[] {n,m});
							click++;
							flag = true;
							bfs(n,m);
						}
						//map[n][m] = '0';
						//q.offer(new int[] {n,m});
						//si = n;
						//sj = m;
					}//터트릴 시작점 지정
				}
			}*/
			flag = true;
			while(flag) {
				flag = false;
				//bfs();//클릭
				for(int n=0;n<N;n++) {
					for(int m=0;m<N;m++) {
						if(map[n][m] == '.') { //아직클릭안한빈칸이 남아있음
							thezero = true;
							for(int d=0; d<8; d++) {
								ni = n+di[d];
								nj = m+dj[d];
								if(ni>=0&&nj>=0&&ni<N&&nj<N&&map[ni][nj]=='*') {
									thezero = false;
									break;
								}
							}
							if(thezero) { //8방향이 모두 0임
//								map[n][m] = '0';
//								q.offer(new int[] {n,m});
								bfs(n,m);
								click++;
								flag = true;
							}
//							si = n;
//							sj = m;
						}
					}
					//System.out.println(Arrays.toString(map[n]));
				}
			}
			
			for(int n=0;n<N;n++) {
				for(int m=0;m<N;m++) {
					if(map[n][m] == '.') { //아직클릭안한빈칸이 남아있음
						click++;
					}
				}
				//System.out.println(Arrays.toString(map[n]));
			}
			//
			sb.append('#').append(tc).append(' ').append(click).append('\n');
		}
		System.out.print(sb);
	}
	
	private static void bfs(int i, int j) { //dfs로도 구현할 수 있음
		map[i][j] = '0';
		q.offer(new int[] {i,j});
		while(!q.isEmpty()) {
			//curr = q.poll();
			ci = q.peek()[0];
			cj = q.poll()[1];
			//if(map[ci][cj] != '.') continue;
			//map[ci][cj] = '0';
			for(int d=0;d<8;d++) { //0주변 8방향에 있는 .들이 thezero인지 체크
				ni = ci+di[d];
				nj = cj+dj[d];
				if(ni>=0 && nj>=0 && ni<N && nj<N && map[ni][nj] == '.') {
					map[ni][nj] = '0';
					//thezero = true;
					for(int dd=0; dd<8; dd++) {
						nni = ni+di[dd];
						nnj = nj+dj[dd];
						if(nni>=0&&nnj>=0&&nni<N&&nnj<N&&map[nni][nnj]=='*') {
							//thezero = false;
							map[ni][nj]++;
						}
					}
					//if(thezero) { //8방향이 모두 0임
					if(map[ni][nj] == '0') {
						q.offer(new int[] {ni,nj});
					}
/*					if(map[ni][nj] == '.') {
						map[ni][nj] = '0';
						q.offer(new int[] {ni,nj});
					}
					else map[ci][cj]++;*/
				}
			}
		}
	}

}
