package com.swing;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutTest extends JFrame { //LayoutTest는 JFrame창이다.
	JButton a,b,c,d;
	
	public void gui() {
		a = new JButton("east");
		b = new JButton("west");
		c = new JButton("south");
		d = new JButton("north");
		//setLayout(new BorderLayout()); //동서남북중앙 5개로 화면이 나뉨 //JFrame의 디폴트
		setDefaultCloseOperation(EXIT_ON_CLOSE); //JFrame.EXIT_ON_CLOSE
		
		Container cc = getContentPane(); //t.아님... 클래스 본인이 JFrame이기 때문!!
		cc.add(a, "East");
		cc.add(b, "West");
		cc.add(c, "South");
		cc.add(d, "North");
		
		setSize(300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		BorderLayoutTest t = new BorderLayoutTest(); //t가 창임
		t.gui(); //화면 구성
		
	}

}
