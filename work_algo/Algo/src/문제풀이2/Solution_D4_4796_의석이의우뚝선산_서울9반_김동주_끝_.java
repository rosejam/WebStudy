package 문제풀이2;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D4_4796_의석이의우뚝선산_서울9반_김동주_끝_ { //dp로도 풀 수 있음
													//BufferedReader readLine()으로 사용할 수 없는 테케가 나옴
	public static int n, T, cnt, N, up, down;
	public static int[] h;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_D4_4796.txt"));
		StringBuilder sb = new StringBuilder();
		
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//T = Integer.parseInt(br.readLine());
		
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			//br사용하는 경우
/*			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " \t\n\r\f");
			h = new int[N];
			n=0;cnt = 0;
			while(st.hasMoreTokens()) {
				h[n++] = Integer.parseInt(st.nextToken()); //같은 h는 없다.
			}
			//입력다받음
*/			
			//sc사용하는 경우
			cnt = 0;
			N = sc.nextInt();
			h = new int[N];
			for(int n=0; n<N; n++) {
				h[n] = sc.nextInt();
			}
			
			n=0;
			up = 0;
			down =0;
			//boolean topchck = false;
loop:		while(n<N-1) {
				//topchck = false;
				up = 0;
				//올라가는거 먼저(길이세기)
				while(h[n]<h[n+1]) {
					up++;
					n++;
					//topchck = true;
					if(n==N-1) break loop; //올라가는거로 끝남
				}
				//꼭대기
				//int top = n;
				
				//내려가는거 확인(길이세기)
				down = 0;
				while(h[n]>h[n+1]) {
					down++;
					n++;
					if(n==N-1) break; //내려가는거로 끝
				}
				//아래꼭지
				//int bottom = n;
				cnt += up*down; //내리막길만 있을 경우 0이므로 상관x
			}
			//sb.append("#"+tc+" "+cnt+"\n");
			sb.append('#').append(tc).append(' ').append(cnt).append('\n');
		}
		System.out.println(sb);
	}
	
	//참고 dp로도 풀수 있음 cnt+= dp[0][n] * dp[1][n];
/* static void make_dp() {
        int height = h[1];
        if(height > h[0]) {
            dp[0][1] = 1;
        }
        else dp[0][1] = 0;
        for(int i=1;i<N-1;i++) {
            if(h[i+1] > h[i]) {
                dp[0][i+1] = dp[0][i]+1;
            } else {
                dp[0][i+1] = 0;
            }
        }
        height = h[N-2];
        if(height > h[N-1]) {
            dp[1][N-2] = 1;
        }
        else dp[1][N-2] = 0;
        for(int i=N-2;i>0;i--) {
            if(h[i-1] > h[i]) {
                dp[1][i-1] = dp[1][i]+1;
            } else {
                dp[1][i-1] = 0;
            }
        }
    }*/
}
