package com.ssafy;

import java.util.ArrayList;

public class BookTest {
	
	public static void ToString(Book c) {
		System.out.println(c.toString());
	}
	public static void ToString(ArrayList<Book> c) {
		for(Book x :c) {
			System.out.println(x.toString());
		}
	}

	public static void main(String[] args) {
		BookMgrImpl b = BookMgrImpl.getInstance(); //ºÏ¸Å´ÏÀú Å¬·¡½º »ý¼º
		//String isbn9~0, String title, String author, String publisher0~9, int price, String desc
		Book b0 = new Novel("9", "Harry", "DJ", "0",000, "¸ô¶ó", "ÆÇÅ¸Áö");
		Book b1 = new Magazine("8", "Potter", "Kim", "1",100, "¸ô¶ó", 2019, 05);
		Book b2 = new Novel("7", "And", "Or", "2",200, "¸ô¶ó", "ÆÇÅ¸Áö");
		Book b3 = new Magazine("6", "The", "SO", "3",300, "¸ô¶ó", 2017, 05);
		Book b4 = new Novel("5", "Sorcerer's" ,"Else", "4",400, "¸ô¶ó", "ÆÇÅ¸Áö");
		Book b5 = new Magazine("4", "Stone", "In", "5",500, "¸ô¶ó", 2018, 05);
		Book b6 = new Novel("3", "By", "The", "6",600, "¸ô¶ó", "ÆÇÅ¸Áö");
		Book b7 = new Magazine("2", "J", "World", "7",700, "¸ô¶ó", 2016, 05);
		Book b8 = new Novel("1", "K", "Period", "8",800, "¸ô¶ó", "ÆÇÅ¸Áö");
		Book b9 = new Magazine("0", "Rowling" ,"Donna", "9",900, "¸ô¶ó", 2019, 05);
		
		b.add(b0);
		b.add(b1);
		b.add(b2);
		b.add(b3);
		b.add(b4);
		b.add(b5);
		b.add(b6);
		b.add(b7);
		b.add(b8);
		b.add(b9);
		System.out.println("------------------");
		ToString(b.search());
		System.out.println("------------------");
		ToString(b.search_isbn("2"));
		System.out.println("------------------");
		System.out.println(b.search_title("Potter"));
		System.out.println("------------------");
		ToString(b.search_M());
		System.out.println("------------------");
		ToString(b.search_N());
		System.out.println("------------------");
		ToString(b.search_M_recent());
		System.out.println("------------------");
		ToString(b.search_publisher("7"));
		System.out.println("------------------");
		ToString(b.search_price_low(400));
		System.out.println("------------------");
		System.out.println(b.sum());
		System.out.println(b.average());
		

	}

}
