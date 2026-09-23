package graph.shortest;

/*
There are n cities numbered from 0 to n-1. Given the array edges where edges[i] = [fromi, toi, weighti] represents a bidirectional and weighted edge between cities fromi and toi, and given the integer distanceThreshold.

Return the city with the smallest number of cities that are reachable through some path and whose distance is at most distanceThreshold, If there are multiple such cities, return the city with the greatest number.

Notice that the distance of a path connecting cities i and j is equal to the sum of the edges' weights along that path.
 */
public class CityWithSmallestNeighboursUsingFloydWarshall {

    public static void main(String[] args) {
        CityWithSmallestNeighboursUsingFloydWarshall solution = new CityWithSmallestNeighboursUsingFloydWarshall();
        int[][] edges = {{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}};
        System.out.println(solution.findTheCity(4, edges, 4));
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = buildMatrix(n, edges);
        floydWarshall(dist);
        return findTheCity(n, distanceThreshold, dist);
    }

    private int[][] buildMatrix(int n, int[][] edges) {
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = i == j ? 0 : Integer.MAX_VALUE;
            }
        }

        for (int[] edge : edges) {
            dist[edge[0]][edge[1]] = edge[2];
            dist[edge[1]][edge[0]] = edge[2];
        }

        return dist;
    }

    // All-pairs shortest paths via Floyd-Warshall so we can look up any city's distance to every other city.
    private void floydWarshall(int[][] dist) {
        int n = dist.length;

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }

    private int findTheCity(int n, int distanceThreshold, int[][] dist) {
        int minCount = n;
        int city = -1;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (dist[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            // <= (not <) so that among ties, the city with the greatest number wins, as required.
            if (count <= minCount) {
                minCount = count;
                city = i;
            }
        }

        return city;
    }
}
