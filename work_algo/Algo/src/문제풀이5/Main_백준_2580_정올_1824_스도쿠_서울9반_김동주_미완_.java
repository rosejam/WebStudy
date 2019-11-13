package 문제풀이5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//테케 1개(정올에서 확인가능)때문에 문제가 생기기 때문에 dfs에서 return하지 않고 "System.exit(0);" 해야함!!
//너무 빠져나오는게 오래걸림
//스도쿠 판을 채우는 방법이 여럿인 경우는 그 중 하나만을 출력한다
public class Main_백준_2580_정올_1824_스도쿠_서울9반_김동주_미완_ { //available(=promising)한 숫자를 넣어보면서 dfs
	public static boolean v[][];
	public static int sudoku[][];
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_JO_2577.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        v = new boolean[27][9];
        sudoku = new int[9][9];
        
        for(int i=0;i<9;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0;j<9;j++) {
        		sudoku[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        //
        
	}

}
