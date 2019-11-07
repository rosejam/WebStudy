package 보충3;

import java.util.Scanner;

public class Main_BJ_1436_영화감독숌_서울9반_김동주 {
	
	//리팩토링 버전 //스트링 메서드는 시간이 좀 걸리기 때문
	public static void main(String[] args) throws Exception {
		//666이 포함되는 수
		//N번째 수
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		//
		int x = 666;
		//
		int temp = 0;//
		int cnt = 0;//글자수 세기 3까지
		//boolean flag = false;//
		for(int n=1; n<N;) { //while문으로 n == N일 때 나오기
			cnt = 0; //플래그 초기화 필수!!
			x++;
			temp = x;
			//한자리씩 끊어내는 방법(10으로 나눈 몫과 나머지)
			while(temp > 0){
				if(temp%10 == 6) {
					cnt++;
					if(cnt == 3) {
						n++;
						//System.out.print(x+" ");
						break; //찾음! 이번이 아닌 경우 다시 x++로 감
					}
				}else {
					cnt = 0;
				}
				temp /= 10; //temp가 0이 되면 나감
			} //리팩토링
			
		}
		//
		System.out.print(x);
	}

}
/* 
 * 7글자 대충 5만가지 미만
 * 0000666
 * 0006660
 * 0066600
 * 0666000
 * 6660000  -> 여기서 1만개 끝남!!
 */