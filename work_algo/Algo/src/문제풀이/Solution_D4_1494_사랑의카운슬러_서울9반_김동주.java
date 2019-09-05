package 문제풀이;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_1494_사랑의카운슬러_서울9반_김동주 {
	public static int TC, N, M;
	public static boolean[] v;//half;
	//public static int[] half;
	public static long Ans, X, Y;
	//public static ArrayList<Point> list;
	public static int[][] list; //[0]이 x, [1]이 y //어레이리스트말고 배열

/*	public static void combination(int start, int flag, int count) {
		if(count == M){ //중복처리 부분은 비트연산으로 대신함
			//nCm이 만들어짐 half[M]에
			boolean[] visited = new boolean[N];
			X=0; Y=0;
			//이 두줄이 여기 꼭 있어야함 !!!! Size를 각 조합마다 처음 부터 구하는 것이기 때문!
			
			for(int m=0; m<M; m++) {
				X -= list[half[m]][0];
				Y -= list[half[m]][1];
				visited[half[m]] = true;
			}
			for(int m=M-1; m>=0; m--) {
				list.remove(half[m]);
			} //리스트에서 빼면 안됨!!! visited 배열 대신 쓰기!
			
			for(int m=0; m<N; m++) {
				if(!visited[m]) { //나머지 반은 더하기
					X += list[m][0];
					Y += list[m][1];
				}
			}
			long Size = X*X+Y*Y;
			if(Size<Ans) Ans = Size; //size의 최소를 계속 갱신
			return;
		}
		for(int i=start; i<N; i++) { //조합은 1이 아닌 start부터 시작
			if((flag&(1<<i))==0) {
				half[count]=i;
				combination(i, flag|(1<<i), count+1); //i 추가
			}
		}
	}*/
	
	//permcomb에서 0~N루프 한번만 돌리면서 if(!visit[n])면 빼고 else면 더하면 더 빨라질 것이다! (visit배열을 활용)
	public static void permcomb(int start, int count) { //count는 레벨(깊이)를 의미한다.
		if(count == M){ //가장 깊은 레벨(r개-뽑는개수)에 도달하면 return
			//nCm이 만들어짐 half[M]에
			X=0; Y=0; //매 조합마다 더하는 x,y좌표 합 초기화 필수!!!!

			for(int m=0; m<N; m++) {
				if(!v[m]) { 
					X -= list[m][0];
					Y -= list[m][1];
				}else { //나머지 반은 더하기
					X += list[m][0];
					Y += list[m][1];
				}
			}
			long Size = X*X+Y*Y;
			if(Size<Ans) Ans = Size; //size의 최소를 계속 갱신
			return;
		}
		////////////////
		for(int i=start; i<N; i++) { ////start부터 조합. 0부터는 순열!!!!
			if(!v[i]) { //방문안했을 경우
				v[i]=true; //방문처리
				//a[count]=d[i];        ////
				permcomb(i, count+1); ////이 두줄은 항상 유지(중복O/중복X)
				v[i]=false; //방문후 방문해제
			}//v확인 및 사용은 중복되지 않도록 하는 부분!!!!(인덱스가 같은것을 중복되지 않도록)
		}
		////////////////
	} 
	public static void main(String[] args) throws Exception {
			//전체를 반으로 나눔 N_C_(N/2)가지, 한쪽은 x,y모두 -해서 더한다.
		
		System.setIn(new FileInputStream("res/input_D4_1494.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			N = Integer.parseInt(br.readLine());
			M = N/2;
			//list = new ArrayList<>();
			list = new int[N][2];
			for(int n=0; n<N; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				list[n][0] = Integer.parseInt(st.nextToken());
				list[n][1] = Integer.parseInt(st.nextToken());
			}//point N개 모두 받음
			
			Ans = Long.MAX_VALUE;
			
			//half = new int[M]; //반을 뽑은 인덱스들(nCm 조합)의 자리
			v = new boolean[N];
			
			//combination(0,0,0);
			permcomb(0,0);
			sb.append("#"+tc+" "+Ans+"\n"); //벡터합 크기의 최소값
		}
		System.out.println(sb);
	}
}
