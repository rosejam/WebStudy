package 보충2;

import java.io.FileInputStream;
import java.util.Scanner;
 
public class Solution_D3_2805_농작물수확하기_Dfs_홍길동 {
    public static int[] di = {-1, 1, 0, 0}; //상하좌우
    public static int[] dj = {0, 0, -1, 1}; //상하좌우
    public static int N,c,sum;
    public static int[][] m;
    public static boolean[][] v;
     
    private static void dfs(int i, int j) {
        v[i][j] = true;
/*      if(Math.abs(c-i)+Math.abs(c-j)>c) return;
        sum += m[i][j];*/
        //또는
        sum += m[i][j];
        if(Math.abs(c-i)+Math.abs(c-j) ==c) return;
        for(int d = 0; d < di.length; d++) {
            int ni = i+di[d];
            int nj = j+dj[d];
            if(0<=ni && ni<N && 0<=nj && nj<N && v[ni][nj] == false) {// && Math.abs(c-ni)+Math.abs(c-nj)<=c) {
                dfs(ni,nj);
            }
        }
    }
     
    public static void main(String[] args)throws Exception{
    	System.setIn(new FileInputStream("res/input_d3_2805.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
         
        for(int t=1; t<=T; t++) {
            N = sc.nextInt();
            c=(N-1)/2;
            m = new int[N][N];
            v = new boolean[N][N];
             
            for(int i=0; i<N; i++) {
                String s = sc.next();
                for(int j=0; j<N; j++) {
                    m[i][j] = s.charAt(j)-'0';
                }
            }
            
            sum = 0;
            dfs(c,c);
            System.out.println("#" + t + " " + sum);
        }
        sc.close();
    }
}