package 문제풀이5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//dfs의 백트랙킹 //다익스트라 //벨만포드
//가장 짧은 시간에 도착할 수 있는 시간&경로
public class Main_JO_2097_지하철_서울9반_김동주_dfs_ { //다익스트라로도 해보자
	public static int M,N,S[][],min,minway[];
	public static boolean v[];
	//public static ArrayList<Integer> way;
	public static String way;
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_JO_2577.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); //지하철역 수 1~N 0~N-1
        M = Integer.parseInt(st.nextToken())-1; //목적지 번호
        //숙소는 0에 있음
        
        S = new int[N][N];
        v = new boolean[N];
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<N; j++) { //i=j면 0
        		S[i][j] = Integer.parseInt(st.nextToken()); //i에서 j로 가는데 걸리는 시간(양수)
        	}
        	//System.out.println(Arrays.toString(S[i]));
        }
        //입력
        
        min = Integer.MAX_VALUE;
        //way = new ArrayList<>();
        v[0] = true;
        dfs(0,0,"1");
        
        
        //출력
/*        StringBuilder sb = new StringBuilder();
        sb.append(min).append('\n');
        for(int i=0; i<minway.length; i++) {
        	sb.append(' ').append(minway[i]+1);
        }
        System.out.print(sb);*/
        System.out.println(min);
        System.out.print(way);
	}
	
	private static void dfs(int i, int time, String path) {
		if(time >= min) return; //백트래킹! (중간에 min보다 커진 경우 제외)
		if(i==M) {
			//min = (min<time)? min: time;
			if(min>time ) {
				min = time;
				way = path;
			}
//			minway = new int[way.size()];
//			for(int k=0; k<way.size(); k++) {
//				minway[k] = way.get(k);
//			}
			return;
		}
		
		for(int j=0;j<N;j++) {
			if(i!=j && !v[j]) {
				v[j] = true;
				//way.add(j);
				dfs(j, time + S[i][j], (path+" "+(j+1)));
				v[j] = false;
				//way.remove(Integer.valueOf(j));//인덱스 삭제가 아닌 객체 삭제를 위해 wrap
			}
		}
	}

}
