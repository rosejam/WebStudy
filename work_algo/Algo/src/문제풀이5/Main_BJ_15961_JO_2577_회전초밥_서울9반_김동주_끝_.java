package 문제풀이5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//특정한 위치부터 k개의 접시를 연속해서 먹기
//1번 행사에 참가할 경우 쿠폰 초밥 하나도 가짓수에 추가!(중복안되도록 먹는것 좋음)
// (없을 경우 새로 만들어 제공)
//가능한 많은 가짓수의 초밥
public class Main_BJ_15961_JO_2577_회전초밥_서울9반_김동주_끝_ {
	public static int N,d,k,c,plate[],max,cnt;//,min;
	//public static HashMap<Integer, Integer> map;
	public static int eat[];
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_JO_2577.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());//회전접시수 3,000,000
        d = Integer.parseInt(st.nextToken());//초밥가짓수 1이상 d이하의 초밥종류 3000
        k = Integer.parseInt(st.nextToken());//연속먹는수 3000
        c = Integer.parseInt(st.nextToken());//쿠폰번호
        
        plate = new int[N]; //인덱스는 mod N으로 접근?
        for(int n=0;n<N;n++) {
        	plate[n] = Integer.parseInt(br.readLine()); //1이상 d이하
        }
        //
        
        max = Integer.MIN_VALUE;
/*        min = Integer.MAX_VALUE;
        
here:	for(int n=0;n<N;n++) { //먹기 시작하는 모든 경우
        	eat = new boolean[d+1];
        	eat[c] = true;
        	int cnt = 1; //가짓수
        	int vcnt = 0; //중복횟수카운트
        	
        	for(int kk=0;kk<k;kk++) { //먹기
        		if(!eat[plate[(n+kk)%N]] ) {
        			eat[plate[(n+kk)%N]] = true;
        			cnt++;
        		}else { //중복
        			vcnt++;
        			if(vcnt > min) continue here;
        		}
        	}
        	if(cnt > max) {
        		max = cnt;
        		min = vcnt;
        	}
        	
        }*/
        
        //1.맵사용
/*        map = new HashMap<>();
        map.put(c, 1); //스시종류, 먹은 횟수
        
        //먼저 한 텀 넣어놓기
        for(int n=0; n<k; n++) {
        	if(map.containsKey(plate[n])) { //있으면 1추가
        		map.put(plate[n], map.get(plate[n]) + 1);
        	}else { //없으면 1로 넣기
        		map.put(plate[n], 1);
        	}
        }
        max = map.size();
        
        for(int n=0;n<N;n++) { //먹기 시작하는 모든 경우
        	//새로 들어가는 1개
        	if(map.containsKey(plate[(n+k)%N])) { //있으면 1추가
        		map.put(plate[(n+k)%N], map.get(plate[(n+k)%N]) + 1);
        	}else { //없으면 1로 넣기
        		map.put(plate[(n+k)%N], 1);
        	}
        	//새로 빠지는 1개
        	if(map.get(plate[n]) > 1) { //하나빼거나
        		map.put(plate[n], map.get(plate[n]) - 1);
        	}else { //1개 들어있는 경우
        		map.remove(plate[n]);
        	}
        	//
        	if(map.size() > max) max = map.size();
        }*/
        
        //2.int 배열사용
        cnt = 1;
        eat = new int[d+1];
        eat[c] = 1;
        
        //먼저 한 텀 넣어놓기
        for(int n=0; n<k; n++) {
        	if(eat[plate[n]] == 0) {
        		cnt++;
        	}
        	eat[plate[n]]++;
        }
        max = cnt;
        
        for(int n=0;n<N;n++) { //먹기 시작하는 모든 경우
        	int count = cnt;
        	//새로 들어가는 1개
        	if(eat[plate[(n+k)%N]] == 0) { //mod안하고 N뒤에 k만큼복사해서 이어붙여도 된다.
        		count++;
        	}
        	eat[plate[(n+k)%N]]++;
        	//새로 빠지는 1개
        	if(eat[plate[n]] == 1) {
        		count--;
        	}
        	if(eat[plate[n]] > 0) {
        		eat[plate[n]]--;
        	}
        	cnt = count;
        	//
        	if(cnt > max) max = cnt;
        }
        
        System.out.print(max);
	}

}
