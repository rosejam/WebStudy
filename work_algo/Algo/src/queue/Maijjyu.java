package queue;

import java.util.LinkedList;
import java.util.Queue;

public class Maijjyu {

	public static void main(String[] args) {
		//Queue<int[]> q = new LinkedList<>();
		Queue<Integer> q = new LinkedList<>();
		int num=1;
		int cnt=20;
		int tot=0; //cnt를 빼서 tot에 넣는다.
		int tnum=-1;//
		int[] recv=null;
		//q.offer(new int[] {num,1});
		q.offer(num); q.offer(1);
		while(cnt>0) {
			tnum=q.poll();
			//recv=q.poll();
			//int su=(recv[1]>cnt)? cnt : recv[1];
			int tsu = q.poll();
			int su=(tsu>cnt)? cnt : tsu;
			
			cnt=cnt-su;
			tot=tot+su;
			//System.out.println(recv[0]+"번"+su+"개 남은수:"+cnt);
			System.out.println(tnum+"번"+su+"개 남은수:"+cnt);
			q.offer(tnum); q.offer(++tsu);
			q.offer(++num); q.offer(1);
/*			recv[1]++;
			q.offer(recv);
			q.offer(new int[] {++num,1});*/
		}
		System.out.println("마지막 받은 사람="+tnum);
		System.out.println(tot);
	}

}
