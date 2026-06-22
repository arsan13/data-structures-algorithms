package stack;

import java.util.Stack;

public class DeleteMiddleElement {

	private static Stack<Integer> delete(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return stack;
		}

		int mid = stack.size() / 2 + 1;
		return deleteRec(stack, mid);
	}

	private static Stack<Integer> deleteRec(Stack<Integer> stack, int k) {
		if (k == 1) {
			stack.pop();
			return stack;
		}

		int temp = stack.pop();
		deleteRec(stack, k - 1);
		stack.push(temp);
		return stack;
	}

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);

		System.out.println(delete(stack));
	}

}
