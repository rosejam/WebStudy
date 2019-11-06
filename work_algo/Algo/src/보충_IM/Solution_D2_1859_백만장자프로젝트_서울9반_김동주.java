package 보충_IM;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1)전체 범위의 최대값을 찾는다. 최대값 앞부분 숫자에서 사서 최대값에 판다.
//	최대값 이후~끝영역에서 두번째 최대값을 찾는다. 두번째 최대값 앞쪽 숫자에 사서 두번째 최대값에서 판다.

//2)뒤에서 부터 역순으로 접근
//	최대기준값 초기화 = 끝값
//	최대기준값보다 작으면 샀다팔기 차이를 누적
//	최대기준값보다 크면 최대기준값을 업데이트

//BufferedReader 쓰면 큰 속도로 준다.
public class Solution_D2_1859_백만장자프로젝트_서울9반_김동주 { //int범위는 21억!!!!
	public static int N;
	public static int[] price;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_D2_1859.txt"));
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			N = Integer.parseInt(br.readLine());
			price = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int n=0; n<N; n++) {
				price[n] = Integer.parseInt(st.nextToken());
			}
			long sum = 0; //타입을 정할때 기준 : 저장할 최대 숫자의 범위!
			int maxIndex = 0; //최대값이 들어있는 방 번호
			int start =0; //판매할 시작 위치 
			while(maxIndex < N-1) { //전체가 끝날 때까지 반복
				//최대값 위치 찾을 범위 : start ~ N-1;
				maxIndex = start; //범위 내의 첫번째 값으로 초기화
				for(int i=start; i<N; i++) {
					if(price[maxIndex] < price[i]) maxIndex = i;
				}
				//start~maxIndex 판매
				for(int i=start; i<maxIndex; i++) {
					sum += price[maxIndex] - price[i];
				}
				start = maxIndex + 1; //start값을 수정
			}
			sb.append("#"+tc+" "+sum+"\n");
		}
		System.out.println(sb);
	}
}
