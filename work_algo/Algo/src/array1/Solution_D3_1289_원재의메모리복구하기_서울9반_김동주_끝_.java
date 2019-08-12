package array1;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution_D3_1289_원재의메모리복구하기_서울9반_김동주_끝_{ 
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("res/input_D3_1289.txt")); 
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();

		for(int tc = 1; tc <= T; tc++)
		{
			String line=sc.next();
/*			//예시답안
			char cur = '0'; //이두 변수가 매번 초기화 되도록 for문안에 들어가야함
			int count = 0 ;
			for(int i=0; i<line.length(); i++) {
				char ch=line.charAt(i); //charAt함수!
				if(ch!=cur) {
					count++;
					cur=ch;
				}
			}*/
			int count = 0;
			int index = 0;
			Boolean toggle = true;
			String st_toggle = "1";
			//for(int i=0; i<X.length() ; i++) {
			while(index < line.length()) { //
				if (toggle == false) {
					st_toggle = "0";
				}else {
					st_toggle = "1";
				}
				int index_t = line.indexOf(st_toggle, index);
				
				if (index_t == -1) { //이 뒤에 바꾸는게 없을때
					break;
					
				}else{
					toggle = !(toggle);
					index = index_t + 1;
					count++;
				}
			}
			
			System.out.println("#" + tc + " " + count);
		}
		sc.close(); ///스캐너를 닫는 부분을 넣어주는게 좋다.
	}
}