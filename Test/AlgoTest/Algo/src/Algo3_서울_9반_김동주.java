import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo3_서울_9반_김동주 { 
	public static int N,M;
	public static int heavy,light;
	public static int num, half;
	public static int[][] weight;
	public static int[] hr;
	public static int[] lr;
	
	public static void main(String[] args) throws Exception { 
		System.setIn(new FileInputStream("res/input3.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer nm = new StringTokenizer(br.readLine());//
		N = Integer.parseInt(nm.nextToken()); //동전개수
		M = Integer.parseInt(nm.nextToken()); //저울에 올려본 횟수
		
		half = (N-1)/2;
		weight = new int[M][2];
		for(int m=0; m<M; m++) { //매 저울에 올라가는 동전 쌍
			StringTokenizer st = new StringTokenizer(br.readLine());
			heavy = Integer.parseInt(st.nextToken());
			light = Integer.parseInt(st.nextToken());
			weight[m][0] = heavy;
			weight[m][1] = light;
		}
		//chain reaction
		//자신보다 크거나 작은 것이 (N-1)/2 half개 초과하는것 제거 num에서 빼기
		hr = new int[N+1];
		lr = new int[N+1];
		for(int n=1; n<N+1; n++) { //모든 동전 찾기
			for(int m=0; m<M; m++) {
				if(weight[m][0] == n) { //왼쪽에 있는 경우
					lr[n]++;
					findlr(m,n);
				}
				if(weight[m][1] == n) { //오른쪽에 있는 경우
					hr[n]++;
					findhr(m,n);
				}
			}
		}
		num = 0;
		for(int n=1; n<N+1; n++) {
			//System.out.println(lr[n]+"개가 "+ n+ "보다 가벼움");//
			//System.out.println(hr[n]+"개가 "+ n+ "보다 무거움");//
			if(lr[n]>half || hr[n]>half) {
				num++; //절대로 중간이 될 수 없는 동전의 수
			}
		}
		System.out.println(num); //절대로 중간이 될 수 없는 동전의 수
		br.close();
	}
	
	
	public static void findhr(int m,int n) { //m,n
		for(int mm=0; mm<M; mm++) {
			if(weight[mm][1] == weight[m][0]) {
				hr[n]++;
				findhr(mm,n);
			}
		}
	}
	public static void findlr(int m, int n) { //m,n
		for(int mm=0; mm<M; mm++) {
			if(weight[mm][0] == weight[m][1]) {
				lr[n]++;
				findlr(mm,n);
			}
		}
	}
}
