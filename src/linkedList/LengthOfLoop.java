package linkedList;

// Find the number of elements in the loop.
public class LengthOfLoop {

	private static int lengthOfLoop(Node head) {
		if(head == null) {
			return 0;
		}
		
		Node fast = head;
		Node slow = head;
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			
			if(slow == fast) {
				return getCountInLoop(slow);
			}
		}
		
		return 0;
	}
	
	private static int getCountInLoop(Node slow) {
		int count = 1;
		
		Node end = slow;
		while(slow.next != end) {
			slow = slow.next;
			count++;
		}
		
		return count;
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
		System.out.println(lengthOfLoop(head));
	}
}
