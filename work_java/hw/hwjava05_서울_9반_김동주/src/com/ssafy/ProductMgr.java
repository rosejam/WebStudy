package com.ssafy;

public class ProductMgr {
	private static ProductMgr instance;
	private Product[] products = new Product[100];
	private int index;
	//생성자
	private ProductMgr() {}
	//
	public static ProductMgr getInstance() {
		if (instance == null) {
			instance = new ProductMgr(); 
		}
		return instance;
	}
	//작성하는 메서드
	public void add(Product p) {
		products[index]=p;
		index++; //
	}
	public Product[] search() {
		return products;
	}
	public Product search(int num) {
		for(Product x: products) {
			if (x!=null) {
				if (x.getNum()==num)//Integer.parseInt()
					return x;
			}
		}
		return null;//같은번호없음
	}
	public Product search(String name) {
		for(Product x: products) {
			if (x!=null) {
				if ((x.getName()).contains(name))//Integer.parseInt()
					return x;
			}
		}
		return null;
	}
	

	public Product[] SearchTV() {
		
		int count =0;
		for(Product x: products) {
			if (x!=null) {
				if (x instanceof TV)//Integer.parseInt()
					count++;
			}
		}
		Product[] TVs = new Product[count+1];
		count = 0;
		for(Product y: products) {
			if (y!=null) {
				if (y instanceof TV) {//Integer.parseInt()
					TVs[count] = y;
					count++;
				}
			}
		}
		return TVs;
	}
	
	public Product[] SearchRefrig() {

		int count =0;
		for(Product x: products) {
			if (x!=null) {
				if (x instanceof Refrigerator)//Integer.parseInt()
					count++;
			}
		}
		Product[] Refrigs = new Product[count+1];
		count = 0;
		for(Product y: products) {
			if (y!=null) {
				if (y instanceof Refrigerator) {//Integer.parseInt()
					Refrigs[count] = y;
					count++;
				}
			}
		}
		return Refrigs;
	}

	public void delete(int num) {
		//int size = size();
		for(int i=0; i<100; i++) {
			if (products[i] != null) {
				if (products[i].getNum()==num) {
					products[i] = null;// x = null로는 안없어짐!! 참조라서 그런듯!(없애기인데 이렇게 못없애지 ;;;)
				}
			}
		}
	}
	public int Total() {
		int total=0;
		for(Product x: products) {
			if(x!=null) total += (x.getPrice()*x.getLeft()); 
		}
		return total;
	}
}