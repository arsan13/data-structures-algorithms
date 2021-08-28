package dp.LIS;

import java.util.Arrays;

/* MAXIMUM NON-OVERLAPPING BRIDGES
 * 1. You are given a number n, representing the number of bridges on a river.
 * 2. You are given north bank and south bank co-ordinates of each bridge, such that north[i] and south[i] is a bridge.
 * 3. You are required to print the count of maximum number of non-overlapping bridges.
 */
public class BuildingBridges {

	private static class Bridge implements Comparable<Bridge> {
		int north;
		int south;
		
		public Bridge(int north, int south) {
			this.north = north;
			this.south = south;
		}
		
		public int compareTo(Bridge that) {
			if(this.north == that.north)
				return this.south - that.south;
			return this.north - that.north;
		}
		
	}

	// Sort north coordinates and find LIS on the basis of south coordinates.
	// Reverse of the above will also fetch the same answer.
	private static int maxNonOverlappingBridges(int n, int[] north, int[] south) {
		
		Bridge[] bridges = new Bridge[n];
		for(int i = 0; i < n; i++) {
			bridges[i] = new Bridge(north[i], south[i]);
		}
		
		Arrays.sort(bridges);
		
		return lis(bridges, n);
	}

	// Longest Increasing Subsequence
	private static int lis(Bridge[] bridges, int n) {
		int dp[] = new int[n];
		dp[0] = 1;
		
		int res = dp[0];
		for(int i = 1; i < n; i++) {
			int max = 0;
			
			for(int j = 0; j < i; j++) {
				if(bridges[i].south >= bridges[j].south) {
					max = Math.max(max, dp[j]);
				}
			}
			
			dp[i] = max + 1;
			res = Math.max(res, dp[i]);
		}
		
		return res;
	}

	public static void main(String[] args) {

		int n = 8;
		int north[] = { 8, 1, 4, 3, 5, 2, 6, 7 };
		int south[] = { 1, 2, 3, 4, 5, 6, 7, 8 };

		int ans = maxNonOverlappingBridges(n, north, south);
		System.out.println(ans);
	}
}
