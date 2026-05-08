package tree.bt.latest;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidth {

    public static int maximumWidth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int res = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            int minimumNuber = queue.peek().number;

            int first = 0;
            int last = 0;

            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                int currIdx = pair.number - minimumNuber;
                TreeNode node = pair.node;

                if (i == 0) {
                    first = currIdx;
                }
                if (i == size - 1) {
                    last = currIdx;
                }

                if (node.left != null) {
                    queue.add(new Pair(node.left, 2 * currIdx + 1));
                }
                if (node.right != null) {
                    queue.add(new Pair(node.right, 2 * currIdx + 2));
                }
            }

            res = Math.max(res, last - first + 1);
        }

        return res;
    }

    private static class Pair {
        TreeNode node;
        int number;

        Pair(TreeNode node, int number) {
            this.node = node;
            this.number = number;
        }
    }
}
