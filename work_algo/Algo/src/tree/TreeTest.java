package tree;

class Tree{
	class Node{ //중첩클래스(private가 붙어도 동일) : 원래는 이벤트 핸들러 등으로 outer클래스 내부에서 쓰려고 만든것
				//멤버변수, 멤버메소드가 outer클래스객체.으로 접근하는것과 같인 멤버클래스는  outer클래스객체.으로 접근한다.
				//1. tree.Tree.Node를 import하거나 
		char data;
		Node left, right;
	}
	Node root;

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	
	public Node makeTree(Node left, char data, Node right) {
		Node node = new Node();
		node.data = data;
		node.left = left;
		node.right = right;
		return node;
	}
	public void preorder(Node node) {
		if(node!=null) {
			System.out.print(node.data+" ");
			preorder(node.left);
			preorder(node.right);
		}
	}
	public void inorder(Node node) {
		if(node!=null) {
			inorder(node.left);
			System.out.print(node.data+" ");
			inorder(node.right);
		}
	}
	public void postorder(Node node) {
		if(node!=null) {
			postorder(node.left);
			postorder(node.right);
			System.out.print(node.data+" ");
		}
	}
}

public class TreeTest { //이 클래스에서 객체를 생성하므로 위 클래스들이 static이 아니다.
	public static void main(String[] args) {
/*		Tree o = new Tree(); //outer클래스 객체 생성
		Tree.Node n1 = o.new Node(); //내부클래스 객체 생성
		n1.data = 'A';
		n1.left = null;
		n1.right = null;
		
		Tree.Node n2 = new Tree().new Node();
		n2.data = 'B';
		n2.left = null;
		n2.right = null;*/ //클래스 구조 설명
		
/*		Tree t=new Tree();
		Tree.Node d = t.makeTree(null, 'D', null); //2. Node가 아니고 Tree.Node라고 명시한다. 
		Tree.Node h = t.makeTree(null, 'H', null);
		Tree.Node i = t.makeTree(null, 'I', null);
		Tree.Node f = t.makeTree(null, 'F', null);
		Tree.Node g = t.makeTree(null, 'G', null);
		
		Tree.Node e = t.makeTree(h, 'E', i);
		Tree.Node b = t.makeTree(d, 'B', e);
		Tree.Node c = t.makeTree(f, 'C', g);
		
		Tree.Node a = t.makeTree(b, 'A', c);
		t.setRoot(a);
		
		Tree.Node r = t.getRoot();
		t.preorder(r);
		System.out.println();
		t.inorder(r);
		System.out.println();
		t.postorder(r);
		System.out.println();*/
		Tree t=new Tree();
		Tree.Node h = t.makeTree(null, 'H', null);
		Tree.Node i = t.makeTree(null, 'I', null);
		Tree.Node j = t.makeTree(null, 'J', null);
		Tree.Node k = t.makeTree(null, 'K', null);
		Tree.Node l = t.makeTree(null, 'L', null);
		Tree.Node m = t.makeTree(null, 'M', null);
		
		Tree.Node d = t.makeTree(h, 'D', i);
		Tree.Node e = t.makeTree(j, 'E', null);
		Tree.Node f = t.makeTree(null, 'F', k);
		Tree.Node g = t.makeTree(l, 'G', m);
		
		Tree.Node b = t.makeTree(d, 'B', e);
		Tree.Node c = t.makeTree(f, 'C', g);
		
		Tree.Node a = t.makeTree(b, 'A', c);
		t.setRoot(a);
		
		Tree.Node r = t.getRoot();
		t.preorder(r);
		System.out.println();
		t.inorder(r);
		System.out.println();
		t.postorder(r);
		System.out.println();
		

	}

}
