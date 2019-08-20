package array2;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class _BinarySearch2_재귀_서울9반_김동주 { //우선 오름차순으로 소팅 필요
	
	//public static int key = 3;
	public static int [] a = {2,4,7,11,19,23};
	
	public static int binarySearch(int low, int high, int key) { //int[] a는 밖에 놓았으므로 생략.
		if (low > high) {
			return -1; //검색 실패
		}
		int middle = (low+high)/2;
		if ( key == a[middle]) {
			return middle; 
		}else if (key < a[middle]) {
			return binarySearch(low, middle -1, key);
		}else {
			return binarySearch(middle +1, high, key);
		}
		//return -1; //이부분작성했는데 else if (key > a[middle]) 대신 else쓰면 필요x
	}
	
	public static void main(String[] args) {
		//int [] a = {10,4,6,7,2,9,3,1,8,5};
		Scanner sc = new Scanner(System.in);
		int key = sc.nextInt();
		int key_index;
		//Arrays.sort(a);
		key_index = binarySearch(0, a.length-1, key); //-1해야함 
		if (key_index >=0 && a[key_index]==key) {
			System.out.println("성공!");
		}
		
	}

}