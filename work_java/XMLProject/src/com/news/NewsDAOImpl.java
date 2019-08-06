package com.news;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NewsDAOImpl implements NewsDAO {
	
	ArrayList<News> list; //일단 필드에 선언해놓기
	
	public NewsDAOImpl() { //생성자에서 리스트를 생성
		list = new ArrayList<>();
	}
	
	@Override
	public List<News> getNewsData(String url) {
		list.clear(); //ArrayList가 계속 추가되는게 아니라 새로 만들기 위해 전부 지우고 넣기
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
			DocumentBuilder parser = factory.newDocumentBuilder(); 
			Document doc = parser.parse(url); //최상위 /
			
			//NodeList list = doc.getElementsByTagName("item");
			NodeList tlist = doc.getElementsByTagName("title");
			NodeList plist = doc.getElementsByTagName("pubDate");
			
			for(int i=2; i< tlist.getLength();i++) { //두 리스트의 길이는 동일
				Node teach = tlist.item(i); 
				Node peach = plist.item(i-2);
				if(teach != null && peach != null) {
					Node tchild = teach.getFirstChild(); //text node
					Node pchild = peach.getFirstChild(); //text node
	
					String tval = tchild.getNodeValue();
					String pval = pchild.getNodeValue();
					
					News n = new News(tval, pval); //vo생성하면서 값 넣기
					list.add(n);
				}
			}	 
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
