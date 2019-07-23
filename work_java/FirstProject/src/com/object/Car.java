package com.object;

public class Car { //클래스 설계
	//1. data(field, member field) = 전역변수 (클래스 내부에서 사용할수 있다.)
	//초기화 안된 부분은 기본값으로 나온다. = 클래스안의 필드(전역변수)는" default값"이 존재하고 아래와 같음
	int num; //0 
	String owner; //참조형은 null
	String model; //null
	boolean flag; //false
	double d; //0.0

	//constructor : 객체 생성시에 자동 실행되는 메소드
	//클래스 이름과 메소드 명이 동일해야 하고 리턴타입은 적지않음
	
	//"default 생성자!" : "파라메터가 없는" 생성자
	Car(){ //Car c = new Car();로 객체 생성후 실행되는 생성자
		//this.num = 0;
		this(0); //int를 하나 받는 생성자를 호출해서 대신 파라메터를 전달하고 시킨다.
	}
	
	Car(int num){
		//파라메터와 클래스의 필드가 이름이 같을 경우, 파라메터가 우선이므로, 필드이름 앞에는 this를 붙여야한다!
		//this.num = num;
		this(num, "xyz"); //전달 할때 없는 부분은 기준 값을 정해서 넣어준다. 
	}
	
	Car (int num, String owner){
		//this.num = num;
		//this.owner = owner;
		this(num, owner, "abc");
		
	}
	
/*	Car(int num, String model){
		this.num = num;
		this.model =model;
	}
	
	Car(String model, int num){ // 파라메터 순서나 파라메터 타입으로 바로 위의 생성자와 구분된다~
		this.num = num;
		this.model =model;
	}*/
	
	
	Car(int num, String model, String owner){ //얘도 생성자이다~ 이건 파라메터가 있는 생성자. Car()와 파라메터 개수로 구분한다.
		this.num = num; //this라는 키워드 = 지금 막 "new로 생성한 객체"를 말함!!!!
		this.model = model; 
		this.owner = owner;
	}
	
	//생성자가 여러개 ->"객체를 만들수 있는 방법"이 여러개라는 뜻
	
	//2. method
	void run() {
		String color = "red"; //메소드 안에서 선언되었기 때문에 이 메소드 안에서만 사용할 수 있다.
		System.out.println("running car!");
	}
	
	void stop() {
		int year= 1994; 
		//year는 클래스의 필드는 아니고 "메소드 안의 지역(local)변수" -> "default값이 없어서 초기화(값 setting)가 필요"함!!!
		System.out.println("stopping car!" + year);
	}
	void info() {
		System.out.println("num:"+num);
		System.out.println("model:"+model);
		System.out.println("num:"+owner);
		System.out.println("----------------------------");
	}
}
