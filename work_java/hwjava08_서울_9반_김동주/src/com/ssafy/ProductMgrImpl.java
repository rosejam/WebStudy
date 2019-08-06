package com.ssafy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
		try {
			FileOutputStream fos = new FileOutputStream("product.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(ps);
			
			oos.close();
			fos.close();
			System.out.println("클로즈 성공");
		}catch(Exception e){
			System.out.println("close()문제");
		}
	}
	
}