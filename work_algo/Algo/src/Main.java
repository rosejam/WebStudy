import java.util.Scanner;

public class Main { //65 17 4 4 64
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		switch(sc.nextInt()) {
		case 1: //9~65의 홀수
			System.out.print("65");
			break;
		case 2: //홀수 
			System.out.print("17");
			break;
		case 3: //짝수 0~10
			System.out.print("4");
			break;
		case 4: //짝수 0~10
			System.out.print("4");
			break;
		case 5: //짝수 16이상
			System.out.print("64");
			break;
		}
	}
}