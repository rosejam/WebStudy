package com.swing;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SwingTest {

	public static void main(String[] args) {
		JFrame f = new JFrame(); //화면
		//JFrame은 기본으로 BorderLayout이 관리해줌
		f.setLayout(new FlowLayout()); //배치 관리자 지정. add시키는 순서대로 화면에 붙음
		Container c = f.getContentPane(); //화면 구성 요소들이 붙을 ContentPane 영역을 알아냄
		//창닫기 버튼 클릭(CloseOperation)시 할일 지정
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //스태틱 필드
		
		JButton ok = new JButton("ok");
		JButton cancel = new JButton("cancel");
		JRadioButton jb = new JRadioButton("one"); //동그란거
		JCheckBox jc = new JCheckBox("red");
		JTextArea ta = new JTextArea(5, 30); //여러줄
		JTextField tf = new JTextField(50); //한줄
		JLabel la = new JLabel("hello, swing");
		
		c.add(la);
		c.add(ok);
		c.add(cancel);
		c.add(jb);
		c.add(jc);
		c.add(ta);
		c.add(tf);
		
		f.setSize(300, 500); //창크기 지정
		f.setVisible(true); //실행시에 눈에 보이도록(나타나도록) //그냥 창을 끄면 프로그램이 종료되는것이 아니고 이 값만 false가 되는 것(안보이게만 된다)
							//스트림과 소켓등을 닫거나 db정리등을 하고 종료되어야 하기 때문
	}
}
