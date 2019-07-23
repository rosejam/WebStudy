package com.ssafy;
//BookManager 클래스가 완성해야 되는 메소드 목록을 가지고 있는 인터페이스
public interface IBookManager {
	//데이터 추가
	void add(Book book);
	Book[] total(); //전체 데이터 검색
	Book findByIsbn(String isbn);
	Book[] findByTitle(String title);
	Book[] findByPrice(int price);
	Book[] findMagazine();
	Book[] findNovel();
	int sum();
	double average();
}
