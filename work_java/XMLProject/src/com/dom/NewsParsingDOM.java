package com.dom;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class NewsParsingDOM {

	public static void main(String[] args) {
		String url = "http://news.sbs.co.kr/news/SectionRssFeed.do?sectionId=03";
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); //싱글톤. 스태틱 메서드로 객체 생성
			DocumentBuilder parser = factory.newDocumentBuilder(); //parser생성
			
			Document doc = parser.parse(url); 
			NodeList tlist = doc.getElementsByTagName("title");
			NodeList plist = doc.getElementsByTagName("pubDate");
			
			for(int i=0; i< plist.getLength();i++) { //두 리스트의 길이는 동일
				Node teach = tlist.item(i+2); 
				Node peach = plist.item(i);
				//아래를 if(teach != null && peach != null) 로 쓸수도 있다 근데 내가 한게 맞음
				Node tchild = teach.getFirstChild();  
				Node pchild = peach.getFirstChild(); 
				System.out.println(tchild.getNodeValue() + "::"+ pchild.getNodeValue().substring(0,21)); //0~20까지 
				 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
