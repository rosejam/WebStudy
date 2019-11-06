package 보충_IM;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_6730_장애물경주난이도_서울9반_김동주_끝_ {
    public static int T,N,n,um,dm;
    public static int[] a;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            N = Integer.parseInt(br.readLine());
            a = new int[N]; //경기장
            n=0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) { //N개의 정수
                a[n++]=Integer.parseInt(st.nextToken());
            }
            n=0;
            um=0; dm=0;
            while(n<N-1) {
                if(a[n+1]-a[n]>=0) { //올라감
                    if((a[n+1]-a[n])>um) um=a[n+1]-a[n];
                }else {//내려감
                    if((a[n]-a[n+1])>dm) dm=a[n]-a[n+1];
                }
                n++;
            }
            sb.append("#"+tc+" "+um+" "+dm+"\n"); //올변, 내변
        }
        System.out.println(sb);
    }
}
