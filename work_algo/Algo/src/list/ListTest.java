package list;

class MyLinkedList{
	Node head = new Node(); //더미객체 -> 헤드바로 앞을 delete할 때 코드가 깔끔해짐
							
	public void addFirst(int data) {
/*		Node n = new Node();
		n.data = data;
		n.link = head.link;
		head.link = n; //n은 Node n의 주소값!
*/		head.link = new Node(data, head.link);
	}
	public void addLast(int data) {
		if(head.link==null) {
			addFirst(data);
		}else { //뒤에넣기
			Node n = new Node();
			n.data = data;
			n.link = null;
			
			Node t = head.link; //temp : 널인지 확인하기 위한 객체
			while(t.link!=null) {
				System.out.print(t.data+"->");
				t = t.link;
			}
			t.link = n; //마지막 노드를 가리킴
		}
	}
	public void delete(int data) { //하나 앞쪽에서 비교
		if(head.link==null) return; //empty
		
		Node t = head; //더미를 가리킴 //t가 앞부터 쭉 따라간다.
		//1개가 아닌 여러개 삭제하려면 p도 필요
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
public class ListTest {

	public static void main(String[] args) {
		MyLinkedList ll = new MyLinkedList();
		ll.addFirst(3);
		ll.addFirst(2);
		ll.addFirst(1);
		ll.addLast(4);
		ll.addLast(5);
		ll.delete(1);
		ll.print();
	}
}
