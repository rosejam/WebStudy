package com.ssafy;

public class MovieMgr {
	private static MovieMgr instance;
	private Movie[] movies = new Movie[100];
	private int index;
	//생성자
	private MovieMgr() {}
	//
	public static MovieMgr getInstance() {
		if (instance == null) {
			instance = new MovieMgr(); 
		}
		return instance;
	}
	//작성하는 메서드
	public void add(Movie m) {
		movies[index]=m;
		index++; //차량이 100개넘게 들어오면 어떻게 하는가?
	}
	public Movie[] search() {
		return movies;}
	public Movie search(String title) {
		for(Movie x: movies) {
			if (x!=null) {
				if (x.getTitle().equals(title))//Integer.parseInt()
					return x;
			}
		}
		return null;//같은번호없음
	}

	public Movie[] searchDirector(String name) {
		int count =0;
		for(Movie x: movies) {
			if (x!=null) {
				if ((x.getDirector()).equals(name))//Integer.parseInt()
					count++;
			}
		}
		Movie[] cheaps = new Movie[count+1];
		count = 0;
		for(Movie y: movies) {
			if (y!= null) {
				if ((y.getDirector()).equals(name)) {
					cheaps[count] = y;
					count++;
				}
			}
		}
		return cheaps;
	}
	
	public Movie[] searchGenre(String genre) {
		int count =0;
		for(Movie x: movies) {
			if (x!=null) {
				if ((x.getGenre()).equals(genre))//Integer.parseInt()
					count++;
			}
		}
		Movie[] cheaps = new Movie[count+1];
		count = 0;
		for(Movie y: movies) {
			if (y!= null) {
				if ((y.getGenre()).equals(genre)) {
					cheaps[count] = y;
					count++;
				}
			}
		}
		return cheaps;
	}
	

	public void delete(String title) {
		//int size = size();
		for(int i=0; i<100; i++) {
			if (movies[i] != null) {
				if ((movies[i].getTitle()).equals(title)) {
					movies[i] = null;// x = null로는 안없어짐!! 참조라서 그런듯!(없애기인데 이렇게 못없애지 ;;;)
				}
			}
		}
	}
	public int getSize() {
		int count=0;
		for(Movie x: movies) {
			if(x!=null) count++; //100칸중 널이 아닌것이 전부 차량
		}
		return count;
	}
}