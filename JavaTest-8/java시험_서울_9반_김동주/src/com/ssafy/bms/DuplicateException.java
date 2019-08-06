package com.ssafy.bms;

import java.util.Arrays;

public class DuplicateException extends Exception {
	
	public DuplicateException() {}
	@Override
	public String toString() {
		return "데이터가 중복되었습니다";
	}
	
}
