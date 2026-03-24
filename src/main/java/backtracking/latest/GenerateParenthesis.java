package backtracking.latest;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParenthesis {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
//        generateParenthesis(n, "", res);
        generateParenthesisOptimized(n, n, "", res);
        return res;
    }

    private static void generateParenthesisOptimized(int open, int close, String str, List<String> res) {
        if (open == 0 && close == 0) {
            res.add(str);
            return;
        }

        if (open > 0) {
            generateParenthesisOptimized(open - 1, close, str + "(", res);
        }
        if (close > open) {
            generateParenthesisOptimized(open, close - 1, str + ")", res);
        }
    }

    private static void generateParenthesis(int n, String str, List<String> list) {
        if (str.length() == (2 * n)) {
            if (isValidParenthesis(str)) {
                list.add(str);
            }
            return;
        }

        generateParenthesis(n, str.concat("("), list);
        if (!str.isEmpty()) {
            generateParenthesis(n, str.concat(")"), list);
        }
    }

    private static boolean isValidParenthesis(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(')');
                }
            }
        }
        return stack.isEmpty();
    }
}
