package backtracking.level1;

// Check if the array is sorted.
public class SortedArrayCheck {

	private static boolean isSorted(int[] arr, int index) {
		if (index == arr.length - 1)
			return true;
		if (arr[index] <= arr[index + 1])
			return isSorted(arr, index + 1);
		
		return false;
	}

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5 };
		System.out.println(isSorted(arr, 0));
	}
}
