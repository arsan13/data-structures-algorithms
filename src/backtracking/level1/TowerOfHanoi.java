package backtracking.level1;

public class TowerOfHanoi {

	private static void toh(int n, char from, char to, char aux) {
		
		if(n == 0)
			return;
		
		toh(n-1, from, aux, to);
		System.out.println(n + ": " + from + " -> " + to);
		toh(n-1, aux, to, from);
		
//		return Math.pow(2, n) - 1; // number of moves required
	}
	
	public static void main(String[] args) {
		
		int n = 3;
		toh(n, 'A', 'B', 'C');
	}
}
