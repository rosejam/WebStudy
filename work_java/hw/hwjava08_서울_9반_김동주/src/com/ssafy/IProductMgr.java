package com.ssafy;

import java.util.ArrayList;

public interface IProductMgr {
	void add(Product p) throws DuplicateException;
	ArrayList<Product> search();
	Product search_num(int num) throws CodeNotFoundException;
	ArrayList<Product> search_name(String name);
	ArrayList<Product> search_TV();
	ArrayList<Product> search_Refrig();
	ArrayList<Product> search_Refrig_400() throws ProductNotFoundException;
	ArrayList<Product> search_TV_50() throws ProductNotFoundException;
	void change(int num, int price); //이 가격으로 변화
	void remove(int num);
	int total();
	public void open();
	public void close();
}
