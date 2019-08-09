package com.swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class BorderLayoutTest2 extends JFrame { 
	//JTextArea, JTable, JList -> 화면에 바로 직접 붙이면 안됨. (스크롤바가 있는 Pane(판)위에 올린 다음에 화면에 붙여야 함)
	JButton a,b,c,d;
	JLabel la;
	JTextArea ta;
	JList list;
	String[] color = {"red", "green", "blue", "white", "black", "magenta", "cyan", "yellow","red", "green", "blue", "white", "black", "magenta", "cyan", "yellow"};
	
	public void gui() {
		a = new JButton("east");
		b = new JButton("west");
		c = new JButton("south");
		d = new JButton("north");
		la = new JLabel("안녕, 스윙!", JLabel.CENTER); //글자, 정렬
		
		ta = new JTextArea(5,20); //5줄, 20글자정도 들어가는 영역이 만들어 짐
		JScrollPane pane = new JScrollPane(ta); //"scroll바가 붙어 있는 판"위에 ta를 올렸다.
		
		list = new JList<>(color); //()에 배열이 들어갈 수있음 //한줄에 하나씩 뿌림
		JScrollPane pane2 = new JScrollPane(list);
		
		Font font = new Font("궁서체", Font.BOLD, 30); 
		la.setFont(font); //라벨에 폰트를 적용
		JPanel panel = new JPanel(new BorderLayout()); //JFrame보다 작은 container //디폴트는 Flow
		panel.add(a, "North");
		panel.add(b, "South");
		
		//setLayout(new BorderLayout()); //동서남북중앙 5개로 화면이 나뉨 //JFrame의 디폴트
		setDefaultCloseOperation(EXIT_ON_CLOSE); //JFrame.EXIT_ON_CLOSE
		
		Container cc = getContentPane(); //t.아님... 클래스 본인이 JFrame이기 때문!! //큰 컨테이너
		//cc.add(a, "East");
		//cc.add(b, "West");
		cc.add(panel, "South"); //패널을 붙임
		cc.add(la, "North");
		//cc.add(pane, "Center"); 
		cc.add(pane2, "Center"); 
		
		setSize(300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		BorderLayoutTest2 t = new BorderLayoutTest2(); //t가 창임
		t.gui(); //화면 구성
		
	}

}
