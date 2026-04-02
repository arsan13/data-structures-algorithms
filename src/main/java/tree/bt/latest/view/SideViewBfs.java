package tree.bt.latest.view;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SideViewBfs {

    public static List<Integer> rightView(Node root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();

                // If it's the last node of this level
                if (i == levelSize - 1) {
                    result.add(current.data);
                }

                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
        }

        return result;
    }

    public static List<Integer> leftView(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();

                // First node of this level
                if (i == 0) {
                    result.add(current.data);
                }

                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
        }

        return result;
    }

    private static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
}
