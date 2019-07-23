package com.object;

class Employee {//사원
	int num;
	String name;
	int salary;
	
	public Employee(int num, String name, int salary) {
		super();
		this.num = num;
		this.name = name;
		this.salary = salary;
	}

	double getBonus() {
		return salary * 0.2;
	}
}

public class Manager extends Employee {//과장
	int deptcode; 
	
	public Manager(int num, String name, int salary, int deptcode) {
		super(num, name, salary); //"super()메소드 : 부모 생성자 호출~" 부모와 중복되는 코드 없게함
/*		this.num = num;
		this.name = name;
		this.salary = salary; 이렇게 중복되면 에러발생*/ 
		this.deptcode = deptcode; 
	}
	
	//
	double getBonus() { //오버라이딩
		return salary * 0.3;
	}	
	
	


	public static void main(String[] args) {
		Employee tom = new Employee(100, "tom lee", 5000);
		Employee tom2 = new Manager(100, "tom lee", 5000, 1);
		Manager bill = new Manager(200, "bill jones", 7000, 1);
		
		System.out.println(tom.getBonus());
		System.out.println(tom2.getBonus());
		System.out.println(bill.getBonus());

	}

}
