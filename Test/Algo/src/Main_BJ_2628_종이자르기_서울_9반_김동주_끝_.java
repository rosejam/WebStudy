import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_BJ_2628_종이자르기_서울_9반_김동주_끝_ { //Algo2
	public static int N,M;
	public static int rc;
	public static ArrayList<Integer> rnum;
	public static ArrayList<Integer> cnum;
	public static ArrayList<Integer> rlens;
	public static ArrayList<Integer> clens;
	//public static int[][] map;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_BJ_2628.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer nm = new StringTokenizer(br.readLine());//
		N = Integer.parseInt(nm.nextToken()); //가로
		M = Integer.parseInt(nm.nextToken()); //세로
		rnum = new ArrayList<Integer>();
		cnum = new ArrayList<Integer>();
		//map = new int[M+1][N+1];
		int NUM = Integer.parseInt(br.readLine()); //구분선 개수//
		for(int nn=0; nn<NUM; nn++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			rc = Integer.parseInt(st.nextToken()); //가로0세로1
			if(rc == 0) { //0가로로 자르는 정보 //0초기화 
				rnum.add(Integer.parseInt(st.nextToken())); //번호
			}else{ //1세로로 자르는 곳 정보
				cnum.add(Integer.parseInt(st.nextToken())); //번호
			}
		}
		//이 정보로 가로의 길이들, 세로의 길이들을 구한다.
		Collections.sort(rnum);
		Collections.sort(cnum); //둘다 오름차순 정렬
		//System.out.println(rnum);
		//System.out.println(cnum);
		rlens = new ArrayList<Integer>();
		clens = new ArrayList<Integer>();
		int x = 0;
		for(int m=0; m<M; m++) { //이 부분은 for(int k=1; k<rnum.size(); k++) w=Math.max(w, rnum.get(k)-rnum.get(k-1));
			if(rnum.size()>1) {
				if(m==rnum.get(x)) {
					if(x==0) { //처음 자르는 정보
						rlens.add(rnum.get(x)-0); 
						x++;
					}else if(x==rnum.size()-1) { //마지막 정보
						rlens.add(rnum.get(x)-rnum.get(x-1)); //이부분을 빼서 틀렸다.
						rlens.add(M-rnum.get(x));
						break;
					}else {
						rlens.add(rnum.get(x)-rnum.get(x-1));
						x++;
					}
				}
			}else if(rnum.size()==1) {
				rlens.add(rnum.get(x)-0); 
				rlens.add((M-rnum.get(x)));
			}else if(rnum.size() ==0) {
				rlens.add(M);
			}
		}
		int y = 0;
		for(int n=0; n<N; n++) {//이 부분은 for(int k=1; k<cnum.size(); k++) w=Math.max(w, cnum.get(k)-cnum.get(k-1));
			if(cnum.size()>1) {
				if(n==cnum.get(y)) {
					if(y==0) {
						clens.add(cnum.get(y)-0);
						y++;
					}else if(y==cnum.size()-1) { //마지막 정보
						clens.add(cnum.get(y)-cnum.get(y-1)); //이부분을 빼서 틀렸다.
						clens.add(N-cnum.get(y));
						break;
					}else {
						clens.add(cnum.get(y)-cnum.get(y-1));
						y++;
					}
				}
			}else if(cnum.size()==1) {
				clens.add(cnum.get(y)-0);
				clens.add(N-cnum.get(y));
			}else if(cnum.size() ==0) {
				clens.add(N);
			}
		}
		//clens와 rlens의 조합만들어서 곱하기 //그냥 최대값만 찾아서 곱하기
		//int xy =0;
		int maxc =0;
		int maxr =0;
		for(int cl=0; cl<clens.size(); cl++) {
			for(int rl=0; rl<rlens.size(); rl++) {
				if(maxc<clens.get(cl)) maxc=clens.get(cl);
				if(maxr<rlens.get(rl)) maxr=rlens.get(rl);
			}
		}
		System.out.print(maxc*maxr); //가장 큰 영역의 넓이 출력!
		br.close();
	}
}
