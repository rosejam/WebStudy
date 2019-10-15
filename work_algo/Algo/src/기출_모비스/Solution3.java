package 기출_모비스;

import java.util.Arrays;
import java.util.Map.Entry;
import java.util.TreeMap;

class Solution3 {
	public static char[][] map;
	public static char nm;
	public static boolean[][] v;
	public static boolean flag;
	public static int N,cnt0,cnt1,cnt2,cnt3;
	public static int solution(String[] board) {
        int answer = 0;
        N = board[0].length();
        map = new char[N][N];
        v = new boolean[N][N];
        for(int n=0; n<N; n++) {
        	String line = board[n];
        	for(int m=0; m<N; m++) {
        		map[n][m] = line.charAt(m);
        	}
        	//System.out.println(Arrays.toString(map[n]));
        }
        //맵만듬
        flag = false;
        for(int n=1; n<N-1; n++) {
        	for(int m=1; m<N-1; m++) {
        		nm = map[n][m];
        		if(map[n-1][m-1]==nm && map[n-1][m]!=nm && map[n-1][m+1]==nm && //!v[n][m] && 
        				map[n][m-1]!=nm && map[n][m+1]!=nm && 
        						map[n+1][m-1]==nm && map[n+1][m]!=nm && map[n+1][m+1]==nm) { //x의 중심지점
        			cnt0=0;cnt1=0;cnt2=0;cnt3=0;
        			int ni = n-1 ; int nj = m-1;
        			do {
        				cnt0++;
        				ni -= 1;
        				nj -= 1;
        			}while(ni >=0 && nj>=0 && ni<N && nj<N && map[ni][nj] == nm);
        			ni = n-1 ; nj = m+1;
        			do {
        				cnt1++;
        				ni -= 1;
        				nj += 1;
        			}while(ni >=0 && nj>=0 && ni<N && nj<N && map[ni][nj] == nm);
        			ni = n+1 ; nj = m-1;
        			do {
        				cnt2++;
        				ni += 1;
        				nj -= 1;
        			}while(ni >=0 && nj>=0 && ni<N && nj<N && map[ni][nj] == nm);
        			ni = n+1 ; nj = m+1;
        			do {
        				cnt3++;
        				ni += 1;
        				nj += 1;
        			}while(ni >=0 && nj>=0 && ni<N && nj<N && map[ni][nj] == nm);
//        			dfs0(n-1,m-1);
//        			dfs1(n-1,m+1);
//        			dfs2(n+1,m-1);
//        			dfs3(n+1,m+1);
//        			System.out.println(cnt0);
//        			System.out.println(cnt1);
//        			System.out.println(cnt2);
//        			System.out.println(cnt3);
        			//if(cnt0==cnt1 && cnt1==cnt2 && cnt2==cnt3) {
        			if(cnt0 > cnt1) cnt0 = cnt1; 
        			if(cnt0 > cnt2) cnt0 = cnt2; 
        			if(cnt0 > cnt3) cnt0 = cnt3; 
        			//가장 짧은게 cnt0
        			if(answer < cnt0) answer = cnt0;
//        				System.out.println(map[n][m]);
//        				System.out.println(cnt0);
        			//}
        			flag = true;
        			//sSystem.out.println("in");
        		}
        	}
        }
        //
        if(flag) return answer*2+1;
        return 0;
    }
/*    public static void dfs0(int i, int j) {
    	cnt0++;
    	//v[i][j] = true;
    	int ni = i -1;
    	int nj = j -1;
    	if(ni >=0 && nj>=0 && ni<N && nj<N && map[ni][nj] == nm) { //&& !v[ni][nj]
    		dfs0(ni,nj);
    	}
	}
    public static void dfs1(int i, int j) {
    	cnt1++;
    	v[i][j] = true;
    	int ni = i -1;
    	int nj = j +1;
    	if(ni >=0 && nj>=0 && ni<N && nj<N && map[ni][nj] == nm) {
    		dfs1(ni,nj);
    	}
    }
    public static void dfs2(int i, int j) {
    	cnt2++;
    	v[i][j] = true;
    	int ni = i +1;
    	int nj = j -1;
    	if(ni >=0 && nj>=0 && ni<N && nj<N && map[ni][nj] == nm) {
    		dfs2(ni,nj);
    	}
    }
    public static void dfs3(int i, int j) {
    	cnt3++;
    	v[i][j] = true;
    	int ni = i +1;
    	int nj = j +1;
    	if(ni >=0 && nj>=0 && ni<N && nj<N && map[ni][nj] == nm) {
    		dfs3(ni,nj);
    	}
    }*/
	public static void main(String[] args) {
    	String[] P1 = {"ABCBA","DABAG","EBABH","FAJAI","AKLMA"};
    	String[] P2 = {"ABCBA","DABAG","ENABH","FAJAI","AKLMO"};
    	
    	System.out.println(solution(P2));
	}
}