package 문제풀이;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JO_1828_냉장고_서울9반_김동주_끝_ {
/*	public static class Chem{
		int low,high;
		public Chem(int low, int high) {
			this.low = low;
			this.high = high;
		}
	}*/
	public static int css,N, minhigh, maxlow, Ans;
	public static int[] low,high;
	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input_JO_1828.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		css= N;
		//ArrayList<Chem> cs = new ArrayList<>();
		//Chem[] cs = new Chem[N];
		low = new int[N];
		high = new int[N];
		minhigh = Integer.MAX_VALUE;
		maxlow = Integer.MIN_VALUE;
		for(int n=0; n<N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
/*			cs.add(new Chem(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
			if(maxlow < cs.get(n).low) maxlow = cs.get(n).low; 
			if(minhigh > cs.get(n).high) minhigh = cs.get(n).high;*/
			//cs[n] = new Chem();
/*			cs[n].low = Integer.parseInt(st.nextToken());
			cs[n].high = Integer.parseInt(st.nextToken());
			if(maxlow < cs[n].low) maxlow = cs[n].low; 
			if(minhigh > cs[n].high) minhigh = cs[n].high;*/
			low[n] = Integer.parseInt(st.nextToken());
			high[n] = Integer.parseInt(st.nextToken());
			if(maxlow < low[n]) maxlow = low[n]; 
			if(minhigh > high[n]) minhigh = high[n];
		}
		Ans=0;
		if(minhigh >= maxlow) Ans++;
loop:	while(minhigh < maxlow) {
			Ans+=2;
/*			for(int n=0; n<cs.size();) {
				if(maxlow<=cs.get(n).high)
					cs.remove(n);
				else
					n++;
			}
			if(cs.size()==0) break;
			for(int n=0; n<cs.size();) {
				if(minhigh>=cs.get(n).low)
					cs.remove(n);
				else
					n++;
			}
			if(cs.size()==0) break;*/
			for(int n=0; n<N; n++) {
				if(maxlow<=high[n] || minhigh>=low[n]) {
					high[n] = Integer.MIN_VALUE;
					low[n] = Integer.MAX_VALUE;
					css--;
					if(css==0) break loop;
				}
			}//59 51
			//if(css==0) break;
			//if(css==0) break;
/*			for(Iterator<Chem> iter = cs.iterator() ; iter.hasNext() ; ) {
				Chem value = iter.next();
				if(maxlow<=value.high) {
					iter.remove();
				}
			}
			if(cs.size()==0) break;
			for(Iterator<Chem> iter = cs.iterator() ; iter.hasNext() ; ) {
				Chem value = iter.next();
				if(minhigh>=value.low) {
				    iter.remove();
				}
			}
			if(cs.size()==0) break;*/
			//냉장고 같이쓰는 애들 없애기(냉장고에 넣기)
			minhigh = Integer.MAX_VALUE;
			maxlow = Integer.MIN_VALUE; //없어진 애들이니 초기화를 시켜야지....
			for(int n=0; n<N; n++) {
				if(maxlow < low[n] && low[n] <= 10000) maxlow = low[n];
				if(minhigh > high[n] && high[n] >= -270) minhigh = high[n];
/*				
				if(minhigh == Integer.MAX_VALUE) minhigh = Integer.MIN_VALUE;
				if(maxlow == Integer.MIN_VALUE) maxlow = Integer.MAX_VALUE;*/
			}//조건 다시 설정
		}
		if(minhigh >= maxlow) Ans++;
		System.out.println(Ans);
	}
}
