package 보충2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
*/
class Solution_AD_0001_ShuffleOMatic_김동주
{	
	static int Ans,T,N;
	static int[] ccards, oans, nans,cards;
	static int[] LL,RR,L,R;
	static boolean bo,bn,notsameo, notsamen;
	static int co,min;
	static int xx;
	public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 sample_input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 sample_input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		*/
		System.setIn(new java.io.FileInputStream("res/input_AD_1.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		*/
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++)
		{
			N = Integer.parseInt(br.readLine()); //카드갯수
			LL = new int[N/2];
			RR = new int[N/2];
			L = new int[N/2];
			R = new int[N/2];
			ccards = new int[N];
			cards = new int[N];
			oans = new int[N];
			nans = new int[N];
			//int x=0;
			StringTokenizer st = new StringTokenizer(br.readLine());
/*			while(st.hasMoreTokens()) {
				L[x++]=Integer.parseInt(st.nextToken());
			}
			
*/			for(int n=0; n<N;n++) {
				ccards[n]=Integer.parseInt(st.nextToken());
			}
			for(int n=0; n<N/2;n++) {
				LL[n]=ccards[n];
			}
			for(int n=0; n<N/2;n++) {
				RR[n]=ccards[n+N/2];
			}
			//System.out.println(Arrays.toString(L)+Arrays.toString(R));
			for(int n=0; n<N; n++) {
				oans[n]= ccards[n];
			}
			Arrays.sort(oans);
			for(int n=0; n<N; n++) {
				nans[n]= oans[N-1-n];
			}
			//5회 셔플이내에 오름차순or내림차순 정렬
			//lllrrr, llrlrr, lrlrlr, rlrlrl, rrlrll, rrrlll
			bo=false;
			bn=false;
			min=Integer.MAX_VALUE;
			co=0;
			orum(ccards, LL,RR);

			Ans=0;
			if(!bo && !bn) {Ans = -1;} //둘다없//정렬이 불가능한 경우나 셔플 횟수가 5 회를 초과할 경우, 정답으로 -1 을 출력한다.
			else Ans=min;
			// 표준출력(화면)으로 답안을 출력합니다.
			sb.append("#" + test_case+" "+Ans+"\n"); //정렬에 필요한 최소 셔플 횟수
		}
		System.out.println(sb);
		br.close(); // 사용이 끝난 스캐너 객체를 닫습니다.
	}
	private static void orum(int[] cards,int[] L,int[] R) {
		if(co == 6) return; //co==5 를 하면 마지막 테스트 케이스가 틀리다.
		notsameo=false;
		notsamen=false;
		for(int n=0; n<N; n++) { //어느방향으로든 정렬되는지 체크
			if(cards[n]!= oans[n]) notsameo=true;
			if(cards[n]!= nans[n]) notsamen=true;
		}
		if(!notsameo) {
			if(co<min) min=co;
			bo = true;
			return;
		}else if(!notsamen) {
			if(co<min) min=co;
			bn = true;
			return;
		}
		/////////Shuffling
		for(int x=0; x<N; x++) {
			if(x<N/2) {
				for(int n=0;n<N/2-x; n++) { //0
					cards[n]=L[n];
				}
				for(int n=N/2-x; n<N/2+x; n++) { //1,2,3,4
					if((n-(N/2-x))%2==0) cards[n]=R[(n-(N/2-x))/2];
					else cards[n]=L[(n-(N/2-x))/2+(N/2-x)];
				}
				for(int n=N/2+x;n<N; n++) { //5
					cards[n]=R[n-N/2]; //2
				}
			}else {
				xx = N-x-1;
				for(int n=0;n<N/2-xx; n++) { //0 //
					cards[n]=R[n]; //0
				}
				for(int n=N/2-xx; n<N/2+xx; n++) { //12
					if((n-(N/2-xx))%2==0) cards[n]=L[(n-(N/2-xx))/2]; //0
					else cards[n]=R[(n-(N/2-xx))/2+(N/2-xx)]; //1
				}
				for(int n=N/2+xx;n<N; n++) { //3
					cards[n]=L[n-N/2]; //1
				}
			}
			/////////
			for(int n=0; n<N/2;n++) {
				L[n]=cards[n];
			}
			for(int n=0; n<N/2;n++) {
				R[n]=cards[n+N/2];
			}
			co++;
			orum(cards,L,R);
			co--;
		}
	}
}
