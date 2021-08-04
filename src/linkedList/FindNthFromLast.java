package linkedList;

// Find the value of nth node from the last of the linked list.
public class FindNthFromLast {

	// One pass algorithm
	private static int nthFromLast1(Node head, int n) {
		Node fast = head;
        Node slow = head;
        
        for (int i = 0; i < n; i++) {
        	fast = fast.next;
            if(fast.next == null) {
                return -1;
            }
        }
        
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        return slow.data;
	}
	
	// Two pass algorithm
	private static int nthFromLast2(Node head, int n) {
		Node dummy = new Node(0);
		dummy.next = head;
		Node node = head;
		int length = 0;
		
		while (node != null) {
			node = node.next;
			length++;
		}
		
		node = dummy;
		length = length - n + 1;
		while (length > 0) {
			length--;
			node = node.next;
		}
		
		return node.data;
	}
	
	public static void main(String[] args) {

		int n = 2;
		Node head;
		Node tail;
		
		head = tail = new Node(10);
		tail.next = new Node(20);	tail = tail.next;
		tail.next = new Node(30);	tail = tail.next;
		tail.next = new Node(40);	tail = tail.next;
		tail.next = new Node(50);	tail = tail.next;
		
		HelperClass obj = new HelperClass();
		
		obj.printList(head);
		int res = nthFromLast1(head, n);
		System.out.println(res);
		res = nthFromLast2(head, n);
		System.out.println(res);
	}
}
