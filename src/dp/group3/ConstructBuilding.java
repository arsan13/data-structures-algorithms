package dp.group3;

/*
 * Count possible ways to construct buildings.
 * Given an input number of sections and each section has 2 plots on either sides of the road. 
 * Find all possible ways to construct buildings in the plots such that 2 buildings aren't together.
*/
public class ConstructBuilding {
	
	// Returns count for one section, return power of result m times for m sections
	// Brute force
	private static long countWays(int n, String ans) {

		if (n == 0) {
			System.out.print(ans + " ");
			return 1;
		}

		long countB = 0;
		if (ans.length() == 0)
			countB = countWays(n - 1, ans + "B");
		else if(ans.charAt(ans.length() - 1) != 'B')
			countB = countWays(n-1, ans + "B");

		long countS = countWays(n - 1, ans + "S");

		return countB + countS;
	}

	// Optimal
	private static long countWays(int n) {
		long oldCountB = 1;
		long oldCountS = 1;

		for (int i = 2; i <= n; i++) {
			long newCountB = oldCountS;
			long newCountS = oldCountS + oldCountB;

			oldCountB = newCountB;
			oldCountS = newCountS;
		}

		// Result for one side is sum of ways ending with building and ending with space
		long countInOneSection = oldCountB + oldCountS;

		// Result for 2 sides is square of result for one side. For m sections, return m power of result
		return countInOneSection * countInOneSection; // for two sections
	}

	public static void main(String[] args) {

		int n = 3;
		long ans = 0;

		ans = countWays(n, "");
		System.out.println("\nWays in one section = " + ans);
		ans = countWays(n);
		System.out.println("Ways in two sections = " + ans);
	}
}
