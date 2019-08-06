package com.ssafy;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class BookServer {
	static ArrayList<Book> books;
	
	public static void main(String[] args) {
		ServerSocket s = null;
		Socket s1;
		
		InputStream s1in;
		ObjectInputStream dis;
		
		try {
			s = new ServerSocket(9898);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true) { //계속 다음 클라이언트를 받음
			System.out.println("클라이언트를 기다리는 중...");
			try {
				s1 = s.accept();
			System.out.println("클라이언트 접속!");
			
			s1in = s1.getInputStream();
			dis = new ObjectInputStream(s1in);
			
			books = (ArrayList<Book>) dis.readObject();
			for(Book b : books) {
				System.out.println(b);
			}
			
			dis.close();
			s1in.close();
			
			s1.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}

	}


}
