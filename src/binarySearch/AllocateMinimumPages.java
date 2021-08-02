package binarySearch;

/* 
 * Given number of pages in n different books and m students. 
 * Every student is assigned to read some consecutive books.
 * The of number of pages of the book may or may not be in sorted order.
 * The task is to assign books in such a way that the maximum number of pages assigned to a student is minimum.
 */
public class AllocateMinimumPages {

	// O(NlogN) Time
	private static int minPages(int arr[], int m) {
		if(arr.length < m)
			return -1;
		
		// SET RANGE: low as maximum of array and high as sum of the given array. 
		int low = 0; 
		int high = 0;
		for (int val : arr) {
			low = Math.max(low, val);
			high += val;
		}

		int res = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;	//mid is the maximum number of pages a student can read.

			if (isPossible(arr, m, mid)) {  
				res = mid;		//Update possible answer in the result.
				high = mid - 1;	//Try to minimize maximum number of pages a student can read.
			} else {	//Increase maximum number of pages a student can read if current capacity is not enough for m students. 
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

		return (countOfStudents <= m);
	}

	public static void main(String[] args) {

		int pages[] = { 12, 34, 67, 90 }; // Number of pages of the i-th book
		int m = 2; // number of students

		System.out.println(minPages(pages, m));
	}

}
