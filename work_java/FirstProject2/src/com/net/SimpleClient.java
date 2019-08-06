package com.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SimpleClient {

	public static void main(String[] args) throws Exception {
		String msg2 = "이제 되니?";
		Socket s1;
		
		InputStream s1in;
		DataInputStream dis;
		OutputStream s1out; 
		DataOutputStream dos;
		
		s1 = new Socket("70.12.108.210", 9988); //localhost는 내 컴퓨터를 의미 - loopback address
											//여기 s1이 서버의 s1과 같은 소켓
		s1in = s1.getInputStream();
		dis = new DataInputStream(s1in);
		s1out = s1.getOutputStream(); 
		dos = new DataOutputStream(s1out);
		
		String msg = dis.readUTF(); //서버에서 보낸 한글 읽기 상대방이 보낼때까지 계속 기다림(block)
		System.out.println(msg);
		
		dos.writeUTF(msg2);
		
		dis.close();
		s1in.close();
		dos.close();
		s1out.close();
		
		s1.close();
	} 

}
