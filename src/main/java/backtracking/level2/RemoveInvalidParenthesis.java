package backtracking.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemoveInvalidParenthesis {

	private static void removeInvalidParenthesis(String str) {
		
		List<String> ans = new ArrayList<>();
		int minRemovals = getMinRemoval(str);
		
		removeParenthesis(str, minRemovals, ans);
		
		System.out.println(ans);
	}
	
	private static void removeParenthesis(String str, int minRemovals, List<String> ans) {
		
		if(minRemovals == 0) {
			if(getMinRemoval(str.toString()) == 0) {
				if(!ans.contains(str))
					ans.add(str);
			}
			return;
		}
		
		for (int i = 0; i < str.length(); i++) {	// Remove i'th element, use String builder to optimise
			String left = str.substring(0, i);
			String right = str.substring(i + 1);
			removeParenthesis(left + right, minRemovals - 1, ans);
		}
	}

	private static int getMinRemoval(String str) {
		Stack<Character> stack = new Stack<>();
		
		for(char ch : str.toCharArray()) {
			if(ch == '(')
				stack.push(ch);
			else if( ch == ')') {
				if(stack.size() == 0 || stack.peek() == ')')
					stack.push(ch);
				else if(stack.peek() == '(')
					stack.pop();
			}
		}
		
		return stack.size();
	}

	public static void main(String[] args) {

		removeInvalidParenthesis("()())()");
		removeInvalidParenthesis("()a)");
	}
}
