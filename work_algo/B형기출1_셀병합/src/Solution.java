import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

	private static BufferedReader br;
	private static UserSolution usersolution = new UserSolution();
	
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

		System.setIn(new java.io.FileInputStream("res/sample_input.txt"));
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
