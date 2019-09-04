package 문제풀이;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_JO_1863_종교_서울9반_김동주 { //학생들이 최대한 가질 수 있는 종교의 가지 수
											//유니온 파인드에서 덩어리의 개수?
	public static int i, j, Ans, pp;
	public static int[] p;
	//public static boolean[] visited;
	public static int getParent(int x) {
		if(p[x]==x) return x;
		else return p[x]=getParent(p[x]); //계속 부모를 따라감(재귀)
	}
	public static void union(int i, int j) {
		i=getParent(i);
		j=getParent(j);
		
		if(i>j) p[i]=j;
		else p[j]=i;
		//if(i!=j) p[i]=j;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("res/input_JO_1863.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //학생수
        int M = Integer.parseInt(st.nextToken()); //쌍의 수
        
        //make set //학생 set
        p = new int[N+1];
        for(int n=1; n<N+1; n++) { //학생인덱스에서 -1연산을 하지 않기 위해 한개 추가
        	p[n]=n; //스스로가 부모임
        }
        
        for(int m=0; m<M; m++) {
        	st = new StringTokenizer(br.readLine());
        	i = Integer.parseInt(st.nextToken());
        	j = Integer.parseInt(st.nextToken()); //학생인덱스
        	//학생 i와 학생 j가 같은 종교를 가진다. union
        	union(i,j);
        }//다묶음

        //Ans=0;
/*      int pi = 0;
        pp = getParent(pi);*/
        
/*        HashSet<Integer> hs = new HashSet<>();
        for(int n=1; n<N+1; n++) {
        	hs.add(getParent(n));
        }
        Ans = hs.size();*/
        //HashSet대신 자기자신이 부모인 학생 대표 수만 구해도 된다!
        Ans=0;
        for(int n=1; n<N+1; n++) {
        	if(p[n]==n) Ans++;
        }
        System.out.println(Ans);
	}
}
