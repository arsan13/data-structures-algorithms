package backtracking.latest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2};

        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        solve(arr, 0, list, res);
        System.out.println(res);
    }

    private static void solve(int[] arr, int index, List<Integer> list, List<List<Integer>> res) {
        res.add(new ArrayList<>(list));

        for (int i = index; i < arr.length; i++) {
            if(i == index || arr[i] != arr[i - 1]) {
                list.add(arr[i]);
                solve(arr, i + 1, list, res);
                list.remove(list.size() - 1);
            }
        }
    }
}
