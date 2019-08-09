package com.multichat;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ChatServer {
	private Vector<ChatHandler> handlers; //<쓰레드>!!
	//private Vector<String> namelist; //<사용자이름>
	int port = 9830;
	
	//새로운 접속자가 들어오면 thread를 벡터에 저장
	public void register(ChatHandler c) {
		//this.println("레지스터");
		handlers.add(c);
	}

	//기존 접속자가 나가면 thread를 벡터에서 삭제
	public void unregister(ChatHandler o) {
		//this.println("언레지스터");
		handlers.remove(o);
	}

	//벡터의 모든 스레드에게 message를 전달하면서 각자의 클라이언트에게 출력해 달라는 메소드
	public void broadcast(String message) {
		//this.println("브로드캐스팅 시작");
		for(int i=0; i<handlers.size(); i++) {
			//try {
				handlers.get(i).println(message);
			//} catch (Exception ex) {
			//}
		}
	}
	
	public ChatServer() {
		//벡터 만들어 놓기
		handlers = new Vector<>();
		//namelist = new Vector<>();
	}
	
	public void network() {
		try {
			//서버소켓 만들기
			ServerSocket server = new ServerSocket(port);
			while(true) {
				//기다렸다 받기
				Socket client = server.accept();
				//받은 후 담당 스레드 만들기
				ChatHandler handler = new ChatHandler(client, this); //소켓을 파라메터로 전달,
																		//this는 ChatServer클래스 -> 쓰레드가 여기의 메서드를 쓸 수 있게 됨
				//register(handler);//여기서 하거나 ChatHandler에서 하거나 1번만 등록!
				//스레드 스타트
				handler.start();
			}
		}catch(Exception w) {
			w.printStackTrace();
		}
	}

	public static void main(String args[]) {
		ChatServer server = new ChatServer();		
		server.network();
	}
	
	//참고용으로 추가
	public void println(String msg) {
		System.out.println(msg);
	}
}