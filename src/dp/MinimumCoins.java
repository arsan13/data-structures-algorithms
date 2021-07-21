package dp;

import java.util.HashMap;

// Coins can be repeated 
public class MinimumCoins {

	private static int minCoins(int n, int[] arr, HashMap<Integer, Integer> dp) {

		if (n == 0)
			return 0;

		int ans = Integer.MAX_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (n - arr[i] >= 0) {
				int subAns = 0;

				if (dp.containsKey(n - arr[i]))
					subAns = dp.get(n - arr[i]);
				else
					subAns = minCoins(n - arr[i], arr, dp);

				if (subAns != Integer.MAX_VALUE && subAns + 1 < ans)
					ans = subAns + 1;
			}
		}
		
		dp.put(n, ans);
		return ans;
	}

	public static void main(String[] args) {

		int amt = 11;
		int arr[] = { 2, 5, 1 ,6};

		int ans = minCoins(amt, arr, new HashMap<Integer, Integer>());
		System.out.println("Minimum coins required: " + ans);
	}
}
