package com.ssafy.bms;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import sun.util.locale.StringTokenIterator;

public class BookMgrImpl implements IBookMgr {

	private static BookMgrImpl bml = new BookMgrImpl();
	private ArrayList<Book> list;
	
	public static BookMgrImpl getInstance() {
		return bml;
	}
	
	BookMgrImpl(){
		if(list == null) list = new ArrayList<Book>();
		
		try {
			FileInputStream fis = new FileInputStream("books.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			ArrayList<Book> temp = (ArrayList<Book>)ois.readObject();
			if(list!=null)
				list = temp;
			fis.close();
			ois.close();
			System.out.println("파일이 성공적으로 로딩 되었습니다.");
		}catch(Exception e) {
			System.out.println("파일을 찾을 수 없습니다");
		}
	}
	
	
	@Override
	public void load() {
		// TODO Auto-generated method stub
		
		try {
			FileInputStream fis = new FileInputStream("src/books.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			ArrayList<Book> temp = (ArrayList<Book>)ois.readObject();
			if(list!=null) {
				list = temp;
				for(Book tb : list) {
					if(tb!=null)
						System.out.println(tb.toString());
				}
			}
			fis.close();
			ois.close();
			System.out.println("파일이 성공적으로 로딩 되었습니다.");
		}catch(Exception e) {
			System.out.println("파일을 찾을 수 없습니다");
		}
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		try {
			FileOutputStream fos = new FileOutputStream("src/books.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
			fos.close();
			oos.close();
			System.out.println("파일이 성공적으로 닫혔습니다.");
		}catch(Exception e) {
			System.out.println("파일을 찾을 수 없습니다.");
		}
	}

	@Override
	public void add(Book b) throws DuplicateException {
		// TODO Auto-generated method stub
		boolean find = false;
		for(Book tb : list) {
			if(tb.getIsbn().equals(b.getIsbn())) {
				find = true;
				throw new DuplicateException();
			}
		}
		if(find != true) list.add(b);
	}

	@Override
	public List<Book> search() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Book search(String isbn) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		boolean find = false;
		Book tb2 = new Book();
		for(Book tb : list) {
			if(tb.getIsbn().equals(isbn)) {
				find = true;
				tb2 = tb;
			}
		}
		if(find == false) throw new RecordNotFoundException();
		else
			return tb2;
	}

	@Override
	public void update(String isbn, int price) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		boolean find = false;
		for(Book tb : list) {
			if(tb.getIsbn().equals(isbn)) {
				find = true;
				tb.setPrice(price);
			}
		}
		if(find == false) throw new RecordNotFoundException();
	}

	@Override
	public void delete(String isbn) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		boolean find = false;
		for(Book tb : list) {
			if(tb.getIsbn().equals(isbn)) {
				find = true;
				list.remove(tb);
			}
		}
		if(find != true) throw new RecordNotFoundException();
	}

	@Override
	public List<Book> searchTitle(String title) {
		// TODO Auto-generated method stub
		ArrayList<Book> temp = new ArrayList<Book>();
		for(Book tb : list) {
			if(tb.getTitle().equals(title)) {
				temp.add(tb);
			}
		}
		return temp;
	}

	@Override
	public List<Book> sortIsbn() {
		// TODO Auto-generated method stub
		Collections.sort(list);
		return list;
	}

	@Override
	public String countWord() {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> al = new ArrayList<>();
		int cnt = 0, max =-987654321;
		for(Book b : list) {
			StringTokenizer st = new StringTokenizer(b.getTitle());
			while(st.hasMoreTokens())
				al.add(st.nextToken());
		}
		
		int scnt = 0;
		HashMap<String, Integer> hm = new HashMap<>(); 
		HashMap<Integer, String> hm2 = new HashMap<>(); 
		for(String s : al) {
			scnt=0;
			//System.out.println("s : " + s);
			for(String s2 : al) {
				//System.out.println("s2 :" + s2);
				if(s.equals(s2)) scnt+=1;
			}
			//System.out.println("scnt : " +scnt);
			hm.put(s, scnt);
		}
		
		int scnt2 = 0;
		int maxCheck = 0;
		for(String s : al) {
			if(hm.get(s)> scnt2) {
				//if(hm.get(s)>maxCheck) maxCheck = hm.get(s);
				scnt2 = hm.get(s) ;
				hm2.put(scnt2,s);
			}
		}
		String u = "";
		for(String s : al) {
			System.out.println("s : "+s);
			if(hm.get(s) == scnt2 && !u.contains(" "+s) && !u.equals(" "+s) && !u.contains(s) && !u.equals(s)) {
				System.out.println("u :"+u);
				u+=hm2.put(scnt2,s);
			}
		}
		
		return u;
	}
}


