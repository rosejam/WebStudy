package array2;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D2_1989_초심자의회문검사_서울9반_김동주 {
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("res/input_D2_1989.txt")); //제출할때는 입력 삭제!!!
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt(); 
		sc.nextLine();
		for(int tc = 1; tc <= T; tc++)
		{
			String s = sc.nextLine();//스트링받음
			int p;
			
			StringBuilder sb = new StringBuilder(s);
			//System.out.println(sb.reverse());
			String r = sb.reverse().toString();
			
			if(s.equals(r)) p=1;
			else p=0;
			
			System.out.println("#"+tc+" "+p);

		}
		sc.close();
	}
}