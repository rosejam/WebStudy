package com.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

//Sax파싱 : 이벤트(시작태그 만날 떄 , 텍스트 만날 때 , 닫는태그 만날 때) 발생시마다 처리하는 방식
//이벤트 발생시마다 작업하는 핸들러 클래스 
public class MySaxParser extends DefaultHandler{
	
	@Override
	public void startDocument() throws SAXException { //문서가 시작될 때
		System.out.println("문서시작");
	}

	@Override
	public void endDocument() throws SAXException { //문서가 끝날때
		System.out.println("문서끝");
	}

	//엘리먼트 시작
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException { //qname, attributes 사용
		if(qName.equals("booklist")) {
			System.out.println("<booklist>");
			
		}else if(qName.equals("book")) {
			System.out.println("<book kind="+attributes.getValue("kind")+">");
			
		}else if(qName.equals("isbn")) {
			System.out.print("<isbn>");
			
		}else if(qName.equals("title")) {
			System.out.print("<title>");
			
		}else if(qName.equals("author")) {
			System.out.print("<author>");
			
		}else if(qName.equals("publisher")) {
			System.out.print("<publisher>");
			
		}else if(qName.equals("price")) {
			System.out.print("<price>");
		}
	}
	//엘리먼트 끝
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equals("booklist")) {
			System.out.println("</booklist>");
			
		}else if(qName.equals("book")) {
			System.out.println("</book>");
			
		}else if(qName.equals("isbn")) {
			System.out.println("</isbn>");
			
		}else if(qName.equals("title")) {
			System.out.println("</title>");
			
		}else if(qName.equals("author")) {
			System.out.println("</author>");
			
		}else if(qName.equals("publisher")) {
			System.out.println("</publisher>");
			
		}else if(qName.equals("price")) {
			System.out.println("</price>");
		}
	}
	//텍스트만날떄
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String str = new String(ch,start,length).trim();
		System.out.print(str);
	}
}
