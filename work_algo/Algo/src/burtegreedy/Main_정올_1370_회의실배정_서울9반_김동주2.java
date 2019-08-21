package burtegreedy;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
//컴패래터
class Main_정올_1370_회의실배정_서울9반_김동주2{
	
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("res/input_JO_1370.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int N = Integer.parseInt(br.readLine());
		int [][] m = new int[N][3]; //Meeting클래스 대신 int[]!!!! 3은 생략 가능
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		}
		Arrays.sort(m, new Comparator<int[]>() { //comp(비교용) 어나니머스 클래스 작성 //기본이 아닌 별도의 정렬규칙 작성
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		}); 
		
		List<int[]> li = new ArrayList<>();
		li.add(m[0]);
		for(int i=1; i<m.length; i++) {
			if(li.get(li.size()-1)[2] <= m[i][1]) { //메서드 대신 배열 위치
				li.add(m[i]);
			}
		}
		System.out.println(li.size());
		for(int[] meet : li) {
			System.out.print(meet[0]+" ");
		}
		br.close();
	}
}