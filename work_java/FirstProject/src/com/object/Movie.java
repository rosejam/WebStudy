package com.object;

/**
 * <pre>
 * 회원정보(Data)와 
 * @author 홍길동
 * @version 1.0
 * @see String
 */


public class Movie {
		/** 제목 데이터를 저장하는 변수*/
		String title;
		String director;
		int grade;
		String genre;
		String summary;
		
		/** 객체가 가지고 있는 정보를 출력하는 메서드*/
		public void movieInfo() {
			System.out.println("* 제목:"+title+"\t감독:"+director
					+"\t등급:" + grade + "\t장르:" + genre
					+ "\n줄거리:" + summary);
		}

}
