package com.net;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//0. class 선언시 listener 표시
public class ChatClient implements ActionListener, Runnable{
	JFrame f;
	JLabel label;
	JTextField tf;//사건 발생 대상.enter key 입력시 사건 발생됨(ActionEvent)
	JTextArea ta;
	Container c; 
	
	//for network----------------------
	//접속해 들어올 크라이언트 정보 저장하기 위한 변수	
	Socket socket; ////
	
	String sendString = "안녕하세요~자바 네트워크!";	
	//입,출력용 스트림
	//filter stream 
	InputStream s1in;
	DataInputStream dis;
	OutputStream s1out; 
	DataOutputStream dos;

	public static void main(String[] args) {
		ChatClient client = new ChatClient();
		client.gui();
		client.net();//네트워크 관련 작업

	}

	//네트워크 관련 작업 메소드
	private void net() {		
		try {
			///////
			socket = new Socket("70.12.108.203",8888);
			//입출력 스트림 생성-------------
			//출력스트림		
			s1out = socket.getOutputStream(); 
			//filter stream		
			dos = new DataOutputStream(s1out); //한글이 깨지지 않게 writer로 바꿔주는 필터 등도 있다.
			//입력 스트림
			s1in = socket.getInputStream();
			//filter stream. 한글처리		
			dis = new DataInputStream(s1in);
			//입력 작업을 위해 thread 생성하고 start
			Thread t = new Thread(this);
			t.start();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void gui() {
		//1.jframe 작성
		f = new JFrame("hello chat!");
		
		//1-1.jframe의 속성지정(닫기버튼, 레이아웃 매니저 지정)
		//f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent w) {
				//마무리 작업 (창 닫을 때 정리할 내용)
				System.out.println("window closing...");
				try {
					//stream close
					dis.close();
					s1in.close();
					dos.close();
					s1out.close();
					//socket close
					socket.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}		
				System.exit(0); // 프로세스 종료
			}
		});
		
		f.setLayout(new BorderLayout());
		
		//2.화면구성요소
		Font font = new Font("맑은 고딕", Font.BOLD|Font.ITALIC,30);
		label = new JLabel("채팅클라이언트", JLabel.CENTER);
		label.setFont(font);
		
		tf = new JTextField(20);
		
		ta = new JTextArea(10, 20);
		ta.setEditable(false);//편집 안되게 함
		JScrollPane pane = new JScrollPane(ta);
				
		//3.이벤트 발생 대상에 listener 등록
		tf.addActionListener(this);
		
		//4.화면 구성요소를 jframe에 붙이기
		c = f.getContentPane();
		c.add(label, "North");
		c.add(pane, "Center");
		c.add(tf, "South");
		
		//5.jframe 크기, 가시성 지정
		f.setSize(300, 300);
		f.setVisible(true);
		
		tf.requestFocus();
	}

	//출력작업
	@Override
	public void actionPerformed(ActionEvent e) { //사건(이벤트)처리 - 엔터키 누르는 것
		//1.tf에 입력한 글자 알아내기--> msg에 저장
		String msg = "동주client>"+tf.getText();
		
		//2.msg를 ta에 붙이기
		ta.append(msg + "\n");
		//textArea 안의 문자열의 길이를 알아옴
		int pos = ta.getText().length(); 
		ta.setCaretPosition(pos);
		
		//2-1. 출력용 스트림으로 msg를 client에게 보내기
		try {
			//요기요기...
			dos.writeUTF(msg);
		} catch (Exception e1) {
			//e1.printStackTrace();
		}
		
		//3.tf의 글자 지우기
		tf.setText("");
	}

	//thread가 수행하는 메소드:입력
	@Override
	public void run() {
		//클라이언트가 보내는 메세지를 입력 받아 화면에 출력
		try {
			while(true) {
				//입력 스트림 이용해서 읽어온 후 msg 에 저장
				String msg = dis.readUTF();
				ta.append(msg +"\n"); //화면에 msg 표시
				//textArea 안의 문자열의 길이를 알아옴
				int pos = ta.getText().length(); 
				ta.setCaretPosition(pos);
			}
			
		} catch (Exception e) { //IOException
			//e.printStackTrace();
		}
		
	}

	
}