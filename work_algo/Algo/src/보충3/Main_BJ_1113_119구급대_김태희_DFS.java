package 보충3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
// 백트랙킹
// max 사이즈로 할시 스택오버플로 발생.(97까지 가능했음)
public class Main_BJ_1113_119구급대_김태희_DFS {
    static int N, M;
    static int tx, ty;
    static int[][] map,dMap;    
    static int[] dx ={-1,1,0,0};
    static int[] dy ={0,0,-1,1};
    static int minDrift=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
    	long start = System.nanoTime();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine().trim());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        map=new int[N][M];
        dMap=new int[N][M];
        
        st=new StringTokenizer(br.readLine().trim());
        tx=Integer.parseInt(st.nextToken());
        ty=Integer.parseInt(st.nextToken());
         
        for (int i = 0; i < N; ++i) 
			for (int j = 0; j < N; ++j) {
				dMap[i][j] = Integer.MAX_VALUE;
			}
        
        for(int i=0;i<N;i++){                 
            st=new StringTokenizer(br.readLine().trim());
            for(int j=0;j<M;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
         
        //1은 도로, 0은 벽
        dMap[0][0]=0;
        ambulance(0, 0, 1, 0); // 세로
        ambulance(0, 0, 3, 0); // 가로
        System.out.println(minDrift);
        
        System.out.println(System.nanoTime()-start);
    }
     
    public static void ambulance(int x, int y, int dir, int drift){
        if(x==tx && y==ty){
            if(minDrift>drift) minDrift=drift;
            return;
        }
        int nx, ny;
        for(int d=0;d<4;d++){
            nx=x+dx[d];
            ny=y+dy[d];
            if(nx>=0 && nx<N && ny>=0 && ny<M &&map[nx][ny]==1 
            		&& minDrift>drift){
                if(dir==d && drift<=dMap[nx][ny]) {
                	dMap[nx][ny] = drift;
                	ambulance(nx, ny, d, drift);
                }else if(dir != d && drift+1<=dMap[nx][ny]){
                	dMap[nx][ny] = drift+1;
                	ambulance(nx, ny, d, drift+1);	                
                }
            }
        }
    }
 
}
