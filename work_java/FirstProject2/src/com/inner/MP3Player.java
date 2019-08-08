package com.inner;
//Anonymous class
//꼭 추상메서드가 아니더라도 오버라이딩해서 1회용 객체를 만들때 사용할 수 있다.
abstract class Song{ //추상클래스(생성불가) - 생성하려면 (메서드를 모두 완성하는)자식으로 생성해야함
	public abstract void sing();
	
	
}
interface Video{
	//int num = 99;
	void play();
}


public class MP3Player {
	
	public void play(Song s) { //Song의 자식 객체가 들어가야함
		s.sing();
	}
	public void play(Video v) { //play()메소드 오버로딩
		v.play();
	}

	public static void main(String[] args) {
		MP3Player player = new MP3Player();
		player.play(new Song() { //Song클래스를 만드는것이 아니고! Song을 상속받는(extends하는), 무명의 자식 클래스 정의 및 new
			public void sing() { //Song이 가지고 있던 추상 메소드 완성
				System.out.println("happy happy song!!!");
			}
		}); //여기까지 player.play(무명객체);
		
		player.play(new Song() {
			public void sing() { //Song이 가지고 있던 추상 메소드 완성
				System.out.println(this.getClass().getName()); //com.inner.MP3Player$2 : 두번째 무명클래스의 이름 2.
			}
		});
		
		player.play(new Video() { //Video인터페이스를 구현하는 무명의 클래스를 정의 및 생성
			@Override 
			public void play() {
				System.out.println(this.getClass().getName()); //com.inner.MP3Player$3
			} 
		});
		
	}

}
