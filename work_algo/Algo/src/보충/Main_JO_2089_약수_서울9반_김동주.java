package 보충;

import java.util.Scanner;

public class Main_JO_2089_약수_서울9반_김동주 { //약수를 모두 출력
	public static int N;
	public static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sb = new StringBuilder();
		print();
	}
	
	//1 2 4 7 8 14 28 56 에서 8도 나오도록 하자!!!!
	public static void print() { //21억이므로 int범위 안
        int nn=(int)Math.sqrt(N); //루트n(내린것)
        if(N%nn==0 && Math.sqrt(N) == nn) { //중간이 제곱근으로 1개 일 때!!
        	sb.append(' ').append(nn).append(' ');
	        for(int i=nn-1; i>1; i--) {
	            if(N%i==0) {
	                sb.insert(0, i).insert(0, ' ');
	                sb.append(N/i).append(' ');
	            }
	        }
        }
        else { //중간이 제곱근이 아닐 때!
        	sb.append(' ');
	        for(int i=nn; i>1; i--) {
	            if(N%i==0) {
	                sb.insert(0, i).insert(0, ' ');
	                sb.append(N/i).append(' ');
	            }
	        }
        }
        sb.insert(0, 1);
        sb.append(N);
        
        System.out.print(sb);
    }
	
}
