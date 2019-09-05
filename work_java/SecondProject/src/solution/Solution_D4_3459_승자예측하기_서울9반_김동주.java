package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D4_3459_승자예측하기_서울9반_김동주 { //나는 안넘게, 상대는 2x하면 N초과 되도록 2x +1
    static long N;
    static int T,n,diff,d2;
    static boolean w; //false이면 alice true면 bob
    public static void main(String[] args) throws Exception {
    	//System.setIn(new FileInputStream("res/input_D4_3459.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Scanner sc = new Scanner(System.in);
    	StringBuilder sb = new StringBuilder();
        
        T = Integer.parseInt(br.readLine());
    	//T = sc.nextInt();
    	
        for(int tc=1; tc<=T; tc++) {
            N = Long.parseLong(br.readLine());
            //N = sc.nextLong();
            n = (int) (Math.log10(N)/Math.log10(2)); //L의 레벨
            if (!game(1,0,false)) sb.append("#" + tc + " Alice\n");
            else sb.append("#" + tc + " Bob\n");
        }
        System.out.println(sb);
    }
         
    public static boolean game(long x, int curr, boolean w) {
    	diff = n-curr; //층차이
    	d2 = diff%2;
    	
        if(N >= (long)((x+1)*Math.pow(2, diff)-1)){ //바닥이 평평할 때
            if(d2 == 0) return !w; //짝수층 차이나면 !w가 이김(지금 턴 아닌애)
            else return w;
        }else if(N < (long)(x*Math.pow(2, diff))){ //바닥이 평평할 때
            if(d2 == 0) return w; //홀수층 차이나면 w가 이김(지금 턴인 애)
            else return !w;
        }else {
            if(d2 == 0) return game(x*2+1, curr+1, !w); //짝수층 차이날 때는 오른쪽으로(조금이라도 홀수일확률이 있게!!)
            else return game(x*2, curr+1, !w); //홀수층 차이날 때는 왼쪽으로
        }
    }
}