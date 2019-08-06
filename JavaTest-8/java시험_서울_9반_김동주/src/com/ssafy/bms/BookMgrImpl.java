package com.ssafy.bms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.ArrayList;

public class BookMgrImpl implements IBookMgr {
	File file = new File("data.txt"); //내용 무엇?
	private ArrayList<Book> bs = new ArrayList<>();;
	private static BookMgrImpl instance;
	
	public static BookMgrImpl getInstance() {
		if(instance == null)
			instance = new BookMgrImpl();
		return instance;
	}
	private BookMgrImpl() { //파일의 존재유무 판단 파일 존재시 파일 읽어옴
/*		if(bs == null)
			bs = new ArrayList<Book>();*/
		load();
	}
	///
	@Override
	public void load() {
		try {
		FileInputStream fis = new FileInputStream("Books.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		bs = (ArrayList<Book>)ois.readObject();  
		
		ois.close();
		fis.close();
		}catch(Exception e) {
			System.out.println("load()의 문제 발생");
		}
	}
	@Override
	public void save() {
		try {
		FileOutputStream fos = new FileOutputStream("Books.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(bs);  

		oos.close();
		fos.close();
		}catch(Exception e) {
			System.out.println("save()의 문제 발생");
		}
		
	}
	@Override
	public void add(Book b) throws DuplicateException {
		for(Book book : bs) {
			if(book.getIsbn().equals(b.getIsbn())) {
				throw new DuplicateException();
			}
		}
		bs.add(b);
	}
	@Override
	public ArrayList<Book> search() {
		return bs;
	}
	@Override
	public Book search(String isbn) throws RecordNotFoundException {
		for(Book book : bs) {
			if(book.getIsbn().equals(isbn)) {
				return book;
			}
		}
		throw new RecordNotFoundException();
	}
	@Override
	public void update(String isbn, int price) throws RecordNotFoundException {
		for(Book book : bs) {
			if(book.getIsbn().equals(isbn)) {
				book.setPrice(price);
				return;
			}
		}
		throw new RecordNotFoundException();
	}
	@Override
	public void delete(String isbn) throws RecordNotFoundException {
		Book bb = null;
		for(Book book : bs) {
			if(book.getIsbn().equals(isbn)) {
				bb = book;
				break;
			}
		}
		if (bb== null) throw new RecordNotFoundException();
		else {
			System.out.println(bb.getTitle());
			bs.remove(bb);
		}
		
	}
	@Override
	public ArrayList<Book> searchTitle(String title) {
		ArrayList<Book> bbs = new ArrayList<>();
		for(Book book : bs) {
			if(book.getTitle().contains(title)) {
				bbs.add(book);
			}
		}
		return bbs; //isempty체크
	}
	@Override
	public ArrayList<Book> sortIsbn() {
		Collections.sort(bs);
		return bs;
	}
	/*	@Override
	public String countWord() {
		ArrayList<String> names = new ArrayList<String>;
		for(int i=0; i<bs.size() ; i++ ) {
			names.addAll(bs.get(i).getTitle().split(" "));
		} //제목 모두 저장
		return bbs; //isempty체크
	}*/
}
