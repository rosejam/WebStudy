package tree;

public class TreeArray {
	public static int N=13;
	public static char[] a;
	public static void preorder(int i) {
		if(i<=N && a[i]!=0) { //유니코드의 null='\u0000'=0 //배열의 인덱스가 범위내여야 한다 //노드가 널이 아니면
			System.out.print(a[i]+" ");
			preorder(2*i);
			preorder(2*i+1);
		}
	}
	public static void inorder(int i) {
		if(i<=N && a[i]!=0) { //유니코드의 null='\u0000'=0 //배열의 인덱스가 범위내여야 한다 //노드가 널이 아니면
			inorder(2*i);
			System.out.print(a[i]+" ");
			inorder(2*i+1);
		}
	}
	public static void postorder(int i) {
		if(i<=N && a[i]!=0) { //유니코드의 null='\u0000'=0 //배열의 인덱스가 범위내여야 한다 //노드가 널이 아니면
			postorder(2*i);
			postorder(2*i+1);
			System.out.print(a[i]+" ");
		}
	}
	public static void main(String[] args) {
		a = new char[N+1];
		for(int i=1; i<=N; i++) {
			a[i]=(char) ('A'+(i-1)); //i가 1부터 이므로 i-1사용
		}
		//System.out.println(Arrays.toString(a));
		preorder(1);
		System.out.println();
		inorder(1);
		System.out.println();
		postorder(1);
		System.out.println();
	}
}
