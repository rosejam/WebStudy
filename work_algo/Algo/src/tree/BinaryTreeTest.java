package tree;

class BinaryTree{
	static class Node{ //static 붙인 이유 : 
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data=data;
		}
	}
	Node root;
	public void makeTree(int[] a) {
		root=makeTree(a,0,a.length-1); //makeTree시작(저 아래 트리 모양으로 만든다.)
	}
	public Node makeTree(int[] a,int start,int end) {
		if(start>end) return null;
		int mid=(start+end)/2;
		Node node=new Node(a[mid]);
		node.left=makeTree(a,start,mid-1);
		node.right=makeTree(a,mid+1,end);
		return node; //처음 돌면 여기서 root node를 리턴하는데 그전에 L/R을 붙이고 온다.
	}
	public void searchBTree(Node n,int find) {
		if(find<n.data) {
			System.out.println("Data is smaller than "+n.data);
			searchBTree(n.left,find);
		}else if(find>n.data) {
			System.out.println("Data is bigger than "+n.data);
			searchBTree(n.right,find);
		}else {
			System.out.println("Data found!");
		}
	}
}
/*
          4
   1           7
0    2       5   8
       3      6   9 
              
Data is bigger than 4
Data is bigger than 7
Data is bigger than 8
Data found!
       
*/
public class BinaryTreeTest {
	public static void main(String[] args) {
		//BinaryTree.Node n1 = new BinaryTree().new Node(7); //Node클래스에 static안 붙인 경우
		BinaryTree.Node n1 = new BinaryTree.Node(7); //Node클래스에 static붙인경우
		System.out.println(n1.data);
		
		int[] a=new int[10];
		for(int i=0; i<a.length; i++) a[i]=i;
		//int[] a= {10,12,21,33,44,52,69,73,88,91};
		
		BinaryTree t=new BinaryTree();
		t.makeTree(a);
		t.searchBTree(t.root, 9); //
	}
}
