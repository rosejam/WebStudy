import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the birthdayCakeCandles function below.
    static int birthdayCakeCandles(int[] ar) {
    	int cnt = 0;
     	int max = 0;
/*  	for(int i=0; i<ar.length; i++) {
    		if(max < ar[i]) max = ar[i];
    	}//불 수 있는 가장 큰 촛불
    	for(int i=0; i<ar.length; i++) {
    		if(max == ar[i]) cnt++;
    	}*/
    	for(int i=0; i<ar.length; i++) {
    		if(max < ar[i]) {
    			max = ar[i];
    			cnt = 1;
    		}else if(max == ar[i]) {
    			cnt++;
    		}
    	}
    	return cnt; //the number of candles that can be blown out
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[arCount];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arCount; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = birthdayCakeCandles(ar);

        bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
