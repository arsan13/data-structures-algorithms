package binarySearch;

/*
 * Given number of pages in n different books and m students. 
 * The books are arranged in ascending order of number of pages.
 * Every student is assigned to read some consecutive books.
 * The task is to assign books in such a way that the maximum number of pages assigned to a student is minimum.
 */
public class AllocateMinimumPages {

	// O(NlogN) Time
	private static int minPages(int arr[], int m) {
		if(arr.length < m)
			return -1;
		
		// Set range: low as maximum of array and high as sum of the given array. 
		int low = arr[arr.length - 1];
		int high = 0;
		for (int val : arr) {
			high += val;
		}

		int res = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (isPossible(arr, m, mid)) {
				res = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return res;
	}

	private static boolean isPossible(int[] arr, int m, int res) {
		int countOfStudents = 1;
		int pages = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > res)
				return false;
			
			if (pages + arr[i] > res) {
				countOfStudents++;
				pages = arr[i];
			} else {
				pages += arr[i];
			}
		}

		if (countOfStudents > m)
			return false;
		return true;
	}

	public static void main(String[] args) {

		int pages[] = { 12, 34, 67, 90 }; // Number of pages of the i-th book
		int m = 2; // number of students

		System.out.println(minPages(pages, m));
	}

}
