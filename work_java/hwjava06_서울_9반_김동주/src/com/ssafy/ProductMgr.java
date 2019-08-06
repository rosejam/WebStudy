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
	
	///hw06 추가분1
	public double left_price(String which) {
		double lp=0;
		if(which.equals("TV")) {
			int count =0;
			for(Product x: products) {
				if (x!=null) {
					if (x instanceof TV) {
						count++;
						lp += x.getPrice() * x.getLeft() ;
					}
				}
			}
			return lp/count;
			
		}else if(which.equals("냉장고")) {
			int count =0;
			for(Product x: products) {
				if (x!=null) {
					if (x instanceof Refrigerator) {
						count++;
						lp += x.getPrice() * x.getLeft() ;
					}
				}
			}
			return lp/count;
		}
		return 0;
	}
	//2
	public int left_num(String which) {
		if(which.equals("TV")) {
			int count =0;
			for(Product x: products) {
				if (x!=null) {
					if (x instanceof TV)
						count++;
				
				}
			}
			return count;
			
		}else if(which.equals("냉장고")) {
			int count =0;
			for(Product x: products) {
				if (x!=null) {
					if (x instanceof Refrigerator)
						count++;
				}
			}
			return count;
		}
		return 0;
	}
	//3
	public double TV_mean() {
		double lp =0;
		int count =0;
		for(Product x: products) {
			if (x!=null) {
				if (x instanceof TV) {
					count++;
					lp += ((TV) x).getinch() ;
				}
			}
		}
		return lp/count;
	}
	//4
	public double Refrig_sum() {
		double lp =0;
		for(Product x: products) {
			if (x!=null) {
				if (x instanceof TV)
					lp += ((Refrigerator) x).getliter() ;
			}
		}
		return lp;
	}
	//5
	public Product[] Cheaper(String name, int price) {
		int count =0;
		for(Product x: products) {
			if (x!=null) {
				if ((x.getName()).contains(name)) {
					if((x.getPrice())<price) 
						count++;
				}
			}
		}
		Product[] cheaps = new Product[count+1];
		count=0;
		for(Product x: products) {
			if (x!=null) {
				if ((x.getName()).contains(name)) {
					if((x.getPrice())<price) 
						cheaps[count]=x;
				}
			}
		}
		return cheaps;
		
	}
	
}