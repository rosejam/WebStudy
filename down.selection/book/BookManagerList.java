package com.book;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookManagerList implements IBookMgr {
	private List<Book> list;
	private static BookManagerList bml = new BookManagerList();

	public static BookManagerList getInstance() {
		return bml;
	}

	private BookManagerList() {		
		if(list == null) {
			list = new ArrayList<>();
		}
		open();//파일에서 ArrayList 읽어 옴
	}

	@Override
	public boolean addBook(Book book) {
		for(Book stored: list) {
			if(stored.equals(book)) {
				System.out.println("동일한 책은 들어갈 수 없어요.");
				return false;
			}
		}
		return list.add(book);
	}

	@Override
	public List<Book> getBookAll() {
		return list;
	}

	@Override
	public Book getBookByIsbn(String isbn) {
		Book book = null;
		for (Book temp : list) {
			if (temp.getIsbn().equals(isbn)) {
				book = temp;
			}
		}
		return book;
	}

	@Override
	public List<Book> getBookByTitle(String title) {
		List<Book> temp = new ArrayList<>();
		for (Book book : list) {
			if (book.getTitle().contains(title)) {
				temp.add(book);
			}
		}
		return temp;
	}

	@Override
	public List<Book> getNovelOnly() {
		List<Book> temp = new ArrayList<>();
		for (Book book : list) {
			if ((book instanceof Novel)) {
				temp.add(book);
			}
		}
		return temp;
	}

	@Override
	public List<Book> getMagazine() {
		List<Book> temp = new ArrayList<>();
		for (Book book : list) {
			if (book instanceof Magazine) {
				temp.add(book);
			}
		}
		return temp;
	}

	@Override
	public List<Book> getMagazinePublishedThisYear() {
		List<Book> temp = new ArrayList<>();
		int year = LocalDate.now().getYear();
		
		for (Book book : list) {
			if (book instanceof Magazine) {
				Magazine m = (Magazine) book;
				if (m.getYear() == year) {
					temp.add(book);
				}
			}
		}
		return temp;
	}

	@Override
	public List<Book> getBookByPublisher(String publisher) {
		List<Book> temp = new ArrayList<>();
		for (Book book : list) {
			if (book.getPublisher().equals(publisher)) {
				temp.add(book);
			}
		}
		return temp;
	}

	@Override
	public List<Book> getBookLowerPrice(int price) {
		List<Book> temp = new ArrayList<>();
		for (Book book : list) {
			if (book.getPrice() < price) {
				temp.add(book);
			}
		}
		return temp;
	}

	@Override
	public int getSumPrice() {
		int sum = 0;
		for (Book book : list) {
			sum += book.getPrice();
		}
		return sum;
	}

	@Override
	public double getAvgPrice() {
		return 1.0 * getSumPrice() / list.size();
	}

	@Override
	public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException {
		boolean find = false;
		for(Book book: list) {
			if(book.getIsbn().equals(isbn)) {
				find = true;
				if(book.getQuantity()>=quantity) {
					book.setQuantity(book.getQuantity()-quantity);
					
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
		for(Book book: list) {
			if(book.getIsbn().equals(isbn)) {
				find = true;
				book.setQuantity(book.getQuantity() + quantity);
				return;
			}
		}
		if(!find) {
			throw new ISBNNotFoundException();
		}
	}

	@Override
	public int getTotalAmount() {
		int total = 0;
		for(Book book: list) {
			total+= book.getPrice() * book.getQuantity();
		}
		return total;
	}

	@Override
	public void open() {		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("book_list.dat"));){
			Object obj = ois.readObject();
			if(obj != null) {
				list = (List)obj;
			}
			System.out.println("자료 로딩 성공");
		} catch (FileNotFoundException e) {
			System.out.println("지정한 파일이 없습니다.");			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	@Override
	public void close() {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("book_list.dat"));){
			oos.writeObject(list);
			System.out.println("파일 저장 완료");
			
		} catch (FileNotFoundException e) {
			System.out.println("지정한 파일이 없습니다.");			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
