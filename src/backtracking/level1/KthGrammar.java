package backtracking.level1;

public class KthGrammar {

	private static int kthGrammar(int n, int k) {

		if (n == 1 && k == 1) {
			return 0;
		}

		int length = (int) Math.pow(2, n - 1);
		int mid = length / 2;
		if (k <= mid)
			return kthGrammar(n - 1, k);
		else
			return 1 - kthGrammar(n - 1, k - mid);
	}

	public static void main(String[] args) {

		System.out.println(kthGrammar(4, 3));;
	}

}
