package com.basic;

public class SwitchTest_ {

	public static void main(String[] args) {
		char code = 'Y';
		switch (code) {
			case 'X':
			case 'x':
				System.out.println("room-101");
				break;
				
			case 'Y': //브레이크가 없으므로 아래껄 실행한 후 나감
			case 'y':
				System.out.println("room-201");
				break;
				
			case 'Z':
			case 'z':
				System.out.println("room-301");
				break;
				
			default:
				System.out.println("room-500");
				break;
		}
		
		
		int score = 80;
		switch (score) { //switch + <컨트롤+스페이스>단축키로 세팅
			//(조건)안에 byte, short, int, char, String("long을 제외한 정수형과 String만" 들어갈 수 있다.)
			case 90:
				System.out.println("level-1");
				break;
			case 80:
				System.out.println("level-2");
				//break; 브레이크가 없으면 case에 걸린 후 나가지 않고 아래로 쭉 내려감
			case 70:
				System.out.println("level-3");
				//break;
			default:
				System.out.println("no level");
				//break; 이건상관없음 어차피 마지막
		} 

	}

}
