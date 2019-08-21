package burtegreedy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_1244_최대상금_서울9반_김동주 { //5번 예시 88832여야함 
	//trade가 num이상이 경우 같은게 있거나(flag true) 다 셀렉션 소팅하고 짝수번 trade가 남거나하면 소팅 끝내고 넘기기
	//					else면 끝자리 2개바꿔서 리턴 		//백트랙킹 
	//trade가 num미만일 경우 전부 다 만들어보고 가장 큰 값을 리턴 - ㄴㄴ 15^4나 됨..
	//					현재 index 뒤에 최댓값들의 개수를 세고 뭉텅이로 옮긴 후 뒤에를 소팅
	
	//시간을 많이주므로 DFS로 완전탐색을 하면 답이 나옴(순열 by swap-Perm 참고)
	public static char[] info;
	public static int[] info2;
	public static int trade;
	public static byte num;
	public static boolean flag;
	public static void trading(int trade, int index) {
		if(trade==0) return; //시드 
		if(index<num-1) { //셀렉션 소팅완료이전 
			int max=maxindex(index, num-1)[0];
			int cnt=maxindex(index, num-1)[1];
			if((index!=max)&&cnt==1) {
				int T=info2[index]; info2[index]=info2[max]; info2[max]=T;
				trading(trade-1, index+1);
			}else if((index!=max)&&cnt>1) {/////////////////////////////////////////
				int xx = (trade>cnt)? cnt:trade; //더 작은거
				int[] array = new int[xx];
				for(int x=0; x<xx; x++) {
					//int T=info2[index+x]; info2[index+x]=info2[max-x]; info2[max-x]=T;
					array[xx-x-1]=info2[index+x];//아무렇게나 넣기 
					info2[index+x]=info2[max-x];
				}
				Arrays.sort(array);
				for(int x=0; x<xx; x++) { 
					info2[max-x] = array[x]; //오름차순소팅이므로 거꾸로 넣기
				}
				trading(trade-xx, index+xx);
				///////////////////////////////////////////
			}else { //지금 값이 최대 
				trading(trade, index+1);
			}
		}else if((flag == false)&&(trade%2==1)) { ////////////이 아래는 그냥 백트랙킹
			int T=info2[num-1]; info2[num-1]=info2[num-2]; info2[num-2]=T;
			return;
		}else {
			return;
		}
	}
	public static int[] maxindex(int i, int j) { //i포함 뒤에서부터 max찾기
		int max = i;
		int cnt = 0;
		for(int x=j; x>i; x--) {
			if(info2[x]>info2[max]) {
				max=x;
			}
		}
		for(int y=j; y>i; y--) { //i 제외하고 뒤에 최댓값 개수
			if(info2[y]==info2[max]) {
				cnt++;
			}
		}
		int[] xx = {max, cnt};
		return xx;
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
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("res/input_D3_1244.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		byte T = Byte.parseByte(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; tc++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			info = st.nextToken().toCharArray();
			trade = Integer.parseInt(st.nextToken());
			num = (byte)info.length;
			info2 = new int[num];
			for(byte i=0; i<num; i++) {
				info2[i] = info[i]-'0';
			}
			flag =false;
			for(int x=0; x<num; x++) {
				for(int y=0; y<num; y++) {
					if((x!=y) && (info2[x]==info2[y])) flag = true; //같은게 있다.
				}
			}
			trading(trade,0);
			sb.append("#"+ tc + " ");
			for(int i=0; i<num; i++) {
				sb.append(info2[i]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
