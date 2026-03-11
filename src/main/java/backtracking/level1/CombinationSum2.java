package backtracking.level1;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum2 {

    public static void main(String[] args) {
        int[] candidates = {2, 2, 3, 6, 7};
        int target = 7;

        System.out.println(new CombinationSum2().combinationSum(candidates, target));
    }

    private List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        combinationSum(candidates, target, 0, list, res);

        return res;
    }

    private void combinationSum(int[] candidates, int target, int index, List<Integer> list, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            res.add(new ArrayList<>(list));
        }

        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            if (i == index || candidates[i] != candidates[i - 1]) {
                list.add(candidates[i]);
                combinationSum(candidates, target - candidates[i], i + 1, list, res);
                list.remove(list.size() - 1);
            }
        }
    }
}