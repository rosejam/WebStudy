package queue;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

//public을 붙이면 에러.. public한 class는 파일명과 동일하게 하나만!!!(주로 main들어간 클래스로 함)
class StringComparator implements Comparator<String>{ 
	@Override
	public int compare(String o1, String o2) {
		return -o1.compareTo(o2); 	//기본형 데이터타입말고는 모두 이렇게 비교(객체 정렬 등) //오름차순 //내꺼 그 다음 비교하고자 하는것
									//"앞에 -를 붙이면 내림차순"
									//기본형 데이터  : Integer.compare(o1, o2);
	}
}

public class QueuePriority {
	public static void main(String[] args) {
		PriorityQueue<String> pq = new PriorityQueue<>(new StringComparator()); //Priority큐에 위에 작성한 Comparator객체를 인자로 전달
		PriorityQueue<int[]> pq2 = new PriorityQueue<>(new Comparator<int[]>(){ //Anonymous nested class
			@Override
			public int compare(int[] o1, int[] o2) {
				return -Integer.compare(o1[2], o2[2]); //3번째 원소를 기준으로 내림차순으로 정렬
			}
		});
		
		pq.offer("홍길동");
		pq.offer("강호동");
		pq.offer("사오정");
		System.out.println(pq); //안에 있는 순서는 상관X
		while(!pq.isEmpty()) System.out.println(pq.poll()); //나올때는 오름차순으로 잘 나온다.
		System.out.println();
	}
}
