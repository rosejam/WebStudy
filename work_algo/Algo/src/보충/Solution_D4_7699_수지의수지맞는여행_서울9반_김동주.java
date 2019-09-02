package 보충;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//DFS
public class Solution_D4_7699_수지의수지맞는여행_서울9반_김동주 {
	public static int R,C;
	public static int max, cnt;
	public static int[][] map;
	public static boolean[] visited;
	//public static HashSet<Integer> visited; //배열 대신 HashSet을 이용하는 방법도 있다!!(들어가면 visit안한 것)
	public static int ni,nj;
	public static int[] di= {-1,1,0,0};
	public static int[] dj= {0,0,-1,1}; //상하좌우
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_D4_7699.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine()); //int는 21억 까지
        for (int tc = 1; tc <= TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            map = new int[R][C];
            visited = new boolean[26];
            //visited = new HashSet<>();
            for(int r=0; r<R; r++) {
                String line = br.readLine();
                for(int c=0; c<C; c++) {
                    map[r][c] = line.charAt(c)-'A'; //0~25 알파벳이다~ 
                    //원래 char배열로 받았는데 아래에서 연산을 줄이기 위해 int로 바꾸어 받았다.
                }
            }
            max = 1;
            cnt = 0;
            travel(0,0);
            sb.append("#"+tc+" "+max+"\n");
        }
        System.out.println(sb);
    }
	public static void travel(int i, int j) {//, int cnt) { //불필요한 파라메터는 줄인다
		if(max==26) return; //가지치기!!로 시간을 줄이자
		visited[map[i][j]] = true;
		cnt++;
		max = (cnt>max)? cnt : max;
		//visited.add(map[i][j]);
		for(int d=0; d<4; d++) {
			ni = i+di[d];
			nj = j+dj[d];
			if(ni>=0&&ni<R&&nj>=0&&nj<C&&(!visited[map[ni][nj]])) { //visited.add(map[ni][nj])) {//범위안에 있고 방문한 종류의 명물이 아닐 경우
				//visited[map[ni][nj]] = true;
				travel(ni,nj);
			}
		}
		//방향 다 찾아도 갈곳이 없어서 재귀 호출을 안한 경우 이리로 온다.
		visited[map[i][j]] = false; //이게필수!!! 방문한 명물을 지우면서 뒤로 간다.
		cnt--;
		//visited.remove(map[i][j]);
	}
}
