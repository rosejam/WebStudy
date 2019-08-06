package com.exception;
//ArrayIndexOutOfBoundsException : Runtime Exception중 하나
public class ArrayTest {

	public static void main(String[] args) {
		String[] color = {"yellow", "red", "blue", "white", "pink"};
		
		for(int i=0; i<= color.length; i++) { 	//java.lang.ArrayIndexOutOfBoundsException : 5 
												//인덱스5는 범위를 벗어났다! -  Runtime Exception
			//try~catch : 예외가 발생한 위치에서 바로 감싸서 처리하는 방법
			try { 
				System.out.println(color[i]); //예외가 발생(할가능성이 있는)하는 문장 -> try내부에 작성
			}catch(java.lang.ArrayIndexOutOfBoundsException e) {	//VM이 던진 예외를 잡는 catch("익셉션객체"타입 변수명)
				System.out.println("oops, sorry...");
				System.out.println(e);
				System.out.println(e.getMessage()); //5 : 발생된 예외 종류에 따라 다른 메시지가 나옴
			}finally { 	//예외 발생 여부와 관계없이 매번 수행해야 하는 내용을 적어둠. 생략 가능
						//따라서 try가 실행된후 , catch가 실행된후 매번 실행
				System.out.println("finally...");
			}
		}
		
		System.out.println("finished...");

	}

}
