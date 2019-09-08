package brutegreedy;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
//어나니머스 컴패래터
class Main_정올_1370_회의실배정_서울9반_김동주3{
	public static class Meeting { //클래스 생성! 
		int num;  //디폴트 레벨로 캡슐화된 필드
		int start;
		int end;
		
		Meeting(int num, int start, int end){ //생성자
			this.num=num;
			this.start=start;
			this.end=end;
		}
		
/*		@Override
		public int compareTo(Meeting o) { //필드중에 어떤 것을 기준으로 정렬하고 싶은지
			return Integer.compare(end, o.end); //end 오름차순
		}*/

	}
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("res/input_JO_1370.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int N = Integer.parseInt(br.readLine());
		Meeting[] m = new Meeting[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		//comparable 정렬클래스의 비교 규칙 오버라이딩
		Arrays.sort(m, new Comparator<Meeting>() { //기본이 아닌 별도의 정렬규칙 작성(어나니머스 클래스로)
			@Override
			public int compare(Meeting o1, Meeting o2) {
				return Integer.compare(o1.end, o2.end); //이 규칙 대로 소팅
			}
		}); 
		
		List<Meeting> li = new ArrayList<>();
		li.add(m[0]);
		for(int i=1; i<m.length; i++) {
			if(li.get(li.size()-1).end <= m[i].start) { //방금 넣은 것을 끄집어 냄
				li.add(m[i]);
			}
		}
		System.out.println(li.size());
		for(Meeting meet : li) {
			System.out.print(meet.num+" ");
		}
		//System.out.println(Arrays.toString(m).replace("[","").replace("]","").replace(", ","\n"));
		br.close();
	}
}