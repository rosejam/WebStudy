package array2;
//외우기!
//(Binary Counting)
public class _SubSet2__ { 
	public static int[] a = {1,2,3,4}; 
	public static void main(String[] args) {
		int n = a.length;
		for(int i=0; i<(1<<n); i++) {//i는 0~15까지 4자리 2진수(들어가는지 안들어가는지 모든 경우의 Subset 표현되었음)
											//2진수 활용
			//System.out.println("i=" +i+" "+ Integer.toBinaryString(i));
			int sum =0;
			for(int j=0; j<n; j++) {
				if((i&(1<<j)) > 0) { //비트연산!! 으로 i의 어떤 자리가 1인지를 확인하는 코드(i의 j번째 비트가 1인지)
					System.out.print(a[j]+" "); //SubSet 원소
					sum = sum + a[j];
				}
			}
			System.out.println(" sum="+sum); //부분집합의 합을 구하기 위한 sum
		}
	}
}
