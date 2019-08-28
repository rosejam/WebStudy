package 보충;

import java.util.Scanner;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
*/
class Solution_IM_0001_사각형칠하기_서울9반_김동주
{
	static int T;
	static int N;
	static int M;
	static int K;
	static int[][] DRAW = new int[21][5];
	static int AnswerN;
	static int[][] wall;
	static boolean nodraw;
	static int[] ld;
	public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 sample_input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 sample_input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		*/
		System.setIn(new java.io.FileInputStream("res/input_IM_1.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		*/
		Scanner sc = new Scanner(System.in);

		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++)
		{
			/*
			   각 테스트 케이스를 표준 입력에서 읽어옵니다.
			*/
			N = sc.nextInt(); //행
			M = sc.nextInt(); //열
			K = sc.nextInt();
			wall = new int[N][M]; //명도번호 0~10
			for (int k = 0; k < K; k++)
			{
				DRAW[k][0] = sc.nextInt(); //행1
				DRAW[k][1] = sc.nextInt(); //열1
				DRAW[k][2] = sc.nextInt(); //행2
				DRAW[k][3] = sc.nextInt(); //열2
				DRAW[k][4] = sc.nextInt(); //명도번호 0~10
				nodraw = false;
				for(int n=DRAW[k][0]; n<=DRAW[k][2]; n++) {
					for(int m=DRAW[k][1]; m<=DRAW[k][3]; m++) { //칠할 범위내에
						if(wall[n][m] > DRAW[k][4]) { //더 높은 명도 번호를 가지는 영역이 존재한다면
							nodraw = true;
						}
					}
				}
				if(!nodraw) {//그릴 수 있다면
					for(int n=DRAW[k][0]; n<=DRAW[k][2]; n++) {
						for(int m=DRAW[k][1]; m<=DRAW[k][3]; m++) { //칠할 범위내에
							wall[n][m] = DRAW[k][4];
						}
					}
				}
			}
			ld = new int[11];
			AnswerN = 0;
			/////////////////////////////////////////////////////////////////////////////////////////////
			for(int n=0; n<N; n++) {
				for(int m=0; m<M; m++) {
					ld[wall[n][m]]++;
					if(ld[wall[n][m]]>AnswerN) AnswerN=ld[wall[n][m]];
				}
			}
			/////////////////////////////////////////////////////////////////////////////////////////////

			// 표준출력(화면)으로 답안을 출력합니다. //영역 크기를 출력하는 프로그램을 작성하라 
			System.out.println("#" + test_case + " " + AnswerN);
		}

		sc.close(); // 사용이 끝난 스캐너 객체를 닫습니다.
	}
}
