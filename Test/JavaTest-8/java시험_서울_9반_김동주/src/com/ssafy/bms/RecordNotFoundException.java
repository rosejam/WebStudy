package com.ssafy.bms;

public class RecordNotFoundException extends Exception {

	public RecordNotFoundException() {}
	@Override
	public String toString() {
		return "데이터가 없습니다";
	}
	
}
