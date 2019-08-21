package stack2;
//외우기!
import java.util.Arrays;
import java.util.Scanner;

//중복순열 nPIr =n^r,  5PI3 :125
//순열 nPr =n*(n-1)*...*(n-r),  5P3 :60
//중복조합 nHr =n+r-1Cr,  5H3 = 5+3-1C3 = 7C3 = 7P3/3! :35
//조합 nCr =nPr/r!,  5C3 = 5P3/3! = 5*4*3/3*2*1 :10
//자리순서가 바뀌었을 때 의미가 달라지면 순열, 아니면 조합

public class PermComb__ {
	public static int n, r, cnt, a[], v[], d[]={1,2,3,4,5};
	
	public static void permcomb(int start, int count) { //count는 레벨(깊이)를 의미한다.
		if(count == r){ //가장 깊은 레벨(r개-뽑는개수)에 도달하면 return
			cnt++; //그냥 가지의 개수를 세는 용도
			System.out.println(Arrays.toString(a));
			return;
		}
		////////////////
		for(int i=0; i<n; i++) { ////start부터 조합. 0부터는 순열!!!!
			if(v[i]==0) { //방문안했을 경우
				v[i]=1; //방문처리
				a[count]=d[i];        ////
				permcomb(i, count+1); ////이 두줄은 항상 유지(중복O/중복X)
				v[i]=0; //방문후 방문해제
			}//v확인 및 사용은 중복되지 않도록 하는 부분!!!!(인덱스가 같은것을 중복되지 않도록)
		}
		////////////////
	} 
	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		n = 5; //sc.nextInt();
		r = 3; //sc.nextInt();
		v = new int[n];
		a = new int[r]; //데이터를 담으려함
		permcomb(0, 0); //조합에 이용하기 위해 start 0도 받는다.
		System.out.println(cnt); //
		//sc.close();
	}
}
