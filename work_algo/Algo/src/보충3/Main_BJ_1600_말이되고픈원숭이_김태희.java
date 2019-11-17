package 보충3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BFS
public class Main_BJ_1600_말이되고픈원숭이_김태희 {

	static int map[][];
	static int row,col, endX,endY, count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		count = Integer.parseInt(in.readLine().trim()); // 말의움직임으로 이동가능한 횟수
		StringTokenizer st = new StringTokenizer(in.readLine());
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		endX = row-1;
		endY = col-1;
		map = new int[row][col];
		
		for(int i=0; i<row; ++i){
			st = new StringTokenizer(in.readLine().trim());
			for(int j=0; j<col; ++j){
				map[i][j] = Integer.parseInt(st.nextToken()); //0은 아무것도 없는 평지, 1은 장애물
			}
		}
		System.out.println(move());
	}
	
	static int[][][] direction = {  
									{{-1,0},{1,0},{0,-1},{0,1}},//상하좌우
									{{-1,-2},{1,-2},{-2,-1},{2,-1},{-2,1},{2,1},{-1,2},{1,2}}, // 말움직임 방향 
								};
	private static int move() {
		int moveCnt = 0 ,temp[] = null,x=0,y=0,nx=0,ny=0,cnt=0;
		boolean visited[][][] = new boolean[count+1][row][col];
		
		Queue<int[]> queue = new LinkedList<int[]>();
		visited[count][0][0] = true;
		queue.offer(new int[]{count,0,0,0});
		
		while(!queue.isEmpty()){
				temp = queue.poll();
				cnt = temp[0];
				x = temp[1];
				y = temp[2];
				moveCnt = temp[3];
				
				if(x==endX && y==endY)return moveCnt;
				
				for(int h=0;h<2;++h){ // h:0(원숭이의움직임), 1:(말의움직임)
					if(h==1){ 
						if(cnt==0) break; //말움직임 이동 불가
						else cnt--;
					}
					for(int d=0; d<direction[h].length; ++d){
						nx = x + direction[h][d][0];
						ny = y + direction[h][d][1];
						
						if(nx>=0 && nx<row && ny>=0 && ny<col 
								&& map[nx][ny]==0 // 평지 
								&& !visited[cnt][nx][ny]){ 
							visited[cnt][nx][ny] = true;
							queue.offer(new int[]{cnt,nx,ny,moveCnt+1});							
						}
					}	
				}
		}
		return -1;
	}
}
