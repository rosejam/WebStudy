package com.inter;
//interface를 implements해도 상속과 같음
class Truck{}
interface Other{
	//추상메소드...
}

public class ICircle extends Truck implements IShape, Other { //인터페이스는 다중 상속이 가능하다. 셋 모두 부모
	int r;
	
	public ICircle(int r) {
		this.r = r;
	}

	@Override
	public double getArea() {
		return 3.14 * r * r;
	}

	@Override
	public double getCircum() {
		return 2 * 3.14 * r;
	}

}
