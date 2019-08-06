package com.ssafy;

import java.util.ArrayList;

public interface IBookMgr {
	void add(Book b);
	ArrayList<Book> search();
	void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException;
	void buy(String isbn, int quantity) throws ISBNNotFoundException;
	int getTotalAmount();
	void open(); //파일 읽기
	void close(); //파일로 저장
	void delete(String isbn);
	Book findbyisbn(String isbn);
	ArrayList<Book> novelbygenre(String genre);
}
