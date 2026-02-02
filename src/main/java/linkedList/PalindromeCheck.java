package linkedList;

public class PalindromeCheck {

	private static boolean isPalindrome(Node head) {
		if (head == null)
			return true;

		Node middle = getMiddle(head);
		Node tail = reverse(middle);

		Node temp = head;
		while (tail != null) {
			if (temp.data != tail.data)
				return false;
			temp = temp.next;
			tail = tail.next;
		}

		return true;
	}

	private static Node getMiddle(Node head) {
		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	private static Node reverse(Node head) {
		Node following = head;
		Node current = head;
		Node previous = null;

		while (current != null) {
			following = current.next;
			current.next = previous;
			previous = current;
			current = following;
		}

		return previous;
	}

	public static void main(String[] args) {

		Node head;
		Node tail;

		head = tail = new Node(10);
		tail.next = new Node(20);
		tail = tail.next;
		tail.next = new Node(30);
		tail = tail.next;
		tail.next = new Node(20);
		tail = tail.next;
		tail.next = new Node(10);
		tail = tail.next;

		System.out.println(isPalindrome(head));
	}

}
