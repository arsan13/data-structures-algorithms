package backtracking.level2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {

	private static void validParenthesisNaive(int currSpot, int totalSpots, String ans) {

		if (currSpot == totalSpots) {
			if (isBalanced(ans))
				System.out.print(ans + "  ");
			return;
		}

		validParenthesisNaive(currSpot + 1, totalSpots, ans + '(');

		if (currSpot != 0)
			validParenthesisNaive(currSpot + 1, totalSpots, ans + ')');
	}

	private static boolean isBalanced(String str) {
		Stack<Character> stack = new Stack<>();

		for (char ch : str.toCharArray()) {
			if (ch == '(')
				stack.push(ch);
			else if (ch == ')') {
				if (stack.size() == 0 || stack.peek() == ')')
					stack.push(ch);
				else if (stack.peek() == '(')
					stack.pop();
			}
		}

		return stack.size() == 0;
	}

	private static void validParenthesisEfficient(int n) {

		int open = n;
		int close = n;
		String ans = "";

		recursive(close, open, ans);
	}

	private static void recursive(int open, int close, String ans) {

		if (open == 0 && close == 0) {
			System.out.print(ans + "  ");
			return;
		}

		if (open > 0)
			recursive(open - 1, close, ans + '(');

		if (close > open)
			recursive(open, close - 1, ans + ')');
	}

	public static void main(String[] args) {

		int brackets = 2; // 2 open and 2 close

		validParenthesisNaive(0, 2 * brackets, "");
		System.out.println();
		validParenthesisEfficient(brackets);
	}
}
