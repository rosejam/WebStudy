package 보충3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//내구도는 상대계란의 무게만큼 깎임
public class Main_BJ_16987_계란으로계란치기_서울9반_김동주_끝_ {
	static class Egg{
		int s; //내구도
		int w; //무게
		public Egg(int s, int w) {
			this.s = s; //0이하가 되면 깨짐
			this.w = w;
		}
	}
	public static int N,max;
	public static Egg[] eggs;
	//public static ArrayList<Egg> eggs;
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_JO_1113.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		eggs = new Egg[N];
		//eggs = new ArrayList<>();
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			eggs[n] = new Egg(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}//입력
		//process
		max = Integer.MIN_VALUE;
		dfs(0);
		//최대 깰수있는 개수 출력
		System.out.print(max);
	}
	private static void dfs(int n) {
		
		if(n==N) {
			int cnt = 0;
			for(int m=0; m<N; m++) {
				if(eggs[m].s <= 0) cnt++;
			}
			max = (max>cnt)? max:cnt;
			return;
		}
		
		if(eggs[n].s <=0) { //손에 든계란이 깨진 경우
			dfs(n+1);
		}else {
			boolean flag = false;
			for(int nn=0; nn<N; nn++) { //다른 계란치기
				if(nn!=n && eggs[nn].s > 0) {
					flag = true;
					eggs[nn].s -= eggs[n].w;
					eggs[n].s -= eggs[nn].w;
					dfs(n+1);
					eggs[nn].s += eggs[n].w;
					eggs[n].s += eggs[nn].w;
				}
			}
			if(!flag) { //다깨져있는 경우
				dfs(n+1); //return 0;로 백트래킹해야지
			}
		}
		
	}

}