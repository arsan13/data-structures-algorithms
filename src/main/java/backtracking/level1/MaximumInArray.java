package backtracking.level1;

public class MaximumInArray {

	private static int getMax(int index, int[] arr, int n) {
		
		if(index == n-1)
			return index;
		
		int max = getMax(index + 1, arr, n);
		return Math.max(max, arr[index]);
	}
	
	public static void main(String[] args) {
		
		int[] arr = {2, 10, 5, 25, 6};	
		System.out.println(getMax(0, arr, arr.length));
	}
}
