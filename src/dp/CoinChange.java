package dp;
import java.util.HashMap;
import java.util.Map;

public class CoinChange {

	private static int minCoins(int n, int[] arr, Map<Integer, Integer> dp) {

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

		int n = 18;
		int arr[] = { 7, 5, 1 };
		Map<Integer, Integer> map = new HashMap<>();

		int ans = minCoins(n, arr, map);
		System.out.println(map);
		System.out.println(ans);
	}
}
