package dp.tree;

import java.util.HashMap;
import java.util.Map;

//Given an integer n, return the number of structurally unique BST's which has exactly n nodes of unique values from 1 to n.
public class UniqueBSTs {

	private static Map<Integer, Integer> map = new HashMap<>();

	public static int numTreesMemo(int n) {
		if (n <= 1)
			return 1;
		if (map.containsKey(n))
			return map.get(n);

		int count = 0;
		for (int i = 1; i <= n; i++)
			// count += root.left * root.right;
			count += numTreesMemo(i - 1) * numTreesMemo(n - i);

		map.put(n, count);
		return count;
	}

	public static int numTreesTab(int n) {
		int T[] = new int[n + 1];
		T[0] = 1;
		T[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				T[i] += T[j] * T[i - j - 1];
			}
		}
		return T[n];
	}

	public static void main(String ars[]) {
		
		int n = 3;
		System.out.println(numTreesMemo(n));
		System.out.println(numTreesTab(n));
	}
}