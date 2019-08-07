package com.ssafy.news;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class NewsDAODOMImpl implements INewsDAO {
	List<News> list;
	private static NewsDAODOMImpl instance;
	static Document doc;
	private String title;
	private String desc;
	private String link;
	
	private NewsDAODOMImpl(){
		list = new ArrayList<>();
	}
	
	public static NewsDAODOMImpl getInstance() {
		if(instance ==null) {
			instance = new NewsDAODOMImpl();
		}
		return instance;
	}
	
	public List<News> getNewsList(String url){
		list.clear();
		connectNews(url);
		
		NodeList items = doc.getElementsByTagName("item");
		
		for(int i=0; i< items.getLength();i++) {
			Node data = items.item(i); 
			NodeList datachild = data.getChildNodes();
			
			for(int j=0; j< datachild.getLength(); j++) {
				Node child = datachild.item(j); 
				String name = child.getNodeName(); 
				if(name.equals("title")) { 
					title = child.getFirstChild().getNodeValue();
					continue;
				}
				if(name.equals("desc")) { 
					desc = child.getFirstChild().getNodeValue();
					continue;
				}

			}
			News w = new News(title,desc,null);
			list.add(w);
		}
		
		
		return list;
	}
	private void connectNews(String url) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
			DocumentBuilder parser = factory.newDocumentBuilder(); 
			doc = parser.parse(url);
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public News search(int index) {
		return list.get(index);
	}
}
