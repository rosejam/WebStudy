package solution.D1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
public class Solution_D1_2056_연월일달력_서울9반_김동주 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_D1_2072.txt")); //제출할때는 입력 삭제!!!
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			String line = br.readLine(); //String에도, Stringbuilder에도 substring()이 있음 
			int year = Integer.parseInt(line.substring(0,4));
			if(year<0) {
				sb.append("#"+tc+" "+(-1)+"\n");
				break;
			}
			int month = Integer.parseInt(line.substring(4,6));
			int date = Integer.parseInt(line.substring(6,8));
			switch (month) {
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
					if(date<=31 && date>=1) {
						sb.append("#"+tc+" "+ line.substring(0,4)+"/"+line.substring(4,6)+"/"+line.substring(6,8)+"\n");
						break;
					}
					sb.append("#"+tc+" "+ (-1)+"\n");
					break;
				case 2:
					if(date<=28 && date>=1) {
						sb.append("#"+tc+" "+ line.substring(0,4)+"/"+line.substring(4,6)+"/"+line.substring(6,8)+"\n");
						break;
					}
					sb.append("#"+tc+" "+ (-1)+"\n");
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					if(date<=30 && date>=1) {
						sb.append("#"+tc+" "+ line.substring(0,4)+"/"+line.substring(4,6)+"/"+line.substring(6,8)+"\n");
						break;
					}
					sb.append("#"+tc+" "+ (-1)+"\n");
					break;
				default:
					sb.append("#"+tc+" "+ (-1)+"\n");
					break;
			}
		}
		System.out.println(sb);//그냥 int출력하면 앞에 0이안나온다.
		//에러플래그가 서면 -1, 아니면 날짜를 출력하는 방법을 써도 된다.
	}
}