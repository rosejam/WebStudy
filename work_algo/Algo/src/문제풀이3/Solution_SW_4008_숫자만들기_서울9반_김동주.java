package 문제풀이3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SW_4008_숫자만들기_서울9반_김동주 { //BJ_14888과 같은 문제지만 펌콤은 시간초과나서 DFS로 한다
//N수 : 순서 그대로
//N-1연산자 : 4가지, 순서 바꾸기
//계산은 앞부터 하므로 dfs로 들어가기. 필요한 만큼만 계산 할 수 있다.
	public static int max, min, T, N;//, n, r; //int
	public static int[] nums, ops, a;
	public static boolean[] v;
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_SW_4008.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			nums = new int[N];
			ops = new int[4];
			//
			StringTokenizer numl = new StringTokenizer(br.readLine());
			for(int i=0;i<4;i++) { //누적안하고 그냥 받기
				ops[i] = Integer.parseInt(numl.nextToken());
			} ///+0, -1, *2, /3 의 순서로 개수가 주어짐 총 N-1개
			//
			numl = new StringTokenizer(br.readLine());
			int nn=0;
			while(numl.hasMoreTokens()) {
				nums[nn++] = Integer.parseInt(numl.nextToken());
			}
			//
			//입력 다받음
			//System.out.print(ops[3]); //N-1이어야 함
			//n=N-1;r=N-1;
			v = new boolean[N-1]; a = new int[N-1];
			//위는 펌콤쓰기 위해 필요함
			max = Integer.MIN_VALUE; min = Integer.MAX_VALUE;
			dfs1(nums[0],1);
			//dfs2(ops[0],ops[1],ops[2],ops[3],num[0], 0); //마지막은 depth
			//
			sb.append('#').append(tc).append(' ').append(max-min).append('\n');
		}
		System.out.print(sb);
	}
	private static void dfs1(int calc, int depth) {
		if(depth == N) {
			max = (max>calc)? max : calc;
			min = (min<calc)? min : calc;
			return;
		}
		if(ops[0]>0) {
			ops[0]--;
			dfs1(calc+nums[depth], depth+1);
			ops[0]++;
		}
		if(ops[1]>0) {
			ops[1]--;
			dfs1(calc-nums[depth], depth+1);
			ops[1]++;
		}
		if(ops[2]>0) {
			ops[2]--;
			dfs1(calc*nums[depth], depth+1);
			ops[2]++;
		}
		if(ops[3]>0 && nums[depth] !=0) {
			//if(nums[depth] ==0) return;//?
			ops[3]--;
			dfs1(calc/nums[depth], depth+1);
			ops[3]++;
		}
	}
}
