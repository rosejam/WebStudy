package com.object;

import java.awt.Button; //java.awt패키지의 Button클래스를 가져다 쓴다고 말한것.
import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.Frame;

public class ObjectTest {

	public static void main(String[] args) {
		Checkbox c = new Checkbox("one");
		Checkbox c2 = new Checkbox("two", true);
		Checkbox c3 = new Checkbox();
		
		Button b = new Button("ok"); //버튼은 창 안에 있어야함
		Button b2 = new Button();
		Frame f = new Frame(); //창
		f.setLayout(new FlowLayout());
		f.add(b); //창에 b를 붙인다
		f.add(b2);
		f.add(c);
		f.add(c2);
		f.add(c3);
		
		f.setSize(300,300);
		f.setVisible(true);
	}

}
