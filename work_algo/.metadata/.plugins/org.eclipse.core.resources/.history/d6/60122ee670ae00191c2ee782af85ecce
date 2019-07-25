package array1;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch1_재귀_서울9반_김동주 { //우선 오름차순으로 소팅 필요
	
	public static int key = 3;
	
	public static int binarySearch(int[] a, int low, int high, int key) { //찾는 부분의 배열, 찾는 
		if (low > high) {
			return -1; //검색 실패
		}
		int middle = (low+high)/2;
		if ( key == a[middle]) {
			return middle; 
		}else if (key < a[middle]) {
			return binarySearch(a, low, middle -1, key);
		}else if (key > a[middle]) {
			return binarySearch(a, middle +1, high, key);
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int [] a = {10,4,6,7,2,9,3,1,8,5};
		int key_index;
		Arrays.sort(a);
		key_index = binarySearch(a, 0, a.length, key);
		if (key_index >0 && a[key_index]==key) {
			System.out.println("성공!");
		}
		
	}

}