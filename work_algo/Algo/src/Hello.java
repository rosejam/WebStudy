/*package array1;

public clast Hello {

	public static void main(String[] args) {
		System.out.println("Hello Algo^^");
		String h = "Hello";
		System.out.println(h.charAt(4));
		System.out.println("박찬호".length());
	}

}
*/


import java.io.FileInputStream;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
//메서드에 더블클릭후 F3하면 소스코드를 볼수 있다//컨트롤+D하면 한줄삭제//알트키+아래화살표 하면 줄이 아래로 "이동"
public class Hello {
	
	public static final int i1= 11;
	public        final int i2= 12;
	public static       int i3= 13;
	public              int i4= 14;
/*	public static double nCr(int n, int r) {
		if(r==0) return 1.0;
		return 1.0*n/r*nCr(n-1,r-1); //정수끼리 나누기 하지 않도록(double형으로 계속 계산되도록!)
	}*/
	public static double nCr(int n, int r) {
		if(n<r) return 0.0;
		if(r==0) return 1.0;
		return nCr(n-1,r-1)+nCr(n-1,r); //정수끼리 나누기 하지 않도록(double형으로 계속 계산되도록!)
	}
	
	public static void main(String args[]) throws Exception
	{
		char[] d = {'a','b','c','a'};
		System.out.println(String.valueOf(d)); //캐릭터배열을 스트링으로!!!!
		
		System.out.println(nCr(5,3)); 
		System.out.println();
		
		double db = 1.123456789;
		int tc = 1;
		System.out.println(db);
		System.out.printf("#%d %f\n",tc,db);
		System.out.printf("#%d %.3f\n",tc,db); //소수점 이하 3자리까지만(반올림)
		System.out.printf("#%d %.4f\n",tc,db); //소수점 이하 4자리까지만(반올림)
		
		/*System.out.println(Integer.toBinaryString(n)); //2진수표현
		String s ="10";
		System.out.println(Integer.parseInt(s,10)); */
/*		System.out.println("---------------");
		System.out.println(1<<0); //2의 0승 
		System.out.println(1<<1);
		System.out.println(1<<2);
		System.out.println(1<<3);
		System.out.println(1<<4);
		System.out.println(1<<5);
		System.out.println(1<<6);
		System.out.println(1<<7);
		System.out.println(1<<8);
		System.out.println(1<<9);
		System.out.println(1<<10);
		System.out.println(1<<11);
		System.out.println(1<<12);
		System.out.println(1<<13);
		System.out.println(1<<14);
		System.out.println(1<<15);
		System.out.println(1<<16);
		System.out.println(1<<17);
		System.out.println(1<<18);
		System.out.println(1<<19);
		System.out.println(1<<20);
		System.out.println(1<<21);
		System.out.println(1<<22);
		System.out.println(1<<23);
		System.out.println(1<<24);
		System.out.println(1<<25);
		System.out.println(1<<26);
		System.out.println(1<<27);
		System.out.println(1<<28);
		System.out.println(1<<29);
		System.out.println("---------------");
		System.out.println(128>>1);
		System.out.println(128>>2);
		System.out.println(128>>3);
		System.out.println(128>>4);
		System.out.println(128>>5);
		System.out.println(128>>6);
		System.out.println(128>>7);
		System.out.println(128>>8);
		System.out.println("---------------");
		System.out.println(-128>>1);
		System.out.println(-128>>2);
		System.out.println(-128>>3);
		System.out.println(-128>>4);
		System.out.println(-128>>5);
		System.out.println(-128>>6);
		System.out.println(-128>>7);
		System.out.println(-128>>8); //>>는 부호 유지, >>>는 부호를 없앤다 ...*/
		
/*		String s0 = "Hello";
		//s.replace('H', 'h'); //이렇게 하면 s가 바뀌지는 않음
		s0 = s0.replace("ll", "LL");
		
		System.out.println(s0.replace('H', 'h'));
		System.out.println(s0);
		
		String s1 = "He llo";
		String[] sa = s1.split(" ");
		System.out.println(Arrays.toString(sa));
		
		String s2 = "He llo ll";
		System.out.println(s2.contains("llo")); //스트링을 포함하는지
		
		//
		String st = "ABCDEFGHIJ"; 
		String t = "";

		System.out.println(st.substring(3)); //3~
		System.out.println(st.substring(0, 3)); //0~2
		System.out.println(st.substring(3, 6)); //3~5
		
		System.out.println(st.length()); //길이10
		int[] ii = {1,2,3};
		System.out.println(ii.length); //3
		//i.length=7; ->불가능 
		//참고:()가 있으면 메소드, 없으면 변수

		//reverse():역순 을 for문으로 
		for(int i=st.length()-1; i>=0; i--) {
			t=t+st.charAt(i);
			//System.out.println(s.charAt(i));
			System.out.println(t);
		}
		
		//스트링빌더 
		StringBuilder sb = new StringBuilder(st); //StringBuffer에서 바뀜
		sb.append("ABC").replace(0, 3, "XYZ");
		System.out.println(sb.reverse()); //reverse()
		String ss = sb.toString(); //s를 직접적으로 조작하지 않고 StringBuilder로 조작한 후 마지막에 다시 스트링으로 환원
		
		String st1 = "홍길동";
		String st2 = "홍길동";
		StringBuilder sb1 = new StringBuilder(st1);
		StringBuilder sb2 = new StringBuilder(st2);
		System.out.println(st1==st2); //String의 값 비교는 == 사용 가능 
		System.out.println(st1.equals(st2));
		System.out.println(sb1==sb2); //객체안의 값 비교는 ==이렇게 하면 안됨.
		System.out.println(sb1.equals(sb2)); //StringBuilder는 내부적으로 Buffer사용.이렇게 하면 안됨
		System.out.println(sb1.toString().equals(sb2.toString())); //이렇게 해야함.
		System.out.println();
	
		//진법 변환
		System.out.println(Integer.parseInt("101", 2)); //2진법->10진법
		System.out.println(Integer.parseInt("101", 8)); //8진법->10진법
		System.out.println(Integer.parseInt("101", 16)); //16진법->10진법
		System.out.println();
		System.out.println("0b"+Integer.toBinaryString(17)); //10진법->2진법
		System.out.println("0b"+Integer.toString(17, 2)); //10진법->2진법 //위와 동일
		System.out.println("0"+Integer.toOctalString(17)); //10진법->8진법
		System.out.println("0x"+Integer.toHexString(17)); //10진법->16진법
		System.out.println();
		//BigInteger
		long i = 11111111111L; //정수형 범위 밖이면 에러, long에 숫자에 L을 붙이고 대입
		String i0 = "11111111111111111111111111111"; //long범위 밖이면 BigInteger
		BigInteger i1 = new BigInteger(i0);
		BigInteger i2 = i1.add(BigInteger.valueOf(3));
		BigInteger i3 = i1.subtract(BigInteger.ONE);
		BigInteger i4 = i1.multiply(BigInteger.TEN);
		BigInteger i5 = i1.divide(BigInteger.valueOf(2));
		System.out.println(i2);
		System.out.println(i3);
		System.out.println(i4);
		System.out.println(i5);*/
	}
}