package 문제풀이5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//불번지는 문제와 유사
//며칠이 지나면 토마토가 다 익는지 (최소) 일수
public class Main_BJ_7576_JO_2613_토마토고_서울9반_김동주 {
	public static int N,M,sangja[][],i,j,days,ni,nj;
	public static boolean allripe,isripe;//,canberipen;
	public static Queue<int[]> q;
	public static final int[] di = {-1,1,0,0};
	public static final int[] dj = {0,0,-1,1}; //상하좌우
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_JO_2577.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        q = new LinkedList<>();
        sangja = new int[N][M];
        allripe = true;
        isripe = false;
        
        for(int n=0;n<N;n++) {
        	st = new StringTokenizer(br.readLine());
        	for(int m=0;m<M;m++) {
        		sangja[n][m] = Integer.parseInt(st.nextToken());
        		//1 은 익은 토마토, 0 은 익지 않은 토마토, -1 은 빈곳
        		if(sangja[n][m] == 0) allripe = false;
        		if(sangja[n][m] == 1) {
        			isripe = true;
        			q.add(new int[] {n,m,0});
        		}
        	}
        }
        //
        if(allripe) { //다 1인 경우가 아니고 0이 없는 경우
        	System.out.print(0);
        }else if(isripe) { //0과 1이 있는 경우
        	//만약 토마토가 한개도 안들어 있다면 어쩌지 > 0이겠지
        	int[] curr;
        	while(!q.isEmpty()) { //익은토마토를 꺼내서 전염시키기
        		curr = q.poll();
        		i = curr[0];
        		j = curr[1];
        		days = curr[2];
        		//canberipen = false;
        		for(int d=0;d<4;d++) { //주변에 안익은게 있으면 익히기
        			ni = i + di[d];
        			nj = j + dj[d];
        			if(ni>=0 && nj>=0 && ni<N && nj<M && sangja[ni][nj] ==0) {
        				//canberipen = true;
        				sangja[ni][nj] = 1;
        				q.offer(new int[] {ni,nj,days+1});
        			}
        		}
/*        		if(!canberipen) { //다돌았는데 못익음(다시 큐에 넣기)
        			//System.out.print(-1);
        			//System.exit(0);
        			q.offer(new int[] {i,j,days+1});
        		}*/
        	}
        	//
        	for(int n=0;n<N;n++) {
        		for(int m=0;m<M;m++) {
        			if(sangja[n][m] ==0) {
        				System.out.print(-1);
        				System.exit(0);
        			}
        		}
        	}
        	System.out.print(days);
        }else {//0은 있는데 1이 없는 경우
        	System.out.print(-1);
        }
	}

}
