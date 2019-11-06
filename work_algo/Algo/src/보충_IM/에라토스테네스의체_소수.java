package 보충_IM;

public class 에라토스테네스의체_소수 {
	public static void main(String[] args) {
		int N=120; //구하고자 하는 최대 수
		boolean[] V = new boolean[N+1]; //초기값은 false //N까지 이므로 N+1크기의 배열
		for(int i=2; i<=N; i++) {
			if(!V[i]) { //1.일단 출력 2.뒤 전부 순회하면서 배수들을 소수가 아니라고 체크 //V[i]==false
				System.out.print(i+" "); //1
/*				for(int j=i+1; j<=N; j++) { //j=i*2
					if(j%i==0) {
						V[j]=true;
					}
				}*/
				for(int j=i*2; j<=N; j+=i) { //배열의 인덱스를 벗어나기 전까지 i를 더해가면서 배수만 순회!!!!
					V[j]=true;
				}
			}
			//(true면 그냥 넘어감)
		}
	}
}
