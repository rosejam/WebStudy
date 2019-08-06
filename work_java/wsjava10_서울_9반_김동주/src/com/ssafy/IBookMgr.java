package com.ssafy;

import java.util.ArrayList;

public interface IBookMgr {
	void add(Book b);
	ArrayList<Book> search();
	void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException;
	void buy(String isbn, int quantity) throws ISBNNotFoundException;
	int getTotalAmount();
	void open(); //파일 읽기 io
	void close(); //파일로 저장 io
	void delete(String isbn);
	Book findbyisbn(String isbn);
	ArrayList<Book> novelbygenre(String genre);
	void send(); //server로 데이터전송
}
