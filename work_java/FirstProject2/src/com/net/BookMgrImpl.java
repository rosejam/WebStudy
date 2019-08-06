package com.net;

public class BookMgrImpl { //implements IBookMgr {
	public void send() { //아래 스레드를 이용해서 서버로 도서정보 전송
		new BookClient().start(); //스레드를 생성하고 바로 일을 시킴
	}
	
	//내부 클래스 : Thread -> run() : 서버로 접속해 들어간 후 ArrayList를 보내야 함
	class BookClient extends Thread{
		//변수 선언 : Socket, Stream(Output & ObjectOutput)
		public void run() { //서버로 접속해 들어간 후 ArrayList를 보내야 함
			//1. Socket 생성해서 서버로 접속해 들어가기
			
			//2. socket으로부터 스트림 얻어낸 후 필터까지 끼우기
			
			//3. 서버로 출력 : oos.writeobject(list);
			
			//4. 마무리 : close
			
			//5. 확인 메시지 : 서버로 보냈습니다.
		}
	}
}
