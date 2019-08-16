package burtegreedy;

import java.util.Arrays;
import java.util.Scanner;


public class Perm { //nPn을 구할때 종소리 패턴 스왑을 이용해서 구하는 방법!
	public static int n, cnt, d[]={1,2,3,4};
	
	public static void swap(int i, int j) {
		if(i==j) return;
		int T=d[i]; d[i]=d[j]; d[j]=T;
	}
	public static void perm(int count) { //count는 레벨(깊이)를 의미한다.
		if(count == n){ //가장 깊은 레벨에 도달하면 return
			cnt++; //그냥 가지의 개수를 세는 용도
			System.out.println(Arrays.toString(d)); //원본 d자체를 바꾼것을 출력 //하고싶은 작업의 위치
			return;
		}
		for(int i=count; i<n; i++) { 
				swap(count,i);
				perm(count+1);
				swap(count,i); //끝나고 나면 원위치
		}
	} 
	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		n = d.length; //sc.nextInt();
		perm(0); //조합에 이용하기 위해 start 0도 받는다.
		System.out.println(cnt); //
		//sc.close();
	}
}
