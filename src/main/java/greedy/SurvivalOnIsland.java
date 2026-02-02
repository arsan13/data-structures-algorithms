package greedy;

public class SurvivalOnIsland {

	private static boolean survival(int s, int n, int m) {
		
		int x = s/7; 	// find number of sunday's
		int y = s - x;  // number of days food can be bought....food can't be bought on Sunday
		
		int foodRequired = s * m;  // total amount of food required to survive
		int days = foodRequired / n;  // number of days needed to buy food 
		
		if(foodRequired % n != 0)  // inrement days if given numbers are not divisible..eg. 20 / 16: days should be 2
			days++;
		
//		System.out.println(days);
		
		if(days <= y)
			return true;
		
		return false;
	}
	
	public static void main(String[] args) {
		
		int S = 10; // Number of days you are required to survive.
		int N = 16; // Maximum unit of food you can buy each day.
		int M = 2;  // Unit of food required each day to survive.
		 
        System.out.println(survival(S, N, M));
	}
}
