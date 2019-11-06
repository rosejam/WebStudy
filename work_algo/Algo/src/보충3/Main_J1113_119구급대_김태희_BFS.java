package 보충3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
/*
5 5
4 4
1 0 1 1 1
1 1 1 0 1
0 0 0 1 1
1 1 0 1 0
1 1 1 1 1
 */

// BFS + Queue
public class Main_J1113_119구급대_김태희_BFS {
    static int N, M;
    static int tx, ty;
    static int[][] map,dMap;    
    static int[] dx ={-1,1,0,0};
    static int[] dy ={0,0,-1,1};
    public static void main(String[] args) throws IOException {
//    	long start = System.nanoTime();
//    	System.setIn(new FileInputStream("1113.txt"));    	
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine().trim());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        map=new int[N][M];
        dMap=new int[N][M];
        st=new StringTokenizer(br.readLine().trim());
        tx=Integer.parseInt(st.nextToken());
        ty=Integer.parseInt(st.nextToken());
         
        for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				dMap[i][j] = Integer.MAX_VALUE;
			}
		}
        for(int i=0;i<N;i++){                 
            st=new StringTokenizer(br.readLine().trim());
            for(int j=0;j<M;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(ambulance());
//        System.out.println(System.nanoTime()-start);
    }
     
    static class Point{
    	int x,y,dir,drift;

		public Point(int x, int y, int dir, int drift) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.drift = drift;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", dir=" + dir + ", drift=" + drift + "]";
		}
		
    }
    public static int ambulance(){
    	
    	int minDrift=Integer.MAX_VALUE;
    	Queue<Point> queue = new LinkedList<Point>();
    	dMap[0][0] = 0;// 시작점 턴수
    	queue.offer(new Point(0, 0, 1, 0));//하
    	queue.offer(new Point(0, 0, 3, 0));//우
    	
    	Point p = null;
    	while (!queue.isEmpty()) {
			p = queue.poll();
	        if(p.x==tx && p.y==ty) {
	        	if(p.drift<minDrift) minDrift = p.drift;
	        	continue;
	        }
	        int nx, ny;
	        for(int d=0;d<4;d++){
	            nx=p.x+dx[d];
	            ny=p.y+dy[d];
	            if(nx>=0 && nx<N && ny>=0 && ny<M 
	            		&&map[nx][ny]==1){
	                if(p.dir==d && p.drift<=dMap[nx][ny]) {
	                	dMap[nx][ny] = p.drift;
	                	queue.offer(new Point(nx, ny, d, p.drift));
	                }
	                else if(p.dir != d && p.drift+1<=dMap[nx][ny]){
	                	dMap[nx][ny] = p.drift+1;
	                	queue.offer(new Point(nx, ny, d, p.drift+1));	                
	                }
	            }
	        }
		}
    	return minDrift;
    }
 
}
