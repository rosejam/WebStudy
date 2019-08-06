package com.exception;
//사용자 정의 예외 클래스
class TransferException extends Exception {

	@Override
	public String toString() {
		return "예외 발생";
	}

}
public class MoneyTransfer {

	public static void main(String[] args) {
		MoneyTransfer t = new MoneyTransfer();
		t.transfer();//이체
	}
	
	private void transfer() { //만약 여기서도 throws하면 익셉션이 메인으로 전달된다
		withdraw();//출금
		try {
			deposit();//입금
		} catch (TransferException e) {
			System.out.println("입금예외발생");
			System.out.println("출금취소");
		}
	}

	private void deposit() throws TransferException { //호출자로 던져진 익셉션을 전달한다. 따라서 transfer()메서드에서 try~catch로 받는다.
		//예외발생 -> 입금실패
		throw new TransferException();
	}

	private void withdraw() {
		//...
		System.out.println("출금성공");
	}

}
