package com.inter;

public class IPhone implements SmartPhone {
	public void call() {
		System.out.println("아이폰에서 전화를 겁니다.");
	}
	public void sendMessage() {
		System.out.println("아이폰에서 문자를 보냅니다.");
	}
	void FaceTime() {
		System.out.println("아이폰에서 페이스타임을 합니다.");
	}
}