package greedy;

import java.util.Arrays;

/*
 * You are given n activities with their start and finish times. 
 * Select the maximum number of activities that can be performed by a single person, 
 * assuming that a person can only work on a single activity at a time. 
 */
public class ActivitySelection {

	static class Pair implements Comparable<Pair> {
		int start;
		int end;

		public Pair(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Pair that) {
			if (this.end - that.end == 0)
				return this.start - that.start;
			return this.end - that.end;
		}

		@Override
		public String toString() {
			return "Pair [start=" + start + ", end=" + end + "]";
		}
	}

	public static int maxMeetings(int start[], int end[], int n) {
		int count = 1; // since, first meeting always gets selected
		Pair[] pair = new Pair[n];

		// 1. Create pair
		for (int i = 0; i < n; i++) {
			pair[i] = new Pair(start[i], end[i]);
		}

		// 2. Sort Pairs
		Arrays.sort(pair);

		// 3. Compare pairs
		int i = 0;
		for (int j = 1; j < n; j++) {
			if (pair[i].end < pair[j].start) {
				count++;
				i = j;
			}
		}

		return count;
	}

	public static void main(String[] args) {

		int N = 6;
		int S[] = { 1, 3, 0, 5, 8, 5 };
		int F[] = { 2, 4, 6, 7, 9, 9 };

		System.out.println(maxMeetings(S, F, N));
	}

}
