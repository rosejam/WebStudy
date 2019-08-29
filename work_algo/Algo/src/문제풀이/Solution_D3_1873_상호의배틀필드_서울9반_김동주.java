package 문제풀이;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_D3_1873_상호의배틀필드_서울9반_김동주 {
    public static int T,H,W,N,i,j,ni,nj;//,n;
    public static char[][] map;
    //public static char[] in;
    public static char d;
    public static String st, st2;
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("res/input_D3_1873.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            StringTokenizer nm = new StringTokenizer(br.readLine());
            H = Integer.parseInt(nm.nextToken());
            W = Integer.parseInt(nm.nextToken());
            map = new char[H][W];
            for(int h = 0; h < H; h++){
                st = br.readLine();
                for(int w=0; w<W; w++) {
                    map[h][w] = st.charAt(w);
                    if(map[h][w] == '^' || map[h][w] == 'v' || map[h][w] =='<' ||map[h][w] =='>') {
                        i=h; j=w; d=map[h][w]; //시작 좌표찾아두기
                    }
                }
            }//맵완성
            N = Integer.parseInt(br.readLine()); //사용자 입력개수
            //in = new char[N];
            st2 = br.readLine();
/*          for(int n=0; n<N; n++) {
                in[n] = st2.charAt(n);
            }//인풋받음
*/          //n=0;
            //ni=i; nj=j;
            start(i,j,0,d);
            sb.append("#"+tc+" ");
            for(int h = 0; h < H; h++){
                for(int w=0; w<W; w++) {
                    sb.append(map[h][w]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
    private static void start(int ii, int jj, int t, char d) {
        if(t==N) return;
        switch (st2.charAt(t)) {
            case 'U':
                ni = ii-1;
                nj=jj;
                d = '^';
                if(ni>=0 && nj>=0 && ni<H && nj<W && map[ni][nj]=='.') {
                    map[ii][jj]='.';
                    map[ni][nj]=d;
                    start(ni,nj,t+1,d);
                }
                else {
                    map[ii][jj] = d;
                    start(ii,jj, t+1,d);
                }
            break;
            case 'D':
                ni = ii+1;
                nj=jj;
                d = 'v';
                if(ni>=0 && nj>=0 && ni<H && nj<W && map[ni][nj]=='.') {
                    map[ii][jj]='.';
                    map[ni][nj]=d;
                    start(ni,nj,t+1,d);
                }
                else {
                    map[ii][jj] = d;
                    start(ii,jj, t+1,d);
                }
            break;
            case 'L':
                nj = jj-1;
                ni=ii;
                d = '<';
                if(ni>=0 && nj>=0 && ni<H && nj<W && map[ni][nj]=='.') {
                    map[ii][jj]='.';
                    map[ni][nj]=d;
                    start(ni,nj,t+1,d);
                }
                else {
                    map[ii][jj] = d;
                    start(ii,jj, t+1,d);
                }
            break;
            case 'R':
                nj = jj+1;
                ni=ii;
                d = '>';
                if(ni>=0 && nj>=0 && ni<H && nj<W && map[ni][nj]=='.') {
                    map[ii][jj]='.';
                    map[ni][nj]=d;
                    start(ni,nj,t+1,d);
                }
                else {
                    map[ii][jj] = d;
                    start(ii,jj, t+1,d);
                }
            break;
            case 'S'://처음마주치는 벽돌벽 없애고 사라지기 or 처음 마주치는 강철벽만나면 사라지기
                switch(d) {
                case '^':
                    for(int l=1; l<=ii; l++) {
                        ni = ii-l;
                        nj = jj;
                        if(map[ni][nj] =='*') {
                            map[ni][nj]='.';
                            break;
                        }else if(map[ni][nj] =='#') {
                            break;
                        }
                    }
                break;
                case 'v':
                    for(int l=1; l<H-ii; l++) {
                        ni = ii+l;
                        nj = jj;
                        if(map[ni][nj] =='*') {
                            map[ni][nj]='.';
                            break;
                        }else if(map[ni][nj] =='#') {
                            break;
                        }
                    }
                break;
                case '<':
                    for(int l=1; l<=jj; l++) {
                        ni = ii;
                        nj = jj-l;
                        if(map[ni][nj] =='*') {
                            map[ni][nj]='.';
                            break;
                        }else if(map[ni][nj] =='#') {
                            break;
                        }
                    }
                break;
                case '>':
                    for(int l=1; l<W-jj; l++) {
                        ni = ii;
                        nj = jj+l;
                        if(map[ni][nj] =='*') {
                            map[ni][nj]='.';
                            break;
                        }else if(map[ni][nj] =='#') {
                            break;
                        }
                    }
                break;
                default:
                break;
                }
            start(ii,jj, t+1,d);
            break;
            default:
            break;
        }
    }
}