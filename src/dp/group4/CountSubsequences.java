package dp.group4;

public class CountSubsequences {

	private static int count(String str) {
		int a = 0;
		int ab = 0;
		int abc = 0;

		for (char ch : str.toCharArray()) {

			if (ch == 'a')
				a = 2 * a + 1;
			else if (ch == 'b')
				ab = 2 * ab + a;
			else
				abc = 2 * abc + ab;
		}

		return abc;
	}

	public static void main(String[] args) {

		String str = "abcabc";
		System.out.println(count(str));
	}

}
