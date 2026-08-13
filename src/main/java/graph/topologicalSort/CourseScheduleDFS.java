package graph.topologicalSort;

import java.util.ArrayList;
import java.util.List;

/*
* There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
* For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
* Return true if you can finish all courses. Otherwise, return false.
*/
public class CourseScheduleDFS {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = getAdjList(numCourses, prerequisites);

        boolean[] visited = new boolean[numCourses];
        boolean[] visitedPath = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && hasCycle(i, adjList, visited, visitedPath)) {
                    return false;
                }

        }

        return true;
    }

    private boolean hasCycle(int src, List<List<Integer>> adjList, boolean[] visited, boolean[] visitedPath) {
        visited[src] = true;
        visitedPath[src] = true;

        for (int neighbor : adjList.get(src)) {
            if (!visited[neighbor]) {
                if (hasCycle(neighbor, adjList, visited, visitedPath)) {
                    return true;
                }
            } else if (visitedPath[neighbor]) {
                return true;
            }
        }

        visitedPath[src] = false;
        return false;
    }

    private List<List<Integer>> getAdjList(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            adjList.get(pair[1]).add(pair[0]);
        }

        return adjList;
    }
}
