package com.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

	public static void main(String[] args) throws Exception {
		String msg = "우리 어떻게 하면 졸지 않을까"; //클라이언트에 보낼 메세지
		ServerSocket s = null; //이게 있으면 서버 프로그램임
		Socket s1; //접속해 들어오는 클라이언트를 받기 위해 선언
		
		//
		OutputStream s1out; 
		DataOutputStream dos; //ObjectOutputStream, BufferedWriter같은 필터.
		InputStream s1in;
		DataInputStream dis;
		
		s = new ServerSocket(9898); //서버 소켓 생성, 포트번호 넣어줌(클라이언트가 맞춰서 들어와야함) - 서버소켓은 닫지않기
		while(true) { //계속 다음 클라이언트를 받음
			System.out.println("클라이언트를 기다리는 중...");
			s1 = s.accept(); //클라이언트가 접속할 때까지 기다렸다가 받음. block되는 특징이 있다(=요구조건이 만족될때까지 계속 기다리고 아래로 진행하지 않음)
			System.out.println("클라이언트 접속!");
			
			s1out = s1.getOutputStream(); //여기서 클라이언트로 출력용 파이프 받아냄.
			dos = new DataOutputStream(s1out); //필터끼움
			s1in = s1.getInputStream();
			dis = new DataInputStream(s1in);
			
			dos.writeUTF(msg); //메시지를 보내버리고 밑으로 진행(block안됨) //출력 먼저
			
			msg = dis.readUTF(); //입력 나중
			System.out.println(msg);
			
			dos.close();
			s1out.close();
			dis.close();
			s1in.close();
			
			s1.close();
		}

	}

}
