package backtracking.latest;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum1 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        combinationSum(candidates, target, 0, list, res);

        return res;
    }

    private void combinationSum(int[] candidates, int target, int index, List<Integer> list, List<List<Integer>> res) {
        if(index >= candidates.length) {
            if(target == 0) {
                res.add(new ArrayList<>(list));
            }
            return;
        }

        if (candidates[index] <= target) {
            list.add(candidates[index]);
            combinationSum(candidates, target - candidates[index], index, list, res);
            list.remove(list.size() - 1);
        }

        combinationSum(candidates, target, index + 1, list, res);
    }
}
