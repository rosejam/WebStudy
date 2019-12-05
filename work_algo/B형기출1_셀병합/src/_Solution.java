import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class _Solution { //입출력 처리하는 코드. 수정할 수 없음.
	//1. 각 테스트 케이스 시작 시 init() 함수가 호출된다.
	//2. mergeCell() 함수에서 (row1, col1) 에 위치한 셀과 (row2, col2) 에 위치한 셀은 반드시 인접해 있는 서로 다른 셀이다.
	//3. 입력으로 주어지는 문자열 str[]은 영어 소문자로 구성되며, ‘＼0’ 로 끝나고 ‘＼0’ 을 포함한 전체 길이는 3 이상 11 이하이다.
	//4. 각 테스트 케이스에서 하나의 셀의 넓이는 최대 200 이다. 즉, mergeCell() 함수를 통해 병합되는 셀의 최대 넓이는 200 이다.
	//5. 각 테스트 케이스에서 모든 함수의 호출 횟수 총합은 최대 50,000 이다.
	
	private static BufferedReader br;
	private static _UserSolution usersolution = new _UserSolution();
	
	private final static int INIT         = 0;
	private final static int SETCONTENT   = 1;
	private final static int GETCONTENT   = 2;
	private final static int MERGECELL    = 3;
	private final static int COUNTCELL    = 4;
	private final static int COUNTAREA    = 5;
	
	private static int mstrcmp(char a[], char b[])
	{
		int i;
		for (i = 0; a[i] != '\0'; ++i) if (a[i] != b[i]) return a[i] - b[i];
		return a[i] - b[i];
	}

	private static int run(int answer) throws Exception {
		
		int N, cmd, p1, p2, p3, p4, p5, ret;
		char str[] = new char [11];
		char buf[] = new char [11];
		
		String inputStr;		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			cmd = Integer.parseInt(st.nextToken());
			switch (cmd) {
			case INIT:
				p1 = Integer.parseInt(st.nextToken());
				p2 = Integer.parseInt(st.nextToken());
				usersolution.init(p1, p2);
				break;
			case SETCONTENT:
				p1 = Integer.parseInt(st.nextToken());
				p2 = Integer.parseInt(st.nextToken());				
				inputStr = st.nextToken();
				for (int k = 0; k < inputStr.length(); ++k) {
					buf[k] = inputStr.charAt(k);
				}
				buf[inputStr.length()] = '\0';
				usersolution.setContent(p1, p2, buf);
				break;
			case GETCONTENT:
				p1 = Integer.parseInt(st.nextToken());
				p2 = Integer.parseInt(st.nextToken());				
				inputStr = st.nextToken();
				for (int k = 0; k < inputStr.length(); ++k) {
					str[k] = inputStr.charAt(k);
				}
				str[inputStr.length()] = '\0';
				usersolution.getContent(p1, p2, buf);
				if (str[0] == 'N') str[0] = '\0';
				if (mstrcmp(str, buf) != 0) answer = 0;
				break;
			case MERGECELL:
				p1 = Integer.parseInt(st.nextToken());
				p2 = Integer.parseInt(st.nextToken());
				p3 = Integer.parseInt(st.nextToken());
				p4 = Integer.parseInt(st.nextToken());
				p5 = Integer.parseInt(st.nextToken());
				usersolution.mergeCell(p1, p2, p3, p4, p5);
				break;
			case COUNTCELL:
				p1 = Integer.parseInt(st.nextToken());
				inputStr = st.nextToken();
				for (int k = 0; k < inputStr.length(); ++k) {
					buf[k] = inputStr.charAt(k);
				}
				buf[inputStr.length()] = '\0';
				ret = usersolution.countCell(buf);
				if (ret != p1) answer = 0;
				break;
			case COUNTAREA:
				p1 = Integer.parseInt(st.nextToken());
				inputStr = st.nextToken();
				for (int k = 0; k < inputStr.length(); ++k) {
					buf[k] = inputStr.charAt(k);
				}
				buf[inputStr.length()] = '\0';
				ret = usersolution.countArea(buf);
				if (ret != p1) answer = 0;
				break;
			default:
				break;
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		int T, Mark;

		System.setIn(new java.io.FileInputStream("res/sample_input.txt")); ////파일 입력받기
		br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stinit = new StringTokenizer(br.readLine(), " ");
		T = Integer.parseInt(stinit.nextToken());
		Mark = Integer.parseInt(stinit.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			System.out.println("#" + tc + " " + run(Mark));
		}
		
		br.close();
	}
}
