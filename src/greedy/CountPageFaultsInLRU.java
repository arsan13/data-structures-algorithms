package greedy;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class CountPageFaultsInLRU {

	private static int pageFaults(int[] pages, int capacity) {

		Deque<Integer> cache = new LinkedList<>();
		int res = 0;

		for (int page : pages) {

			if (!cache.contains(page)) {
				if (cache.size() == capacity) {
					cache.removeLast();
					cache.addFirst(page);
				} else {
					cache.addFirst(page);
				}
				res++;
			} else {
				cache.remove(page);
				cache.addFirst(page);
			}
		}

		return res;
	}

	public static void main(String[] args) {

		int pages[] = { 7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2 };
		int capacity = 4;

		System.out.println(pageFaults(pages, capacity));
	}
}
