package com.first;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.util.Date; //

public class FileTest {

	public static void main(String[] args) {
		// 2. 객체 생성
		TextFile f1 = new TextFile();
		TextFile f3 = new TextFile("java test", 250, "2019/07/25", "java", "tom");
		f3.info(); //값 대입 없이 생성자로 초기화했기 때문에 바로 사용가능
		MP3File f2 = new MP3File();
		
		// 3. 객체 사용
		f1.name = "이력서.txt";
		f1.date = "2018/08/22";
		f1.size = 245;
		f1.type = "txt";
		f1.writer = "tommy lee";
		
		f1.info();
		
		f2.name = "아무거나";
		f2.date = "2019/01/30";
		f2.size = 120;
		f2.type = "mp3";
		f2.singer = "Kim";
		
		f2.info();
		
		//jdk에서 제공하는 객체 생성. 외부에 있는 클래스들을 사용하기 위해 import해주어야 한다.
		Date d = new Date();
		Button b1 = new Button("ok");
		Button b2 = new Button("cancel");
		Checkbox c1 = new Checkbox("one");
		Checkbox c2 = new Checkbox("two");
		Checkbox c3 = new Checkbox("three");
		Frame f = new Frame("테스트"); //창생성
		f.setLayout(new FlowLayout());
		f.add(b1); //창f에 b1를 붙여라
		f.add(b2); 
		f.add(c1); 
		f.add(c2); 
		f.add(c3); 
		f.setSize(300, 300); //창 크기지정
		f.setVisible(true); //창을 보이게 
		


	}

}
