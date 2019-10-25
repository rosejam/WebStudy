

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Algo4_서울_9반_김동주 { //Count
	//public static int index;
	public static boolean flag;
	public static void main(String[] args) throws Exception {
		//String word = "";
		System.setIn(new FileInputStream("res/input4.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " "); 
			
			
			
			//String[] ws = book.toLowerCase().split(" ");//띄어쓰기 기준으로 나누어 배열에 저장
			
			//int N = sents.length;
			//String[] ws = new String[N];
			
			//int[] count = new int[1000];//
			//String[] string = new String[1000];
			
			//String[] ws = new String[1000];//
			ArrayList<String> ws = new ArrayList<>();
			//n=0;
			
			while(st.hasMoreTokens()) {
				ws.add(st.nextToken().toLowerCase());  //ws에 저장
	/*			flag = false;
				for(int j=0; j<n; j++) {
					if(ws[n].equals(ws[j])) { //이전에 나온것과 일치하는게 있다면
						flag = true;
						count[index]++;
					}
				}
				if(!flag) { //이전에 나온것과 일치하는게 없다면
					index++;
					string[index] = ws[n];
				}*/
				//n++;
			}
			
			//index = -1;
			int[] count = new int[ws.size()];//string의 빈도 체크
			//ArrayList<Integer> count = new ArrayList<>();
			//String[] string = new String[ws.size()];
			ArrayList<String> string = new ArrayList<>();
			//string.add(ws.get(0));
			for(int i=0; i<ws.size(); i++) {
				flag = false;
				for(int j=0; j<string.size(); j++) {
					if(ws.get(i).equals(string.get(j))) { //이전에 나온것과 일치하는게 있다면
						flag = true;
						count[j]++;
						//count.get(index)
						break;
					}
				}
				if(!flag) { //이전에 나온것과 일치하는게 없다면(처음)
					//index++;
					string.add(ws.get(i));
				}
			}
	/*		for(int i=0; i<ws.length; i++) {
				for(int j=i+1; j<ws.length; j++) {
					if(ws[i].equals(ws[j])) {
						
					}
				}
			}*/
			int max = 0;
			for(int i=0; i<ws.size(); i++) {
				if(count[i]>count[max]) max = i; //가장 큰 인덱스 구함
			}
			//int[] intst = new int[ws.size()];
			//ArrayList<Integer> mxs = new ArrayList<>();
			ArrayList<String> mxs2 = new ArrayList<>();
			for(int i=0; i<ws.size(); i++) {
				if(count[i]==count[max]) {
					//mxs.add(string[i].toCharArray()); //가장 큰 인덱스 구함
	/*				for(int j=0;j<string[i].length(); j++) {
						//string[i].charAt(j)-'a';
					}*/
					mxs2.add(string.get(i));
				}
			}
			
			//Collections.sort(mxs);
			//Arrays.sort(mxs);
	/*		Collections.sort(mxs, new Comparator<char[]>() {
	
				@Override
				public int compare(char[] o1, char[] o2) {
					return Integer.compare(o1-'a', o2-'a');
				}
				
			});*/
	/*		Collections.sort(mxs2, new Comparator<String>() {
	
				@Override
				public int compare(String o1, String o2) {
					return Character.compare(o1.charAt(0), o2.charAt(0));
				}
			});*/
			Collections.sort(mxs2);
			//System.out.println(mxs2.size());
			//for(int i=0; i<mxs2.size(); i++) System.out.println(mxs2.get(i));
			sb.append(mxs2.get(0)).append("\n");//return mxs2.get(0);
			//return string[1];
			
			
			
			////예시답안
/*			TreeMap<String, Integer> map = new TreeMap<>(); //정렬까지 한번에
			while(st.hasMoreTokens()) {
				String word = st.nextToken().toLowerCase();
				if(map.containsKey(word)) {
					map.put(word, map.get(word)+1);
				}else {
					map.put(word, 1);
				}
			}
			int maxx = 0;
			String ans = "";
			for(String key:map.keySet()) {
				if(maxx < map.get(key)) {
					maxx = map.get(key);
					ans = key;
				}
			}
			sb.append(ans).append("\n");*/
			//
			
		}
		System.out.println(sb);
	}

/*	public static void main(String[] args) {
		String book1 ="Can Danny and his father outsmart the villainous Mr. Hazell? Danny has a life any boy would love - his home is a gypsy caravan, he's the youngest master car mechanic around, and his best friend is his dad, who never runs out of wonderful stories to tell. But one night Danny discovers a shocking secret that his father has kept hidden for years. "; 
		String book2 ="Soon Danny finds himself the mastermind behind the most incredible plot ever attempted against nasty Victor Hazell, a wealthy landowner with a bad attitude. Can they pull it off? If so, Danny will truly be the champion of the world.";
		String book3 ="I like cat. I like cat. I like cat. ";
		Algo4_서울_9반_김동주 c = new Algo4_서울_9반_김동주();
		System.out.println(c.execute(book1));
		System.out.println(c.execute(book2));
		System.out.println(c.execute(book3));
		System.out.println(c.execute("cc aa aa bb bb cc"));

	}*/

}
