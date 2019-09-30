package 기출_nhn;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
class Main2 {
	public static int N;
	public static int[] cvar;
	public static boolean flag,ans;
	public static String[] S;
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_D4_4366.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        S = new String[N]; 
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); 
        for(int n = 0; n < N; n++){
        	S[n]= st.nextToken();
        }
        int[] count = new int[N];//string의 빈도 체크
        ArrayList<String> string = new ArrayList<>();
        //int index=0;
		//string.add(ws.get(0));
		for(int i=0; i<N; i++) {
			flag = false;
			for(int j=0; j<string.size(); j++) {
				if(S[i].equals(string.get(j))) { //이전에 나온것과 일치하는게 있다면
					flag = true;
					count[j]++;
					break;
				}
			}
			if(!flag) { //이전에 나온것과 일치하는게 없다면(처음)
				string.add(S[i]);
			}
		}
		
        int var = string.size();
        //cnt =0;
        cvar = new int[var];
        for(int j=0; j<var; j++) {
			cvar[j] = count[j];
			//cnt += cvar[j];
		}
        Arrays.sort(cvar);
        boolean flag2 = false;
        for(int i=2; i<var; i++) {
        	if(cvar[i]!=cvar[i-1]) flag2= true;
        }
		if(cvar[0]!=cvar[1]-1) flag2 = true;
		if(!flag2) { //가능
			sb.append('Y').append('\n').append(N+1).append('\n').append(var);
		}else {
			sb.append('N').append('\n').append(N).append('\n').append(var);
		}
        
		System.out.print(sb);
        
	}
}