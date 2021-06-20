package stack.implementation;

public class StackUsingLinkedList 
{
	static class Node 
	{ 
		int data;
		Node next;
		Node(int data) {
			this.data = data;
			this.next = null;
		}		
	}
	
	Node top;
	
	boolean isEmpty() {
		return top == null;
	}
	
	void push(int data)
	{
		Node newNode = new Node(data);
		
		if(isEmpty())
			top = newNode;
		else {
			newNode.next = top;
			top = newNode;
		}
		System.out.println(data + " inserted");
	}
	
	int peek() 
	{
		int peek = Integer.MIN_VALUE;
		
		if(isEmpty())
			System.out.println("Stack is empty");
		else
			peek = top.data;
		
		return peek;
	}
	
	int pop() 
	{
		int pop = Integer.MIN_VALUE;
		
		if(isEmpty())
			System.out.println("Stack is empty");
		else {
			pop = top.data;
			top = top.next;
		}
		
		return pop;
	}
}
