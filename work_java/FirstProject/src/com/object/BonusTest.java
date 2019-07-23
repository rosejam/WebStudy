package com.object;

public class BonusTest { 
		void sayBonus(Employee who) { //인풋으로 변수가 아닌 임플로이 타입 "객체"를 받음.
			System.out.println(who.getClass().getName()); //클래스의 이름(패키지.클래스)
			System.out.println(who.getBonus());
			System.out.println("-------------------");
		}
		
		void sayBonus(Manager who) { //인풋으로 변수가 아닌 임플로이 타입 "객체"를 받음.
			System.out.println(who.getClass().getName()); //클래스의 이름(패키지.클래스)
			System.out.println(who.getBonus());
			System.out.println("-------------------");
		} //똑같은 함수를 또 작성한 overloading(다형성활용하면 필요X)
		
	public static void main(String[] args) {
		BonusTest bt = new BonusTest();
		Employee tom = new Employee(111, "tom brown", 3000);
		Manager bill = new Manager(789, "bill jones", 5000, 100);
		bt.sayBonus(tom);
		bt.sayBonus(bill); //크기비교해보면 임플로이에 들어갈 수있다. Employee who = bill;
		////"타입은 임플로이 이지만 매니저가 들어가고", "매니저에서 overriding"이 되었었기 때문에 오버라이딩된 getBonus()가 호출된다!!!!!!!!!!<다형성>

	}

}
