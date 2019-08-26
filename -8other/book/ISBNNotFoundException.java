package com.book;

public class ISBNNotFoundException extends Exception{
	@Override
	public String toString() {		
		return "ISBNNotFoundException 발생:없는 ISBN입니다";
		
	}
}
