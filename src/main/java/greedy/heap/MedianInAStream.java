package greedy.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

//Find median in a running stream of integers.
class MedianFinder {
	List<Integer> list;
	PriorityQueue<Integer> maxHeap; // contains first half of the elements
	PriorityQueue<Integer> minHeap; // contains second half of the elements

	public MedianFinder() {
		list = new ArrayList<>();
		maxHeap = new PriorityQueue<>((a, b) -> b - a);
		minHeap = new PriorityQueue<>((a, b) -> a - b);
	}

	// O(logN) Time
	public void insert(int num) {
		// max-heap contains the elements with value less than the median and
		// min-heap contains values greater than the median.
		if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
			maxHeap.add(num);
		} else {
			minHeap.add(num);
		}

		// Either both heaps will have equal number of elements(even number of elements) or
		// max-heap will have one more element than the min-heap(odd number of elements).
		if (maxHeap.size() > minHeap.size() + 1) {
			minHeap.add(maxHeap.poll());
		} else if (minHeap.size() > maxHeap.size()) {
			maxHeap.add(minHeap.poll());
		}

		// Just to print all the inserted elements
		list.add(num);
		System.out.println(list);
	}

	// O(1) Time
	public double getMedian() {
		//In case of even number of elements, median will be average of two middle elements.
		if (maxHeap.size() == minHeap.size()) {
			return (double)(maxHeap.peek() + minHeap.peek()) / 2;
		}
		//In case of odd number of elements, median will be peek element of max-heap.
		return maxHeap.peek();
	}
}

public class MedianInAStream {

	public static void main(String[] args) {

		MedianFinder obj = new MedianFinder();
		Scanner in = new Scanner(System.in);

		boolean flag = true;
		while (flag) {
			System.out.println("1. Insert element \t  2. Find Median \t 3. Exit");
			int choice = in.nextInt();

			switch (choice) {
				case 1:
					System.out.println("Enter the element");
					int n = in.nextInt();
					obj.insert(n);
					break;
				case 2:
					System.out.println("Median = " + obj.getMedian());
					break;
				case 3:
					System.out.println("Bye!");
					flag = false;
					break;
				default:
					System.out.println("Invalid input");
					break;
			}
		}
	}

}
