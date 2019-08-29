package 문제풀이;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
 
public class Solution_D4_4408_자기방으로돌아가기_서울9반_김동주 {
    public static int T, Ans, N;
    public static int a,b, xxx, nn;
    public static ArrayList<Stud> ss;
    public static class Stud{
        int a,b;
        boolean used;
        public Stud(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    public static void goback(int x, int bbb) {
        if(x==ss.size()) return;
        if(!ss.get(x).used && ss.get(x).a > bbb) {
            ss.get(x).used = true;
            bbb = ss.get(x).b;
            nn--;
        }
        goback(x+1, bbb);
    }
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("res/input_D4_4408.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
         
        T = Integer.parseInt(br.readLine().trim());
        for(int tc=1; tc<=T; tc++) {
            N = Integer.parseInt(br.readLine().trim());
            nn=N;
/*          a = new int[N];
            b = new int[N];*/
            ss = new ArrayList<>();
            for(int n=0; n<N; n++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken())-1; //현재방
/*                if(a%2==0) a = a/2-1;
                else a /=2;*/
                a /= 2;
                b = Integer.parseInt(st.nextToken())-1; //목표방 //중복없음 0~199로 200가지
/*                if(b%2==0) b = b/2-1;
                else b /=2;*/
                b /=2;
                if(a<b) ss.add(new Stud(a,b));
                else ss.add(new Stud(b,a));
            } //세로로 몇번째 인지 가 저장됨!
            Collections.sort(ss, new Comparator<Stud>() { //a로 소팅
                @Override
                public int compare(Stud o1, Stud o2) {
                    return Integer.compare(o1.a, o2.a);
                }
            });
            //System.out.println(ss.get(0).a);
            Ans=0;
            xxx=0;
            /*for(int x=0; x<200; x++) {
            }*/
loop:       while(nn!=0) { //1초에 벌어지는 일
                Ans++;
                goback(xxx,-1);
                for(int i=0;i<N; i++) { //false잇으면
                    if(!ss.get(i).used) {
                        xxx=i;
                        continue loop;
                    }
                }
                //if(nn==0)break;
            }
            sb.append("#"+tc+" "+Ans+"\n"); //최소 몇 단위시간에 돌아가는지 측정
        }
        System.out.println(sb);
    }
}
