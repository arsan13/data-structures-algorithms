package linkedList;

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}

public class HelperClass {
	public  void printList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + "  ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public  void printCLL(Node head) {
		Node temp = head;
		while (temp.next != head) {
			System.out.print(temp.data + "  ");
			temp = temp.next;
		}
		System.out.print(temp.data + "  ");
		System.out.println();
	}
}
