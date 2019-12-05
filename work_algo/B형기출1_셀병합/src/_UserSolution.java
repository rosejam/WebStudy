//응시자가 작성해야 하는 코드. 입출력은 별도로 처리하지 않는다. 어떠한 라이브러리 함수도 포함 불가(주석 처리 하기).
//제한시간은 최대 50개 태케 3초 이내
//메모리는 Heap, Global, Stack 등을 모두 합해 최대 256MB까지 (스택은 최대 1MB까지)

class _UserSolution { //셀 행렬은 1-base

	// The below commented functions are for your reference.
	// If you want to use it, uncomment these functions.
	/*
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
		dest[i] = src[i];
	}
	
	int mstrlen(char[] a)
	{
		int len = 0;
		while (a[len] != '\0') ++len;
		return len;
	}
	*/

	void init(int R, int C)
	{
		/*각 테스트 케이스의 처음에 호출된다.
		
		표는 1 * 1 크기의 R * C 개의 셀로 초기화 되며, 각 셀의 내용은 비어있는 상태가 된다.
		
		각각의 인자 값의 범위는 아래와 같다.
		 5 ≤ R ≤ 150
		 5 ≤ C ≤ 150
		 
		Parameters
		   R : 표의 행 개수
		   C : 표의 열 개수*/
	}

	void setContent(int row, int col, char str[])
	{
		/*(row, col) 에 위치한 셀의 내용을 str[] 로 설정한다.

		str[] 는 영어 소문자로 구성되며, ‘＼0’ 로 끝나고 ‘＼0’ 을 포함한 전체 길이는 3 이상 11 이하이다.

		각각의 인자 값의 범위는 아래와 같다.
		   1 ≤ row ≤ R
		   1 ≤ col ≤ C

		Parameters
		   row : 행 위치
		   col : 열 위치
		   str[] : 셀의 내용으로 설정할 문자열*/
	}

	void getContent(int row, int col, char str[])
	{
		str[0] = '\0';
		/*(row, col) 에 위치한 셀의 내용을 str[] 에 저장한다.

		str[] 은 반드시 ‘＼0’ 로 끝나야 한다.

		각각의 인자 값의 범위는 아래와 같다.
		   1 ≤ row ≤ R
		   1 ≤ col ≤ C

		Parameters
		   row : 행 위치
		   col : 열 위치
		   str[] : 셀의 내용을 저장하는 배열*/
	}

	void mergeCell(int row1, int col1, int row2, int col2, int opt)
	{
		/*(row1, col1) 에 위치한 셀과 (row2, col2) 에 위치한 셀을 병합하고, 병합된 셀의 내용을 opt 에 따라 변경한다.

		opt = 1 일 경우, 병합된 셀의 내용은 (row1, col1) 에 위치한 셀의 내용으로 변경된다.

		opt = 2 일 경우, 병합된 셀의 내용은 (row2, col2) 에 위치한 셀의 내용으로 변경된다.

		(row1, col1) 에 위치한 셀과 (row2, col2) 에 위치한 셀은 서로 다른 셀이다.

		(row1, col1) 에 위치한 셀과 (row2, col2) 에 위치한 셀은 인접해 있음이 보장된다.

		각각의 인자 값의 범위는 아래와 같다.
		   1 ≤ row1, row2 ≤ R
		   1 ≤ col1, col2 ≤ C
		   1 ≤ opt ≤ 2

		Parameters
		   row1, col1 : 병합하는 첫번째 셀이 있는 행과 열 위치
		   row2, col2 : 병합하는 두번째 셀이 있는 행과 열 위치
		   opt : 병합된 셀의 내용을 선택하기 위한 값*/
	}

	int countCell(char str[])
	{
		return 0;
		/*표에 있는 모든 셀 중에서 내용이 str[] 인 셀의 개수를 리턴한다.
		
		str[] 는 영어 소문자로 구성되며, ‘＼0’ 로 끝나고 ‘＼0’ 을 포함한 전체 길이는 3 이상 11 이하이다.

		Parameters
		   str[] : 개수를 세려고 하는 셀의 내용

		Returns
		   내용이 str[] 인 셀의 개수*/
	}

	int countArea(char str[])
	{
		return 0;
		/*표에 있는 모든 셀 중에서 내용이 str[] 인 셀들의 넓이의 총 합을 리턴한다.

		str[] 는 영어 소문자로 구성되며, ‘＼0’ 로 끝나고 ‘＼0’ 을 포함한 전체 길이는 3 이상 11 이하이다.

		Parameters
		   str[] : 총 넓이를 계산하려고 하는 셀의 내용

		Returns
		   내용이 str[] 인 셀들의 넓이의 총 합*/
	}
}