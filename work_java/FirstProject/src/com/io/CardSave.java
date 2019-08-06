package com.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CardSave {

	public static void main(String[] args) throws Exception {
		Card mycard = new Card(12345, "harry potter", "master");
		
		//스트림을 이용해서 파일에 객체 저장
		FileOutputStream fos = new FileOutputStream("save.ser"); //node stream
		ObjectOutputStream oos = new ObjectOutputStream(fos); //filter stream
		oos.writeObject(mycard); //직렬화된 객체를 byte스트림으로 객체 단위로 하나씩 저장함
		
		oos.close();
		fos.close();
		
		//스트림을 이용해서 객체 읽어오기
		FileInputStream fis = new FileInputStream("save.ser");
		ObjectInputStream ois  = new ObjectInputStream(fis);
		Card cc = (Card) ois.readObject(); //"객체 단위로 하나씩" 읽어옴 -> "형변환"을 꼭 해주어야 한다!!
		
		System.out.println(cc.getNum());
		System.out.println(cc.getName());
		System.out.println(cc.getCompany());
		
		ois.close();
		fis.close();
	} //  ois<--fis<-- file <--oos<--fos
}
