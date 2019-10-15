import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static int flag, len;
	public static char[] var;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		flag = 0; //1은 C++ 2는 Java //0이면 소문자로만 이루어져 둘다 가능 //-1이면 불가능
		var = br.readLine().toCharArray(); //알파벳과 _
		StringBuilder sb = new StringBuilder();
		len = var.length;
		//_소문자(C++) <-> 대문자(Java)
		//대문자 65~90 //소문자 97~122 //_ 95
		sb.append(var[0]);
		if(var[0] < 97) flag = -1; //일단은 소문자로 시작하는지도 체크!!
		for(int i=1; i<var.length; i++) {
			if(var[i] < 95) { //대문자
				if(flag == 0 || flag == 2) {
					flag = 2;
					sb.append("_").append((char)(var[i]+32));
				}else {
					flag = -1;
					break;
				}
			}else if(var[i] > 95) { //소문자
				if(flag != -1) sb.append(var[i]);
				else break;
			}else { //_
				if(flag == 0 || flag == 1) {
					flag = 1;
					i++;
					if(i<var.length && var[i] > 95){ //_뒤 소문자인지 //인덱스 범위 넘어가는지도 체크!! //_로 끝나는 경우
						sb.append((char)(var[i]-32));
					}else {
						flag = -1;
						break;
					}
				}else {
					flag = -1;
					break;
				}
			}
		}
		if(flag == -1) System.out.print("Error!");
		else System.out.print(sb);
	}
}
