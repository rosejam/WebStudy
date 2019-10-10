import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

	/*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
    	int h1 = s.charAt(0)-'0';
    	int h2 = s.charAt(1)-'0';
    	String rest = s.substring(2,8); //2~7
    	char ap= s.charAt(8);
    	//System.out.println(ap);
    	if(ap=='A') { //Midnight is 12:00:00AM on a 12-hour clock, and 00:00:00 on a 24-hour clock.
    		if(h1 != 1 || h2 != 2) return s.substring(0,8); //12시 대가 아닌경우
    		else return "00" + rest;
    	}else { //Noon is 12:00:00PM on a 12-hour clock, and 12:00:00 on a 24-hour clock.
    		if(h1 != 1 || h2 != 2 ) return String.valueOf(h1*10 + h2 + 12) + rest; //12시 대가 아닌경우
    		else return "12" + rest;
    	}
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        //bw.newLine();

        bw.close();
    }
}
