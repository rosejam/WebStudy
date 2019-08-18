package burtegreedy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//어레이가 아니고 스트링으로 substring활용하기 
public class Solution_D3_1240_단순2진암호코드_서울9반_김동주 {
	public static byte N, M;
	public static byte[] arr;
	public static boolean flag;
	public static boolean checked;
	public static byte li;
	public static byte[] cipher;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_D3_1240.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Byte.parseByte(st.nextToken());
			M = Byte.parseByte(st.nextToken());
			arr = new byte[M]; //생성
			cipher = new byte[8];
			checked = false;
			for(byte n=0; n<N; n++) { //매 줄
				String s = br.readLine();
				if(checked == false) {
					flag = false;
					for(byte m=0; m<M; m++) {
						if(s.charAt(m)=='0') {
							arr[m] = 0;
						}else {
							flag = true;
							arr[m] = 1;
						}
					}// 한줄 다 받음.
					//flag가 true면 1이 있는 행이다.
					if(flag == true) {
						for(int m=M-1; m>=0; m--) {
							if(arr[m] == 1) {
								li = (byte) m;
								break;
							}
						}//56번째의 마지막 인덱스 li 찾음
						//li-55~li까지 56개가 암호 8자리
						for(byte x=0; x<8; x++) {
							int ones = 0;
							for(byte y=0; y<7; y++) {
								ones +=arr[li-7*x-y]*Math.pow(10, y);
							} //1자리 암호
							switch(ones) {
								case 1101:
									cipher[7-x]=0;
								break;
								case 11001:
									cipher[7-x]=1;
									break;
								case 10011:
									cipher[7-x]=2;
									break;
								case 111101:
									cipher[7-x]=3;
									break;
								case 100011:
									cipher[7-x]=4;
									break;
								case 110001:
									cipher[7-x]=5;
									break;
								case 101111:
									cipher[7-x]=6;
									break;
								case 111011:
									cipher[7-x]=7;
									break;
								case 110111:
									cipher[7-x]=8;
									break;
								case 1011:
									cipher[7-x]=9;
									break;
								default:
									break;
							}
							//System.out.println(cipher[7-x]);
						}
						//
						if(((cipher[0]+cipher[2]+cipher[4]+cipher[6])*3+(cipher[1]+cipher[3]+cipher[5]+cipher[7]))%10==0) {
							int ans = cipher[0]+cipher[2]+cipher[4]+cipher[6]+cipher[1]+cipher[3]+cipher[5]+cipher[7];
							//for each문 활용 
							sb.append("#"+tc+" "+ans+"\n");
						}else {
							sb.append("#"+tc+" "+ 0 +"\n");
						}
						checked = true;
					}//1이 있는 행일 경우
					//0만 있는 행일 경우
				}
				//이미 체크된 행렬일 경우
			}//한 행종료 
		}
		System.out.print(sb);
		br.close();
	}
}
