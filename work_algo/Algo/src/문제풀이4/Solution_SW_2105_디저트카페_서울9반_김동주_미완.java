package 문제풀이4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SW_2105_디저트카페_서울9반_김동주_미완 {
	public static int T, N, map[][], max, ni, nj, ndir;
	public static boolean vnum[];//v[][], 
	//public static HashSet<Integer> set;
	public static final int[] di = {-1,-1,1,1};
	public static final int[] dj = {-1,1,1,-1}; //좌상, 우상, 우하, 좌하
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_SW_2105.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for(int n=0; n<N; n++) {
				st = new StringTokenizer(br.readLine());
				for(int m=0; m<N; m++) {
					map[n][m] = Integer.parseInt(st.nextToken());
				}
			}//입력
			
			//max = Integer.MIN_VALUE;
			max = -1;
			for(int n=0; n<N; n++) {
				for(int m=0; m<N; m++) {
					//v = new boolean[N][N];
					//set = new HashSet<>();
					vnum = new boolean[101];
					//4가지 네모를 확인한다. //0321, 1032, 2103, 3210
					dfs(n,m,0,0,0,0,0);
					dfs(n,m,0,0,0,1,0);
					dfs(n,m,0,0,0,2,0);
					dfs(n,m,0,0,0,3,0);
				}
			}
			
			//출력 //디저트를 가장 많이 먹을 때의 디저트 수 (없으면 -1)
			sb.append('#').append(tc).append(' ').append(-1).append('\n');
		}
		System.out.print(sb);

	}

	private static void dfs(int i, int j, int cnt, int cnt1, int cnt2, int dir, int dcnt) { //사각형을 그리면서 돌아와야 한다.
		if(dcnt ==3 && cnt2 == 0) { //처음으로 돌아왔을 때 max체크
			if(max < cnt) max = cnt;
			return;
		}
		//v[i][j] = true; //이건 빼도됨!!! 어차피 숫자로 체크
		vnum[map[i][j]] = true;
		//set.add(map[i][j]);
		
		switch(dcnt){
		case 0:
			//꺾을 때
			if(cnt != 0) {
				if(dir == 0) {
					ndir = 3;
				}else {
					ndir = dir -1;
				}
				ni = i + di[ndir];
				nj = j + dj[ndir];
				if(ni>=0 && nj>=0 && ni<N && nj<N && !vnum[map[ni][nj]] ) {//&& !v[ni][nj] //같은디저트로, 길로 안간다.
					dfs(ni,nj, cnt+1, cnt1, cnt2+1, ndir, dcnt+1);
				}
			}
			//안꺾을때
			ni = i + di[dir];
			nj = j + dj[dir];
			if(ni>=0 && nj>=0 && ni<N && nj<N&& !vnum[map[ni][nj]] ) {//&& !v[ni][nj] //같은디저트로, 길로 안간다.
				dfs(ni,nj, cnt+1, cnt1+1, cnt2, dir, dcnt);
			}
		break;
		case 1:
			//꺾을 때
			if(dir == 0) {
				ndir = 3;
			}else {
				ndir = dir -1;
			}
			ni = i + di[ndir];
			nj = j + dj[ndir];
			if(ni>=0 && nj>=0 && ni<N && nj<N && !vnum[map[ni][nj]] ) { //&& !v[ni][nj] //같은디저트로, 길로 안간다.
				dfs(ni,nj, cnt+1, cnt1-1, cnt2, ndir, dcnt+1);
			}
			//안꺾을때
			ni = i + di[dir];
			nj = j + dj[dir];
			if(ni>=0 && nj>=0 && ni<N && nj<N && !vnum[map[ni][nj]] ) { //&& !v[ni][nj] //같은디저트로, 길로 안간다.
				dfs(ni,nj, cnt+1, cnt1, cnt2+1, dir, dcnt);
			}
		break;
		case 2:
			//꺾을 때
			if(cnt1==0) {
				if(dir == 0) {
					ndir = 3;
				}else {
					ndir = dir -1;
				}
				ni = i + di[ndir];
				nj = j + dj[ndir];
				if(ni>=0 && nj>=0 && ni<N && nj<N && !vnum[map[ni][nj]] ) {//!set.contains(map[ni][nj]) ) { //같은디저트로, 길로 안간다.
					dfs(ni,nj, cnt+1, cnt1, cnt2-1, ndir, dcnt+1);
				}
			}else{
				//안꺾을때
				ni = i + di[dir];
				nj = j + dj[dir];
				if(ni>=0 && nj>=0 && ni<N && nj<N && !vnum[map[ni][nj]] ) {//!set.contains(map[ni][nj]) ) { //같은디저트로, 길로 안간다.
					dfs(ni,nj, cnt+1, cnt1-1, cnt2, dir, dcnt);
				}
			}
		break;
		case 3:
			//안꺾을때
			ni = i + di[dir];
			nj = j + dj[dir];
			if(ni>=0 && nj>=0 && ni<N && nj<N  && !vnum[map[ni][nj]] ) {//!set.contains(map[ni][nj]) ) { //같은디저트로, 길로 안간다.
				dfs(ni,nj, cnt+1, cnt1, cnt2-1, dir, dcnt);
			}
		break;
		}
		
		vnum[map[i][j]] = false;
	}
}

/*import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class Solution_SW_2105_디저트카페_서울9반_홍길동 {
    static int N;
    static int[][] map;
    static int[] di = {1,1,-1,-1};//대각이동
    static int[] dj = {1,-1,-1,1};
    static int max_dist;
    static boolean[] isV;
    static int start_i;
    static int start_j;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine().trim());
          
        for(int tc=0;tc<T;tc++) {
            N = Integer.parseInt(br.readLine().trim());
            map = new int[N][N];
            isV = new boolean[101];
            max_dist = 3;
            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine().trim());
                for(int j=0;j<N;j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i=0;i<N-1;i++) {
                for(int j=1;j<N-1;j++) {
                    start_i = i;
                    start_j = j;
                    isV[map[i][j]] = true;
                    find_all(i,j,0,1,0);
                    isV[map[i][j]] = false;
                }
            }
              
            if(max_dist == 3) max_dist = -1;
            bw.write("#"+(tc+1)+" "+max_dist+"\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
    static void find_all(int s_i,int s_j,int dir ,int cur_dist, int change) {
        if(change > 3) return;
        //s_i랑 s_j랑 스타트랑 같으면 한바퀴 돈거임 종료조건
        //크게 돌아서 한바퀴 돈 경우는?? d 변경 횟수 찍어서 보내기??
        int ti = s_i;
        int tj = s_j;
        int newi = ti + di[dir];
        int newj = tj + dj[dir];
        if(newi<N && newi >=0 && newj<N && newj >=0 ) {
            if(change == 3) {
                if(newi == start_i && newj == start_j) {//되돌아옴
                    max_dist = Math.max(max_dist, cur_dist);
                    return;
                }
            }
            if(!isV[map[newi][newj]]) {
                isV[map[newi][newj]] = true;
                find_all(newi,newj,dir,cur_dist+1,change);
                find_all(newi,newj,dir+1,cur_dist+1,change+1);
                isV[map[newi][newj]] = false;
            }
        }
    }
}*/