package array2;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class _BinarySearch1_반복_서울9반_김동주 { //우선 오름차순으로 소팅 필요!!!
	
	//public static int key = 3;
	public static int [] a = {2,4,7,11,19,23};
	
	public static int binarySearch(int key) { //int[] a, 
		int start = 0 , middle =0;
		int end = a.length -1;
		while(start <= end) {
			middle = (start  + end)/2; //중간값 인덱스 middle (짝수개면 왼쪽거선택, 정수/정수 = 정수)
			if(a[middle] == key) {
				return middle; 
			}else if ( a[middle] > key) {
				end = middle -1; //왼쪽에서 더 찾기
			}else start = middle +1;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int key = sc.nextInt();
		int key_index;
		//Arrays.sort(a);
		//System.out.println(Arrays.binarySearch(a,key)); 이건 원래있는 거
		key_index = binarySearch(key); //인덱스를 찾는다.
		if (key_index >=0 & a[key_index]==key) {
			System.out.println("성공!");
		}
		
	}

}