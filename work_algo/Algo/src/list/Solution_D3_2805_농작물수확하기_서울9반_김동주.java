package list;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D3_2805_농작물수확하기_서울9반_김동주 {
	static int N;
	static int M;
	static byte T;
	//static StringTokenizer st;
	static String line;
	static int[][] X;//
	static int tot;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_D3_2805.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Byte.parseByte(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            N = Integer.parseInt(br.readLine()); //홀수
            M= N/2; //정수나누기는 버림. m은 가운데 인덱스
            tot = 0;
            X = new int[N][N];//
            for(int n=0; n<N; n++) {
                line = br.readLine();
                for(int m=0; m<N; m++) {
                    X[n][m] = line.charAt(m)-'0'; //char를 int로 바꾸는 방법 -'0'
                    
                    if(Math.abs(M-n) + Math.abs(M-m) <=M) tot += X[n][m]; ////맨하탄 자!!
//                    if(n<=N/2) {
//                        if(m<=N/2+n && m>=N/2-n) {
//                            tot += X[n][m];
//                        }
//                    }else {
//                        if(m<=N/2+(N-n-1) && m>=N/2-(N-n-1)) {
//                            tot += X[n][m];
//                        }
//                    }
                }
            }    
            
/*          for(int n=0; n<N/2; n++) {
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
            }*/
            
/*            for(int n=0; n<N; n++) {
            	int t = Math.abs(M-n); //
            	char[] ch = br.readLine().substring(t,N-t).toCharArray(); //한줄받아서 그 범위에 있는 것만 substring으로 잘라냄.
            	for(char c : ch) tot+=c-'0';
            }//예시 답안(배열을 사용하지 않음!!!)
*/          
            System.out.println("#" + tc + " " + tot);
        }
        br.close();
    }
}
