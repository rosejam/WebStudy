package 문제풀이3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_14888_연산자끼워넣기_서울9반_김동주 {
//N수 : 순서 그대로
//N-1연산자 : 4가지, 순서 바꾸기 //n-1Pn-1으로 n-1! 그냥 모두 다르게 만들고 순열
//계산은 앞부터 /는 몫만(그냥 인트끼리 하기) 음수/양수이면 양수로 바꾸어 나누고 *-1
	public static int max, min, N;//, n, r; //int
	public static int[] nums, ops, a;
	public static boolean[] v;
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_BJ_14888.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		ops = new int[4];
		//
		StringTokenizer numl = new StringTokenizer(br.readLine());
		int nn=0;
		while(numl.hasMoreTokens()) {
			nums[nn++] = Integer.parseInt(numl.nextToken());
		}
		//
		numl = new StringTokenizer(br.readLine());
		ops[0] = Integer.parseInt(numl.nextToken());
		for(int i=1;i<4;i++) { //누적해서 받기
			ops[i] = Integer.parseInt(numl.nextToken()) + ops[i-1];
		} ///+0, -1, *2, /3 의 순서로 개수가 주어짐 총 N-1개
		//
		//입력 다받음
		//System.out.print(ops[3]); //N-1이어야 함
		//n=N-1;r=N-1;
		v = new boolean[N-1]; a = new int[N-1];
		//위는 펌콤쓰기 위해 필요함
		max = Integer.MIN_VALUE; min = Integer.MAX_VALUE;
		permcomb(0);
		//
		System.out.println(max);
		System.out.print(min);
	}
	private static void permcomb(int depth) {
		if(depth == N-1) {
			int[] calc = nums.clone();
			for(int j=0; j<N-1; j++) { //0~N-2로 N-1개
				if(a[j]<ops[0]) { //+
					calc[j+1] = calc[j] + calc[j+1];
				}else if(a[j]<ops[1]) { //-
					calc[j+1] = calc[j] - calc[j+1];
				}else if(a[j]<ops[2]) { //*
					calc[j+1] = calc[j] * calc[j+1];
				}else { // /
					if(calc[j+1]==0) return; //0으로 나눌 수 없다!!
//					if(calc[j]<0) {
//						calc[j+1] = (-1)*((-1)*calc[j] / calc[j+1]);
//					}else {
						calc[j+1] = calc[j] / calc[j+1];
//					}
				}
			}
			if(max < calc[N-1]) max = calc[N-1];
			if(min > calc[N-1]) min = calc[N-1];
			return;
		}
		//
		for(int i=0; i<N-1; i++) {
			if(!v[i]) {
				v[i] = true;
				a[depth] = i; //인덱스로 기존 배열을 생각
				permcomb(depth+1);
				v[i] = false;
			}
		}
		//
	}	
}
