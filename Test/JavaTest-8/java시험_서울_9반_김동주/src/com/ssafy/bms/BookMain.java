package com.ssafy.bms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookMain {
	Scanner s=new Scanner(System.in);
	BookMgrImpl mgr=BookMgrImpl.getInstance();     

	public static void main(String[] args) {
		BookMain m=new BookMain();
		int num=0;
Loop:	while(true) {
			num=m.menu();
			if(num==0) break;
			switch (num){
				case 1:
					m.insert();
					break;
				case 2:
					m.search();
					break;
				case 3:
					m.searchIsbn();
					break;
				case 4:
					m.searchTitle();
					break;
				case 5:
					m.update();
					m.search();
					break;
				case 6:
					m.delete();
					m.search();
					break;
				case 7:
					m.save();
					break;
				case 8:
					m.load();
					m.search();
					break;
				case 9:
					m.sortIsbn();
					break;
				case 10:
					//m.countWord();
					break;
				case 0:
					break Loop;
			}//end switch
			
		}//end while
	}
	public  int menu() {
		int result=0;
		System.out.println("==================================");
		System.out.println("========== 도서 관리 프로그램 ===========");
		System.out.println("==================================");
		System.out.println("1. 도서 등록");
		System.out.println("2. 도서 목록 보기");
		System.out.println("3. 도서 검색(ISBN으로 검색)");
		System.out.println("4. 도서 검색(도서명으로 검색)");
		System.out.println("5. 도서 수정");
		System.out.println("6. 도서 삭제");
		System.out.println("7. 도서 정보 파일 저장");
		System.out.println("8. 도서 정보 파일로 부터 읽어오기");
		System.out.println("9. ISBN으로 정렬해서 목록보기");
		System.out.println("10.도서명 중 가장 빈도수 높은 단어 구하기");
		System.out.println("0. 종료");
		System.out.println("원하는  번호를 선택 하세요.");
		result=Integer.parseInt(s.nextLine());
		return result;
		
	}
    public void insert() {
    	System.out.println("도서 정보를 입력하세요. 형식:ISBN,도서명,저자,금액");
    	String[] info=s.nextLine().split(",");
    	
    	Book book = new Book(info[0],info[1],info[2],Integer.parseInt(info[3]));
    	try {
			mgr.add(book);
		} catch (DuplicateException e) {
			System.out.println(e.toString());
		}
    	
    }
    public void search() {
    	System.out.println(">>>>>>>>  도서 목록 보기 ");
    	ArrayList<Book> sb = mgr.search();
    	if(!(sb.isEmpty())){
	    	for(Book b : sb) {
	    		System.out.println(b.toString());
	    	}
    	}else {System.out.println("책이 한권도 없습니다.");}
    	
    }
    public void searchIsbn() {
    	System.out.println(">>>>>>>>  도서  검색 (ISBN으로 검색) ");
    	System.out.println("검색하고자하는 ISBN을 입력하세요.");
    	String isbn=s.nextLine();
    	
    	try {
			System.out.println(mgr.search(isbn));
		} catch (RecordNotFoundException e) {
			System.out.println(e.toString());
		}
    	
    }
    public void searchTitle() {
    	System.out.println(">>>>>>>>  도서  검색 (이름으로 검색) ");
    	System.out.println("검색하고자하는 이름을 입력하세요.");
    	String title=s.nextLine();
    	ArrayList<Book> sbs = mgr.searchTitle(title);
    	if(!(sbs.isEmpty())) {
	    	for(Book b : sbs) {
	    		System.out.println(b.toString());
	    	}
    	}else {System.out.println("책이 한권도 없습니다.");}
    	
    }
    public void update() {
    	System.out.println(">>>>>>>>  도서  수정 ");
    	System.out.println("수정하고자하는 ISBN,부서을 입력하세요.");
    	String[] info=s.nextLine().split(",");

    	try {
			mgr.update(info[0], Integer.parseInt(info[1]));
		} catch (RecordNotFoundException e) {
			System.out.println(e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
    	
    }
    public void delete() {
    	System.out.println(">>>>>>>>  도서  삭제 ");
    	System.out.println("삭제하고자하는 ISBN을 입력하세요.");
    	String isbn=s.nextLine();

    	try {
			mgr.delete(isbn);
			System.out.println(mgr.search(isbn).getTitle() + "도서가 삭제 되었습니다.");
		} catch (RecordNotFoundException e) {
			System.out.println(e);
		}
    	
    }
    public void save() {
    	System.out.println(">>>>>>>>  도서  정보 저장 ");
    	mgr.save();
    	System.out.println(mgr.search().size()+"개 정보를 저장했습니다.");
    }
    public void load() {
    	System.out.println(">>>>>>>>  도서  정보 읽어오기 ");
    	mgr.load();
    	System.out.println("읽기 완료");
    	
    }
    public void sortIsbn() {
    	System.out.println(">>>>>>>>  도서ISBN로 정렬하기 ");
    	ArrayList<Book> b = mgr.sortIsbn();
    	for(Book bb : b) {
    		System.out.println(bb.toString());
    	}
    	
    }
    /*public void countWord() {
    	System.out.println(">>>>>>>>  빈도수 높은 단어 구하기 ");

    	// 구현하세요.
    	
    	
    }*/
   /* public void sortTitle() {
    	System.out.println(">>>>>>>>  도서이름로 정렬하기 ");
    	ArrayList<Book> bs=mgr.sortTitle();
    	for(Book e: bs) {
    		System.out.println(e);
    	}
    }    */
}
