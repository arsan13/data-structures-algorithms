package dp.group3;

//Given a fence with n posts and k colors.
//Find out the number of ways of painting the fence such that at most 2 adjacent posts can have the same color. 
public class PaintFences {

//	Answer may be very large, return it modulo 10**9 + 7 for large numbers
	private static int countWays(int n, int k) {
		if(n == 0)
            return 0;
        
        if(n == 1)
            return k;
		
		// for k = 3(rgb), max ways = 3*1 = 3 -> rr, bb, gg if two poles must be of same color
		int same = k * 1;		//upto fence 2
		// for k = 3, max ways = 3*(3-1) = 6 -> every color will have 2 optionsi.e.,join with other 2
		// rg, rb, gb, gr, br, bg
		int diff = k * (k - 1);	//upto fence 2
		int total = same + diff;
		
		for (int fence = 3; fence <= n; fence++) {
			same = diff * 1;	// Pick all the prev Diff combinations and repeat the last-two color by appending all the colors.
			diff = total * (k - 1);	// Pick all the total combinations and append color except the color present at the last position, thats why k - 1.
			total = same + diff;
		}

		return total;
	}

	public static void main(String[] args) {

		int n = 5;
		int k = 3;
		System.out.println(countWays(n, k));
	}

}
