package 문제풀이2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_3074_입국심사_서울9반_김동주_미완_ { //바이너리 서치
	public static int T,M,N;
	public static double ssum;
	public static int[] t;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_D4_3074.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
        	StringTokenizer nm = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(nm.nextToken());
        	M = Integer.parseInt(nm.nextToken());
        	t = new int[N];
        	ssum = 0;
        	for(int k=0; k<N; k++) {
        		t[k] = Integer.parseInt(br.readLine());
        		ssum += (double) 1/t[k]; //초당 몇사람 (속도)
        	}
        	//ssum * ans >= M;
        	int time = (int) Math.ceil((M)/ssum);
        	sb.append("#"+tc+" "+time+"\n");
        }
        System.out.println(sb);
	}

}
