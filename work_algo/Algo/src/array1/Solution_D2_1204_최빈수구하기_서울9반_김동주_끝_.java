package array1;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

class Solution_D2_1204_최빈수구하기_서울9반_김동주_끝_{ 
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("res/input_D2_1204.txt")); 
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt(); //int T = Integer.parseInt(sc.nextLine()); 으로 해도 된다.

		for(int tc = 1; tc <= T; tc++)
		{
			sc.nextInt();
			int[] X = new int[1000]; 
			////String line = sc.nextLine();
			////String[] X = line.split(" "); 으로 for문없이 공백을 구분자로 분리한 스트링 배열을 X에 넣을수도 있다!
			
			int[] Y = new int[101]; //인덱스가 점수
			for(int i=0; i<1000; i++) { 
				X[i] = sc.nextInt();
				for(int j=0; j<=100; j++) { //// for(int i=0; i<1000; i++) Y[sc.nextInt()]++;으로 대체 가능!!!! 이중포문을 제거!
					if(X[i] == j)
						Y[j]++;
				}
				
			}//X, Y에 다넣음
			/////////////////////////////////////////////////////////////////////////////////////////////
			int m_index = 0;
			for(int k = 100; k >=0; k--){ //같은 빈도면 더 큰 점수를 출력해야하는 문제 조건
				if(Y[k] > Y[m_index]){ //그 조건을 위해서 그냥 k를 0~100순서로 돌리면서 여기에 등호를 붙여주어도 된다~
					m_index=k;
				}
			}
			System.out.println("#" + tc + " "+ m_index); //Y의 "제일 큰 내용물의 인덱스 출력" 이부분을 구글링함!!!
			/////////////////////////////////////////////////////////////////////////////////////////////
		}
	}
}