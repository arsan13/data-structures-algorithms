package greedy;

public class SmallestNumberWithGivenSumAndDigits {

	static String smallestNumber(int s, int d) {

//	The idea is to one by one fill all digits from rightmost to leftmost . Initially deduct 1 from sum s so that smallest digit is at the end. 
//	After deducting 1, we apply greedy approach. We compare remaining sum with 9, 
//	if remaining sum is more than 9, we put 9 at the current position, else we put the remaining sum. 
//	Since we fill digits from right to left, we put the highest digits on the right side.
		
		if (d * 9 < s)
			return "-1";

		String ans = "";

		for (int i = d - 1; i >= 0; i--) {
			if (s > 9) { // fill 9 from the last
				ans = "9" + ans;
				s = s - 9;
			} else {
				if (i == 0) // if only one slot is available
					ans = s + ans;
				else { // add s-1 and go on adding 0s until first slot is reached
					ans = (s - 1) + ans;
					i--;
					while (i > 0) {
						ans = "0" + ans;
						i--;
					}
					ans = "1" + ans; // for first slot
					break;
				}
			}
		}

		return ans;
	}

	public static void main(String[] args) {

		int s = 9, d = 2;

		System.out.println(smallestNumber(s, d));
	}

}
