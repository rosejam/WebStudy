package com.dom;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class BookParsingDOM {

	public static void main(String[] args) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); //싱글톤. 스태틱 메서드로 객체 생성
			DocumentBuilder parser = factory.newDocumentBuilder(); //parser생성
			
			Document doc = parser.parse("res/book.xml"); //돔트리에서 레퍼런스/를 리턴함 (doc은 parsing이 된 .xml문서)
			NodeList list = doc.getElementsByTagName("author"); //NodeList에 해당되는 "Element"가 저장된다.
			
			for(int i=0; i< list.getLength();i++) {
				Node each = list.item(i); //노드리스트에서 인덱스에 해당하는 "Element"를 하나 꺼내는 .item()메서드
				Node child = each.getFirstChild(); //Element의 body부분인 Child Node(text node)을 얻는다. 
													//자식이 1개이므로 getLastChild도 됨
				System.out.println(child.getNodeValue()); //Node의 값을 얻어냄 -> text값
			}
			//////
			list = doc.getElementsByTagName("title");
			for(int i=0; i< list.getLength();i++) {
				Node each = list.item(i); 
				Node child = each.getFirstChild(); 
				System.out.println(child.getNodeValue()); 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
