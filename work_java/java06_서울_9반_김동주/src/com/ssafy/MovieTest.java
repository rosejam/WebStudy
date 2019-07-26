package com.ssafy;

import java.util.Scanner;

public class MovieTest {
	//MovieMgr을 테스트 한다.
	
	///필요에 의해서 추가한 메서드
	public static void ToString(Movie c) {
		System.out.println(c.toString());
	}
	public static void ToString(Movie[] c) {
		for(Movie x :c) {
			if(x!=null)
				System.out.println(x.toString());
		}
	}
		
	public static void main(String[] args) {
		MovieMgr c = MovieMgr.getInstance(); //
		
/*		Movie c1 = new Movie("1제목","1감독",5,"1장르");
		Movie c2 = new Movie("2제목","2감독",4,"2장르");
		Movie c3 = new Movie("3제목","3감독",3,"3장르");
		Movie c4 = new Movie("4제목","4감독",2,"4장르");
		Movie c5 = new Movie("5제목","5감독",1,"7장르");
		Movie c6 = new Movie("6제목","4감독",2,"6장르");
		Movie c7 = new Movie("7제목","3감독",3,"7장르");
		Movie c8 = new Movie("8제목","2감독",4,"8장르");
		Movie c9 = new Movie("9제목","1감독",5,"9장르");
		
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
		System.out.println(c.getSize());
		c.delete("6제목");
		ToString(c.search());
		ToString(c.search("4제목"));
		ToString(c.searchGenre("7장르")); //2개 
		ToString(c.searchDirector("2감독")); //2개
		//ToString(c.search("6감독"));
		
		System.out.println(c.getSize());*/
		
		//////// Command Line Menu 작성////////
		String title=null;
		String director=null;
		int grade=0;
		String genre=null;
		String summary=null;

		System.out.println("<<< 영화 관리 프로그램 >>>\n1. 영화 정보 입력\n2. 영화 정보 전체 검색  \n3. 영화명 검색\n4. 영화 장르별 검색\n5. 영화 정보 삭제\n0. 종료\n원하는 번호를 선택하세요. ");
		System.out.println();
		Scanner sc = new Scanner(System.in);
		int Do = sc.nextInt();
		while(Do!=0) {
			switch (Do) {
			case 1:
				sc.nextLine();
//				System.out.println("title:");
				title = sc.nextLine();
//				System.out.println("director:");
				director = sc.nextLine();
//				System.out.println("grade:");
				grade = Integer.parseInt(sc.nextLine());
//				System.out.println("genre:");
				genre = sc.nextLine();
//				System.out.println("summary:");
				summary = sc.nextLine();
				Movie mov = new Movie(title,director,grade,genre,summary);
				c.add(mov);
				ToString(mov);
				System.out.println("입력됨");
				break;
			case 2:
				ToString(c.search());
				break;
			case 3:
				sc.nextLine();
				title = sc.nextLine();
				ToString(c.search(title));
				break;
			case 4:
				sc.nextLine();
				genre = sc.nextLine();
				ToString(c.searchGenre(genre));
				break;
			case 5:
				sc.nextLine();
				title = sc.nextLine();
				c.delete(title);
				System.out.println("삭제됨");
				break;
			default:
				break;
			}
			System.out.println("<<< 영화 관리 프로그램 >>>\n1. 영화 정보 입력\n2. 영화 정보 전체 검색  \n3. 영화명 검색\n4. 영화 장르별 검색\n5. 영화 정보 삭제\n0. 종료\n원하는 번호를 선택하세요. ");
			System.out.println();
			Do = sc.nextInt();
		}
		System.out.println("종료됨");
	}

}