package graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_3289_서로소집합_서울9반_김동주 {
    public static int n, m;
    public static int a, b;
    public static byte op;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            StringTokenizer nm = new StringTokenizer(br.readLine());
            n = Integer.parseInt(nm.nextToken());
            m = Integer.parseInt(nm.nextToken());
            sb.append("#"+tc+" ");
            //makeset
            int[] p = new int[n+1];
            for(int i=1; i<n+1; i++) p[i]=i;
            for(int mm=0; mm<m; mm++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                op = Byte.parseByte(st.nextToken()); //0이면 합치고 1이면 같은집합인지 확인 //1이면 출력
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                //연산 진행//확인이면 결과 append
                if(op == (byte)0) {
                    unionParent(p,a,b);
                }else {
                    if(findParent(p,a,b)) 
                        sb.append(1);
                    else
                        sb.append(0);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
     
    public static int getParent(int[] p, int x) {
        if(p[x]==x) return x; //대표값까지 도달
        else return p[x]=getParent(p, p[x]); //p[x]에 대입하여서 Path compression까지 함께함
    }
    public static void unionParent(int[] p, int a, int b) {
        a=getParent(p,a);
        b=getParent(p,b);
        if(a<b) p[b]=a;
        else    p[a]=b;
    }
    public static boolean findParent(int[] p, int a, int b) {
        a=getParent(p,a);
        b=getParent(p,b);
        if(a==b)    return true; //같은 집합에 있다.
        else        return false; //다른 집합에 있다.
    }
}
