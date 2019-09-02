package 보충;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_7733_치즈도둑_서울9반_김동주 { //가장 많이 쪼개어 졌을 때의 쪼개진 개수 //안전영역문제 
	public static int N,cnt;
	public static int[][] cheese;
	public static boolean[][] visited;
	public static int[] di= {-1,1,0,0};
	public static int[] dj= {0,0,-1,1};
	public static int ni,nj;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_D4_7733.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine()); //int는 21억 까지
        for (int tc = 1; tc <= TC; tc++) {
            N = Integer.parseInt(br.readLine());
            cheese = new int[N][N];
            int min = Integer.MAX_VALUE;
            int max= Integer.MIN_VALUE;
            for(int r=0; r<N; r++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int c=0; c<N; c++) {
                    cheese[r][c] = Integer.parseInt(st.nextToken());
                    if(cheese[r][c]<min) min=cheese[r][c];
                    if(cheese[r][c]>max) max=cheese[r][c];
                }
            }//cheese정보 모두 받음 
            int ans=1;//1부터 시작하는 덩어리 수 
            //for(int x=1; x<=100; x++) { //x번째날의 덩어리 수를 세서 최대를구한다.
            for(int x=min; x<max; x++) { //여기서 1~100까지 다하지 않도록 max, min을 구함
            	cnt=0; //카운트, 방문 모두 초기화 해야함!
            	visited = new boolean[N][N]; //여기서 새로 생성해야한다!!!
        		for(int i=0; i<N; i++) {
        			for(int j=0; j<N; j++) {
        				if((visited[i][j] == false) && (cheese[i][j]>x)) {
        					cnt++;
        					pieces(i,j,x);
        				}
        			}
        		} //그날의 덩어리 개수num를 찾는다.
            	if(cnt>ans) ans=cnt;
            }
            sb.append("#"+tc+" "+ans+"\n");
            //System.out.println("#"+tc+" "+ans);
        }
        System.out.println(sb);
	}
/*	public static void eating(int x) { //이 함수는 굳이 안만들고 main에 포함해도 됨
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if((visited[i][j] == false) && (cheese[i][j]>x)) {
					cnt++;
					pieces(i,j,x);
				}
			}
		}
	}*/
	public static void pieces(int i, int j, int x) { //덩어리 만들기(v표시)
		visited[i][j]=true;
		for(int d=0; d<4; d++) {
			ni = i+di[d];
			nj = j+dj[d];
			if(ni>=0&&ni<N&&nj>=0&&nj<N&&(cheese[ni][nj]>x)&&(visited[ni][nj] == false)) { //범위안에 있고 x보다 크고 visit안한경
				pieces(ni,nj, x);
			}
		}//지우면서 돌아가면 안됨. 표시하기 위한 메서드
	}
}
