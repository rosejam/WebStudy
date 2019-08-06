package com.dom;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MemberParsingDOM {

	public static void main(String[] args) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); //싱글톤. 스태틱 메서드로 객체 생성
			DocumentBuilder parser = factory.newDocumentBuilder(); //parser생성
			
			Document doc = parser.parse("res/member.xml"); //돔트리에서 레퍼런스/를 리턴함 (doc은 parsing이 된 .xml문서)
			NodeList list = doc.getElementsByTagName("member"); //NodeList에 해당되는 "Element"가 저장된다.
			
			//name, address
			for(int i=0; i< list.getLength();i++) {
				Node member = list.item(i); //member 한 사람
				NodeList memberchild = member.getChildNodes(); //member의 모든 자식 노드 알아냄
				
				for(int j=0; j< memberchild.getLength(); j++) {
					Node child = memberchild.item(j); //멤버의 자식중 하나를 알아냄
					String name = child.getNodeName(); //노드 이름(tag) 알아내기
					if(name.equals("name")) { //노드이름이 name이면
						System.out.print(child.getFirstChild().getNodeValue()+"::"); //노드의 자식(body)노드를 찾고 그값을 구한다.
					}
					if(name.equals("address")) {
						System.out.print(child.getFirstChild().getNodeValue()+"\n"); 
					}
				}
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
