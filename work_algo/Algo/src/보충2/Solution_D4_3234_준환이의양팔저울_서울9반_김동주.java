package 보충2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_3234_준환이의양팔저울_서울9반_김동주 {
	public static int TC, N, cnt, right, left;
	public static int[] choo;
	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input_D4_3234.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        TC=Integer.parseInt(br.readLine());
        for(int tc=1; tc<=TC; tc++) {
        	N=Integer.parseInt(br.readLine());
        	choo = new int[N];
        	st = new StringTokenizer(br.readLine());
        	int n=0;
        	while(st.hasMoreTokens()) {
        		choo[n++] = Integer.parseInt(st.nextToken());//꼭 n++로 받기..
        	}
        	//입력모두 받음
        	// 2^N * N!가지의 경우 중 
        	//오른쪽 위에 올라가있는 무게의 총합이 왼쪽에 올라가 있는 무게의 총합보다 커지지 않는 경우
        	cnt=0;
        	perm(0);
        	//dfs(weight, new boolean[N],0,0,0);
        	sb.append("#"+tc+" "+cnt+"\n");
        }
        System.out.println(sb);
        //br.close();
	}
	public static void puton(int dep) {
		if(right>left) return; //백트래킹
		if(dep == N) {
			cnt++; 
			return;
		}
		right+=choo[dep];
		puton(dep+1);
		right-=choo[dep];
		left+=choo[dep];
		puton(dep+1);
		left-=choo[dep];
		//return;
	}
	public static void swap(int i, int j) {
		if(i==j) return;
		int T=choo[i]; choo[i]=choo[j]; choo[j]=T;
	}
	public static void perm(int count) { //count는 레벨(깊이)를 의미한다!! //(int cur, int count)
		if(count == N){
			right=0; left=0;
			puton(0);
			return;
		}
		//swap을 시키므로 i=count부터 한다.
		for(int i=count; i<N; i++) {  
				swap(count,i);	
				perm(count+1);	
				swap(count,i);
		}
	}
	
	//예시답안
	public static int dfs(int[] weight, boolean[] check, int left, int right, int depth) {
		if(left<right) return 0;
		int r=0;
		if(weight.length == depth) return 1;
		for(int i=0; i<weight.length; i++) {
			if(check[i]) continue;
			check[i]=true;
			r=r+dfs(weight,check,left+weight[i],right,depth+1);
			r=r+dfs(weight,check,left,right+weight[i],depth+1);
			check[i]=false;
		}
		return r;
	}
}
