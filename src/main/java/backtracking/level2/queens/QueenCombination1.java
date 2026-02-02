package backtracking.level2.queens;

public class QueenCombination1 {

	private static void queenCombination(int qsf, int tq, int row, int col, String ans) {

		if (row == tq) {
			if (qsf == tq) {
				System.out.println(ans);
			}
			return;
		}

		int nr = 0;
		int nc = 0;
		String yans = "";
		String nans = "";

		if (col == tq - 1) {
			nr = row + 1;
			nc = 0;
			yans = ans + "q\n";
			nans = ans + "-\n";
		} else {
			nr = row;
			nc = col + 1;
			yans = ans + "q";
			nans = ans + "-";
		}

		queenCombination(qsf + 1, tq, nr, nc, yans);
		queenCombination(qsf + 0, tq, nr, nc, nans);
	}

	public static void main(String[] args) {

		queenCombination(0, 4, 0, 0, "");
	}
}
