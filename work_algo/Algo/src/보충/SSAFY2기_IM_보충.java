package 보충;
import java.util.Arrays;
/**
 * IM 소검 시험 범위
 *	for문 i 변수 관리
 *	배열의 index 관리
 *	API 사용
 *	문자열
 */
public class SSAFY2기_IM_보충 {
	public static void main(String[] args) {
// 1. arr 배열에  key 값이 존재하는가? 있음/없음 출력
		int[] arr = {4,6,2,1,5,3};
//		int key = 1; // 있음
		int key = 10; // 없음
		// 코드작성 해주세요
		boolean check=false;
		for(int a: arr) {
			if(key==a) {
				check = true;
				break;
			}
		}
/*		if(check==false) System.out.println("없음");
		else System.out.println("있음");*/
		System.out.println(check?"있음":"없음"); //위두줄을 한줄로
		//
		int x; //i를 꺼내서 중간에 break되었는지 여부를 확인할수도 있긴함 
		for(x=0; x< arr.length; x++) {
			if(arr[x]==key) {
				break;
			}
		}
		System.out.println(x == arr.length?"없음":"있음");
// 2. brr 배열에 최대값을 출력하시오 6
// 3. brr 배열에 최소값을 출력하시오 1
		int[] brr = {4,1,6,2,1,5,6,3};
		// 코드작성 해주세요
		//초기값 중요
		int max = Integer.MIN_VALUE; //비교하는 모든 대상보다 작아야
		//int max = brr[0]; //또는 비교하고자 하는 원소들 중 하나의 값 
		for(int i=0; i<brr.length; i++) {
			if(max<brr[i]) {
				max = brr[i];
			}
		}
		System.out.println(max);
// 4. crr 배열의 모든 원소 합을 출력하시오
		int[] crr = {4,6,2,1,5,3}; // 21
		// 코드작성 해주세요
		int sum = 0; //초기값==연산자에 대한 항등원
		for(int i=0;i<crr.length;i++) {
			sum += crr[i];
		}
		System.out.println(sum);
// 5. drr 배열에서 ki 값이 몇회 나오는가?
		int[] drr = {2,4,1,2,3,2,3,2,5,2};
		int ki = 2;
		// 코드작성 해주세요
		int cnt =0;
		for(int d: drr) {
			if(ki==d) {
				cnt++;
			}
		}
		System.out.println(cnt);
// 6. 정렬 
		//카운팅 > 퀵 , 병합 -> 빠름
		//카운팅 정렬은 구현할 수 있어야 함!!!!
		//삽입(priority큐), 선택(최소값찾을때), 버블 
		int[] err = {4,6,2,1,5,3};
		// 코드작성 해주세요
		Arrays.sort(err); //1차원 배열 원소를 정렬, 오름차순, 이거 빠름(듀얼피봇퀵)
		System.out.println(Arrays.toString(err));
		 
// 7. frr 배열에서 사용된 숫자들을 오름차순으로 출력하시오
		int[] frr = {9,4,1,4,5,9,1,5,1,3,9}; //1 3 4 5 9
		// 코드작성 해주세요
		Arrays.sort(frr);
		System.out.println(Arrays.toString(frr));
		//중복 제거하기
		int value = frr[0]-1; //초기값 //첫번째 원소가 아닌 다른 값
		for(int i=0; i<frr.length;i++) {
			if(value != frr[i]) { //다른 새로운 값이 나오면 출력
				System.out.print(frr[i]+" ");
				value = frr[i]; //새로운 값으로 업데이트 
			}
		}
		System.out.println();
// 8. API 활용
		int[] grr = {4,6,2,1,5,3};
		int ke = 3;
		System.out.println(Arrays.toString(grr));
		Arrays.sort(grr);
		System.out.println(Arrays.toString(grr));
		System.out.println(Arrays.binarySearch(grr,ke)); //이진 검색은 정렬된 배열에서만 사용할 수 있다!
		//ke값의 인덱스를 출력
		
		//String[] srr = str.split("[]");
		//StringTokenizer st = new StringTokenizer(str, "!.?"); //더빠름 -> while(st.hasmoreTokens())
	}
}