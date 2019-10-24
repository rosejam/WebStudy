package PS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Solution_D1_2056_연월일달력_서울9반_김동주_끝_ {
	public static int T,year,month,date;
	public static void main(String args[]) throws Exception {
		//System.setIn(new FileInputStream("res/input_D1_2056.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			sb.append('#').append(tc).append(' ');
			String line = br.readLine(); //String에도, Stringbuilder에도 substring()이 있음
			year = Integer.parseInt(line.substring(0,4));
/*			if(year<0) {
				sb.append(-1).append('\n');
				continue;
			}*/
			month = Integer.parseInt(line.substring(4,6));
			date = Integer.parseInt(line.substring(6,8));
			
			switch (month) {
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
					if(date<=31 && date>0) {
						sb.append(String.format("%04d", year)).append('/').append(String.format("%02d", month)).append('/').append(String.format("%02d", date)).append('\n');
						break;
					}
					sb.append(-1).append('\n');
					break;
					
				case 2:
					if(date<=28 && date>0) {
						sb.append(String.format("%04d", year)).append('/').append(String.format("%02d", month)).append('/').append(String.format("%02d", date)).append('\n');
						break;
					}
					sb.append(-1).append('\n');
					break;
					
				case 4:
				case 6:
				case 9:
				case 11:
					if(date<=30 && date>0) {
						sb.append(String.format("%04d", year)).append('/').append(String.format("%02d", month)).append('/').append(String.format("%02d", date)).append('\n');
						break;
					}
					sb.append(-1).append('\n');
					break;
					
				default:
					sb.append(-1).append('\n');
					break;
			}
		}
		System.out.println(sb);//그냥 int출력하면 앞에 0이안나온다.
		//에러플래그가 서면 -1, 아니면 날짜를 출력하는 방법을 써도 된다.
	}
}