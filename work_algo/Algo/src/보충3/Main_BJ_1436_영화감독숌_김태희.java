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
		int no = 666 ,target = 0;
		do {
			int t = no, m,cnt=0;
			while(t>0) {
				m = t % 10;
				t /= 10;
				if(m==6) {
					if(++cnt>2) {
						target++;
						break;
					}
				}else {
					cnt = 0;
				}
			}
			if(target == N) break;
			no++;
		}while(true);
		return no;
	}
}