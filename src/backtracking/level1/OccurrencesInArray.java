package backtracking.level1;

import java.util.Arrays;

public class OccurrencesInArray {

	private static int getFirstOccurence(int target, int index, int[] arr, int n) {

		if (index == arr.length)
			return -1;

		if (arr[index] == target)
			return index;
		else {
			int getIndex = getFirstOccurence(target, index + 1, arr, n);
			return getIndex;
		}

	}

	private static int getLastOccurence(int target, int index, int[] arr, int n) {
		
		if(index == n)
			return -1;
		
		int lastIndex = getLastOccurence(target, index+1, arr, n);
		if(lastIndex == -1) {
			if(arr[index] == target)
				return index;
		}
		return lastIndex;
	}

	private static int[] getAllOccurrences(int target, int index, int count, int[] arr, int n) {

		if (index == n)
			return new int[count];

		if (arr[index] == target) {
			int res[] = getAllOccurrences(target, index + 1, count + 1, arr, n);
			res[count] = index;
			return res;
		} else {
			int res[] = getAllOccurrences(target, index + 1, count, arr, n);
			return res;
		}
	}

	public static void main(String[] args) {

		int[] arr = { 3, 4, 6, 4, 4, 8 };

		System.out.println("First: " + getFirstOccurence(4, 0, arr, arr.length));
		System.out.println("Last: " + getLastOccurence(4, 0, arr, arr.length));
		int[] res = getAllOccurrences(4, 0, 0, arr, arr.length);
		System.out.println("All: " + Arrays.toString(res));

	}
}
