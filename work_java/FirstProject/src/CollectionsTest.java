import java.util.ArrayList;
import java.util.Collections;
//String, Wrapper 클래스(그 중 Boolean 제외~) 정렬
//이 클래스들은 이미 implements Comparable<String>등을 하고 있다!!
public class CollectionsTest {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(new Integer(10));
		list.add(new Integer(30));
		list.add(new Integer(2));
		list.add(new Integer(6));
		list.add(new Integer(5));
		list.add(new Integer(22));
		
		Collections.sort(list); //ArrayList를 정렬할때는 Collections클래스를 임포트해서 사용한다.
		System.out.println(list);
		
		ArrayList<String> list2 = new ArrayList<>();
		list2.add("welcome");
		list2.add("apple");
		list2.add("banana");
		list2.add("xman");
		list2.add("fill");
		
		Collections.sort(list2);
		System.out.println(list2);
	}

}
