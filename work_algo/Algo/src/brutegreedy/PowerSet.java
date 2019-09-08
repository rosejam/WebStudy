package brutegreedy;

import java.util.Arrays;

//부분 집합은 0과 1에서 중복순열을 구하는 것. //(Binary Counting)
//중복순열 2PIr = 2^r

public class PowerSet {
	public static int r, cnt,v[], d[]={1,2,3,4};
	
	public static void powerset(int count) { //count는 레벨(깊이)를 의미한다.
		if(count == r){ //가장 깊은 레벨에 도달하면 return
			cnt++; //그냥 가지의 개수를 세는 용도
			System.out.println(Arrays.toString(v)+" "); //파워셋
/*			for(int i=0; i<r; i++) {
				if(v[i]==1) System.out.print(d[i]+" ");
			}
			System.out.println();*/
			return;
		}
		////////////////
		v[count]=0;
		powerset(count+1);
		v[count]=1;
		powerset(count+1);
		////////////////
	}
	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		r = d.length; //4
		v = new int[r];
		powerset(0); //조합에 이용하기 위해 start 0도 받는다.
		System.out.println(cnt); //
		//sc.close();
	}
}
