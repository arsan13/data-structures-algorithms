package greedy;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class CountPageFaultsInLRU {

	private static int pageFaults(int[] pages, int capacity) {

		Set<Integer> set = new HashSet<>();
		Deque<Integer> cache = new LinkedList<>();
		int res = 0;

		for (int page : pages) {

			if (!set.contains(page)) {
				if (set.size() == capacity) {
					int temp = cache.getLast();
					set.remove(temp);
					set.add(page);
					cache.removeLast();
					cache.addFirst(page);
				}
				else {
					set.add(page);
					cache.addFirst(page);
				}
				res++;
			} 
			else {
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
