package com.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class CharacterStreamTest {
	public static void main(String[] args) throws Exception {
		File f = File.createTempFile("sample", ".tmp"); //클래스이름.스태틱메서드 - 임시 파일을 생성
		System.out.println(f); //윈도우의 임시파일 저장경로가 찍힘, 파일이름뒤에는 임의의 숫자들이 붙음
		
		FileWriter fw = new FileWriter(f); //출력용 node stream(FileOutputStream과 동일) 
		BufferedWriter bw = new BufferedWriter(fw); //filter stream : fw파이프에 끼워진 필터. buffer가 있고 특별한 메소드가 있음
		
		//그 후에는 bw필터로 이용
		bw.write("hello~");
		bw.newLine();
		bw.write("애들아");
		bw.newLine();
		bw.write("샌드위치 다 먹었니?");
		bw.newLine();
		bw.write("졸지 말아라");
		bw.newLine();
		
		bw.close();
		fw.close();
		
		//읽어내기
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		
		for(String str; (str = br.readLine()) != null; ) { //readLine()으로 데이터를 한줄씩 읽어들임
			System.out.println(str);
		}
		//읽어내기
		
	}// <--br<--fr<-- file <--bw<--fw<-- 인듯?
}
