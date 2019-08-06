package com.ssafy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class QuantityException extends Exception {
	@Override
	public String toString() { 
		return "QuantityException 발생";
	} //객체를 생성한다 == 예외가 발생한다!!
	
}

class ISBNNotFoundException extends Exception {
	@Override
	public String toString() { 
		return "ISBNNotFoundException 발생";
	} //객체를 생성한다 == 예외가 발생한다!!
	
}

public class BookMgrImpl implements IBookMgr {
	private static BookMgrImpl instance; //"객체생성메서드용"
	
	private ArrayList<Book> books;// = new ArrayList<>(); //배열 대신 ArrayList 사용
	
	//"private생성자"
	private BookMgrImpl() { //!!!!
		
		if(books == null) { //books 안만들었으면 생성
			books = new ArrayList<>(); //
		}
		
		open(); //파일에 저장되어 있는 ArrayList 가져오기
	}
	
	//"객체 생성해서 리턴해 주는 메서드"
	public static BookMgrImpl getInstance() {
		if(instance == null) {
			instance = new BookMgrImpl();
		}
		return instance;
	}
	
	////
	@Override
	public void add(Book b) {
		boolean flag = false;
		//중복데이터 처리
		for(Book b2 : books) {
			if(b2.getIsbn() == b.getIsbn()) {
				//중복되는 경우 예외 발생시켜야됨.
				flag = true; //중복 표시
				break;
				//return; 그냥 이렇게 해두됨 플래그 필요 X
			}
		}
/*		if(books.contains(b)) {
			return;
		}
		books.add(b);*/ //이거 안됨.. b2.equals(b)도 안됨
		books.add(b);
	}
	public void sort() {
		Collections.sort(books);
	}
	
	@Override
	public ArrayList<Book> search() {
		return books;
	}
	@Override
	public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException { //중요!
		boolean find = false; 
		for(Book b : books) {
			if(b.getIsbn().equals(isbn)) {
				find =true; 
				if(b.getQuantity()>=quantity) {
					b.setQuantity(b.getQuantity()-quantity);
				}else {
					throw new QuantityException();
				}
				return;
			}
		}
		if(!find) {
			throw new ISBNNotFoundException();
		}
		
	}
	
	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException {
		boolean find = false; 
		for(Book b : books) {
			if(b.getIsbn().equals(isbn)) {
				find =true; 
				b.setQuantity(b.getQuantity()+quantity);
				return;
			}
		}
		
		if(!find) {
			throw new ISBNNotFoundException();
		}
	}
	
	@Override
	public int getTotalAmount() {
		int sum=0;
		for(Book b : books) {
			sum += b.getPrice() * b.getQuantity();
 		}
		return sum;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void open() {
		try {
			FileInputStream fis = new FileInputStream("book.dat");
			ObjectInputStream ois  = new ObjectInputStream(fis);
			
			Object oldbook =  ois.readObject(); //"객체 단위로 하나씩" 읽어옴 -> "형변환"을 꼭 해주어야 한다!!
			
			if(oldbook != null) { //올드북있을 경우 형변환시켜서 books에 넣기
				books = (ArrayList<Book>)oldbook;
				System.out.println("로딩성공");
			}
			
			ois.close();
			fis.close();
			System.out.println("오픈끝");
		}catch(Exception e) {
			System.out.println(e);
			System.out.println("open()에서 안됬다.");
		}
	}
	@Override
	public void close() {
		try {
		FileOutputStream fos = new FileOutputStream("book.dat"); //node stream
		ObjectOutputStream oos = new ObjectOutputStream(fos); //filter stream
		oos.writeObject(books); //직렬화된 객체를 byte스트림으로 "객체 단위로 하나씩" 저장함
		
		oos.close();
		fos.close();
		System.out.println("클로즈끝");
		}catch(Exception e) {
			//System.out.println(e);
			System.out.println("close()에서 안됬다.");
		}
	}

	@Override
	public void delete(String isbn) {
		for(Book b : books) {
			if(b.getIsbn().equals(isbn)) {
				books.remove(b); 
				break;
			}
		}
	}
	
	@Override
	public Book findbyisbn(String isbn) {
		Book a = null;
		for(Book b : books) {
			if(b.getIsbn().equals(isbn)) {
				a = b; 
				break;
			}
		}
		//null일 경우 isbnnotfoundexc
		//어레이리스트 일 경우 isEmpty 또는 size가 0인지 확인 -> 메인에서!!
		return a; //없으면 null이 리턴이 된다.
	}

	@Override
	public ArrayList<Book> novelbygenre(String genre) {
		ArrayList<Book> find = new ArrayList<>();
		for(Book b : books) {
			if(b instanceof Novel) {
				Novel n = (Novel)b; 
				if(n.getGenre().equals(genre)) {
					find.add(n);
				}
			}
		}
		return find; //isempty 등으로 테스트에서 체크해서 없을 경우 처리해주어야함!!!!
	}
	
	
	
}
