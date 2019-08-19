package com.ssafy;

import java.util.List;

public class Test {
	private static void printAllBooks(List<Book> list) {
		for(Book b : list) {
			System.out.println(b); 
		}
	}
	public static void main(String[] args) {
		BookDAO dao = new BookDAO();
/*		dao.delete("a1101");
		dao.delete("a1102");
		dao.delete("a1103");
		dao.delete("a1104");*/
		
		System.out.println(1);
		Book b1 = new Book("a1101","JAVA 기본","자앤 기술연구소","자앤 출판사",23000,"기본");
		Book b2 = new Book("a1102","JAVA 중급","자앤 기술연구소","자앤 출판사",25000,"중급");
		Book b3 = new Book("a1103","JAVA 실전","자앤 기술연구소","자앤 출판사",30000,"실전");
		dao.insertBook(b1);
		dao.insertBook(b2);
		dao.insertBook(b3);
		
		List<Book> list = dao.listBooks();
		System.out.println(2);
		printAllBooks(list);
		
		Book b0 = dao.findBook("a1101");
		System.out.println(3);
		System.out.println(b0);
		
		Book b4 = new Book("a1104","JAVA 심화","자앤 기술연구소","자앤 출판사",28000,"심화");
		dao.insertBook(b4);
		list = dao.listBooks();
		System.out.println(4);
		printAllBooks(list);
		
		Book b5 = new Book("a1101","JAVA 기본","자앤 기술연구소","자앤 출판사",20000,"기본");
		dao.updateBook(b5);
		list = dao.listBooks();
		System.out.println("5.1");
		printAllBooks(list);
		Book b6 = new Book("a1101","JAVA 기본","자앤 기술연구소","그린 출판사",20000,"기본");
		dao.updateBook(b6);
		list = dao.listBooks();
		System.out.println("5.2");
		printAllBooks(list);
		
		dao.delete("a1103");
		list = dao.listBooks();
		System.out.println(6);
		printAllBooks(list);
	}

}
