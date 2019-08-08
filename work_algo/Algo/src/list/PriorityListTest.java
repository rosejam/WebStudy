package list;

class PriorityMyLinkedList{
	Node head = new Node(); //더미객체 -> 헤드바로 앞을 delete할 때 코드가 깔끔해짐
							
	public void addFirst(int data) {
/*		Node n = new Node();
		n.data = data;
		n.link = head.link;
		head.link = n; //n은 Node n의 주소값!
*/		head.link = new Node(data, head.link);
	}
	public void append(int data) {
		if(head.link==null) {
			addFirst(data);
		}else { //뒤에넣기
			Node n = new Node();
			n.data = data;
			n.link = null;
			
			Node t = head; //더미를 가리킴
			while(t.link!=null) {
				if(t.link.data>data) { //찾으면
					n.link=t.link;
					t.link=n;
					return; //while을 빠져나가기 위함
				}else {
					t=t.link;
				}
			}
			t.link=n; //마지막 노드를 가리킴
		}
	}
	public void delete(int data) { //하나 앞쪽에서 비교
		if(head.link==null) return; //empty
		
		Node t = head; //더미를 가리킴
		while(t.link!=null) {
			if(t.link.data==data) { //여기서 1번 데이터 부터 찾기 위해서 //문자열이라면 equals()이용
				t.link = t.link.link;
			}else {
				t = t.link;
			}
		}
	}
	public void print() {
		if(head.link==null) return;
		
		Node t = head.link; //temp : 널인지 확인하기 위한 객체 //일단첫번째 부터
		while(t.link!=null) {
			System.out.print(t.data + "->");
			t = t.link;
		}
		System.out.println(t.data); //마지막 데이터
	}
}
public class PriorityListTest {

	public static void main(String[] args) {
		PriorityMyLinkedList ll = new PriorityMyLinkedList();
		ll.append(2);
		ll.append(3);
		ll.append(1);
		ll.print();
	}

}
