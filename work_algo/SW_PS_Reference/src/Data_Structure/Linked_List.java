package Data_Structure;

import java.util.Scanner;


class ListNode {
	int data; //값
	ListNode prev; //링크
	ListNode next; //링크
	
	public ListNode()
	{
		data = 0;
		prev = this;
		next = this;
	}

	public static ListNode searchListNode(ListNode head, int data) //get
	{
		return null;
	}

	public static ListNode addtoFirstListNode(ListNode head, int data) //insert
	{
		return null;
	}

	public static ListNode addtoLastListNode(ListNode head, int data) //append
	{
		ListNode node = new ListNode();
		node.data = data;
		if (head == null)
		{
			head = node;
		}
		else 
		{
			ListNode last = head.prev;
			last.next = node;
			head.prev = node;
			node.prev = last;
			node.next = head;
		}
		return head;
	}

	public static ListNode addListNode(ListNode head, int data) //
	{
		return null;
	}

	public static void deleteListNode(ListNode head, ListNode node) //remove
	{
		if (head != head.next)
		{
			node.prev.next = node.next;
			node.next.prev = node.prev;
		}
		
	}
}
	

class Solution_Linked_List
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++)
		{
			ListNode head = null;
			int N = sc.nextInt();
			for (int i = 0; i < N; i++)
			{
				int data = sc.nextInt();
				head = ListNode.addtoLastListNode(head, data);
			}
			ListNode node = head;
			while(head != head.next)
			{
				ListNode nextNode = node.next;
				//head = ListNode.deleteListNode(head, node);
				node = nextNode.next.next;
			}
			System.out.printf("#%d %d\n", test_case, head.data);
		}
		sc.close();
	}
}