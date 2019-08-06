package com.ssafy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;


class DuplicateException extends Exception {
	public String toString() {
		return "DuplicateException";
	}
}

class CodeNotFoundException extends Exception{
	public String toString() {
		return "CodeNotFoundException";
	}
}

class ProductNotFoundException extends Exception{
	public String toString() {
		return "ProductNotFoundException";
	}
}
public class ProductMgrImpl implements IProductMgr {
	private static ProductMgrImpl instance;
	private ArrayList<Product> ps;// = new ArrayList<>();
	//private int index;
	//생성자
	private ProductMgrImpl() {
		if(ps ==null ) {
			ps = new ArrayList<>();
		}
		open();
		//ps.clear();
	}
	//
	public static ProductMgrImpl getInstance() {
		if (instance == null) {
			instance = new ProductMgrImpl(); 
		}
		return instance;
	}
	
	@Override
	public void add(Product p) throws DuplicateException{
		for(Product pd : ps) {
			if(pd.getNum()==p.getNum())
				throw new DuplicateException();
		}
		ps.add(p);
	}
	
	@Override
	public ArrayList<Product> search() {
		return ps;
	}
	@Override
	public Product search_num(int num) throws CodeNotFoundException {
		for(Product b : ps) {
			if (b.getNum() == num) {
				return b;
			}
		}
		throw new CodeNotFoundException();
	}
	@Override
	public ArrayList<Product> search_name(String name) {
		ArrayList<Product> list = new ArrayList<>();
		for(Product b : ps) {
			if (b.getName().contains(name))
				list.add(b);
		}
		return list;
	}
	@Override
	public ArrayList<Product> search_TV() {
		ArrayList<Product> list = new ArrayList<>();
		for(Product b : ps) {
			if (b instanceof TV)
				list.add(b);
		}
		return list;
	}
	@Override
	public ArrayList<Product> search_Refrig() {
		ArrayList<Product> list = new ArrayList<>();
		for(Product b : ps) {
			if (b instanceof Refrigerator)
				list.add(b);
		}
		return list;
	}
	@Override
	public ArrayList<Product> search_Refrig_400() throws ProductNotFoundException{
		ArrayList<Product> list = new ArrayList<>();
		for(Product b : ps) {
			if (b instanceof Refrigerator) {
				if(((Refrigerator) b).getliter() >= 400) {
					list.add(b);
				}
			}
		}
		if(list.isEmpty()) throw new ProductNotFoundException();
		return list;
	}
	@Override
	public ArrayList<Product> search_TV_50() throws ProductNotFoundException{
		ArrayList<Product> list = new ArrayList<>();
		for(Product b : ps) {
			if (b instanceof TV) {
				if(((TV) b).getinch() >= 50) {
					list.add(b);
				}
			}
		}
		if(list.isEmpty()) throw new ProductNotFoundException();
		return list;
	}
	@Override
	public void change(int num, int price) {
		for(Product b : ps) {
			if (b.getNum() == num) {
				b.setPrice(price);
			}
		}
	}
	@Override
	public void remove(int num) {
		int index =0;
		for(int i=0; i < ps.size(); i++) {
			if (ps.get(i).getNum() == num) { //같은 인덱스 찾기 //ps[i]아님!!
				index =i;
				break;
			}
		}
		ps.remove(index);
	}
	@Override
	public int total() {
		int sum=0;
		for(Product b : ps) {
			sum += b.getPrice() * b.getLeft();
 		}
		return sum;
	}
	@SuppressWarnings("unchecked")
	public void open() {
		try {
			FileInputStream fis = new FileInputStream("product.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			ArrayList<Product> old =(ArrayList<Product>) ois.readObject();
			
			if(old != null) {
				ps = old;
				System.out.println("오픈 성공");
			}
			ois.close();
			fis.close();
			System.out.println("오픈끝");
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("open()문제");
		}
	}
	
	
	public void close() {
		new ProductSave().start(); //스레드를 생성하고 바로 일을 시킴
	}
	//내부 클래스 : Thread
	class ProductSave extends Thread {
		public void run() {
			try {
				FileOutputStream fos = new FileOutputStream("product.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos); //두줄 이어붙이면 트라이캐치 및 close()가 필요없다.
				oos.writeObject(ps);
				
				oos.close();
				fos.close();
				System.out.println("클로즈 성공");
			}catch(Exception e){
				System.out.println("close()문제");
			}
		}
	}
	
	//////서버에 보내는 부분 추가 
	@Override
	public synchronized void send() {
		new ProductClient().start(); //스레드를 생성하고 바로 일을 시킴
	}
	//내부 클래스 : Thread -> run() : 서버로 접속해 들어간 후 ArrayList를 보내야 함
	class ProductClient extends Thread {
		
		//변수 선언 : Socket, Stream(Output & ObjectOutput)
		public void run() { //서버로 접속해 들어간 후 ArrayList를 보내야 함
			ArrayList<Product> pss = new ArrayList<>();
			try {
				//1. Socket 생성해서 서버로 접속해 들어가기
				Socket s1 = new Socket("70.12.108.203", 9898);
				//2. socket으로부터 스트림 얻어낸 후 필터까지 끼우기
				OutputStream s1out = s1.getOutputStream(); 
				ObjectOutputStream oos = new ObjectOutputStream(s1out);
				//3. 서버로 출력 : oos.writeobject(list);
/*				for(Product p: ps) {
					if(p instanceof TV) {
						pss.add(p);
					}
				}
				for(Product p: ps) {
					if(p instanceof Refrigerator) {
						pss.add(p);
					}
				}
				*/
				oos.writeObject(search_TV());
				oos.writeObject(search_Refrig()); //서버에서 받을 때도 2번받아야함
				//4. 마무리 : close
				oos.close();
				s1out.close();
				s1.close();
				//5. 확인 메시지 : 서버로 보냈습니다.
				System.out.println("서버로 보냈습니다.");
			}catch(Exception e) {
				System.out.println(e);
			}
		}
	}
	
	
}