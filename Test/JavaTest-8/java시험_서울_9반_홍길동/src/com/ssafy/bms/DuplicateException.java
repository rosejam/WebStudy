package com.ssafy.bms;

public class DuplicateException extends Exception{

	@Override
	public String toString() {
		return "데이터가 중복되었습니다.";
	}

}
