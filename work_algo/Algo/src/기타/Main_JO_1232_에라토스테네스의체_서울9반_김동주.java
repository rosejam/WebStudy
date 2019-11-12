package 기타;

import java.util.Scanner;

//N까지의 소수를 구하는 알고리즘
public class Main_JO_1232_에라토스테네스의체_서울9반_김동주 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int cnt = 0;
		
		boolean[] check = new boolean[N+1]; //체에 걸러지는 애들 true체크용
		
here:	for(int n=2; n<=N; n++) {
			if(!check[n]) { //n이 소수P임
				//check[n] = true;
				for(int m=n; m<=N; m += n) { //n부터 N까지 n의 배수 지우기
					check[m] = true; //체에 걸러짐
					cnt++;
					if(cnt == K) {
						System.out.print(m);
						break here;
					}
				}
			}
		}
		
	}

}
