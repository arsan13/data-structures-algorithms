package backtracking.level2.queens;

public class QueenPermutation2 {

	private static void queenPermutation(int qsf, int tq, int row, int col, String ans, boolean[] queens) {

		if (row == tq) {
			if (qsf == tq) {
				System.out.println(ans);
				System.out.println();
			}
			return;
		}

		int nr = 0;
		int nc = 0;
		String sep = "\0";

		if (col == tq - 1) {
			nr = row + 1;
			nc = 0;
			sep = "\n";
		} else {
			nr = row;
			nc = col + 1;
			sep = "\t";
		}

		for (int i = 0; i < queens.length; i++) {
			if(queens[i] == false) {
				queens[i] = true;
				queenPermutation(qsf + 1, tq, nr, nc, ans + "q" + (i+1) + sep, queens);  // include any queen
				queens[i] = false;
			}
		}
		
		queenPermutation(qsf + 0, tq, nr, nc, ans + "-" + sep, queens); // exclude queen
	}

	public static void main(String[] args) {

		boolean[] queens = new boolean[4];
		queenPermutation(0, 4, 0, 0, "", queens);
	}
}
