package linkedList;

public class StartNodeOfCycle {
	
	private static Node getStartNode(Node head) {
		Node meet = getMeetPoint(head);
		Node start = head;
		
		while(start != meet) {
			start = start.next;
			meet = meet.next;
		}
		
		return meet;
	}
	
	private static Node getMeetPoint(Node head) {
		if(head == null) {
			return head;
		}
		
		Node fast = head;
		Node slow = head;
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			
			if(slow == fast) {
				return slow;
			}
		}
		
		return null;
	}
	
	public static void main(String[] args) {

		Node head;
		Node tail;
		
		head = tail = new Node(10);
		Node node = new Node(20);
		tail.next = node;			tail = tail.next;
		tail.next = new Node(30);	tail = tail.next;
		tail.next = new Node(40);	tail = tail.next;
		tail.next = new Node(50);	tail = tail.next;
		tail.next = node;			tail = tail.next;
				
//		10 - 20 - 30 - 40
//				\	  /
//				  50
		System.out.println(getStartNode(head).data);
	}
}
