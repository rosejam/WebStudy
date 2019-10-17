package 문제풀이3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_14889_나무재테크_서울9반_김동주_느림_ {
	public static class Tree{ //좌표와 나이
		int x;
		int y;
		int age;
		public Tree(int x, int y, int age) {
			super();
			this.x = x;
			this.y = y;
			this.age = age;
		}
	}
	////public static List<Integer>[][] list;
	public static int[] di = {-1,-1,-1,0,0,1,1,1};
	public static int[] dj = {-1,0,1,-1,1,-1,0,1};
	public static int N,M,K,A[][],land[][];//,B[][],age
	public static PriorityQueue<Tree> trees;
	public static ArrayList<Tree> list,list2;
	public static void main(String[] args) throws Exception {
		//1베이스 인덱스 //양분은 모든 칸에 5
		//한칸에 여러개의 나무 심을 수 있다.
		//System.setIn(new FileInputStream("res/input_BJ_14889.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer nmk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(nmk.nextToken());
		M = Integer.parseInt(nmk.nextToken());
		K = Integer.parseInt(nmk.nextToken());
		////list = new ArrayList[N][N];
		A = new int[N][N]; //겨울에 추가되는 양분
		land = new int[N][N]; //현재 땅에 있는 양분
		for(int n=0; n<N; n++) {
			nmk = new StringTokenizer(br.readLine());
			for(int m=0; m<N; m++) {
				A[n][m] = Integer.parseInt(nmk.nextToken());
				land[n][m] = 5;
			}
			//System.out.println(Arrays.toString(A[n]));
		}
		trees = new PriorityQueue<>(new Comparator<Tree>() {
			@Override
			public int compare(Tree o1, Tree o2) {
				return o1.age-o2.age;
			}
		}); //나이순으로 오름차순
		for(int m=0; m<M; m++) {
			nmk = new StringTokenizer(br.readLine());
			trees.offer(new Tree(Integer.parseInt(nmk.nextToken())-1,Integer.parseInt(nmk.nextToken())-1,Integer.parseInt(nmk.nextToken())));
			//System.out.println(trees.get(m).x);
		}
		//입력다받음
/*		land = new int[N][N]; //실제 땅의 양분
		for(int n=0; n<N; n++) {
			for(int m=0; m<N; m++) {
				land[n][m] = 5;
			}
		}*/
		
		//1년사이클 K회
		for(int k=0; k<K; k++) {
			//System.out.println(k+"year");
			//봄:나무가 나이만큼 양분을 먹고 나이++ 어린나무부터 양분을 먹기. 양분이 부족해서 못먹으면 바로 죽음
			//B = new int[N][N]; //죽은나무 저장
			list = new ArrayList<>();
			list2 = new ArrayList<>();
			while(!trees.isEmpty()) {
				//for(int ii=0; ii<trees.size(); ii++) { //일단 들어있는 애들만돌리기!
				Tree temp = trees.poll();
				if(land[temp.x][temp.y] >= temp.age) {
					land[temp.x][temp.y] -= temp.age;
					temp.age = temp.age+1;
					//trees.offer(temp); //다시넣기
					list.add(temp);
				}else {
					//B[temp.x][temp.y] += temp.age/2;
					list2.add(temp);
				}
			}
			for(Tree t:list) {
				//trees.offer(list.remove(list.size()-1));
				//System.out.println(t.x+" "+t.y+" "+t.age);
				trees.offer(t);
			}
			//여름:봄에 죽은 나무의 (int)나이/2가 양분에 더해짐
/*			for(int n=0; n<N; n++) {
				for(int m=0; m<N; m++) {
					land[n][m] += B[n][m];
				}
			}*/
			for(Tree t:list2) {
				//trees.offer(list.remove(list.size()-1));
				//System.out.println(t.x+" "+t.y+" "+t.age);
				land[t.x][t.y] += t.age/2;
				//trees.remove(t);
			}
			//가을:나이가 5의 배수인 나무는 번식. 인접 8방향(범위안)에 나이1인 나무가 생성.
			list = new ArrayList<>();
			int i=0,j=0,ni=0,nj=0;
			while(!trees.isEmpty()) {
			//for(int ii=0; ii<trees.size(); ii++) { //일단 들어있는 애들만돌리기!
				Tree temp = trees.poll();
				if(temp.age%5 ==0) {
					i= temp.x;
					j= temp.y;
					for(int d=0; d<8; d++) {
						ni = i+di[d];
						nj = j+dj[d];
						if(ni>=0 && nj>=0 && ni<N && nj<N) {
							//trees.offer(new Tree(ni,nj,1));
							list.add(new Tree(ni,nj,1));
						}
					}
				}
				list.add(temp);
			}
			for(Tree t:list) {
				//trees.offer(list.remove(list.size()-1));
				///System.out.println(t.x+" "+t.y+" "+t.age);
				trees.offer(t);
			}
			//겨울:입력에 주어진 대로 땅에 양분 추가
			for(int n=0; n<N; n++) {
				for(int m=0; m<N; m++) {
					land[n][m] += A[n][m];
				}
			}
		}
		//살아있는 나무 개수는?
		//System.out.println("Ans");
		System.out.print(trees.size());
	}

}