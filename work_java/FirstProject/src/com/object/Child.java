package com.object;
//부모 클래스
class Parent{
	String name = "tom";
	String address = "seoul";
	//생성자
	Parent(){
		System.out.println("Parent 생성자");
	}
	
	String getName() {
		return name;
	}
	String getAddress() {
		return address;
	}
}
//자식 클래스
public class Child extends Parent { //상속받아서 다쓸 수 있게됨 .//파일하나에 클래스를 여러개 넣을 수도 있다. 
	String email = "me@me.com";
	//생성자
	Child(){
		System.out.println("Child 생성자");
	}
	
	//method overriding : 부모에게 물려받은 메서드를 자식클래스에 맞게 수정하는 일 - 이후 부터는 오버라이딩 된(재정의 된) 메소드로 실행이 된다~
	//1.메소드이름, 2.리턴타입, 3.파라메터를 수정하면 안되고 같아야함(수식어나 내용만 고칠 수 있음!)
	////접근지정자는 수정할 수 있음! 부모의 범위보다 자식의 접근지정자가 같거나 넓어지면 괜찮다.
	@Override ////annotation(프로그램의 실행 정보나 설정 정보, 단순한 정보제공이 목적인 기능 - 지워도 됨)
	protected String getName() {
		return "tomson";
	}
	
	void go() {
		System.out.println(super.name); //"오버라이딩된 후에" "부모의 메서드"를 호출하고 싶을 경우 "super."사용(수퍼를 쓰면 안내려옴)!!!! - 2개중첩해서 사용X, 한개한개 올라가야함
	}
	
	public static void main(String[] args) { 
		//상속관계가 존재하는 자식 객체를 생성하면 메모리에 부모 객체가 먼저 생성된다.
		//Child c = new Child(); //명시적으로 자식 객체를 생성할 때, 부모가 먼저생성되면서 부모의 생성자가우선 호출되고, 자식 객체가 생성된다!!
		Parent c = new Child(); //상속관계에서 부모가 자식보다 타입이 더 큼 //다형성
		
		System.out.println(c.getAddress()); //부모에게 상속받은 메서드 사용 가능
		System.out.println(c.getName()); //"c는 부모타입"이므로 원래는 "tom"이 나와야 하지만, 메서드가 "오버라이딩(재정의)"되어있으면 "무조건" 자식꺼를 호출!!(아래로 쭉 흘러내림!!!!) -> "tomson" 
		//System.out.println(c.go); //go는 자식타입에서 정의된 메서드 이므로 c레퍼런스에서는 사용불가
		//System.out.println(super.getName()); 
			//static이 붙어있는 메서드에서 super나 this 사용안됨!!!! -> go()에서 가져오기
		Child d = (Child)c; //객체간 type casting : 실제 객체 c에 실질적으로 Child(작은 타입)가 들어있었기 떄문에 가능
							//반대라면 컴파일은 되지만 실행이 안될 수 있다.
		
		d.go();
		
	}

}
