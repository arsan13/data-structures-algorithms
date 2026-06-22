package backtracking.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TargetSumSubset2 {

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();

		Arrays.sort(candidates);
		combination(0, candidates, target, list, res);
		return res;
	}

	private static void combination(int index, int arr[], int k, List<Integer> list, List<List<Integer>> res) {
		if (k < 0)
			return;

		if (k == 0) {
			res.add(new ArrayList<>(list));	
			return;
		}
		
		for (int i = index; i < arr.length; i++) {
			if(i == index || arr[i] != arr[ i - 1]) {
				list.add(arr[i]);
				combination(i + 1, arr, k - arr[i], list, res);
				list.remove(list.size() - 1);
			}
		}
	}
		

	public static void main(String[] args) {
//		int arr[] = {10, 20, 30, 40, 60};
//		int target = 60;
		int arr[] = { 2, 5, 2, 1, 2 };
		int target = 5;

		List<List<Integer>> res = combinationSum2(arr, target);
		for (List<Integer> list : res) {
			System.out.println(list);
		}
	}

}
