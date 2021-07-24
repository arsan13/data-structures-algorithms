package dp;

import java.util.HashMap;
import java.util.Map;

// Consider a highway of M miles. The task is to place billboards on the highway such that revenue is maximized. 
// There is a restriction that no two billboards can be placed within t miles or less than it. 
public class HighwayBillboard {

	// O(poles*poles) time, O(poles) space
	private static int maxProfit1(int miles, int[] poles, int[] revenue, int t) {
		if (miles == 0 || poles.length == 0)
			return 0;

		int[] dp = new int[poles.length];
		dp[0] = revenue[0];
		int ans = 0;

		for (int i = 1; i < poles.length; i++) {
			int max = 0;

			for (int j = 0; j < i; j++) {
				int dist = poles[i] - poles[j];
				if (dist > t) {
					max = Math.max(max, revenue[j]);
				}
			}

			dp[i] = max + revenue[i];
			ans = Math.max(ans, dp[i]);
		}

		return ans;
	}

	// O(miles) time, O(miles + poles) space
	private static int maxProfit2(int miles, int[] poles, int[] revenue, int t) {
		if (miles == 0 || poles.length == 0)
			return 0;

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < poles.length; i++)
			map.put(poles[i], revenue[i]);

		int[] dp = new int[miles + 1];

		for (int i = 1; i <= miles; i++) {
			if (!map.containsKey(i)) {
				dp[i] = dp[i - 1];
			} else {
				int exclude = dp[i - 1];
				int include = map.get(i);
				if(i >= t + 1)
					include += dp[i - t - 1];
				dp[i] = Math.max(exclude, include);
			}
		}

		return dp[miles];
	}

	public static void main(String[] args) {

		int miles = 20;
		int t = 5;
		int[] poles = { 6, 7, 12, 13, 14 };
		int[] revenue = { 5, 6, 5, 3, 1 };

		int ans = maxProfit1(miles, poles, revenue, t);
		System.out.println(ans);

		ans = maxProfit2(miles, poles, revenue, t);
		System.out.println(ans);
	}
}
