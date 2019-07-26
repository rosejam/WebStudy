package com.second;

//import java.awt.Button;
//import java.awt.Checkbox;
//import java.awt.FlowLayout;
//import java.awt.Frame;
//import java.util.Date; //

public class FileTest {

	public static void main(String[] args) {
		File[] flist = new File[3]; //File 타입의 데이터가 저장될 배열 생성
		TextFile f3 = new TextFile("java test", 250, "2019/07/25", "java", "tom");
		
		flist[0] = f3; //
		flist[1] = new MP3File("아무거나",120,"2019/01/30","mp3","Kim"); //다형성!!
		f3.info(); //값 대입 없이 생성자로 초기화했기 때문에 바로 사용가능

	}

}
