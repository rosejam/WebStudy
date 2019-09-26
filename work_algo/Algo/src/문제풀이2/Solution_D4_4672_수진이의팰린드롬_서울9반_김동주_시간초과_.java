package 문제풀이2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class Solution_D4_4672_수진이의팰린드롬_서울9반_김동주_시간초과_ { //재구성 -> 부분문자열 //DP로
	//길이 2,4,6,8,10인경우 팰린드롬은 좌우대칭이어야 함
	//길이 3,5,7,9인 경우 팰린드롬은 가운데 빼고 좌우대칭이어야 함
	//길이 1인 경우 팰린드롬은 그자체임
	//문자열의 순서는 상관이 없으므로 그냥 나올 수 있는 팰린드롬의 최대를 구하면 된다.
    public static int T,cnt,n,max,ll;
    public static char[] W,indx, indx2; //알파벳 소문자에서 -'a'
    //public static int[] alpha; //0~25
    public static boolean[] v,v2;
    public static void main(String[] args) throws Exception{
    	System.setIn(new FileInputStream("res/input_D4_4672.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
        	String line = br.readLine();
        	//alpha = new int[26];
        	ll = line.length(); //1~10
        	W = new char[ll];
        	for(int i=0; i<ll; i++) {
        		W[i] = line.charAt(i);// - 'a';
        		//alpha[W[i]]++; //개수 세기
        	}//인트배열로 바꿔 받았음
/*        	int ans = ll; //길이 1인경우 끝
        	for(int i=0; i<26; i++) {
        		if(alpha[i] > 0) { //좌우대칭을 만들 수 있음
        			for(int j=1; j<alpha[i]; j++) ans +=j; //피보나치 //하면 된다던데 이 이유는..?
        		}
        	}*/
        	
        	n=ll;
        	//ans = ll;//길이 1인경우 끝
        	max = Integer.MIN_VALUE;
        	v = new boolean[n];
    		indx = new char[n];
    		permcomb(0,0);

            //sb.append("#"+tc +" "+max+"\n");
            System.out.println("#"+tc+" "+max);
            //System.out.println("#"+tc+" "+ans);
        }
       // System.out.print(sb);
    }
	public static void permcomb(int start, int depth) { //npn //재구성
		if(depth == n) {
			//cnt++;
			//System.out.println(Arrays.toString(a));
			cnt = 0;
			for(int r=1; r<=n; r++) {
				//v2 = new boolean[n];
				//indx2 = new int[r];
				//part(0,0,r);
				part(r); //부분문자열 길이 r
			}
			
			if(cnt>max) max = cnt;
			return;
		}
		for(int i=0;i<n;i++) {
			if(!v[i]) {
				v[i]=true;
				indx[depth] = W[i];
				permcomb(i,depth+1);
				v[i]=false;
			}
		}
	}
/*	public static void part(int start, int depth, int r) { //npr //부분문자열 //npr이아님
		if(depth == r) {
			//cnt++;
			//System.out.println(Arrays.toString(a));
			pelin(indx2, r);
			return;
		}
		for(int i=0;i<n;i++) {
			if(!v2[i]) {
				v2[i]=true;
				indx2[depth] = indx[i];
				part(i,depth+1,r);
				v2[i]=false;
			}
		}
	}*/
	public static void part(int r) { //길이 r인 부분수열 만들기
		char[] ps = new char[r];
		for(int i=0; i<n-r+1; i++) {
			for(int j=0; j<r; j++) {
				ps[j] = indx[i+j];
			}
			pelin(ps,r);
		}
	}
	public static void pelin(char[] ps, int r) { //회문
		boolean fl = false;
		for(int i=0; i<r/2; i++) {
			if(ps[i] != ps[r-1-i]) fl = true; //회문이 아니다.
		}
		if(!fl) cnt++;
	}
}
