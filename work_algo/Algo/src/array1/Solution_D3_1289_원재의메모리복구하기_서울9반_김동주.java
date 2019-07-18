package array1;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution_D3_1289_원재의메모리복구하기_서울9반_김동주{ 
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("res/input_D3_1289.txt")); 
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();

		for(int tc = 1; tc <= T; tc++)
		{
		
			/////////////////////////이 부분에 여러분의 알고리즘 구현이 들어갑니다.///////////////////////////////////
			String X=sc.next(); 
			///참고)))char[] chs = X.toCharArray(); ///sysout(Arrays.toString(chs)); 로 스트링을 캐릭터의 배열로, 다시 스트링으로 출력할수 있음.
			///		for(char ch : chs){로 하나씩 스트링에서 캐릭터 배열로 넣을 수도 있다.
			int count = 0;
			int index = 0;
			Boolean toggle = true;
			String st_toggle = "1";
			//for(int i=0; i<X.length() ; i++) {
			while(index < X.length()) { //
				if (toggle == false) {
					st_toggle = "0";
				}else {
					st_toggle = "1";
				}
				int index_t = X.indexOf(st_toggle, index);
				
				if (index_t == -1) { //이 뒤에 바꾸는게 없을때
					break;
					
				}else{
					toggle = !(toggle);
					index = index_t + 1;
					count++;
				}
				
			}
			System.out.println("#" + tc + " " + count);
			/////////////////////////////////////////////////////////////////////////////////////////////
			sc.close(); ///스캐너를 닫는 부분을 넣어주는게 좋다.
		}
	}
}