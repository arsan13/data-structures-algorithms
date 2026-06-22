package backtracking.latest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetSums {

    public static void main(String[] args) {
        int[] candidates = {1, 2, 1};

        List<Integer> res = new ArrayList<>();
        solve(candidates, 0, 0, res);
        Collections.sort(res);
        System.out.println(res);
    }

    private static void solve(int[] candidates, int index, int sum, List<Integer> res) {
        if (index == candidates.length) {
            res.add(sum);
            return;
        }

        solve(candidates, index + 1, sum + candidates[index], res);
        solve(candidates, index + 1, sum, res);
    }
}
