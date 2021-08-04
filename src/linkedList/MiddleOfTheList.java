package linkedList;

public class MiddleOfTheList {

	private static int reverseList(Node head) {
		if(head == null) {
			return -1;
		}
		
		Node fast = head;
		Node slow = head;
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		return slow.data; 
	}
	
	public static void main(String[] args) {

		Node head;
		Node tail;
		
		head = tail = new Node(10);
		tail.next = new Node(20);	tail = tail.next;
		tail.next = new Node(30);	tail = tail.next;
		tail.next = new Node(40);	tail = tail.next;
		tail.next = new Node(50);	tail = tail.next;
		
		HelperClass obj = new HelperClass();
		
		obj.printList(head);
		int res = reverseList(head);
		System.out.println(res);
	}
}
