package burtegreedy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_1244_최대상금_서울9반_김동주 {
	//trade가 num이상이 경우 같은게 있거나true 다 소팅하고 짝수번 trade가 남거나하면 소팅 끝내고 넘기기
	//					else면 끝자리 2개바꿔서 리턴
	//trade가 num이하일 경우 전부 다 만들어보고 가장 큰 값을 리턴
	public static char[] info;
	public static int[] info2;
	public static int[] array;
	public static int trade;
	public static byte num;
	public static boolean flag;
	public static int[] trading(int trade, int index) {
		//if(trade==0) return info2;
		if(index!=num) {
			int max=maxindex(index, num-1);
			if(index!=max) {
				int T=info2[index]; info2[index]=info2[max]; info2[max]=T;
				return trading( --trade, ++index);
			}else {
				return trading(trade, ++index);
			}
		}
		if(flag == false && (trade-num+1)%2==1) {
			int T=info2[num-1]; info2[num-1]=info2[num-2]; info2[num-2]=T;
			return info2;
		}else {
			return info2;
		}
	}//같은거 여러개면 마지막에 같은거끼리 바꾸기, min값과 바꾸기
	public static int maxindex(int i, int j) { //뒤에서부터 max찾기
		int max = i;
		for(int x=j; x>i; x--) {
			if(info2[x]>info2[max]) {
				max=x;
			}
		}
		return max;
	}
/*	public static int minindex(int i, int j) { //앞에서부터 min찾기
		int min = i;
		for(int x=i+1; x<j; x++) {
			if(info2[x]<info2[min]) {
				min=x;
			}
		}
		return min;
	}*/
	public static int[] tradingall() {
		array = comb(num, 2);
		array[0]
	}
	
	public static int[] comb (int n, int r) { //count는 레벨(깊이)를 의미한다.
		int[] info3 = new int[2];
		if(r==0){ 
			return info3;
		}else if(n<r) return info3;
		info3[r-1] = info2[n-1]; 
		comb(n-1, r-1);
		comb(n-1, r);
		return info3;
	} 
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("res/input_D3_1244.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		byte T = Byte.parseByte(br.readLine());
		StringBuilder sb = new StringBuilder(); //스트링 빌더는 매 테스트케이스 시작때 초기화 하지 않는다. 모아서 출력하는 용도 이기 때문
		for(int tc = 1; tc <= T; tc++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			//N = Integer.parseInt(br.readLine());
			info = st.nextToken().toCharArray();
			trade = Integer.parseInt(st.nextToken());
			num = (byte)info.length;
			info2 = new int[num];
			for(byte i=0; i<num; i++) {
				info2[i] = info[i]-'0';
			}
			if(trade>=num-1) {
				flag =false;
				for(int x=0; x<num; x++) {
					for(int y=0; y<num; y++) {
						if(info2[x]==info2[y]) flag = true;
					}
				}
				info2 = trading(trade,0);
			}else {
				
			}
			sb.append("#"+ tc + " ");
			for(int i=0; i<num; i++) {
				sb.append(info2[i]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
