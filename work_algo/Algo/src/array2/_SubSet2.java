package array2;
//외우기!
public class _SubSet2 { 
	public static int[] a = {1,2,3,4}; 
	public static void main(String[] args) {
		for(int i=0; i<(1<<a.length); i++) {//i는 0~15까지 4자리 2진수(들어가는지 안들어가는지 모든 경우 표현)
			//System.out.println("i=" +i+" "+ Integer.toBinaryString(i));
			int sum =0;
			for(int j=0; j<a.length; j++) {
				if((i&(1<<j))>0) { //비트연산으로 어떤 자리가 1인지를 확인하는 코드
					System.out.print(a[j]+" "); //SubSet 원소
					sum = sum + a[j];
				}
			}
			System.out.println(" sum="+sum);
		}
	}
}
