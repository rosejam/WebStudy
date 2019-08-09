package list;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D3_2805_농작물수확하기_서울9반_김동주 {
	static int N;
	static byte T;
	//static StringTokenizer st;
	static String line;
	//static int[][] X;
	static int tot;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_D3_2805.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Byte.parseByte(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            N = Integer.parseInt(br.readLine());
            //X = new int[N][N];
            tot = 0;
/*            for(int n=0; n<N; n++) {
                line = br.readLine();
                for(int m=0; m<N; m++) {
                    X[n][m] = line.charAt(m)-'0';
                    if(n<=N/2) {
                        if(m<=N/2+n && m>=N/2-n) {
                            tot += X[n][m];
                        }
                    }else {
                        if(m<=N/2+(N-n-1) && m>=N/2-(N-n-1)) {
                            tot += X[n][m];
                        }
                    }
                } 
            }*/
            for(int n=0; n<N/2; n++) {
            	line = br.readLine();
            	for(int m=N/2-n ; m<=N/2+n ; m++) {
            		tot += line.charAt(m)-'0';
            	}
            } 
            for(int n=N/2; n<N; n++) {
            	line = br.readLine();
            	for(int m=N/2-(N-n-1) ; m<=N/2+(N-n-1) ; m++) {
            		tot += line.charAt(m)-'0';
            	}
            }
            System.out.println("#" + tc + " " + tot);
        }
        br.close();
    }
}
