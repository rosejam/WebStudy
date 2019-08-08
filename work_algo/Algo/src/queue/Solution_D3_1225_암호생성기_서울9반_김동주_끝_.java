package queue;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D3_1225_암호생성기_서울9반_김동주_끝_ {
/*	static int[] X = new int[8];
	static int[] Y = new int[8];*/
	static int x;
	static Queue<Integer> q = new LinkedList<>(); 

	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("res/input_D3_1225.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		for(int tc = 1; tc <= 10; tc++){
			br.readLine(); //한줄 버리기
			String line = br.readLine(); //라인단위로 String으로 읽어들임.
			StringTokenizer st = new StringTokenizer(line); //8개 들어있음
			q = new LinkedList<>(); 
			q.offer( Integer.parseInt(st.nextToken()));
			q.offer( Integer.parseInt(st.nextToken()));
			q.offer( Integer.parseInt(st.nextToken()));
			q.offer( Integer.parseInt(st.nextToken()));
			q.offer( Integer.parseInt(st.nextToken()));
			q.offer( Integer.parseInt(st.nextToken()));
			q.offer( Integer.parseInt(st.nextToken()));
			q.offer( Integer.parseInt(st.nextToken()));
			
			
here:		while(true) {
				for(int i=1; i<=5; i++) {
					x = q.poll()-i;
/*					if(x>0) q.offer(x);
					else {
						q.offer(0);
						break here;
					}*/
					if(x<=0) {
						q.offer(0);
						break here; //return
					}
					q.offer(x);
				}
			} //이 while문을 메소드로 빼놓고 break는 return으로 대신한다. (public static메서드)
			
			
			//출력용
			System.out.print("#" + tc);
			for(int j=0; j<8; j++) { //while(!queue.isEmpty())
				System.out.print(" " + q.poll());
			}
			System.out.println();
		}
		br.close();
	}
}
