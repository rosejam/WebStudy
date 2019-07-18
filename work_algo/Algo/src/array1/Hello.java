/*package array1;

public class Hello {

	public static void main(String[] args) {
		System.out.println("Hello Algo^^");
		String h = "Hello";
		System.out.println(h.charAt(4));
		System.out.println("박찬호".length());
	}

}
*/
package array1;

import java.io.FileInputStream;
import java.util.Scanner;

public class Hello {
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("res/input_D3_1208.txt")); 
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 0; tc < 10; tc++)
		{
			int[] X = new int [100]; // 상자 높이
			int T = sc.nextInt();// 덤프횟수
			for(int i=0; i<100; i++) {
				X[i] = sc.nextInt();
			}
			System.out.println("#"+(tc+1)+" ");
		}
		
	}
}