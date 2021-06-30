package stack;

import java.util.Stack;

class SpecialStackConstantSpace {
	
	int min;
	
	public void push(Stack<Integer> stack, int element) {
		
		if(isEmpty(stack)) {
			stack.push(element);
			min = element;
			return;
		}
		if(element < min) {
			stack.push(2*element - min);	
			min = element;
		}
		else {
			stack.push(element);
		}
	}

	public int pop(Stack<Integer> stack) {
		
		if(isEmpty(stack))
			return -1;
		
		if(stack.peek() < min) {
			min = 2*min - stack.peek();
			return stack.pop();
		}
		else
			return stack.pop();
	}

	public int min(Stack<Integer> stack) {
		return min;
	}

	public boolean isEmpty(Stack<Integer> stack) {
		return stack.isEmpty();

	}
}

public class MinStackWithConstantSpace {

	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<>();
		SpecialStackConstantSpace myStack = new SpecialStackConstantSpace();
		
		myStack.push(stack, 10);
		myStack.push(stack, 20);
		myStack.push(stack, 5);
		
		myStack.pop(stack);

		System.out.println(myStack.min(stack));
	}
}
