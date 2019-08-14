package tree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Tr22{
	class Node{
		int data;
		Node left,right;
	}
	Node root;

	public void preorder(Node root) { //여기서 찍는 순서를 바꿀 수 있음
		if(root!=null) {
			System.out.print (root.data+" ");
			preorder(root.left);
			preorder(root.right);
		}
	}
	public void makeTree(int d1, int d2) {
		if(root==null) {
			root = new Node();
			root.data=d1;
		}
		makeTree(root, d1, d2);
	}
	public Node makeTree(Node root, int d1, int d2) { //프리오더 개념으로 가져다 붙임.
		if(root==null) {
			root = new Node();
			root.data = d2;
			return root;
		}
		if(root.data==d1) {
			if(root.left==null) 		root.left=makeTree(root.left, d1, d2);
			else if(root.right==null) 	root.right=makeTree(root.right, d1, d2);
			return root;
		}
		makeTree(root.left, d1, d2);
		makeTree(root.right, d1, d2);
		return root;
	}
}

public class TreePreorder {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/input_preorder.txt"));
		Scanner sc=new Scanner(System.in);
		int N = sc.nextInt();
		
		Tr22 t=new Tr22();
		for(int i=0; i<N-1; i++) {
			t.makeTree(sc.nextInt(),sc.nextInt());
		}
		t.preorder(t.root);
		sc.close();
	}

}
