package backtracking.level2;

public class FriendsPairing {

	private static void pairing(int i, int n, boolean[] used, String ans) {

		if (i > n) {
			System.out.println(ans);
			return;
		}

		if (used[i])
			pairing(i + 1, n, used, ans);
		else {
			used[i] = true;
			pairing(i + 1, n, used, ans + "(" + i + ")"); // single
			for (int j = i + 1; j <= n; j++) {
				if (!used[j]) {
					used[j] = true;
					pairing(i + 1, n, used, ans + "(" + i + j + ")"); // pair
					used[j] = false;
				}
			}
			used[i] = false;
		}
	}

	public static void main(String[] args) {

		int n = 3;
		pairing(1, n, new boolean[n + 1], "");
	}

}
