package bitManipulation;

/*Given an unsorted array Arr of size N of positive integers. 
One number 'A' from set {1, 2, …N} is missing and one number 'B' occurs twice in array. 
Find these two numbers.*/
public class MissingAndRepeatingNumber {

	public static int[] findTwoElement(int arr[], int n) {

		int res[] = new int[2];
		int xor = 0;

		for (int i = 0; i < n; i++)
			xor ^= arr[i];

		for (int i = 1; i <= n; i++)
			xor ^= i;

		xor = xor & -xor;

		int x = 0;
		int y = 0;
		for (int i = 0; i < n; i++) {
			if ((arr[i] & xor) == 0)
				x ^= arr[i];
			else
				y ^= arr[i];
		}
		for (int i = 1; i <= n; i++) {
			if ((i & xor) == 0)
				x ^= i;
			else
				y ^= i;
		}

		for (int i = 0; i < n; i++) {
			if (arr[i] == x) {
				res[0] = x;
				res[1] = y;
				break;
			} else if (arr[i] == y) {
				res[0] = y;
				res[1] = x;
				break;
			}
		}

		return res;
	}

	public static void main(String[] args) {

		int[] arr = { 1, 3, 2, 3, 5, 6 };
		int[] res = findTwoElement(arr, arr.length);
		
		System.out.println("Repeating: "+ res[0]);
		System.out.println("Missing: "+ res[1]);
	}

}
