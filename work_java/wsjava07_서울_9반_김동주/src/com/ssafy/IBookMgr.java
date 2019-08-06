package com.ssafy;

import java.util.ArrayList;

public interface IBookMgr {
	void add(Book b);
	ArrayList<Book> search();
	Book search_isbn(String isbn);
	ArrayList<Book> search_title(String title);
	ArrayList<Book> search_M();
	ArrayList<Book> search_N();
	ArrayList<Book> search_M_recent();
	ArrayList<Book> search_publisher(String publisher);
	ArrayList<Book> search_price_low(int price);
	int sum();
	double average();
	
}
