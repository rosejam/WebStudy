package list;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_D3_1230_암호문3_서울9반_김동주 {
	public static StringTokenizer st;
	public static int L;
	public static LinkedList<String> listl;
	//public static String[] ls;
	public static int N;
	//public static LinkedList<String> listn;
	//public static String[] ns;
	public static int x;
	public static int y;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_D3_1230.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			L = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine()); //2번째 줄
			listl = new LinkedList<>(); //새로 생성해주어야 함.
			for(int l=0; l<L; l++) {
				//listl.add(l, st.nextToken());
				listl.add(st.nextToken());
			}
			N = Integer.parseInt(br.readLine());
			//ns = new String[N];
			st = new StringTokenizer(br.readLine()); //4번째 줄
			for(int n=0; n<N; n++) {
				switch (st.nextToken()) {
					case "I":
						x = Integer.parseInt(st.nextToken());
						y = Integer.parseInt(st.nextToken());
						for(int i=0;i<y;i++) {
							listl.add(x+i, st.nextToken());
						}
						break;
					case "D":
						x = Integer.parseInt(st.nextToken());
						y = Integer.parseInt(st.nextToken());
						for(int i=0;i<y;i++) {
							listl.remove(x);
						}
						break;
					case "A":
						y = Integer.parseInt(st.nextToken());
						for(int i=0;i<y;i++) {
							listl.addLast(st.nextToken());
						}
						break;
	
					default:
						break;
				}
			}
			System.out.print("#" + tc);
			for(int j=0; j<10; j++) {
				System.out.print(" " + listl.pop());
			}
			System.out.println();
		}
	}
}


