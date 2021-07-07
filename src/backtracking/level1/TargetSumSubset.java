package backtracking.level1;

public class TargetSumSubset {

	private static void printSubsets(int[] arr, int index, String set, int currSum, int target) {
		
		if(currSum > target)
			return;
		
		if(index == arr.length) {
			if(currSum == target)
				System.out.print(set + " " + "\n");
			return;
		}
		
		printSubsets(arr, index+1, set+",", currSum + arr[index], target);
		printSubsets(arr, index+1, set, currSum, target);
	}
	
	public static void main(String[] args) {
		
		int arr[] = {10, 20, 30, 40, 60};
		int target = 60;
		
		printSubsets(arr, 0, "", 0, target);
	}
}
