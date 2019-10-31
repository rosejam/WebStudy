package 문제풀이4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;

//비밀번호는 K번째로 큰 수의 10진수 (같은수는 같은 번째)
//한변은 N/4 개의 숫자가 있고 회전mod N/4 로 N/4가지의 상태가 나온다.
public class Solution_SW_5658_보물상자비밀번호_서울9반_김동주 {
	public static HashSet<Integer> set;
	public static ArrayList<Integer> list;
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_SW_5658.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			String line = br.readLine().trim(); //길이 N
			int M = N/4;
//			System.out.println(M);
			//입력
			set = new HashSet<>();
			for(int n=0; n<M; n++) {
				set.add(Integer.parseInt(line.substring(n,M+n), 16)); //M
//				System.out.println(line.substring(n,M+n));
				set.add(Integer.parseInt(line.substring(M+n,M*2+n), 16));
//				System.out.println(line.substring(M+n,M*2+n));
				set.add(Integer.parseInt(line.substring(M*2+n,M*3+n), 16));
//				System.out.println(line.substring(M*2+n,M*3+n));
				set.add(Integer.parseInt(line.substring(M*3+n,N).concat(line.substring(0,n)), 16));
//				System.out.println(line.substring(M*3+n,N).concat(line.substring(0,n)));
//				System.out.println("***");
			}
			list = new ArrayList<>(set); 
			Collections.sort(list, new Comparator<Integer>() { //주의!! 기본은 오름차순인데 문제 요구는 내림차순!
				@Override
				public int compare(Integer o1, Integer o2) {
					return Integer.compare(o2, o1);
				}
			});
			//출력
			//int pw = 0;
			sb.append('#').append(tc).append(' ').append(list.get(K-1)).append('\n');
		}
		System.out.println(sb);
	}

}
