package com.ssafy;

import java.util.ArrayList;

public class ProductTest {
	///출력 필요에 의해서 추가한 메서드
	public static void ToString(Product c) {
		System.out.println(c.toString());
	}
	public static void ToString(ArrayList<Product> c) {
		for(Product x :c) {
			if(x!=null)
				System.out.println(x.toString());
		}
	}
		
	public static void main(String[] args) {
		ProductMgrImpl c = ProductMgrImpl.getInstance(); //객체생성
		
		Product c0 = new Refrigerator(9,"0냉장고",0,0,900);
		Product c1 = new TV(8,"1TV",10000,1,50);
		Product c2 = new Refrigerator(7,"2냉장고",20000,2,500);
		Product c3 = new TV(6,"3TV",30000,3,30);
		Product c4 = new Refrigerator(5,"4냉장고",40000,4,300);
		Product c5 = new TV(4,"5TV",50000,5,20);
		Product c6 = new Refrigerator(3,"6냉장고",60000,6,400);
		Product c7 = new TV(2,"7TV",70000,7,100);
		Product c8 = new Refrigerator(1,"8냉장고",80000,8,100);
		Product c9 = new TV(0,"9TV",90000,9,60);
		
		c.add(c0);
		c.add(c1);
		c.add(c2);
		c.add(c3);
		c.add(c4);
		c.add(c5);
		c.add(c6);
		c.add(c7);
		c.add(c8);
		c.add(c9);
		System.out.println("------------------");
		ToString(c.search());
		System.out.println("------------------");
		ToString(c.search_num(2));
		System.out.println("------------------");
		System.out.println(c.search_name("2"));
		System.out.println("------------------");
		ToString(c.search_TV());
		System.out.println("------------------");
		ToString(c.search_Refrig());
		System.out.println("------------------");
		ToString(c.search_Refrig_400());
		System.out.println("------------------");
		ToString(c.search_TV_50());
		System.out.println("------------------");
		c.change(9, 999999999);
		c.remove(6);
		System.out.println(c.total());
		System.out.println("------------------");
		ToString(c.search());
		
	}

}