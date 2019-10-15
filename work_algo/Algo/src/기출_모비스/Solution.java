package 기출_모비스;

import java.util.Arrays;
import java.util.Map.Entry;
import java.util.TreeMap;

class Solution {
	public static int TT,cnt;//,move;
	public static final char[][] key = {{'Q','W','E','R','T','Y','U','I','O','P'},{'A','S','D','F','G','H','J','K','L'},{'Z','X','C','V','B','N','M'}};
	//public static char[][] c = {{q},{r},{s}};
	public static final int[][] far = {{7,6,5,4,3,2,1,2,3,4},{6,5,4,3,2,1,0,1,2},{7,6,5,4,3,2,1}};
	public static int[] di = { 0,0,-1,1};
	public static int[] dj = {-1,1, 0,0};//좌우상하
	public static int solution(int T) {
        //if(T%2 != 0) return 0;
		TT = T;
        //half = T/2+1;
        //if(cnt==1) return cnt;
        //return 0;
		dfs(1,6,TT);
		return cnt%1000000007;
    }
	public static void dfs(int i, int j,int move) {
		if(move < far[i][j]) {
			if(move == 0 && i==1 && j==6) cnt++; 
			return;
		}
		for (int d=0; d<di.length; d++) { 
			int ni = i+di[d];
			int nj = j+dj[d];
			if(0<=ni && ni<3 && 0<=nj && nj<key[ni].length) { //범위체크 중요
				//if(dfs(ni,nj)==1) return 1; 
				dfs(ni,nj,--move);
			}
		}
	}
	public static void main(String[] args) {
		
    	System.out.println(solution(4));
	}
}