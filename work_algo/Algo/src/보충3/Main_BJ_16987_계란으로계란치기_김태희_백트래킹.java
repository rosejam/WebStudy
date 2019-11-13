package 보충3;
import java.util.Scanner;

public class Main_BJ_16987_계란으로계란치기_김태희_백트래킹 {

	static int N;
	static int[] S, W;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = new int[N];
		W = new int[N];
		for (int i = 0; i < N; ++i) {
			S[i] = sc.nextInt();
			W[i] = sc.nextInt();
		}
		System.out.println(bump(0,0));
	}
	private static int bump(int order, int breakCount) {
		int max = 0;
		
		if (order == N) return breakCount; // 마지막 계란까지 다 처리했다면 그 때까지 깬 갯수 리턴
		if (S[order] <= 0 ) return bump(order + 1, breakCount); // 현계란이 깨졌거나, 현계란을 제외한 다른 계란이 다 깨져있다면 다음 계란으로
        if (breakCount == N - 1) return breakCount;

		for (int i = 0; i < N; ++i) {
			if (i == order || S[i] <= 0) continue; // 현 계란과 깨진 계란은 건너뜀
			S[order] -= W[i]; // 현 계란의 내구도 상대계란 무게만큼 차감
			S[i] -= W[order];// 상대 계란의 내구도 현계란 무게만큼 차감

			max = Math.max(max,bump(order + 1, breakCount + (S[order] <= 0 ? 1 : 0) + (S[i] <= 0 ? 1 : 0)));

			S[order] += W[i];
			S[i] += W[order];
		}
		return max;
	}
	
	
	
	
	
	
	
	
	
	
}