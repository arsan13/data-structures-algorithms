package graph;

import java.util.LinkedList;
import java.util.Queue;

public class StepsByKnight {

	public static int minStepToReachTarget(int KnightPos[], int TargetPos[], int N) {
		
		int dx[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
		int dy[] = { -1, -2, -2, -1, 1, 2, 2, 1 };

		Queue<Cell> queue = new LinkedList<>();
		boolean visited[][] = new boolean[N + 1][N + 1];

		queue.add(new Cell(KnightPos[0], KnightPos[1], 0));
		visited[KnightPos[0]][KnightPos[1]] = true;

		while (!queue.isEmpty()) {

			Cell cell = queue.poll();

			// check if current cell is target cell
			if (cell.x == TargetPos[0] && cell.y == TargetPos[1]) {
				return cell.dist;
			}

			// loop through all eight possibilities
			for (int i = 0; i < 8; i++) {
				int x = cell.x + dx[i];
				int y = cell.y + dy[i];

				if (isValid(x, y, N) && !visited[x][y]) {
					visited[x][y] = true;
					queue.add(new Cell(x, y, cell.dist + 1));
				}
			}
		}

		return -1;
	}

	private static boolean isValid(int x, int y, int N) {
		return (x >= 1 && x <= N && y >= 1 && y <= N);
	}
	
	static class Cell {
		int x, y;
		int dist;

		Cell(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
	
	public static void main(String args[]) {
		
		int n = 6;
		int[] knight = {4, 5};
		int[] target = {1, 1};
		
		int steps = minStepToReachTarget(knight, target, n);
		
		System.out.println(steps);
	}
}

