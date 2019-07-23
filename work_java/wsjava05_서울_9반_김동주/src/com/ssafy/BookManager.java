package com.ssafy;

public class BookManager implements IBookManager {
	private Book[] list;
	
	public BookManager() {
		list = new Book[5];
	}
	
	@Override
	public void add(Book book) {
		
	}

	@Override
	public Book[] total() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book findByIsbn(String isbn) {
		for(int i=0; i<5; i++) {
			if (isbn.equals(list[i].getIsbn()))
				return list[i];
		}
	}

	@Override
	public Book[] findByTitle(String title) {
		Book[] t_list = new Book[0];
		for(int i=0; i<5; i++) {
			if (title.equals(list[i].getTitle()))
				t_list[i] = list[i];
		}
		return t_list;
	}

	@Override
	public Book[] findByPrice(int price) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book[] findMagazine() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book[] findNovel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int sum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double average() {
		// TODO Auto-generated method stub
		return 0;
	}
}
