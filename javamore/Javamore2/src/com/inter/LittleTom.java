package com.inter;

class Tom{
	String name = "Tom";
}
interface Jane{
	String name = "Jane"; //name이 기울은 이유 : static!!!
}

public class LittleTom extends Tom implements Jane {
	String name = "LittleTom";
	
	public void sayName() {
		System.out.println(super.name);//Tom
		System.out.println(Jane.name);//스태틱이므로 그냥클래스이름으로 사용 
		System.out.println(this.name);//LittleTom
	}
	
	public static void main(String[] args) {
		LittleTom little = new LittleTom();
		
		if(little instanceof Tom) {
			System.out.println("instanceof Tom");
		}
		
		if(little instanceof Jane) {
			System.out.println("instanceof Jane");
		}
		
		little.sayName();
	}//둘다부모임

}
