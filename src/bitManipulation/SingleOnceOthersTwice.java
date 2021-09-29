package bitManipulation;

//Find the element that appears once in an array where every other element appears twice.
public class SingleOnceOthersTwice {
	
	private static int findSingle(int[] arr, int length) {
		int res = 0;
		for(int val : arr)
			res ^= val;
		
		return res;
	}
	
	public static void main(String[] args) {
		
		int arr[] = {7, 3, 5, 4, 5, 3, 4};
		System.out.println(findSingle(arr, arr.length));
	}
}
