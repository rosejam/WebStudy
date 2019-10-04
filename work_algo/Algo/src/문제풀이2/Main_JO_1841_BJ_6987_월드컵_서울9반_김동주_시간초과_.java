package 문제풀이2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JO_1841_BJ_6987_월드컵_서울9반_김동주_시간초과_ { //6개국이 15번의 시합(국가별로 5번) //Main_JO_1841_BJ_6987_월드컵_서울9반_김동주_시간초과_
	public static int[][] R, R2, RR;//
	public static int a[],game[] = {-1,0,1};
	//public static int possible;//
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_JO_1841.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringBuilder sb = new StringBuilder();
        a = new int[15];
        for(int tc=0; tc<4; tc++) {
        	R = new int[6][3]; //나라 행/결과3가지 열
        	//R2 = new int[6][3]; //나라 행/결과3가지 열
        	RR = new int[6][6];
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int i=0; i < 6; i++) {
        		for (int k = 0; k < 3; k++) {
					R[i][k] = Integer.parseInt(st.nextToken());
				}
//        		R[j][0] = Integer.parseInt(st.nextToken());
//        		st.nextToken();
//        		R[j][1] = Integer.parseInt(st.nextToken());
        	}
        	//
        	//possible = dfs(0);
//			for(int i=0; i<6; i++) {
//				R2[i] = R[i].clone();
//			}
        	//possible = permcomb(0);
        	//permcomb(0,0); //3ㅠ15
        	//	
        	//sb.append(possible).append(" ");
        	System.out.print(permcomb(0)+" ");
        }
        //System.out.println(sb);
	}
	
/*	public static boolean dfs(int l) {
		if(l == 5) {
			return true;
		}
		n = 5-l; //5~1
		r = R[l][0];//승
		v = new boolean[n];
		a = new int[r];
		if(n<r || !permcomb(0,0,l,1))
			return false;
		else return dfs(l+1);
	}
	
	public static boolean permcomb(int start, int depth, int l, int wtl) {
		if(depth == r) {
			for(int i=0; i<r; i++) {
				if (RR[l][a[i]+l+1] != 0) return false;
				RR[l][a[i]+l+1] = 1;
				RR[a[i]+l+1][l] = -1;
			}
			return true;
		}
		for(int i=0;i<n;i++) {
			if(!v[i]) {
				v[i]=true;
				a[depth] = i;
				if(permcomb(i,depth+1,l,wtl)) {
					return true;
				}
				v[i]=false;
			}
		}
		return false;
	}*/
	public static int permcomb(int depth) { //return int로 백트랙킹
		if(depth == 15) {
/*			for(int i=0; i<6; i++) {
				R2[i] = R[i].clone();
			}
			int k = 0;
			for(int i=0; i<5; i++) {
				for(int j=i+1; j<6; j++) { //15번 합은 30
					switch(a[k++]) {
						case 1:
							R2[i][0]--;
							R2[j][2]--;
						break;
						case 0:
							R2[i][1]--;
							R2[j][1]--;
						break;
						case -1:
							R2[i][2]--;
							R2[j][0]--;
						break;
//						default:
//							System.out.println("theres something wrong");
					}
					//k++;
				}
			}
			//
			for(int i=0; i<6; i++) {
				for(int j=0; j<3; j++) {
					if(R2[i][j] != 0) return 0;
				}
			}*/
			
			int k = 0;
            for(int i=1; i<6; i++) {
                for(int j=0; j<i; j++) {
                    RR[i][j] = a[k];
                    RR[j][i] = (-1)*a[k++];
                }
            }
            //다넣음
            for(int i=0; i<6; i++) {
                //flag[i] = true;
                int w=R[i][0],t=R[i][1],l=R[i][2];
                for(int j=0; j<6; j++) {
                    switch(RR[i][j]) {
                    case 1:
                        w--;
                    break;
                    case 0:
                        t--;
                        break;
                    case -1:
                        l--;
                        break;
                    }
                }
                if(w!=0 || t !=-1 || l!=0) {
                    //flag[i] = false;
                    return 0;
                }
				//System.out.println(Arrays.toString(RR[i]));
			}
			return 1;
		}
		//시드
		for(int i=0;i<3;i++) {
			a[depth] = game[i];// //-1,0,1
			if(permcomb(depth+1)==1) return 1;
			//return 0;
		}
		return 0;
	}
}
