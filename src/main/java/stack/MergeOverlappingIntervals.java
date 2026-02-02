package stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class MergeOverlappingIntervals {

	private static void merge(List<Interval> list) {
		if (list.isEmpty())
			return;

		// Sort Interval based on start time.
		Collections.sort(list, (a, b) -> a.start - b.start);

		Stack<Interval> stack = new Stack<>();
		stack.push(list.get(0));

		for (int i = 1; i < list.size(); i++) {
			Interval item = stack.peek();

			if (item.end < list.get(i).start) {  		// No overlap
				stack.push(list.get(i));
			} else if (item.end < list.get(i).end) {    // Overlapping intervals
				item.end = list.get(i).end;
				stack.pop();
				stack.push(item);
			}
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	public static void main(String[] args) {

		List<Interval> list = new ArrayList<>();
		list.add(new Interval(6, 8));
		list.add(new Interval(1, 9));
		list.add(new Interval(2, 4));
		list.add(new Interval(10, 14));

		merge(list);
	}

	private static class Interval {
		int start;
		int end;

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public String toString() {
			return "[" + start + ", " + end + "]";
		}
	}
}
