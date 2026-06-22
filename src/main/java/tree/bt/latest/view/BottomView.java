package tree.bt.latest.view;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomView {

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(solve(root));
    }

    public static List<Integer> solve(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Map<Integer, Integer> map = new TreeMap<>();

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            map.put(pair.distance, pair.node.data);

            if (pair.node.left != null) {
                queue.add(new Pair(pair.node.left, pair.distance - 1));
            }
            if (pair.node.right != null) {
                queue.add(new Pair(pair.node.right, pair.distance + 1));
            }
        }

        return new ArrayList<>(map.values());
    }

    private static class Pair {
        Node node;
        int distance;

        Pair(Node node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
}
