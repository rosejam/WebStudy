package com.object;

public class MovieTest {

	public static void main(String[] args) {
		//영화 객체를 생성한다.
		Movie m = new Movie();

		//영화 객체에 알맞은 값을 설정한다.
		m.title = "Batman";
		m.director = "Nolan";
		m.grade = 10;
		m.genre = "Action";
		m.summary = "박쥐인간";
		
		//영화 객체의 정보를 출력한다. 
		m.movieInfo();
		
	}

}
