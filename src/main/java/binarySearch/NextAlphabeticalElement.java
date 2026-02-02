package binarySearch;

//Find the next alphabetical/greatest element of the given alphabet present in the sorted array.
//Alphabets should be considered in circular manner. 'a' can come after z.
public class NextAlphabeticalElement {

	private static char nextLetter(char[] letters, char target) {
		int low = 0;
		int high = letters.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (letters[mid] <= target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return letters[low % letters.length];
	}

	public static void main(String[] args) {

		char key = 'a';
		char[] letters = { 'c', 'f', 'j' };
		System.out.println(nextLetter(letters, key));
	}

}
