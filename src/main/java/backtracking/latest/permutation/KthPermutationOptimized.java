package backtracking.latest.permutation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class KthPermutationOptimized {

    public static void main(String[] args) {
        System.out.println(solve(3, 4));
    }

    private static String solve(int n, int k) {
        int partialFact = 1;
        List<Integer> list = new ArrayList<>();

        for(int i = 1; i < n; i++){
            partialFact = partialFact * i;
            list.add(i);
        }
        list.add(n);

        StringBuilder res = new StringBuilder();
        k = k - 1;

        while (true) {
            int index = k / partialFact;
            res.append(list.get(index));
            list.remove(index);

            if(list.isEmpty()) {
                break;
            }

            k =  k % partialFact;
            partialFact = partialFact / list.size();
        }

        return res.toString();
    }

    private static String solveRec(int n, int k) {
        int fact = 1;
        List<Integer> list = new ArrayList<>();

        for(int i = 1; i < n; i++){
            fact = fact * i;
            list.add(i);
        }
        list.add(n);

        return solveRec(n, k - 1, fact, "", list);
    }

    private static String solveRec(int n, int k, int fact, String res, List<Integer> list) {
        if (k == 0) {
            String suffix = list.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining());
            return res.concat(suffix);
        }

        int index = k / fact;
        res = res.concat(String.valueOf(list.get(index)));
        list.remove(index);

        return solveRec(n, k % fact, fact /  list.size(), res, list);
    }
}
