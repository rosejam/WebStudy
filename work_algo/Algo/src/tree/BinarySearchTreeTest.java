package tree;

class BinarySearchTree{
	class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data=data;
		}
	}
	Node root;
	public Node search(Node root,int key) {
		if(root==null || root.data==key) return root; //root가 null이면 null 또는 key를 찾으면 root를 리턴ㄴ
		if(root.data > key) return search(root.left,key);
		return search(root.right,key);
	}
	public void insert(int data) { //루트 노드가 바뀔수도 있으므로
		root=insert(root,data);
	}
	private Node insert(Node root,int data) {
		if(root==null) { //쭉내려가다가 비워있으면 끼운다.
			root=new Node(data);
			return root;
		}
		if(data<root.data) {
			root.left=insert(root.left,data);
		}else if(data>root.data) {
			root.right=insert(root.right,data);
		}
		return root; //끝나면 올라와서 루트를 리턴한다.
	}
	public void delete(int data) { //루트 노드가 바뀔수도 있으므로
		root=delete(root,data);
	}
	private Node delete(Node root,int data) {
		if(root==null) return root;
		if(data<root.data) {
			root.left=delete(root.left,data);
		}else if(data>root.data) {
			root.right=delete(root.right,data);
		}else { //지울 노드에
			//자식이 없으면
			if(root.left==null && root.right==null) return null;
			
			//한쪽에 자식이 있으면
			else if(root.left==null) return root.right; //왼쪽 자식이 없으면 오른쪽 자식을 올려줌
			else if(root.right==null) return root.left;
			
			//양쪽에 자식이 있으면
			root.data=findMin(root.right); //오른쪽 서브트리에서 최소값을 찾아서 나에게 넣고 
			root.right=delete(root.right,root.data); //그 최소값을 가지고 있는 노드는 삭제
		}
		return root;
	}
	private int findMin(Node root) {
		int min=root.data;
		while(root.left!=null) {
			min=root.left.data;
			root=root.left;
		} //제일 왼쪽인 값이 최소값
		return min;
	}
	public void inorder() {
		inorder(root);
		System.out.println();
	}
	private void inorder(Node root) {
		if(root!=null) {
			inorder(root.left);
			System.out.print(root.data+" ");
			inorder(root.right);
		}
	}
}
/*
    4
  2    6  
 1  3 5  7    
*/
public class BinarySearchTreeTest {
	public static void main(String[] args) {
		BinarySearchTree t=new BinarySearchTree();
		t.insert(4);
		t.insert(2);
		t.insert(1);
		t.insert(3);
		t.insert(6);
		t.insert(5);
		t.insert(7);
		
		t.inorder();
		t.delete(5);
		t.delete(6);
		t.delete(2);
		t.delete(4);
		t.inorder();
	}
}
