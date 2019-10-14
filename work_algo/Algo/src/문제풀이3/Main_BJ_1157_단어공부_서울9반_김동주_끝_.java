package 문제풀이3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_1157_단어공부_서울9반_김동주_끝_ { //가장 많이 사용된 알파벳을 대문자로 출력 //여러 개 존재하는 경우에는 "?"

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_BJ_1157.txt"));
		int[] alphabet = new int[26];
		int max = -1; int index = 0; boolean same = false;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().toUpperCase();
        for(int s=0; s<line.length(); s++) {
        	alphabet[line.charAt(s)-'A']++;
        }
        for(int i=0; i<26; i++) {
        	if(max < alphabet[i]) {
        		max = alphabet[i];
        		index = i;
        		same = false;
        	}else if(max == alphabet[i]) {
        		same = true;
        	}
        }
        if(same) System.out.print("?");
        else System.out.print((char)(index+'A'));
	}

}
