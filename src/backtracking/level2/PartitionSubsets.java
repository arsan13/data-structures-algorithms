package backtracking.level2;

import java.util.ArrayList;
import java.util.List;

public class PartitionSubsets {
	
	//Elements will be on level and elements have choices whether to join in any non-empty subset or in a empty subset.
	private static void partition(int index, int[] arr, int n, int k, int subsets, List<List<Integer>> ans) {
		if(n < k)
			return;
		
		if(index == n) {
			if(k == subsets) {
				for(List<Integer> list : ans) {
					System.out.print(list + " ");
				}
				System.out.println();
			}
			return;
		}
		
		
		for(int i = 0; i < ans.size(); i++) {
			if(ans.get(i).size() > 0) {		//join in all the non-empty subsets
				ans.get(i).add(arr[index]);
				partition(index + 1, arr, n, k, subsets, ans);
				ans.get(i).remove(ans.get(i).size() - 1);
			} 
			else {						//join in the first empty set present.
				ans.get(i).add(arr[index]);
				partition(index + 1, arr, n, k, subsets + 1, ans);
				ans.get(i).remove(ans.get(i).size() - 1);
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		
		int k = 2;
		int arr[] = {1, 2, 3, 4};
		
		List<List<Integer>> subsets = new ArrayList<>();
		for(int i = 0; i < k; i++) {		
			subsets.add(new ArrayList<>());
		}
		
		partition(0, arr, arr.length, k, 0, subsets);
	}
}
