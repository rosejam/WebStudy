package com.swing;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
//1. tf에서 엔터키 치면 ActionEvent 발생 -> ActionListener가 처리해주어야 함. (클래스 선언시에 리스너 표시)
public class ChatTest extends JFrame implements ActionListener { 
	//JTextArea, JTable, JList -> 화면에 바로 직접 붙이면 안됨. (스크롤바가 있는 Pane(판)위에 올린 다음에 화면에 붙여야 함)
	JButton a,b,c,d;
	JLabel la;
	JTextArea ta;
	JTextField tf;
	
	public void gui() {
		a = new JButton("east");
		tf = new JTextField(20);
		la = new JLabel("안녕, 스윙!", JLabel.CENTER); //글자, 정렬
		ta = new JTextArea(5,20); //5줄, 20글자정도 들어가는 영역이 만들어 짐
		JScrollPane pane = new JScrollPane(ta); //"scroll바가 붙어 있는 판"위에 ta를 올렸다.
		
		Font font = new Font("궁서체", Font.BOLD, 30); 
		la.setFont(font); //라벨에 폰트를 적용
		
		//2. 사건이 발생하는 대상에게 리스너(감시자)등록
		tf.addActionListener(this); //자기자신객체를 의미 //리스너가 this(=리스너를 임플먼츠함)객체의 actionPerformed()메소드를 찾아감!!
		//tf.addActionListener(this); //감시자를 2번 붙이면 작업이 2번 시행
		
		//setLayout(new BorderLayout()); //동서남북중앙 5개로 화면이 나뉨 //JFrame의 디폴트
		//setDefaultCloseOperation(EXIT_ON_CLOSE); //JFrame.EXIT_ON_CLOSE
		
		///////////////
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("창을 닫습니다");
				//스트림, 소켓 close
				System.exit(0); //프로세스 종료!!
			}//()안에 윈도우리스너(또는 윈도우 어댑터)를 "상속받는 자식 객체!!!"를 넣어야 함. -> 무명으로 생성
		}); //this에 리스너 붙이기 앞에 this.같은건 원래 필요없음! 
		////////////////
		
		Container cc = getContentPane(); //t.아님... 클래스 본인이 JFrame이기 때문!! //큰 컨테이너
		
		cc.add(la, "North");
		cc.add(pane, "Center"); //패널을 붙임
		//cc.add(panel, "South"); //패널을 붙임
		cc.add(tf, "South"); 
		
		setSize(300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		ChatTest t = new ChatTest(); //t가 창임
		t.gui(); //화면 구성
		
	}
	
	//3. ActionListener가 가지고 있는 추상메소드
	@Override
	public void actionPerformed(ActionEvent e) {
		//1. tf에 입력한 내용 알아내기
		String msg = tf.getText();
		
		//2. msg를 ta에 붙이기 + 상대방한테도 보내야함!!(writeUTF로)
		ta.append( msg +"\n");
		
		//3. tf 지우기
		tf.setText(""); //빈문자열로 세팅
	}

}
