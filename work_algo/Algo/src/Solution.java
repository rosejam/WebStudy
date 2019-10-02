import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static void main(String[] args) {
/*        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = in.nextInt(); //1~2*10^6
        }*/
		
		//int[] a = {3,2,1};
		int[] a = {10,4,6,7,2,9,3,1,8,5};
		int n = a.length;
		
        // Write Your Code Here //ascending(오름차순) bubble sort
        int numSwaps = 0;
        for (int i = 0; i < n; i++) {
            // Track number of elements swapped during a single array traversal(=순회)
            int numberOfSwaps = 0;
        	//numSwaps = 0;
            for (int j = 0; j < n - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    //swap(a[j], a[j + 1]); //이렇게 스왑하면 배열의 값이 바뀌지 않는다...
                	int T = a[j]; a[j] = a[j+1]; a[j+1] = T;
                    numberOfSwaps++;
                    numSwaps++;
                    System.out.println(Arrays.toString(a));
                    System.out.println(numberOfSwaps);
                }
            }
            // If no elements were swapped during a traversal, array is sorted
            if (numberOfSwaps == 0) {
            //if (numSwaps == 0) {
                break;
            }
        }
        System.out.println();//
        System.out.println(Arrays.toString(a));//
        System.out.println("Array is sorted in "+numSwaps+" swaps.");
        System.out.println("First Element: "+a[0]);
        System.out.print("Last Element: "+a[n-1]);
    }
	
//	private static void swap(int i, int j) { 
//		int T = i; i = j; j = T;
//	}
	
}

