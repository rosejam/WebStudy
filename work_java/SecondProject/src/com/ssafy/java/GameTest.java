package com.ssafy.java;

import java.util.Scanner; //Scanner�޼��带 ����ϱ� ���� import

public class GameTest {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("1. 5�� 3��");
		System.out.println("2. 3�� 2��");
		System.out.println("3. 1�� 1��");
		System.out.println("몇판.");
		int num = Integer.parseInt(s.nextLine()); //
		int pan = 7 - 2*num;
		int u_win = 0;
		for(int i=1; i<pan+1; ) {
			System.out.println("입력:");
			String user = s.nextLine();
			user.trim();
			int computer = (int)(Math.random() * 3) + 1; //1/2/3
			switch (user) {
				case "가위":
					if (computer==3){//보
						u_win++;
						System.out.println("이겼!!!");
						i++;
					}else if (computer==2) {//바위
						u_win--;
						System.out.println("졌!!!");
						i++;
					}else {//가위
						System.out.println("비겼!!!");
					}
					break;
					
				case "바위":
					if (computer==1) {//가위
						u_win++;
						System.out.println("이겼!!!");
						i++;
					}else if (computer==3) {//보
						u_win--;
						System.out.println("졌!!!");
						i++;
					}else {//바위
						System.out.println("비겼!!!");
					}
					break;

				case "보":
					if (computer==2) {//바위
						u_win++;
						System.out.println("이겼!!!");
						i++;
					}else if (computer==1) {//가위
						u_win--;
						System.out.println("졌!!!");
						i++;
					}else { //보
						System.out.println("비겼!!!");
					}
					break;
				default:
					System.out.println("가위바위보 중!!");
					break;
			}
			//System.out.println("입력: ");
			
			if(Math.abs(u_win) > (pan-i)) {
				if (u_win>0) {
					System.out.println("ㄹㅇ이겼!!!");
					break;
				}else {
					System.out.println("ㄹㅇ졌!!!");
					break;
				}
			}
		}
	}
}
