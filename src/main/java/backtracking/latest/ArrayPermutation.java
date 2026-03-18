package backtracking.latest;

import java.util.ArrayList;
import java.util.List;

public class ArrayPermutation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        boolean[] visited = new boolean[arr.length];
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        solve(arr, visited, list, res);
        System.out.println(res);
    }

    private static void solve(int[] arr, boolean[] visited, List<Integer> list, List<List<Integer>> res) {
        if(list.size() == arr.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                list.add(arr[i]);
                solve(arr, visited, list, res);

                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    private static void solveOptimized(int[] arr, int index, List<List<Integer>> res) {
        if(index == arr.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : arr) {
                list.add(num);
            }
            res.add(list);
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            solveOptimized(arr, index + 1, res);
            swap(arr, index, i);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
