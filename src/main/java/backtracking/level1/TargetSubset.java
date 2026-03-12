package backtracking.level1;

public class TargetSubset {

    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int target = 9;

        System.out.println(solve(arr, 0, target));
    }

    private static boolean solve(int[] arr, int index, int target) {
        if (target == 0) {
            return true;
        }
        if (index == arr.length) {
            return false;
        }

        boolean pick = solve(arr, index + 1, target - arr[index]);
        boolean notPick = solve(arr, index + 1, target);
        return pick || notPick;
    }
}
