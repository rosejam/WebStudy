package com.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopy {

	public static void main(String[] args) throws Exception {
/*		System.out.println(s); //system클래스의 스태틱 data
		System.err.println("hello..."); //빨간색 글자로 출력됨
		try{
			int i = System.in.read(); //빨간색 글자로 출력됨
			System.out.println(i);
		}catch(IOExcepion i) {
		}*/
		
		////////
		
		String origin = "src\\com\\io\\FileCopy.java"; //원본파일
		String copy = "src\\com\\abst\\FileCopy.java"; //복사본
		
		FileInputStream fis; //파일에서 내용을 읽어내는 스트림
		FileOutputStream fos; //파일에 내용을 쓰는 스트림(없으면 만들고 있으면 덮어씌움)
		
		fis = new FileInputStream(origin);
		fos = new FileOutputStream(copy);
		
		for(int i=0; (i=fis.read()) != -1; ) { //fis.read() 한글자를 읽어옴. file의 끝을 만나면 -1이된다. 그전까지는 계속 for문이 돈다.
			System.out.println(i); //코드값(int 숫자)가 나온다.
			fos.write(i); // 숫자 코드에 해당하는 글자를 써주는 역할.
		}
		//파이프는 다 쓴후 close해주어야 한다. 특히 출력용 파이프는 닫지않으면 파일에 아무내용도 저장이 안되어 있을 수도 있다.
		fis.close();
		fos.close();
		//fis, fos는 node스트림
		System.out.println();
	}
}
