package 보충3;

import java.util.Scanner;

public class Main_BJ_1436_영화감독숌_서울9반_김동주 {

	public static void main(String[] args) throws Exception {
		//666이 포함되는 수
		//N번째 수
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		//
		int x = 666;
		int y = 0;//
		int cnt = 0;//
		boolean flag = false;//
		for(int n=1; n<N; n++) {
			x++;
/*			while(!String.valueOf(x).contains("666")) { //666이 들어있을때 벗어난다.
				x++;
			}*/
			
			y = x;
			while(y>0){ //한자리씩 끊어내는 방법(10으로 나눈 몫과 나머지)
				if(y%10 == 6) {
					cnt++;
					if(cnt ==3) {
						flag = true;
						cnt = 0;
						break;
					}
				}
				y = y/10;
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