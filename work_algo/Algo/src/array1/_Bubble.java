package array1;

import java.util.Arrays;

public class _Bubble {

	public static void main(String[] args) { //메서드에 더블클릭후 F3하면 소스코드를 볼수 있다
		//컨트롤+D하면 한줄삭제
		int[] a = {10,4,6,7,2,9,3,1,8,5};
		//System.out.println(Arrays.toString(a)); //루프문돌리지않고 배열을 출력할때 사용!
		//Arrays.sort(a);
		////또는 아래의 <버블소트>!
		for(int i=a.length-1; i>0; i--) { //i=0은 빼도 될거같으니 없앰
			//System.out.println("i="+i);
			for(int j=0; j<i; j++) {
				if(a[j]>a[j+1]) {
					int T=a[j];a[j]=a[j+1];a[j+1]=T; //값바꿈
				}//i에 제일 큰값을 하나씩 고정
				System.out.println(Arrays.toString(a)+" i="+i+" j="+j);
			}
			//System.out.println(Arrays.toString(a)+" i=" + i);
		}
		System.out.println(Arrays.toString(a)); //알트키+아래화살표 하면 줄이 아래로 "이동"
	}
}

