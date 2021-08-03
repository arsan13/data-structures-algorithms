package stack;

import java.util.Stack;

class Queue {
	private Stack<Integer> pushStack, popStack;

	public Queue() {
		pushStack = new Stack<>();
		popStack = new Stack<>();
	}

	public boolean isEmpty() {
		return pushStack.isEmpty() && popStack.isEmpty();
	}

	public void enqueue(int data) {
		pushStack.push(data);
	}

	public int dequeue() {
		if (isEmpty()) {
			System.out.println("Queue Underflow");
			return -1;
		}

		int data = -1;
		if (popStack.isEmpty()) {
			while (!pushStack.isEmpty()) {
				popStack.push(pushStack.pop());
			}
			data = popStack.pop();
		}

		while (!popStack.isEmpty()) {
			pushStack.push(popStack.pop());
		}
		return data;
	}
}

public class QueueUsingStack {
	
	public static void main(String args[]) {
		Queue obj = new Queue();
		
		obj.enqueue(10);
		obj.enqueue(30);
		obj.enqueue(50);
		obj.enqueue(20);
		
		System.out.println(obj.dequeue());
		System.out.println(obj.dequeue());
	}
}