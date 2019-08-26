package com.ssafy;

import java.util.ArrayList;

public interface IProductMgr {
	void add(Product p);
	ArrayList<Product> search();
	Product search_num(int num);
	ArrayList<Product> search_name(String name);
	ArrayList<Product> search_TV();
	ArrayList<Product> search_Refrig();
	ArrayList<Product> search_Refrig_400();
	ArrayList<Product> search_TV_50();
	void change(int num, int price); //이 가격으로 변화
	void remove(int num);
	int total();
}
