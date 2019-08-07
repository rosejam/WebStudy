import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution2{
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("res/input.txt"));
		//Scanner sc = new Scanner(System.in); //constructor Chaining //System.in = new inputStream과 같은 뜻
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		//byte단위를 char단위로 만들어주는 inputsteamreader -> Buffered를 끼움
		String line = br.readLine(); //라인단위로 String으로 읽어들임.
/*		String[] sa = line.split(" "); ////split()은 정규편식을 StringTokenizer보다 더 잘 처리, 그러나 data가 많으면 토크나이저 사용!
		int T = Integer.parseInt(sa[0]);*/
		
		StringTokenizer st = new StringTokenizer(line);
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc = 1; tc <= T; tc++){
			System.out.println("#" + tc + " ");
		}
		br.close();
	}
}