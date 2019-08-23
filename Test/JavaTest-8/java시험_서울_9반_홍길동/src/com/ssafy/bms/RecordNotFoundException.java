package com.ssafy.bms;

public class RecordNotFoundException extends Exception{

	@Override
	public String toString() {
		return "데이터가 없습니다";
	}
	
}
//1234,ssaf Java,홍,1234
//123,ssaf Java,홍,1234
//12,ssaf Java,홍,1234
//9999,ssaf Java,홍,1234
//1,ssaf Java,홍,1234