package stack;

import java.util.Stack;

public class LargestAreaInHistogram {

    public static void main(String[] args) {
        int[] histo = {2, 1, 5, 6, 2, 3, 1};
        System.out.println("The largest area in the histogram is " + largestRectangleArea(histo));
    }

    private static int largestRectangleArea(int[] heights) {
        int n = heights.length;

        if(n == 1) {
            return heights[0];
        }

        int res = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                int index = stack.pop();
                int nse = i;
                int pse = stack.isEmpty() ? -1 : stack.peek();
                res = Math.max(res, heights[index] * (nse - pse - 1));
            }

            stack.push(i);
        }

        while(!stack.isEmpty()) {
            int index = stack.pop();
            int nse = heights.length;
            int pse = stack.isEmpty() ? -1 : stack.peek();
            res = Math.max(res, heights[index] * (nse - pse - 1));
        }

        return res;
    }
}
