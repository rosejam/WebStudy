package 문제풀이4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_정올_2074_홀수마방진_서울9반_김동주 {
	public static int N, mbj[][], limit;
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_D4_1249.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        mbj = new int[N][N];
        //mbj[0][N/2] = 1;
        limit = N*N;
        //cnt = 1;
        make(0,N/2,1); //처음 1을 넣을 자리
        
        for(int i=0; i<N-1; i++) {
        	for(int j=0; j<N-1; j++) {
        		sb.append(mbj[i][j]).append(' ');
        	}
        	sb.append(mbj[i][N-1]);
        	sb.append('\n');
        }
    	for(int j=0; j<N-1; j++) {
    		sb.append(mbj[N-1][j]).append(' ');
    	}
    	sb.append(mbj[N-1][N-1]);
    	
        System.out.print(sb);
	}
	
	private static void make(int i, int j, int cnt) {
		//좌표 범위 벗어난 경우 우선 조정
		if(i == -1) i = N-1;
		if(j == -1) j = N-1;
		mbj[i][j] = cnt;
		if(cnt == limit) return;
		if(cnt % N == 0) {
//			if(i!=N-1)  //이건 왜 체크하지 않아도 되는지??
			make(i+1,j,cnt+1);
//			else make(0,j,cnt+1);
		}else {
/* 			//둘다 0,0인 경우 N-1,N-1로 가므로 이부분은 다음단계로 들어가서 조정
  			if(i==0) make(N-1,j-1,cnt+1);
			else if(j==0) make(i-1,N-1,cnt+1);
			else make(i-1,j-1,cnt+1);	*/
			make(i-1,j-1,cnt+1);
		}
	}

}
