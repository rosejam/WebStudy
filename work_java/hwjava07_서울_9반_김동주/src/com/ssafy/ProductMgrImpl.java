package com.ssafy;

import java.util.ArrayList;

public class ProductMgrImpl implements IProductMgr {
	private static ProductMgrImpl instance;
	private ArrayList<Product> ps = new ArrayList<>();
	//private int index;
	//생성자
	private ProductMgrImpl() {}
	//
	public static ProductMgrImpl getInstance() {
		if (instance == null) {
			instance = new ProductMgrImpl(); 
		}
		return instance;
	}
	@Override
	public void add(Product p) {
		ps.add(p);
		
	}
	@Override
	public ArrayList<Product> search() {
		return ps;
	}
	@Override
	public Product search_num(int num) {
		for(Product b : ps) {
			if (b.getNum() == num)
				return b;
		}
		return null;
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
	public ArrayList<Product> search_Refrig_400() {
		ArrayList<Product> list = new ArrayList<>();
		for(Product b : ps) {
			if (b instanceof Refrigerator) {
				if(((Refrigerator) b).getliter() >= 400)
					list.add(b);
			}
		}
		return list;
	}
	@Override
	public ArrayList<Product> search_TV_50() {
		ArrayList<Product> list = new ArrayList<>();
		for(Product b : ps) {
			if (b instanceof TV) {
				if(((TV) b).getinch() >= 50)
					list.add(b);
			}
		}
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

	
}