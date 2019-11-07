package 보충3;
import java.util.Scanner;

//  완전탐색
public class Main_BJ_1436_영화감독숌_김태희 {
	
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		System.out.println(getNumber());
	}
	private static int getNumber() {
		int x = 666 ,n = 0;
		do {
			int y = x, m,cnt=0;
			while(y>0) {
				m = y % 10;
				y /= 10;
				if(m==6) {
					if(++cnt>2) {
						n++;
						break;
					}
				}else {
					cnt = 0;
				}
			}
			if(n == N) break;
			x++;
		}while(true);
		return x;
	}
}