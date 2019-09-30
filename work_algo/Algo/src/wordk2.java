import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
class Main {
	public static int N;
	public static ArrayList<Integer> de;
	public static HashMap<Integer,Integer> q;
	public static boolean flag,ans;
	public static String[] S;
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_D4_4366.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        q = new HashMap<>();
        de = new ArrayList<>();
        //S = new String[N]; 
        //int index = 0;
        for(int n=0; n<N; n++) {
        	String line = br.readLine();
        	if(line.startsWith("e",0)) { //enq
        		int en = Integer.parseInt(line.split(" ")[1]); //숫자
        		enq(en);
        	}else { //deq
        		de.add(deq());
        	}
        }
        for(int i=0 ;i<de.size()-1; i++) {
        	sb.append(de.get(i)).append(" ");
        }
        sb.append(de.get(de.size()-1));
        System.out.print(sb);
	}
	private static int deq() {
		
		if(q.isEmpty()) return -1;
		else {
			int max =0;
			for(Entry<Integer, Integer> entry : q.entrySet()){
				if(entry.getValue() > max) N = entry.getKey();
			}
			return N;
		}
	}
	private static void enq(int en) {
		int count = q.containsKey(en) ? q.get(en) : 0; //출처 https://codeday.me/ko/qa/20190306/3807.html
		q.put(en, count + 1);
	}
	
}