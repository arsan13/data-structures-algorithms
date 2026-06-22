package backtracking.latest.permutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KthPermutation {

    public static void main(String[] args) {
        System.out.println(solve(3, 4));
    }

    public static String solve(int n, int k) {
        List<String> list = new ArrayList<>();

//        boolean[] visited = new boolean[n + 1];
//        String path = "";
//        solve(n, visited, path, list);

        StringBuilder pathBuilder = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            pathBuilder.append(i);
        }
        solveOptimized(n, 0, pathBuilder.toString(), list);

        Collections.sort(list);
        return list.get(k - 1);
    }

    private static void solve(int n, boolean[] visited, String path, List<String> list) {
        if (path.length() == n) {
            list.add(path);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                solve(n, visited, path.concat(String.valueOf(i)), list);
                visited[i] = false;
            }
        }
    }

    private static void solveOptimized(int n, int index, String path, List<String> list) {
        if (index == n) {
            list.add(path);
            return;
        }

        for (int i = index; i < n; i++) {
            path = swap(path, i, index);
            solveOptimized(n, index + 1, path, list);
            path = swap(path, i, index);
        }
    }

    private static String swap(String str, int i, int j) {
        if (i == j) {
            return str;
        }

        char[] chars = str.toCharArray();

        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;

        return new String(chars);
    }
}
