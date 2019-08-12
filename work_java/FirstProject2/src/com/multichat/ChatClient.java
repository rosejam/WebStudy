package com.multichat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements Runnable, ActionListener {

	private BufferedReader i;
	private PrintWriter o;
	private InputStream in;
	private OutputStream out;
	private JTextArea output;
	private JTextField input;
	private JLabel label;
	private Thread listener;
	private String host = "localhost"; //"70.12.108.210";
	int serverport = 9830;
	Socket s;

	public ChatClient() { //생성자에서 화면gui 만듬
		super("채팅 프로그램"); //부모인 JFrame의 타이틀 바에 들어감.

		listener = new Thread(this);
		listener.start(); //아래 run()에서 input을 기다렸다가 받는 용도의 쓰레드

		output = new JTextArea();
		getContentPane().add(new JScrollPane(output), "Center");
		output.setEditable(false); //편집안되게 막아놓음 보여주기만 할것임
		
		JPanel bottom = new JPanel();
		label = new JLabel("사용자 이름");
		bottom.add(label);
		input = new JTextField(28);
		
		input.addActionListener(this); //사건처리하는 메소드가 이(this)클래스에 있다는 것
		bottom.add(input);

		getContentPane().add(bottom, "South");
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		///////////////
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("창을 닫습니다");
				System.exit(0); //프로세스 종료!! //이게 먼저 오면 안되지 않나? //이게 여기 먼저 안오면 Handler에서 연결끊김으로 가지 않는다.//클라이언트에서 에러가 먼저 발생
				//스트림, 소켓 close
				try { //출력스트림을 먼저 닫는다.
					o.close();
					out.close();
					i.close();
					in.close();
					s.close();
					System.out.println("소켓을 닫았습니다.");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				//System.exit(0); //프로세스 종료!! //null님이 입장하셨습니다;;;;
			}//()안에 윈도우리스너(또는 윈도우 어댑터)를 "상속받는 자식 객체!!!"를 넣어야 함. -> 무명으로 생성
		}); //this에 리스너 붙이기 앞에 this.같은건 원래 필요없음! 
		////////////////
		setSize(400, 300);
		setVisible(true);
		input.requestFocus(); //시작할 때 커서를 위치하게 함 //setVisible다음에 온다!
	}
	
	//callback메소드 : 특정 조건이 되면 자동 호출되는 메소드
	public void run() { //입력받기용 //조건 : 스레드의 start()가 호출이 되면 자동실행
		try {
			// Socket 생성
			s = new Socket(host, serverport);
			// I/O스트림 생성(필터끼우는 거 포함)
			in = s.getInputStream();
			out = s.getOutputStream();
			
			i = new BufferedReader(new InputStreamReader(in)); //byte를 char스트림으로 바꾸고 필터 1개 더낌
			o = new PrintWriter(new OutputStreamWriter(out), true); //byte를 char스트림으로 바꾸고 필터 1개 더낌
			
			System.out.println("서버와 스트림 연결"); //이부분은 한번만 하면 되므로 생성자 등에 옮겨도 된다.
			while(true) { //입력
				String msg = i.readLine(); //서버쪽에서 오는 메세지 받기
				output.append(msg + "\n");
				
				//textArea안의 문자열의 길이를 알아옴
				int pos = output.getText().length();
				output.setCaretPosition(pos); //창이 따라 내려감
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//callback메소드 : 사건이 발생(엔터)하면 자동 호출
	public void actionPerformed(ActionEvent e) { //출력(엔터를 쳤을 때) -> 사건기다렸다가 실행하는 것도 따로 쓰레드가 있음.
		label.setText("메세지"); //여기다 두면 사건발생할때마다 다시 세팅이 되긴함..
		String msg = input.getText();
		o.println(msg); //서버(다른 클라이언트)에게 메세지 출력하기 //프린트writer에 있는 메서드
		input.setText("");
	}

	public static void main(String args[]) {
		new ChatClient();

	}
}