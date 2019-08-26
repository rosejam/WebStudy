package com.ssafy;

public class ProductTest {
	///필요에 의해서 추가한 메서드
	public static void ToString(Product c) {
		System.out.println(c.toString());
	}
	public static void ToString(Product[] c) {
		for(Product x :c) {
			if(x!=null)
				System.out.println(x.toString());
		}
	}
		
	public static void main(String[] args) {
		ProductMgr c = ProductMgr.getInstance(); //
		
		Product c1 = new TV(1,"1TV",1,1,"0");
		Product c2 = new Refrigerator(2,"2냉장고",2,2,"0");
		Product c3 = new TV(3,"3TV",3,3,"0");
		Product c4 = new Refrigerator(4,"4냉장고",4,4,"0");
		Product c5 = new TV(5,"5TV",5,5,"0");
		Product c6 = new Refrigerator(6,"6냉장고",6,6,"0");
		Product c7 = new TV(7,"7TV",7,7,"0");
		Product c8 = new Refrigerator(8,"8냉장고",8,8,"0");
		Product c9 = new TV(9,"9TV",9,9,"0");
		
		c9.toString();
		
		c.add(c1);
		c.add(c2);
		c.add(c3);
		c.add(c4);
		c.add(c5);
		c.add(c6);
		c.add(c7);
		c.add(c8);
		c.add(c9);
		System.out.println(c.Total());
		c.delete(6);
		
		ToString(c.search());
		ToString(c.search(4));
		ToString(c.search("7TV"));
		//if (c.search("6번") == null)
		//	System.out.println("여긴널임");
		
		ToString(c.SearchTV());
		ToString(c.SearchRefrig());
	}

}