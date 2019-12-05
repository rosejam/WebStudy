class UserSolution {
	
	public static char[][][] cell;
	public static int[][] union;
	public static boolean v[][], vv[];
	public static int vvv[];
	public static int R,C,RC,ni,nj;
	public static final int[] di = {-1,1,0,0};
	public static final int[] dj = {0,0,-1,1};
	// The below commented functions are for your reference. 
	// If you want to use it, uncomment these functions.
	
	int mstrcmp(char[] a, char[] b) 
	{
		int i;
		for (i = 0; a[i] != '\0'; ++i) if (a[i] != b[i]) return a[i] - b[i];
		return a[i] - b[i];
	}

	void mstrcpy(char[] dest, char[] src)
	{
		int i = 0;
		while (src[i] != '\0') { dest[i] = src[i]; i++; }
		dest[i] = src[i]; //마지막 \0까지 넣어줌
		
//		i++;
//		while (i < 11) { dest[i] = '\u0000'; i++; } //끝까지는 비우기
	}
	
/*	int mstrlen(char[] a)
	{
		int len = 0;
		while (a[len] != '\0') ++len;
		return len;
	}*/
	
	/////
	
	void init(int r, int c)
	{
		R = r;
		C = c;
		RC = r*c;
		vv = new boolean[RC];
		vvv = new int[RC];
		cell = new char[R+1][C+1][11]; //0행0열 안쓰기!!
		
		int j =0;
		union = new int[R+1][C+1]; //셀병합 상태 표시
		for(int rr=1; rr<=R; rr++) {
			for(int cc=1; cc<=C; cc++) {
				union[rr][cc] = j++; //스트링배열 초기화!!!!
			}
		}
		for(int rr=1; rr<=R; rr++) {
			for(int cc=1; cc<=C; cc++) {
				vvv[union[rr][cc]] = 1; //스트링배열 초기화!!!!
			}
		}
	}

	void setContent(int row, int col, char str[])
	{
//		mstrcpy(cell[row][col], str);//cell[row][col] = str; //넣기
		v = new boolean[R+1][C+1];
		dfs_set(row, col, str, union[row][col]);
		//System.out.println(count+" "+row+" "+col+" "+Arrays.toString(cell[row][col]));
	}

	private void dfs_set(int row, int col, char[] str, int uni) {
		v[row][col] = true; //v말고 문자열 비교도 가능하긴할듯
		mstrcpy(cell[row][col], str);// 그냥 넣으면 절대 안
		for(int d=0;d<4;d++) {
			ni = row + di[d];
			nj = col + dj[d];
			if(ni>0 && nj>0 && ni<=R && nj<=C && !v[ni][nj] && union[ni][nj] == uni) { //방문안한 같은 유니온
				dfs_set(ni,nj,str,uni);
			}
		}
	}

	void getContent(int row, int col, char str[]) //왜맨앞자리 짤리지????
	{
		//str[0] = '\0'; //필요한가??
		mstrcpy(str, cell[row][col]);
		//System.out.println(count+" "+row+" "+col+" "+Arrays.toString(str));
	}

	void mergeCell(int row1, int col1, int row2, int col2, int opt)
	{
		switch(opt) { //한칸만 병합하는게 아닌듯?
		case 1:
			v = new boolean[R+1][C+1];
			vv[union[row2][col2]] = true; //없어짐
			//vvv[union[row2][col2]] = 0;
			vvv[union[row1][col1]] += vvv[union[row2][col2]];
			//dfs_merge(row1, col1, cell[row1][col1], union[row2][col2], union[row1][col1]);
			for(int rr=1;rr<=R;rr++) {
				for(int cc=1;cc<=C;cc++) {
					if(union[rr][cc] == union[row2][col2]) {
						mstrcpy(cell[rr][cc], cell[row1][col1]);
						union[rr][cc] = union[row1][col1];
					}
				}
			}
			break;
		case 2:
			v = new boolean[R+1][C+1];
			vv[union[row1][col1]] = true; //없어짐
			//vvv[union[row1][col1]] = 0;
			vvv[union[row2][col2]] += vvv[union[row1][col1]];
			//dfs_merge(row2, col2, cell[row2][col2], union[row1][col1], union[row2][col2]);
			for(int rr=1;rr<=R;rr++) {
				for(int cc=1;cc<=C;cc++) {
					if(union[rr][cc] == union[row1][col1]) {
						mstrcpy(cell[rr][cc], cell[row2][col2]);
						union[rr][cc] = union[row2][col2];
					}
				}
			}
			break;
		}
		//if(count == 27) for(int[] x: union) System.out.println(Arrays.toString(x));
	}

	private void dfs_merge(int row, int col, char[] str, int uni, int desuni) {
		v[row][col] = true; //v말고 문자열 비교도 가능하긴할듯
		//vvv[desuni]++; //원래 유니온의 개수
		for(int d=0;d<4;d++) {
			ni = row + di[d];
			nj = col + dj[d];
			if(ni>0 && nj>0 && ni<=R && nj<=C && !v[ni][nj]) { //방문안한 같은 유니온
				if(union[ni][nj] == desuni) {
					dfs_merge(ni,nj,str,uni,desuni);
				}else if(union[ni][nj] == uni) {
					mstrcpy(cell[ni][nj], str);
					//vvv[uni]++;
					union[ni][nj] = desuni;
					dfs_merge(ni,nj,str,uni,desuni);
				}
			}
		}
	}

	int countCell(char str[])
	{
		int cnt = 0;
		boolean[] vcnt = new boolean[RC];
		for(int j=0; j<RC; j++) {
			vcnt[j] = vv[j];
		}
		for(int rr=1; rr<=R; rr++) {
			for(int cc=1; cc<=C; cc++) {
				if(!vcnt[union[rr][cc]]) { //있는 셀
					vcnt[union[rr][cc]] = true;
					if(mstrcmp(cell[rr][cc], str) == 0) { //같은거 있는 경우
						cnt++;
						//System.out.println(str);
//						System.out.println("**"+count+" "+rr+ " " + cc);
					}
				}
			}
		}
		//if(count == 16) for(int[] x: union) System.out.println(Arrays.toString(x));
//		System.out.println("**"+count+" "+cnt); //3 2 2 0 2
		return cnt;
	}

	int countArea(char str[])
	{
		int cnt = 0;
		boolean[] vcnt = new boolean[RC];
		for(int j=0; j<RC; j++) {
			vcnt[j] = vv[j];
		}
		for(int rr=1; rr<=R; rr++) {
			for(int cc=1; cc<=C; cc++) {
				if(!vcnt[union[rr][cc]]) { //있는 셀
					vcnt[union[rr][cc]] = true;
					if(mstrcmp(cell[rr][cc], str) == 0) { //같은거 있는 경우
						cnt += vvv[union[rr][cc]];
						//System.out.println(str);
//						System.out.println("**"+count+" "+rr+ " " + cc);
//						System.out.println(vvv[union[rr][cc]]);
					}
				}
			}
		}
		//if(count == 16) for(int[] x: union) System.out.println(Arrays.toString(x));
//		System.out.println("**"+count+" "+cnt); //4 9 3 5 10
		return cnt;
	}
}