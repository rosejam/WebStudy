package com.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SimpleClient {

	public static void main(String[] args) throws Exception {
		String msg2 = "이제 되니?";
		Socket s1;
		
		//
		InputStream s1in;
		DataInputStream dis;
		OutputStream s1out; 
		DataOutputStream dos;
		
		//1.Socket 생성
		s1 = new Socket("70.12.108.203", 9898); //localhost는 내 컴퓨터를 의미 - loopback address
											//여기 s1이 서버의 s1과 같은 소켓
		//2.입출력 스트림 준비
		s1in = s1.getInputStream();
		dis = new DataInputStream(s1in);
		s1out = s1.getOutputStream(); 
		dos = new DataOutputStream(s1out);
		
		//3.입출력
		String msg = dis.readUTF(); //서버에서 보낸 한글 읽기 상대방이 보낼때까지 계속 기다림(block)
		System.out.println(msg);
		
		////출력을 thread에게 시킴
		Thread t = new Thread(new Runnable() {
			public void run() {
				try {
					dos.writeUTF(msg2);
				} catch (IOException e) {
					e.printStackTrace();
				} 
			}
		});
		t.start();
		t.join(); //메인아 기다려 닫지마 //join을 쓰기 위해 t로 받음
		////
//		dos.writeUTF(msg2); //출력
		
		//4.마무리(WindowClosing에서 해줌)
		dis.close();
		s1in.close();
		dos.close();
		s1out.close();
		
		s1.close();
	} 

}
