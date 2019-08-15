package 보충;
/*for문 i 변수 관리
배열의 index 관리
API 사용
문자열(내부적으로는 1차원 배열-나온적은 없음)*/

public class IM소검시험범위 {

	public static void main(String[] args) {
		//1. arr배열에 key값이 존재하는가? 있음/없음
		int[] arr = {4,6,2,1,5,3};
		//int key = 1;
		int key = 10;
		boolean check=false;
		for(int a: arr) {
			if(key==a) {
				check = true;
				break;
			}
		}
/*		if(check==false) System.out.println("없음");
		else System.out.println("있음");*/
		System.out.println(check?"있음":"없음"); //위두줄을 한줄로
		//
		int i; //i를 꺼내서 중간에 break되었는지 여부를 확인할수도 있긴함 
		for(i=0; i< arr.length; i++) {
			if(arr[i]==key) {
				break;
			}
		}
		System.out.println(i == arr.length?"없음":"있음");

	}

}
