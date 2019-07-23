package com.ssafy;

public class BookTest {

	public static void main(String[] args) {
		Book b1 = new Book();
		Book b2 = new Book();
		Magazine m = new Magazine();
		
		b1.isbn = "21424";
		b2.isbn = "35355";
		m.isbn = "35535";
		b1.title = "Java Pro";
		b2.title = "분석설계";
		m.title = "Java World";
		b1.author = "김하나";
		b2.author = "소나무";
		m.author = "편집부";
		b1.publisher = "Jaen.kr";
		b2.publisher = "Jaen.kr";
		m.publisher = "java.com";
		b1.price = 15000;
		b2.price = 30000;
		m.price = 7000;
		b1.desc = "Java 기본 문법";
		b2.desc = "SW 모델링";
		m.desc = "첫걸음";
		m.year = 2018;
		m.month = 2;
		
		System.out.println("******************************도서 목록 ******************************");
		System.out.println(b1.toString());
		System.out.println(b2.toString());
		System.out.println(m.toString());
	}

}
