package 문제풀이5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//불번지는 문제와 유사
//며칠이 지나면 토마토가 다 익는지 (최소) 일수
public class Main_BJ_7569_JO_2606_토마토초_서울9반_김동주 { //정올에는 스캐너 써야지 다맞음
	public static int N,M,H,sangja[][][],i,j,k,days,ni,nj,nk;
	public static boolean allripe,isripe;//,canberipen;
	public static Queue<int[]> q;
	public static final int[] di = {0,-1,1,0,0,0};
	public static final int[] dj = {0,0,0,-1,1,0};
	public static final int[] dk = {-1,0,0,0,0,1};
	public static void main(String[] args) throws Exception {
		//System.setIn(new java.io.FileInputStream("res/input_BJ_7569.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());//높이 0층부터~
        
        q = new LinkedList<>();
        sangja = new int[H][N][M];
        allripe = true;
        isripe = false;
        
        for(int h=0;h<H;h++) {
	        for(int n=0;n<N;n++) {
	        	st = new StringTokenizer(br.readLine());
	        	for(int m=0;m<M;m++) {
	        		sangja[h][n][m] = Integer.parseInt(st.nextToken());
	        		//1 은 익은 토마토, 0 은 익지 않은 토마토, -1 은 토마토
	        		if(sangja[h][n][m] == 0) allripe = false;
	        		if(sangja[h][n][m] == 1) {
	        			isripe = true;
	        			q.add(new int[] {h,n,m,0});
	        		}
	        	}
	        }
        }
        //입력 다받음
        if(allripe) { //다 1인 경우가 아니고 0이 없는 경우
        	System.out.print(0);
        }else if(isripe) { //0과 1이 있는 경우
        	//만약 토마토가 한개도 안들어 있다면 어쩌지 > 0이겠지
        	int[] curr;
        	while(!q.isEmpty()) { //익은토마토를 꺼내서 전염시키기
        		curr = q.poll();
        		k = curr[0];
        		i = curr[1];
        		j = curr[2];
        		days = curr[3];
        		//canberipen = false;
        		for(int d=0;d<6;d++) { //주변(6방향)에 안익은게 있으면 익히기
        			nk = k + dk[d];
        			ni = i + di[d];
        			nj = j + dj[d];
        			if(nk >= 0 && ni>=0 && nj>=0 && nk<H && ni<N && nj<M && sangja[nk][ni][nj] ==0) {
        				//canberipen = true;
        				sangja[nk][ni][nj] = 1;
        				q.offer(new int[] {nk,ni,nj,days+1});
        			}
        		}
/*        		if(!canberipen) { //다돌았는데 못익음(다시 큐에 넣기)
        			//System.out.print(-1);
        			//System.exit(0);
        			q.offer(new int[] {i,j,days+1});
        		}*/
        	}
        	//
        	for(int h=0;h<H;h++) {
	        	for(int n=0;n<N;n++) {
	        		for(int m=0;m<M;m++) {
	        			if(sangja[h][n][m] ==0) {
	        				System.out.print(-1); //다돌았는데 안익음
	        				System.exit(0);
	        			}
	        		}
	        	}
        	}
        	System.out.print(days); //else
        }else {//0은 있는데 1이 없는 경우
        	System.out.print(-1);
        }
	}

}
