package graph.topologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. 
//You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must 
//take course bi first if you want to take course ai.

//Return true if you can finish all courses. Otherwise, return false.
public class CourseSchedule2 {

	private static boolean isPossible(int numCourses, int[][] prerequisites) {

		// Build Graph
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < numCourses; i++)
			adj.add(new ArrayList<>());
		for (int[] edge : prerequisites) {
			adj.get(edge[1]).add(edge[0]);
		}

		Queue<Integer> queue = new LinkedList<>(); // For BFS traversal
		int[] inorder = new int[numCourses];

		// Find in-degree
		for (int[] edge : prerequisites) {
			inorder[edge[0]]++;
		}

		// Push 0 degree nodes in the queue
		for (int i = 0; i < numCourses; i++) {
			if (inorder[i] == 0) {
				queue.add(i);
			}
		}

		while (!queue.isEmpty()) {
			int u = queue.poll();

			for (int v : adj.get(u)) {
				inorder[v]--;

				if (inorder[v] == 0) {
					queue.add(v);
				}
			}
		}

		for (int val : inorder) {
			if (val != 0) { // cycle exists
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {

//		Eg. Pair [0, 1], indicates that to take course 0 you have to first take course 1.

		int numCourses = 6;
//		int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 0 }, { 4, 1 }, { 5, 4 }, { 1, 5 } };
		int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 0 }, { 4, 1 }, { 5, 4 } };

		boolean res = isPossible(numCourses, prerequisites);
		System.out.println(res);
	}
}
