package com.inter;

public class Galaxy implements SmartPhone {
	public void call() {
		System.out.println("갤럭시에서 전화를 겁니다.");
	}
	public void sendMessage() {
		System.out.println("갤럭시에서 문자를 보냅니다.");
	}
	void saveFile() {
		System.out.println("갤럭시에서 파일을 저장합니다.");
	}
}
