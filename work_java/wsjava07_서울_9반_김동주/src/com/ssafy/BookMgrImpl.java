package com.ssafy;

import java.util.ArrayList;

public class BookMgrImpl implements IBookMgr {
	private static BookMgrImpl instance;
	private ArrayList<Book> books = new ArrayList<>(); //배열 대신 ArrayList 사용
	//private static int index; //필요한가?
	
	private BookMgrImpl() {}
	public static BookMgrImpl getInstance() {
		if(instance == null) {
			instance = new BookMgrImpl();
		}
		return instance;
	}

	@Override
	public void add(Book b) {
		books.add(b);
	}

	@Override
	public ArrayList<Book> search() {
		return books;
	}

	@Override
	public Book search_isbn(String isbn) {
		for(Book b : books) {
			if (b.getIsbn() == isbn)
				return b;
		}
		return null;
		
	}

	@Override
	public ArrayList<Book> search_title(String title) {
		ArrayList<Book> list = new ArrayList<>();
		for(Book b : books) {
			if (b.getTitle().contains(title))
				list.add(b);
		}
		return list;
	}

	@Override
	public ArrayList<Book> search_M() {
		ArrayList<Book> list = new ArrayList<>();
		for(Book b : books) {
			if (b instanceof Magazine)
				list.add(b);
		}
		return list;
	}

	@Override
	public ArrayList<Book> search_N() {
		ArrayList<Book> list = new ArrayList<>();
		for(Book b : books) {
			if (b instanceof Novel)
				list.add(b);
		}
		return list;
	}

	@Override
	public ArrayList<Book> search_M_recent() {
		ArrayList<Book> list = new ArrayList<>();
		for(Book b : books) {
			if (b instanceof Magazine) {
				if(((Magazine) b).getYear()==2019)
					list.add(b);
			}
				
		}
		return list;
	}

	@Override
	public ArrayList<Book> search_publisher(String publisher) {
		ArrayList<Book> list = new ArrayList<>();
		for(Book b : books) {
			if (b.getPublisher().equals(publisher))
				list.add(b);
		}
		return list;
	}

	@Override
	public ArrayList<Book> search_price_low(int price) {
		ArrayList<Book> list = new ArrayList<>();
		for(Book b : books) {
			if(b.getPrice() < price)
				list.add(b);
		}
		return list;
	}

	@Override
	public int sum() {
		int sum=0;
		for(Book b : books) {
			sum += b.getPrice();
 		}
		return sum;
	}

	@Override
	public double average() {
		double sum = sum();
		int count = books.size(); 
		return sum/count;
	}

	
}
