package stack;

import java.util.*;

/* Given an array of integers heights representing the histogram's bar height where the 
 * width of each bar is 1, return the area of the largest rectangle in the histogram.  
 */
public class Histogram {

	public static void main(String[] args) {

		long hist[] = { 6, 2, 5, 4, 5, 1, 6 };
		long n = hist.length;

		long rb[] = nsr(hist, n);
		long lb[] = nsl(hist, n);

		long width = 0;
		long area = 0;

		for (int i = 0; i < n; i++) {
			width = rb[i] - lb[i] - 1;
			area = Math.max(area, width * hist[i]);
		}

		System.out.println(area);

	}

	private static long[] nsr(long[] hist, long n) {

		Stack<Integer> stack = new Stack<>();
		long result[] = new long[(int) n];
		int k = (int) (n - 1);

		for (int i = (int) (n - 1); i >= 0; i--) {
			while (!stack.isEmpty() && hist[stack.peek()] >= hist[i])
				stack.pop();
			result[k--] = stack.isEmpty() ? hist.length : stack.peek();
			stack.push(i);
		}

		return result;
	}

	private static long[] nsl(long[] hist, long n) {

		Stack<Integer> stack = new Stack<>();
		long result[] = new long[(int) n];
		int k = 0;

		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && hist[stack.peek()] >= hist[i])
				stack.pop();
			result[k++] = stack.isEmpty() ? -1 : stack.peek();
			stack.push(i);
		}

		return result;
	}

	private static long[] test(long[] src, int n) {

		long res[] = new long[n];
		Stack<Long> stack = new Stack<>();

		res[src.length - 1] = -1;
		stack.push(src[n - 1]);
		for (int i = n - 2; i >= 0; i--) {
			while (!stack.isEmpty() && src[i] >= stack.peek()) {
				stack.pop();
			}
			if (stack.isEmpty())
				res[i] = -1;
			else
				res[i] = stack.peek();
			stack.push(src[i]);
		}
		return res;
	}

}
