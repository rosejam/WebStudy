package array1;

import java.io.FileInputStream;
import java.util.Scanner;

public class 팁1289 { 
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("res/input_D3_1289.txt")); 
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();

		for(int tc = 1; tc <= T; tc++) {
			String line = sc.next();
			char[] chs = line.toCharArray(); //로 스트링을 캐릭터의 배열로
			sysout(Arrays.toString(chs)); //, 다시 스트링으로 출력할수 있음.
			char cur = '0'; //이두 변수가 매번 초기화 되도록 for문안에 들어가야함
			int count = 0 ;
			for(int i=0; i<line.length(); i++) {
				char ch=line.charAt(i); //charAt함수
				if(ch!=cur) {
					count++;
					cur=ch;
				}
			}
			System.out.println("");
	}

}
