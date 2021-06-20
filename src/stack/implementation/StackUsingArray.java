package stack.implementation;

public class StackUsingArray {
	
	int arr[], size, top;

	public StackUsingArray( int n) {
		this.size = n;
		arr = new int[size];
		top = -1;
	}

	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == size -1 ;
	}
	
	public void push(int data) 
	{
		if(isFull()) {
			System.out.println("Stack is full! Insertion not possible ");
		}
		else {
			top++;
			arr[top] = data;
//			System.out.println(data + " inserted");
		}
	}
	
	public int peek() 
	{
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return -1;
		}
		else
			return arr[top];
	}
	
	public int pop()
	{
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return -1;
		}
		else {
			return arr[top--];
		}
	}
	
	public void display() 
	{
		if(isEmpty()) 
			System.out.println("Stack is empty");
		else {
			for(int i = 0; i <= top; i++)
				System.out.print(arr[i] + " ");
			System.out.println();
		}
	}
}
