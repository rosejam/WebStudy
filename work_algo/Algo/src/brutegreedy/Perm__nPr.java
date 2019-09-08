package brutegreedy;

//DFS
public class Perm__nPr { //nPn을 구할때 종소리 패턴 스왑을 이용해서 구하는 방법!
	public static int n, cnt, arr[]={1,2,3,4};
	public static int result;
	
	public static void swap(int i, int j) {
		if(i==j) return;
		int T=arr[i]; arr[i]=arr[j]; arr[j]=T;
	}
	public static void perm(int r, int k) { //count는 레벨(깊이)를 의미한다!! //(int cur, int count)
		if(r == k){ //가장 깊은 레벨에 도달하면 return
			cnt++; //그냥 가지의 개수를 세는 용도
			for(int i=0; i<r; i++) {
				System.out.print(arr[i]+" "); //원본 d자체를 바꾼것을 출력 //하고싶은 작업의 위치
			}
			System.out.println();
			//result = Math.max(result, Integer.parseInt(String.valueOf(d))); //!!!!캐릭터 배열>문자열>정수형 숫자 //최대상금문제
			return;
		}
		//swap을 시키므로 i=count부터 한다.
		for(int i=k; i<arr.length; i++) {  //for(i=cur; i<d.length; i++)
										//for(j=i+1; j<d.length; j++)
												//if(d[i]<=d[j]) //최대상금문제에서 백트랙킹용
				swap(k,i);	//swap(i,j) //visit = true
				perm(r, k+1);	//(i,count+1)
				swap(k,i); //끝나고 나면 원위치 //swap(i,j) //visit = false
		}
	}
	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		n = arr.length; //sc.nextInt();
		int r=3;
		perm(r,0); //조합에 이용하기 위해 start 0도 받는다.
		//result =0; perm(0,0);
		System.out.println(n+"P"+r+"경우의수"+cnt); //
		//sc.close();
	}
}
