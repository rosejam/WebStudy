package array1;

import java.util.Arrays;

public class Array1Test {
	public static void main(String[] args) {
		//1.선언
		int[] a; //int a[];
		//2.생성
		a = new int[3];
		//1+2동시에
		int[] b = new int[3];
		
		//3.초기화
		b[0]=10;
		b[1]=11;
		b[2]=12;
		//오직 0,1,2만 사용 가능
		//b[3]=13; //java.lang.ArrayIndexOutOfBoundsException: 3
		//b[-1]=14; //java.lang.ArrayIndexOutOfBoundsException: -1
		
		//1+2+3
		int[] c = {10,11,12};
		int[] d = new int[] {10,11,12};
		
		//1, 2+3
		int[] e;
		//e = {10,11,12}; //2과정이 없으므로 ERR 
		e = new int[] {10,11,12}; //2+3과정
		
		//4.출력
		for(int i=0; i<e.length; i++) System.out.println(e[i] + " ");
		System.out.println();
		for(int v:e) System.out.println(v + " ");
		System.out.println();
		System.out.println(Arrays.toString(e));
		
		//5.복제
		int[] f= new int[e.length];
		System.arraycopy(e,0,f,0,e.length);
		f=Arrays.copyOf(e,  e.length);
		e[0]=0;
		System.out.println(Arrays.toString(e));
		System.out.println(Arrays.toString(f));//패스바이밸류?
		f = e.clone();
		e[0]=0;
		System.out.println(Arrays.toString(e));
		System.out.println(Arrays.toString(f));//패스바이 레퍼런스?
	}
}
