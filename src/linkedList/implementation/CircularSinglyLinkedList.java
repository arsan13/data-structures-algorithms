package linkedList.implementation;

public class CircularSinglyLinkedList {
	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	Node tail;

	boolean isEmpty() {
		return tail == null;
	}

	public void addFirst(int data) {
		Node newNode = new Node(data);

		if (isEmpty()) {
			tail = newNode;
			tail.next = tail;
			return;
		}

		newNode.next = tail.next;
		tail.next = newNode;
	}

	public void addLast(int data) {
		Node newNode = new Node(data);

		if (isEmpty()) {
			tail = newNode;
			tail.next = tail;
			return;
		}

		newNode.next = tail.next;
		tail.next = newNode;
		tail = newNode;
	}

	public void deleteFirst() {
		if (isEmpty())
			return;

		tail.next = tail.next.next;
	}

	public void deleteLast() {
		if (isEmpty()) {
			return;
		}

		Node temp = tail;
		while (temp.next != tail)
			temp = temp.next;

		temp.next = temp.next.next;
		tail = temp;
	}

	public boolean search(int data) {
		if (isEmpty()) {
			return false;
		}

		Node temp = tail.next;
		while (temp.next != tail.next) {
			if (temp.data == data)
				return true;
			temp = temp.next;
		}
		return false;
	}

	public void display() {
		if (isEmpty()) {
			System.out.println("Empty");
			return;
		}

		Node temp = tail.next;
		while (temp.next != tail.next) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
}
