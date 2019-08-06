import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//부가 기준으로 정렬 시 정렬 기준 클래스를 새로 만듬
class ActorComparator implements Comparator<Actor>{
	@Override
	public int compare(Actor o1, Actor o2) { //Comparator<Actor>인터페이스를 완성하는 메서드
		String o1name = o1.getName();
		String o2name = o2.getName();
		return o1name.compareTo(o2name); //String은 이미 Comparable의 compareTo()메서드-정렬기준을 가지고 있다.
	}
}

//vo
class Actor implements Comparable<Actor>{ //자기클래스를 <>에 적어준다.
	private int num; //기본 정렬 기준
	private String name;
	private int age;
	
	public Actor(int num, String name, int age) {
		super();
		this.num = num;
		this.name = name;
		this.age = age;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Actor [num=" + num + ", name=" + name + ", age=" + age + "]";
	}

	@Override 
	public int compareTo(Actor other) { //Comparable<Actor>인터페이스를 완성하는 메서드
		//오름차순	
		if(this.getAge() < other.getAge())
			return -1; //기준(this)객체가 그자리에 그대로
		else if(this.getAge() == other.getAge())
			return 0; //기준객체가 그자리에 그대로
		else
			return 1; //기준객체가 자리를 바꿈!
	}

}
public class ActorTest{
	public static void main(String[] args) {
		ArrayList<Actor> list = new ArrayList<>();
		list.add(new Actor(12, "Hellen", 36));
		list.add(new Actor(5, "Julie", 17));
		list.add(new Actor(7, "Anne", 46));
		list.add(new Actor(2, "William", 25));
		
		Collections.sort(list);
		
		for(Actor a : list) {
			System.out.println(a.getAge() + ":" + a.getName());
		}
		
		Collections.sort(list, new ActorComparator());
		
		for(Actor a : list) {
			System.out.println(a.getName());
		}
	}
	
}
