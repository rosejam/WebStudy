package solution.D1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//아래 스트링 빌더 쓰는법
public class Solution_D1_2068_최대수구하기_서울9반_김동주 {
	public static int x;
	public static int max;
	public static StringTokenizer st; //한 쌍이라도 토크나이저 쓰자!!!
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_D1_1936.txt")); //제출할때는 입력 삭제!!!
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			max = 0 ; // 매 tc마다 초기화는 필수!!!!
			for(int i=0; i<10; i++) { //while(st.hasMoreTokens())
				x = Integer.parseInt(st.nextToken());
				if (max<x) max=x;
			}
			System.out.println("#"+tc+" "+max);
		}
	}/*
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int testNum=Integer.parseInt(br.readLine());
        for(int i=1;i<=testNum;i++) {
            String str=br.readLine();
            StringTokenizer st=new StringTokenizer(str);
            int result=0;
            while(st.hasMoreTokens()) {
                int n1=Integer.parseInt(st.nextToken());
                if(result<n1)
                    result=n1;
            }
            sb.append("#"+i+" "+result+"\n");
        }
        System.out.println(sb);
    }*/
}

