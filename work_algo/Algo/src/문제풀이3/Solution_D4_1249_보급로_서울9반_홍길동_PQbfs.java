package 문제풀이3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
 
public class Solution_D4_1249_보급로_서울9반_홍길동_PQbfs {
     
    public static class Building{
        int sum, r, c;
 
        public Building(int r, int c, int sum) {
            this.sum = sum;
            this.r = r;
            this.c = c;
        }
 
        @Override
        public String toString() {
            return "Build [sum=" + sum + ", r=" + r + ", c=" + c + "]";
        }
 
 
    }
     
    public static int N, INF = Integer.MAX_VALUE/2;
    public static char[][] maps;
    public static boolean[][] v;
    public static int[] dr = {0,0,-1,1}, dc = {-1,1,0,0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
         
        for(int tc = 1;tc<=T; tc++) {
            N = Integer.parseInt(br.readLine());
            maps = new char[N][N];
            v = new boolean[N][N];
            for(int i = 0; i<N; i++) {
                maps[i] = br.readLine().toCharArray();
                for(int j = 0; j<N; j++) {
                    maps[i][j] -= '0';
                }
            }//INIT END
             
            sb.append("#" + tc + " "+PQBFS() + "\n");
        }//TEST CASE END
        System.out.print(sb);
    }
     
    public static int PQBFS() {
        PriorityQueue<Building> pq  = new PriorityQueue<>(new Comparator<Building>() {
            @Override
            public int compare(Building o1, Building o2) {
                return Integer.compare(o1.sum, o2.sum);
            }
        });
         
        pq.offer(new Building(0,0,0));
        v[0][0] = true;
        while(!pq.isEmpty()) {
            Building b = pq.poll();
             
            if(b.r == N-1 && b.c == N-1) {
                return b.sum;
                 
            }
             
            for(int d = 0; d<dr.length; d++) {
                int nr = b.r + dr[d];
                int nc = b.c + dc[d];
                 
                if(isIn(nr, nc) && !v[nr][nc] ){
                    v[nr][nc] = true;
                    pq.offer(new Building(nr, nc, b.sum + maps[nr][nc]));
                }
            }
        }
        return 0;
    }public static boolean isIn(int r, int c) {
        return (0<= r && r< N && 0<=c && c<N);
    }
}