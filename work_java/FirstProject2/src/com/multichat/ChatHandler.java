package com.multichat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatHandler extends Thread { //쓰레드(클라이언트 1대1담당자)
	Socket s;
	ChatServer server;
	private BufferedReader i;
	private PrintWriter o;
	private InputStream in;
	private OutputStream out;
	
	public ChatHandler(Socket client, ChatServer chatServer) {
		try {
		this.s = client; //this는 빼도 됨
		this.server = chatServer;
		
		// I/O스트림 생성(필터끼우는 거 포함)
		in = s.getInputStream();
		out = s.getOutputStream();
		
		i = new BufferedReader(new InputStreamReader(in)); //byte를 char스트림으로 바꾸고 필터 1개 더낌
		o = new PrintWriter(new OutputStreamWriter(out), true); //byte를 char스트림으로 바꾸고 필터 1개 더낌
		//server.println("클라이언트와 스트림 연결");
		}catch(Exception w) {
			server.println(w.toString());
		}
	}

	@Override
	public void run() { //클라이언트에서 입력 받음
		String name ="";
		try {
			server.register(this); //서버에 나(쓰레드)를 등록해주세요
			name = i.readLine(); //처음엔 이름을 받아넣음
			server.broadcast(name + "님이 입장하셨습니다");
			server.println(name + "님이 입장하셨습니다");//
			
			while(true) { //입력
				String msg = i.readLine(); 
				server.broadcast(name + ">" + msg); //다른 쓰레드들에 출력파이프로 println()!
			}
		} catch (Exception e) { //연결이 끊김(클라이언트가 소켓을 닫음)
			//e.printStackTrace();
			server.println("연결끊김");
		} 
		//연결이 끊김
		server.unregister(this); 
		server.broadcast(name + "님이 퇴장하셨습니다");
		server.println(name + "님이 퇴장하셨습니다");//
		//close
		try {
			i.close();
			in.close();
			o.close();
			out.close();
			s.close();
		} catch (IOException e) {
			server.println(e.toString());
		}
	}
	public void println(String msg) {
		o.println(msg); //서버의 broadcast()에서 쓰레드의 private한 출력파이프를 통해 출력 할 수 있음!!
	}
}