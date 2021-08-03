package stack;

import java.util.Stack;

public class HistogramMatrix {

	public static void main(String[] args) {

		int n = 4, m = 4;
		int M[][] = { { 0, 1, 1, 0 }, 
					  { 1, 1, 1, 1 }, 
					  { 1, 1, 1, 1 }, 
					  { 1, 1, 0, 0 } };

		int hist[] = new int[m];
		int maxArea = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (M[i][j] == 0) {
					hist[j] = 0;
				} else {
					hist[j] += 1;
				}
			}
			maxArea = Math.max(maxArea, getHistArea(hist, m));
		}

		System.out.println(maxArea);
	}

	private static int getHistArea(int[] hist, int n) {
		int[] nsr = nsr(hist, n);
		int[] nsl = nsl(hist, n);

		int width = 0;
		int area = 0;
		for (int i = 0; i < n; i++) {
			width = nsr[i] - nsl[i] - 1;
			area = Math.max(area, width * hist[i]);
		}

		return area;
	}

	private static int[] nsr(int[] hist, int n) {
		Stack<Integer> stack = new Stack<>();
		int result[] = new int[n];

		for (int i = n - 1; i >= 0; i--) {
			while (!stack.isEmpty() && hist[stack.peek()] >= hist[i])
				stack.pop();
			result[i] = stack.isEmpty() ? hist.length : stack.peek();
			stack.push(i);
		}

		return result;
	}

	private static int[] nsl(int[] hist, int n) {
		Stack<Integer> stack = new Stack<>();
		int result[] = new int[n];

		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && hist[stack.peek()] >= hist[i])
				stack.pop();
			result[i] = stack.isEmpty() ? -1 : stack.peek();
			stack.push(i);
		}

		return result;
	}

}
