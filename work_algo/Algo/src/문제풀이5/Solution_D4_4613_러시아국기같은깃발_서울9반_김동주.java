package 문제풀이5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_4613_러시아국기같은깃발_서울9반_김동주 { //dfs로 풀 수 있음
	//흰0파1빨2 순서
	//새로 칠해야하는 칸의 개수 최소값
	public static int T,N,M,min,sum, xsum;
	public static String line;
	public static int[][] flag;
	public static int[][] linesum;
	public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("res/input_D4_4613.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
         
        T = Integer.parseInt(br.readLine());
        for(int tc= 1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            //flag = new int[N][M];
            linesum = new int[N][3];
            for(int n=0; n<N; n++) {
                line = br.readLine();
                for(int m=0; m<M; m++) {
                    switch(line.charAt(m)) {
                    case 'W':
                        //flag[n][m] = 0;
                        linesum[n][0]++;
                        break;
                    case 'B':
                        //flag[n][m] = 1;
                        linesum[n][1]++;
                        break;
                    case 'R':
                        //flag[n][m] = 2;
                        linesum[n][2]++;
                        break;
                    }
                }
                //System.out.println(Arrays.toString(flag[n]));
            }
            //현재 상태 입력받음
            //행나눔 N-1 C 2 //펌콤 또는 그냥 이중포문!
            min = Integer.MAX_VALUE;
            for(int x=1; x<N-1; x++) {
                xsum = 0;
                 
                for(int n=0; n<x; n++) {
                    xsum += linesum[n][1];
                    xsum += linesum[n][2];
                }
                 
                for(int y=x+1; y<N; y++) {
                    sum = xsum;
                     
                    for(int n=x; n<y; n++) {
                        sum += linesum[n][0];
                        sum += linesum[n][2];
                    }
                    for(int n=y; n<N; n++) {
                        sum += linesum[n][0];
                        sum += linesum[n][1];
                    }
                     
                    min = (min<sum)? min : sum;
                }
            }
             
            sb.append('#').append(tc).append(' ').append(min).append('\n');
            //System.out.println("#"+tc+" "+cnt);
        }
        System.out.print(sb);
         
    }

}
