package 문제풀이3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_D5_7396_종구의딸이름짓기_서울9반_김동주 { //가능한 이름 중에서 사전 순으로 가장 앞선 것을 이름으로 택한다.//길이는 N+M-1로 고정됨
	public static class Way{
		int x;
		int y;
		String name;
		public Way(int x, int y, String name) {
			this.x = x;
			this.y = y;
			this.name = name;
		}
	}
	public static int TC,N,M;
	public static char[][] B;
	public static boolean[][] v;
	//public static int[] name;
	//public static ArrayList<String> names;
	public static int[] di = {0,1}; //우1 하2
	public static int[] dj = {1,0}; 
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_D5_7396.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        TC = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=TC; tc++) {
        	StringTokenizer nm = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(nm.nextToken());
        	M = Integer.parseInt(nm.nextToken());
        	B = new char[N][M];
        	v = new boolean[N][M];
        	for(int n=0; n<N; n++) {
        		String line = br.readLine();
        		for(int m=0; m<M; m++) {
        			B[n][m] = line.charAt(m); //소문자
        		}
        	}
        	//입력끝
        	//한 선택에서는 항상 사전순에서 앞선 선택, 같을 때는 둘다 가서 더 사전순으로 앞선 선택 ㄱ
        	//name = new int[N+M-1];
        	//names = new ArrayList<>();
        	//Collections.sort(names);
        	//name = names.get(0);
        	//출력
        	sb.append("#"+tc+" ").append(bfs()).append("\n"); //names.get(0)
        }
        System.out.print(sb);
	}
	private static String bfs() {
		//Queue<Way> q = new LinkedList<>();
		PriorityQueue<Way> q = new PriorityQueue<>(new Comparator<Way>() { //클래스 생성 대신 String[]를 사용해도 된다.
																		//Priority q를 사용할 때 visited체크를 한다!(중복되지 않게! 우선순위 위주로!)
			@Override
			public int compare(Way o1, Way o2) {
				return o1.name.compareTo(o2.name);
			}
		});
		v[0][0] = true;
		q.offer(new Way(0,0,""+B[0][0])); //visit처리는 불필요  //필요
		while(!q.isEmpty()) {
			Way cur = q.poll();
			int ii = cur.x;
			int jj = cur.y;
			String name = cur.name;
			//name[index] = cur[2][index];
			if(ii==N-1 && jj ==M-1) { //도착
				//names.add(name);
				return name;
			}
/*			int ni1 = ii + 0;
			int nj1 = jj + 1;
			int ni2 = ii + 1;
			int nj2 = jj + 0;
			if((ni2>=N || nj2>=M)&&(ni1<N && nj1<M)) q.offer(new Way(ni1,nj1,name+B[ni1][nj1]));
			else if((ni1>=N || nj1>=M)&&(ni2<N && nj2<M)) q.offer(new Way(ni2,nj2,name+B[ni2][nj2]));
			else if((ni1<N && nj1<M)&&(ni2<N && nj2<M)){ //두갈래 모두 가능
				if(B[ni1][nj1]==B[ni2][nj2]) { //두갈래 같을때!
					q.offer(new Way(ni1,nj1,name+B[ni1][nj1]));
					q.offer(new Way(ni2,nj2,name+B[ni2][nj2]));
				}else if(B[ni1][nj1]>B[ni2][nj2]) q.offer(new Way(ni2,nj2,name+B[ni2][nj2]));
				else q.offer(new Way(ni1,nj1,name+B[ni1][nj1]));
			}*/
			
			for(int d=0; d<2; d++) {
				int ni = ii + di[d];
				int nj = jj + dj[d];
				if(ni<N && nj<M && !v[ni][nj]) {
					v[ni][nj] = true;
					q.offer(new Way(ni,nj,name+B[ni][nj]));
				}
			}
		}
		return null;
	}
	
}
