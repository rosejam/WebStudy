package 문제풀이3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//톱니바퀴의 인덱스는 %를 이용한다! //여기서는 아님
public class Main_BJ_14891_톱니바퀴_서울9반_김동주_끝_ {
	public static int[][] T; //톱니바퀴들
	public static int K, score;
	public static int[][] turns;
	public static int[][] dir; //K번째에서 0~3 각각의 방향
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = new int[4][8]; //4개 바퀴, 각각 8개 톱니(시ㄱㅖ방향)
		String line;
		for(int i=0; i<4; i++) {
			line = br.readLine();
			for(int j=0; j<8; j++) {
				T[i][j] = line.charAt(j)-'0'; //0과 1 //다른게 맞닿아있으면 따라감
			}
		}
		K = Integer.parseInt(br.readLine()); //회전 횟수
		turns = new int[K][2];
		StringTokenizer st;
		for(int k=0; k<K; k++) {
			st = new StringTokenizer(br.readLine());
			turns[k][0] = Integer.parseInt(st.nextToken())-1; //톱니 0~3
			turns[k][1] = Integer.parseInt(st.nextToken()); //방향 1(시계) -1(반시계)
//			System.out.println("******");
//			System.out.println(K);
//			System.out.println(Arrays.toString(turns[k]));
		}
		//입력다받음
		//0의 2와 1의 6. 1의 2와 2의 6. 2의 2와 3의 6. 3개의 연결이 있다.
		dir = new int[K][4]; //돌리는 방향 0으로 초기화
		for(int k=0; k<K; k++) {
			switch(turns[k][0]) {
			case 0:
				dir[k][0] = turns[k][1];
				if(T[0][2]!=T[1][6]) {
					dir[k][1] = dir[k][0] * (-1);
					if(T[1][2]!=T[2][6]) {
						dir[k][2] = dir[k][1] * (-1);
						if(T[2][2]!=T[3][6]) {
							dir[k][3] = dir[k][2] * (-1);
						}
					}
				}
				break;
			case 1:
				dir[k][1] = turns[k][1];
				if(T[0][2]!=T[1][6]) {
					dir[k][0] = dir[k][1] * (-1);
				}
				if(T[1][2]!=T[2][6]) {
					dir[k][2] = dir[k][1] * (-1);
					if(T[2][2]!=T[3][6]) {
						dir[k][3] = dir[k][2] * (-1);
					}
				}
				break;
			case 2:
				dir[k][2] = turns[k][1];
				if(T[1][2]!=T[2][6]) {
					dir[k][1] = dir[k][2] * (-1);
					if(T[0][2]!=T[1][6]) {
						dir[k][0] = dir[k][1] * (-1);
					}
				}
				if(T[2][2]!=T[3][6]) {
					dir[k][3] = dir[k][2] * (-1);
				}
				break;
			case 3:
				dir[k][3] = turns[k][1];
				if(T[2][2]!=T[3][6]) {
					dir[k][2] = dir[k][3] * (-1);
					if(T[1][2]!=T[2][6]) {
						dir[k][1] = dir[k][2] * (-1);
						if(T[0][2]!=T[1][6]) {
							dir[k][0] = dir[k][1] * (-1);
						}
					}
				}
				break;
			}//현재상태에서 돌릴 방향찾음
			
			//돌리기
			for(int i=0; i<4; i++) {
				if(dir[k][i]== 1) { //시계방향 돌리기
					//주의!!!!대입 방향 잘못하면 다똑같아짐!!!! //어레이리스트로 처음것과 마지막만 조절하면 자동으로 인덱스 처리가 된다!!
					int temp = T[i][7];
					for(int j=7; j>0; j--) {
						T[i][j] = T[i][j-1]; //7에 6넣음
					}
					T[i][0] = temp;
				}else if(dir[k][i]== -1) { //반시계방향 돌리기
					int temp = T[i][0];
					for(int j=0; j<7; j++) {
						T[i][j] = T[i][j+1]; //0에 1넣음
					}
					T[i][7] = temp;
				}
				//그대로 있기
			}
//			System.out.println(Arrays.toString(dir[k]));
//			System.out.println(Arrays.toString(T[0]));
//			System.out.println(Arrays.toString(T[1]));
//			System.out.println(Arrays.toString(T[2]));
//			System.out.println(Arrays.toString(T[3]));
		}
		
		//점수계산
		//score = 0;
		if(T[0][0]==1) score += 1;
		if(T[1][0]==1) score += 2;
		if(T[2][0]==1) score += 4;
		if(T[3][0]==1) score += 8;
		System.out.print(score);
		
/*		//예시답안 //n은 지금 돌리는 바퀴 index
		int dir = new int[4];
		for(int i=n; i<3; i++) { //오른쪽으로
			if(T[i][2]!=T[i+1][6]) dir[i+1] = dir[i]*-1;
		}
		for(int i=n; i>0; i--) { //왼쪽으로
			if(T[i-1][2]!=T[i][6]) dir[i-1] = dir[i]*-1;
		}
		for(int i=0; i<4; i++) {
			if(dir[i]!=0) rotate(i,dir[i]);
		}*/
	}
	
}
