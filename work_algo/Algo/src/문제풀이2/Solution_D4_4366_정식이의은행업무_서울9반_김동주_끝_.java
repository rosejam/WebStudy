package 문제풀이2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
 
public class Solution_D4_4366_정식이의은행업무_서울9반_김동주_끝_ {
    public static int T,twl,thrl,diff,ans,ff;
    public static String two;
    public static int twoint;
    public static String three;
    public static int thrint;
    public static void main(String[] args) throws Exception{
    	System.setIn(new FileInputStream("res/input_D4_4366.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            two = br.readLine();
            three = br.readLine();
            twoint = Integer.parseInt(two,2);
            thrint = Integer.parseInt(three,3);
             
            twl = two.length(); 
            thrl = three.length();
             
            diff = (int)Math.abs(twoint - thrint);
             
            //ff = find();
here:       for(int i=0; i<twl; i++) {
                for(int j=0; j<thrl; j++) {
                    for(int k=1; k<=2; k++)
                    if(Math.abs(Math.pow(2,i)+k*Math.pow(3,j)) == diff) {
                        ff=i;
                        break here;
                    }else if(Math.abs(Math.pow(2,i)-k*Math.pow(3,j)) == diff) {
                        ff=i;
                        break here;
                    }
                }
            }
         
            if(two.charAt(twl-1-ff)=='1') { //뒤에서부터의 순서이다.
                ans = twoint - (int)Math.pow(2,ff);
            }else{
                ans = twoint + (int)Math.pow(2,ff);
            }
             
            sb.append("#"+tc +" "+ans+"\n");
            //System.out.println("#" + tc + " ");
        }
        System.out.print(sb);
        //br.close();
    }
    //public static int find() {}
}
